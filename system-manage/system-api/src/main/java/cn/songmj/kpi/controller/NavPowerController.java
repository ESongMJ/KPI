package cn.songmj.kpi.controller;


import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.param.NavParam;
import cn.songmj.kpi.param.NavPowerParam;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.service.NavPowerService;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/sys/np")
public class NavPowerController extends BaseController {
    @Resource
    private NavPowerService navPowerService;

    @PostMapping("/page")
    public Result page(NavPowerParam navPowerParam) {
        Page<NavPowerParam> page = navPowerService.page(navPowerParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), page);
    }
    @PostMapping("/save")
    public Result save(NavPowerParam navPowerParam) {
        // 检查对用用户是否已经拥有对当前版块的权限
        if (navPowerService.checkRepeat(navPowerParam)) {
            return view(StatusCode.FAIL.getCode(), "权限重复");
        }
        navPowerService.save(navPowerParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
    @PostMapping("/delete")
    public Result delete(Long npId) {
        navPowerService.delete(npId);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }

    @PostMapping("/power")
    @CrossOrigin
    public Result getPower(Long roleId) {
        // 假设角色id为空则指示用户没有被分配角色或者该角色没有分配权限
        if (roleId == null || roleId == -1L) {
            return view(StatusCode.FAIL.getCode(), "权限不足");
        }
        // 否则返回权限列表
        List<NavParam> navParamList = navPowerService.getPower(roleId);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), navParamList);
    }
}

