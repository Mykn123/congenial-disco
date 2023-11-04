package com.example.demo.config;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;


/**
 * 慡偰偺Controller偱嫟捠張棟傪掕媊
 */
@ControllerAdvice
public class WebMvControllerAdvice {

	/*
	 * This method changes empty character to null
	 * 偙偪傜偺儊僜僢僪傪梡堄偟偰偍偔偲憲怣偝傟偨嬻暥帤偼null偵曄姺偝傟傑偡
	 */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
    
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public String handleException(EmptyResultDataAccessException e, Model model)  {
    	model.addAttribute("message", e);
    	return "error/CustomPage";
    }
   
}