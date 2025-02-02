package org.kje.file.exceptions;

import org.kje.global.exceptions.CommonException;
import org.springframework.http.HttpStatus;

public class FileTypeException extends CommonException {
    public FileTypeException(HttpStatus status) {
        super("FileType", status);
        setErrorCode(true);
    }
}