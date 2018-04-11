package cn.songmj.kpi.controller;


import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.param.UserParam;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.service.UserService;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    @PostMapping("/page")
    public Result page(UserParam userParam) {
        Page<UserParam> paramPage = userService.page(userParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), paramPage);
    }
    @PostMapping("/list")
    public Result list(UserParam userParam) {
        List<UserParam> userParamList = userService.list(userParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), userParamList);
    }
    @PostMapping("/save")
    public Result save(UserParam userParam) {
        if (userService.checkRepeat(userParam)) {
            return view(StatusCode.FAIL.getCode(), "用户名重复");
        }
        userService.save(userParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
    @PostMapping("/delete")
    public Result delete(Long userId) {
        userService.delete(userId);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
}

