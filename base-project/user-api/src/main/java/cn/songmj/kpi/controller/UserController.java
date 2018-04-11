package cn.songmj.kpi.controller;


import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import cn.songmj.kpi.service.UserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author meijie.song123
 * @since 2018-03-23
 */
@RestController
@RequestMapping("/sys/user")
public class UserController extends BaseController {
    @Resource
    private UserService userService;

    @GetMapping("/hello")
    public Result hello() {
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), userService.sayHello("宋美杰"));
    }
}

