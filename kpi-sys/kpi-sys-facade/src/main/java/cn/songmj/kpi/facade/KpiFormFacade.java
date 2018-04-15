package cn.songmj.kpi.facade;

import cn.songmj.kpi.entity.KpiForm;
import cn.songmj.kpi.param.KpiFormParam;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * kpi表单接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface KpiFormFacade extends IService<KpiForm> {
    /**
     * 分页查询
     *
     * @param kpiFormParam
     * @return
     */
    Page<KpiFormParam> page(KpiFormParam kpiFormParam);

    /**
     * 列表查询
     *
     * @param kpiFormParam
     * @return
     */
    List<KpiFormParam> list(KpiFormParam kpiFormParam);

    /**
     * 插入
     *
     * @param kpiFormParam
     * @return
     */
    Integer insert(KpiFormParam kpiFormParam);

    /**
     * 更新
     *
     * @param kpiFormParam
     * @return
     */
    Integer update(KpiFormParam kpiFormParam);

    /**
     * 删除
     *
     * @param kfId
     * @return
     */
    Integer delete(Long kfId);
}
