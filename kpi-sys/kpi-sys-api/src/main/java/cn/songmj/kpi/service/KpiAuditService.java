package cn.songmj.kpi.service;

import cn.songmj.kpi.param.KpiAuditParam;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
public interface KpiAuditService {
    /**
     * 保存
     *
     * @param kpiAuditParam
     * @return
     */
    Integer save(KpiAuditParam kpiAuditParam);

    /**
     * 根据kdid获取审核信息
     *
     * @param kdId
     * @return
     */
    KpiAuditParam getOne(Long kdId);
}
