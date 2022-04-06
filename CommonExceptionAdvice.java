package com.example.ex02.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice // Exception을 처리 하기 위해 공통적인 예외사항에 대해서는 Advice로 분리한다.
@Slf4j
public class CommonExceptionAdvice {

    @ExceptionHandler(Exception.class) // 소괄호에 들어가는 예외 타입을 처리
    public String except(Exception e, Model model){
        log.error("Exception..........." + e.getMessage());
        model.addAttribute("exception", e);
        return "error_page";
    }

//    404 에러 페이지 처리
//    500메세지는 Internal Server Error이므로 @ExceptionHandler를 이용해서 처리가 가능하지만,
//    404메세지는 잘못된 URL을 호출할 때 보이므로 다르게 처리해주어야 한다.

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) //서버 요청에 대한 응답
    public String except404(){
        return "error404_page";
    }
}