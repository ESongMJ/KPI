package cn.songmj.kpi.facade;

import cn.songmj.kpi.entity.KpiAudit;
import cn.songmj.kpi.param.KpiAuditParam;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * kpi审核接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface KpiAuditFacade extends IService<KpiAudit> {
    /**
     * 插入
     *
     * @param kpiAuditParam
     * @return
     */
    Integer insert(KpiAuditParam kpiAuditParam);

    /**
     * 更新
     *
     * @param kpiAuditParam
     * @return
     */
    Integer update(KpiAuditParam kpiAuditParam);

    /**
     * 根据kdId获取审核信息
     *
     * @param kdId
     * @return
     */
    KpiAuditParam getOne(Long kdId);
}
