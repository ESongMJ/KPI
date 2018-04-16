package cn.songmj.kpi.facade;

import cn.songmj.kpi.entity.KpiContent;
import cn.songmj.kpi.param.KpiContentParam;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  kpi内容接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface KpiContentFacade extends IService<KpiContent> {
    /**
     * 分页查询
     *
     * @param kpiContentParam
     * @param kpType
     * @return
     */
    Page<KpiContentParam> page(KpiContentParam kpiContentParam, Integer kpType);

    /**
     * 列表查询
     *
     * @param kpiContentParam
     * @param type
     * @return
     */
    List<KpiContentParam> list(KpiContentParam kpiContentParam, String type);

    /**
     * 插入
     *
     * @param kpiContentParam
     * @return
     */
    Integer insert(KpiContentParam kpiContentParam);

    /**
     * 更新
     *
     * @param kpiContentParam
     * @return
     */
    Integer update(KpiContentParam kpiContentParam);

    /**
     * 删除
     *
     * @param kcId
     * @return
     */
    Integer delete(Long kcId);
}
