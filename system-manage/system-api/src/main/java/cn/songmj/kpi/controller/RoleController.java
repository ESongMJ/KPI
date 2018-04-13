package cn.songmj.kpi.controller;


import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.param.RoleParam;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.service.RoleService;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/sys/role")
public class RoleController extends BaseController {
    @Resource
    private RoleService roleService;
    @PostMapping("/page")
    public Result page(RoleParam roleParam) {
        Page<RoleParam> roles = roleService.page(roleParam);

        return view(StatusCode.SUCCESS.getCode(),StatusCode.SUCCESS.getMsg(),roles);
    }

    @PostMapping("/list")
    @CrossOrigin
    public Result list(RoleParam roleParam) {
        List<RoleParam> roles = roleService.list(roleParam);

        return view(StatusCode.SUCCESS.getCode(),StatusCode.SUCCESS.getMsg(),roles);
    }

    @PostMapping("/save")
    public Result save(RoleParam roleParam) {
        //roleId不满足要求是执行插入操作
        if (roleParam.getRoleId() == null || roleParam.getRoleId() == -1) {
            roleParam.setRoleId(null);
            roleService.insert(roleParam);
        }else {
            roleService.update(roleParam);
        }
        return view(StatusCode.SUCCESS.getCode(),StatusCode.SUCCESS.getMsg());
    }

    @PostMapping("/delete")
    public Result delete(Long roleId) {
        roleService.delete(roleId);

        return view(StatusCode.SUCCESS.getCode(),StatusCode.SUCCESS.getMsg());
    }
    @PostMapping("/get/one")
    @CrossOrigin
    public Result getRole(Long roleId) {
        RoleParam roleParam = roleService.selectById(roleId);

        return view(StatusCode.SUCCESS.getCode(),StatusCode.SUCCESS.getMsg(), roleParam);
    }
}

