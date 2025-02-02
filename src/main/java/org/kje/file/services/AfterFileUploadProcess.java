package org.kje.file.services;

import lombok.RequiredArgsConstructor;
import org.kje.file.controller.RequestUpload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AfterFileUploadProcess {
    private final FileUploadDoneService doneService;

    public void process(RequestUpload form) {

        // 파일 업로드 직후 완료 처리
        if (form.isDone()) {
            doneService.process(form.getGid(), form.getLocation());
        }
    }
}