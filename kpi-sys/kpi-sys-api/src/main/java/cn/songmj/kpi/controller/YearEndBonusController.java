package cn.songmj.kpi.controller;


import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.param.YearEndBonusParam;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.service.YearEndBonusService;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/sys/yeb")
public class YearEndBonusController extends BaseController {
    @Resource
    private YearEndBonusService yearEndBonusService;

    @PostMapping("/save")
    public Result save(YearEndBonusParam yearEndBonusParam) {
        yearEndBonusService.save(yearEndBonusParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
    @PostMapping("/list")
    public Result list(YearEndBonusParam yearEndBonusParam) {
        List<YearEndBonusParam> paramList = yearEndBonusService.list(yearEndBonusParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), paramList);
    }
    @PostMapping("/page")
    public Result page(YearEndBonusParam yearEndBonusParam, String type) {
        Page<YearEndBonusParam> paramPage = yearEndBonusService.page(yearEndBonusParam, type);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), paramPage);
    }
}

