package org.kje.global.advices;

import lombok.RequiredArgsConstructor;
import org.kje.file.entities.FileInfo;
import org.kje.member.MemberUtil;
import org.kje.member.entities.Member;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@RequiredArgsConstructor
@ControllerAdvice("org.kje")
public class CommonControllerAdvice {

    private final MemberUtil memberUtil;
    @ModelAttribute("loggedMember")
    public Member loggedMember(){
        return memberUtil.getMember();
    }
    @ModelAttribute("isLogin")
    public boolean isLogin(){
        return memberUtil.isLogin();
    }
    @ModelAttribute("isAdmin")
    public boolean isAdmin(){
        return memberUtil.isAdmin();
    }

    @ModelAttribute("myProfileImage")
    public FileInfo myProfileImage() {
        if (isLogin()) {
            Member member = memberUtil.getMember();
            return member.getProfileImage();
        }

        return null;
    }

}