package com.cryptoeagle.controller;


import com.cryptoeagle.exception.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.jws.WebParam;
import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionController {

//    @ExceptionHandler(UserNotFoundException.class)
//    public String userNotFound(Model model){
//       model.addAttribute("error", "User not found!!!");
//        return  "error-page";
//    }
//
//    @ExceptionHandler(RssNewsNotFoundException.class)
//    public String newsNotFound(Model model){
//        model.addAttribute("error", "Rss not found!!!");
//        return  "error-page";
//    }
//
//    @ExceptionHandler(EntityNotFoundException.class)
//    public String itemsNotFound(Model model){
//        model.addAttribute("error", "Entity not found!!!");
//        return  "error-page";
//    }
//
//    @ExceptionHandler(IcoNotFoundException.class)
//    public String icoNotFound(Model model){
//        model.addAttribute("error", "Ico data not found!!!");
//        return  "error-page";
//    }
//
//    @ExceptionHandler(UserAlreadyExistException.class)
//    public String userExist(Model model){
//        model.addAttribute("error", "User already exist!!!");
//        return  "error-page";
//    }
//
//    @ExceptionHandler(UserValidationException.class )
//    public String userValidation(Exception ex, Model model){
//        model.addAttribute("error", "User data is incorrect :" + ex.getMessage());
//        return  "error-page";
//    }


    @ExceptionHandler(Exception.class)
    public String userNotFound(Exception e, Model model) {
        model.addAttribute("error", e.getMessage());
        return "error-page";
    }


}
