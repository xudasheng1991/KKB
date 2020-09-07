package com.kaikeba.adapter;

import com.kaikeba.handler.HttpRequestHandler;
import com.kaikeba.model.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpRequestHandlerAdapter implements HandlerAdapter{
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof HttpRequestHandler);
    }

    @Override
    public ModelAndView handleRequest(Object handler, HttpServletRequest request, HttpServletResponse response) throws Exception{
        ((HttpRequestHandler)handler).handleRequest(request,response);
        return null;
    }
}
