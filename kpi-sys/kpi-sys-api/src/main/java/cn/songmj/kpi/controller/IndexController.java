package cn.songmj.kpi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Esong
 * @date 2018/4/8
 **/
@Controller
public class IndexController {

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
        return "admin/"+path;
    }
    @GetMapping("/admin/{path}")
    @CrossOrigin
    public String routeAdmin(@PathVariable("path") String path) {
        return "admin/"+path;
    }
}
