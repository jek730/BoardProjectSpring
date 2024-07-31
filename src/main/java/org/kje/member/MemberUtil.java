package org.kje.member;

import org.kje.member.constants.Authority;
import org.kje.member.entities.Authorities;
import org.kje.member.entities.Member;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberUtil {

    public boolean isLogin() {
        return getMember() != null;
    }

    public boolean isAdmin() {
        if (isLogin()) {
            Member member = getMember();
            List<Authorities> authorities = member.getAuthorities();
            return authorities.stream().anyMatch(s -> s.getAuthority() == Authority.ADMIN);
        }

        return false;
    }

    public Member getMember() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof MemberInfo) {
            MemberInfo memberInfo = (MemberInfo) authentication.getPrincipal();

            return memberInfo.getMember();
        }

        return null;
    }
}