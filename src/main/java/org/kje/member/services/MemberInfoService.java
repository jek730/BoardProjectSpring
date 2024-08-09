package org.kje.member.services;

import lombok.RequiredArgsConstructor;
import org.kje.file.entities.FileInfo;
import org.kje.file.services.FileInfoService;
import org.kje.member.MemberInfo;
import org.kje.member.constants.Authority;
import org.kje.member.entities.Authorities;
import org.kje.member.entities.Member;
import org.kje.member.repositories.MemberRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MemberInfoService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final FileInfoService fileInfoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));

        List<Authorities> tmp = Objects.requireNonNullElse(member.getAuthorities(),//getAuthorities 가 Null 이면 뒤에 반환
                List.of(Authorities.builder()
                        .member(member)
                        .authority(Authority.USER)
                        .build()));

        List<SimpleGrantedAuthority> authorities = tmp.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority().name()))
                .toList();

        // 추가 데이터 처리
        addMemberInfo(member);

        return MemberInfo.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .authorities(authorities)
                .member(member)
                .build();
    }

    /**
     * 회원 추가 데이터 처리
     *
     * @param member
     */
    public void addMemberInfo(Member member) {
        String gid = member.getGid();
        List<FileInfo> items = fileInfoService.getList(gid);
        if (items != null && !items.isEmpty()) {
            member.setProfileImage(items.get(0));
        }
    }
}