package com.xuefei.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//会将 PageNotFoundException 作为资源找不到的状态
//@ResponseStatus(HttpStatus.NOT_FOUND)
public class PageNotFoundException extends RuntimeException{

        public PageNotFoundException() {}

        public PageNotFoundException(String message) {
            super(message);
        }

        public PageNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
    }

