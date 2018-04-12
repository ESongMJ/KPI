package cn.songmj.kpi.controller;

import cn.songmj.kpi.result.Result;
import com.baomidou.mybatisplus.plugins.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *     父级Controller，封装统一返回信息
 * </p>
 *
 * @author meijie.song
 * @date 2018/3/23
 * @time 下午 4:34
 **/
public class BaseController {
    public <T> Result<T> view(String code, String msg, T data) {
        return new Result<T>(code, msg, data);
    }

    public Result view(String code, String msg) {
        return new Result(code, msg);
    }

    public <T> Result<T> view(String code, String msg, List<T> dataList) {
        return new Result<T>(code, msg, dataList);
    }

    public <T> Result<T> view(String code, String msg, Page<T> dataPage) {
        return new Result<T>(code, msg, dataPage);
    }

    public Object getSessionValue(HttpServletRequest request, String key) {
        return request.getSession().getAttribute(key);
    }

    public void setSessionValue(HttpServletRequest request, String key, Object value) {
        request.getSession().setAttribute(key, value);
    }

    public void removeSessionValue(HttpServletRequest request, String key) {
        request.getSession().removeAttribute(key);
    }
}
