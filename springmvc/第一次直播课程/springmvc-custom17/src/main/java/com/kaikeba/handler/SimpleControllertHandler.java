package com.kaikeba.handler;

import com.kaikeba.model.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 指定处理类编写规范(可以针对返回值进行二次处理)
 */
public interface SimpleControllertHandler {
    ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
}
