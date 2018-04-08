package cn.songmj.kpi.controller;


import cn.songmj.kpi.dto.RoleDto;
import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.param.RoleParam;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.service.RoleService;
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
@RequestMapping("/sys//role")
public class RoleController extends BaseController {
    @Resource
    private RoleService roleService;
    @RequestMapping("/list")
    public Result list() {
        RoleParam roleParam = new RoleParam();
        List<RoleDto> roles = roleService.list(roleParam);

        return view(StatusCode.SUCCESS.getCode(),StatusCode.SUCCESS.getMsg(),roles);
    }
}

