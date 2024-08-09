package org.kje.mypage.services;

import lombok.RequiredArgsConstructor;
import org.kje.member.services.MemberSaveService;
import org.kje.mypage.controllers.RequestProfile;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyPageService {

    private final MemberSaveService saveService;

    public void update(RequestProfile form) {

    }
}