package cn.songmj.kpi.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Cookie工具类
 * </p>
 *
 * @author meije.song
 * @date 2018/4/16
 **/
public class CookieUtil {
    public static String getCookie(HttpServletRequest request, String key) {
        Map<String, String> cookieMap = readCookies(request);
        for (Map.Entry<String, String> cookie: cookieMap.entrySet()) {
            if (cookie.getKey().equals(key)) {
                return cookie.getValue();
            }
        }
        return null;
    }
    public static Map<String, String> readCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Map<String, String> cookieMap = new HashMap<>(cookies.length);
        if (cookies.length < 1) {
            return null;
        }
        for (Cookie c: cookies) {
            cookieMap.put(c.getName(), c.getValue());
        }
        return cookieMap;
    }
    public static boolean setCookie(HttpServletResponse response, String key, String value, int time, String path) {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath(path);
        cookie.setMaxAge(time);
        response.addCookie(cookie);
        return true;
    }
}
