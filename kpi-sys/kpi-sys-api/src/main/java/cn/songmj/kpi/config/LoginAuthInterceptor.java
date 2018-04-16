package cn.songmj.kpi.config;

import cn.songmj.kpi.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * <p>
 * 登录认证拦截器
 * </p>
 *
 * @author meijie.song
 * @date 2018/4/12
 **/
@Slf4j
public class LoginAuthInterceptor implements HandlerInterceptor {
    /**
     * 请求转发前
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String key = "user_id";
//        if (CookieUtil.getCookie(request,key) != null) {
//            return true;
//        }
//        response.sendRedirect("http://127.0.0.1:9301/login");
//        return false;
        return true;
    }

    /**
     * 请求转发后，视图解析前
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 视图解析后
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
