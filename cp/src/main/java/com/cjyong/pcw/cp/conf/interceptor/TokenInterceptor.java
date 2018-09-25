package com.cjyong.pcw.cp.conf.interceptor;

import com.cjyong.pcw.cp.conf.ApplicationInfo;
import com.cjyong.pcw.cp.main.entity.enums.TokenVerifyResult;
import com.cjyong.pcw.cp.util.PCUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/12/5
 * Time: 15:09
 * Description: 对权限进行校验
 */
@Service
public class TokenInterceptor implements HandlerInterceptor {


    public TokenInterceptor() {
        super();
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String jwt = request.getHeader("x-access-token");
        if (jwt == null){
            response.setStatus(401);
            return false;
        }

        TokenVerifyResult result = PCUtils.JwtVerify(ApplicationInfo.getJwtKey(), jwt);
        if (result==TokenVerifyResult.success){
            return true;
        }else if (result==TokenVerifyResult.expired){
            response.setStatus(210);
            return false;
        }else {
            response.setStatus(401);
            return false;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
