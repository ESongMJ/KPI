package cn.songmj.kpi.controller;

import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.util.param.UserParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Esong
 * @date 2018/4/8
 **/
@Controller
public class IndexController extends BaseController {

    @GetMapping("/sys/{path}")
    public String indexSys(@PathVariable("path") String path) {
        return path;
    }

    @GetMapping("/")
    public String route() {
        return "index";
    }

    @GetMapping("/{path}")
    @CrossOrigin
    public String route(@PathVariable("path") String path) {
        return path;
    }

    @GetMapping("/sys/admin/{path}")
    public String routeSysAdmin(@PathVariable("path") String path) {
        return "admin/" + path;
    }

    @GetMapping("/admin/{path}")
    @CrossOrigin
    public String routeAdmin(@PathVariable("path") String path) {
        return "admin/" + path;
    }

    @PostMapping("/sys/saveUser")
    @ResponseBody
    @CrossOrigin
    public Result saveUser(HttpServletRequest request, UserParam user) {
        setSessionValue(request,"user", user);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
}
