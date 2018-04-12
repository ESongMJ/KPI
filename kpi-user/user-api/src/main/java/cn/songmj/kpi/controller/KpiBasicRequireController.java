package cn.songmj.kpi.controller;


import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.param.KpiBasicRequireParam;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.service.KpiBasicRequireService;
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
@RequestMapping("/sys/kbr")
public class KpiBasicRequireController extends BaseController {
    @Resource
    private KpiBasicRequireService kpiBasicRequireService;

    @PostMapping("/page")
    public Result page(KpiBasicRequireParam kbrParam) {
        Page<KpiBasicRequireParam> kbrPage = kpiBasicRequireService.page(kbrParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), kbrPage);
    }
    @PostMapping("/list")
    public Result list(KpiBasicRequireParam kbrParam) {
        List<KpiBasicRequireParam> kbrParamList = kpiBasicRequireService.list(kbrParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), kbrParamList);
    }
    @PostMapping("/save")
    public Result save(KpiBasicRequireParam kbrParam) {
        kpiBasicRequireService.save(kbrParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
    @PostMapping("/delete")
    public Result delete(Long kbrId) {
        kpiBasicRequireService.delete(kbrId);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
}

