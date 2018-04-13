package cn.songmj.kpi.service;

import cn.songmj.kpi.param.KpiPointParam;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
public interface KpiPointService {
    /**
     * 分页查询
     *
     * @param kpiPointParam
     * @return
     */
    Page<KpiPointParam> page(KpiPointParam kpiPointParam);

    /**
     * 列表查询
     *
     * @param kpiPointParam
     * @return
     */
    List<KpiPointParam> list(KpiPointParam kpiPointParam);

    /**
     * 保存
     *
     * @param kpiPointParam
     * @return
     */
    Integer save(KpiPointParam kpiPointParam);

    /**
     * 删除
     *
     * @param kpId
     * @return
     */
    Integer delete(Long kpId);
}
