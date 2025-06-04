package com.buka.handlers;

import com.alibaba.fastjson.JSON;
import com.buka.http.AppInfo;
import com.buka.http.HttpCode;
import com.buka.util.ResponseJson;
import com.buka.util.ResponseWriteUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminSessionHandler implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        if(session.getAttribute(AppInfo.SESSION_ADMIN)==null){
            ResponseWriteUtil.responseWrite(response, JSON.toJSONString(ResponseJson.getInstance(HttpCode.NOTLOGIN,null)));
        return false;
        }
        return true;
    }
}
