package cn.songmj.kpi.service;


import cn.songmj.kpi.param.KpiDetailParam;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
public interface KpiDetailService {
    /**
     * 保存绩效申请详情
     *
     * @param kpiDetailParam
     * @return
     */
    Integer save(KpiDetailParam kpiDetailParam);
}
