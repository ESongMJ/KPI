package cn.songmj.kpi.controller;


import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.param.KpiAuditParam;
import cn.songmj.kpi.param.KpiDetailParam;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.service.KpiAuditService;
import cn.songmj.kpi.service.KpiDetailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author meijie.song123
 * @since 2018-03-23
 */
@RestController
@RequestMapping("/sys/ka")
public class KpiAuditController extends BaseController {
    @Resource
    private KpiAuditService kpiAuditService;
    @Resource
    private KpiDetailService kpiDetailService;

    @PostMapping("/save")
    public Result save(KpiAuditParam kpiAuditParam) {
        // 审核成功 -> 同步用户绩效申请详情状态信息
        if (kpiAuditService.save(kpiAuditParam) > 0) {
            KpiDetailParam kpiDetailParam = new KpiDetailParam();
            kpiDetailParam.setKdId(kpiAuditParam.getKdId());
            kpiDetailParam.setKdStatus(kpiAuditParam.getKaResult());
            kpiDetailService.updateStatus(kpiDetailParam);
        }
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }

    @PostMapping("/getOne")
    public Result getOne(Long kdId) {
        KpiAuditParam kpiAuditParam = kpiAuditService.getOne(kdId);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), kpiAuditParam);
    }
}

