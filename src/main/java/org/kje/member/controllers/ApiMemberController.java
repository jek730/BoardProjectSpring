package org.kje.member.controllers;

import lombok.RequiredArgsConstructor;
import org.kje.global.ExceptionRestProcessor;
import org.kje.global.rests.JSONData;
import org.kje.member.repositories.MemberRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class ApiMemberController implements ExceptionRestProcessor {

    private final MemberRepository memberRepository;

    /**
     * 이메일 중복 여부 체크
     * @param email
     * @return
     */
    @GetMapping("/email_dup_check")
    public JSONData duplicateEmailCheck(@RequestParam("email") String email) {
        boolean isExists = memberRepository.exists(email);

        JSONData data = new JSONData();
        data.setSuccess(isExists);

        return data;
    }
}