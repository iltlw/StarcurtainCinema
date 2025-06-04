package com.buka.handlers;
import com.alibaba.fastjson.JSON;
import com.buka.http.HttpCode;
import com.buka.util.ResponseJson;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionHandler implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession();
        if(httpSession.getAttribute("user")==null){
            response.setContentType("text/html;charset=utf-8");
            ResponseJson responseJson=new ResponseJson(HttpCode.NOTLOGIN,null);
            response.getWriter().write(JSON.toJSONString(responseJson));
            return false;
        }
        return true;
    }
}
