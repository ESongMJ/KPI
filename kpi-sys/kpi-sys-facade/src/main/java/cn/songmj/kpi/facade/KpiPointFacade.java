package cn.songmj.kpi.facade;

import cn.songmj.kpi.entity.KpiPoint;
import cn.songmj.kpi.param.KpiPointParam;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * kpi观测点接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface KpiPointFacade extends IService<KpiPoint> {
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
     * 插入
     *
     * @param kpiPointParam
     * @return
     */
    Integer insert(KpiPointParam kpiPointParam);

    /**
     * 更新
     *
     * @param kpiPointParam
     * @return
     */
    Integer update(KpiPointParam kpiPointParam);

    /**
     * 删除
     *
     * @param kpId
     * @return
     */
    Integer delete(Long kpId);
}
