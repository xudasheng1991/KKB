package com.kaikeba.adapter;

import com.kaikeba.model.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 该接口是DispatcherServlet用来调用不同类型处理器的统一类型
 * HandlerAdapter和Handler类型的一对一的，就类似于某一个类型的电脑，对应一个统一的电源适配器
 */
public interface HandlerAdapter {

    /**
     * 用来匹配适配器和处理器
     * @param handler
     * @return
     */
    boolean supports(Object handler);

    /**
     * 调用不同类型的处理器完成请求处理
     * @param handler
     * @param request
     * @param response
     * @return
     */
    ModelAndView handleRequest(Object handler, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
