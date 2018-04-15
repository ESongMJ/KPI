package cn.songmj.kpi.service;


import cn.songmj.kpi.param.KpiFormParam;
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
public interface KpiFormService {
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
     * 保存
     *
     * @param kpiFormParam
     * @return
     */
    Integer save(KpiFormParam kpiFormParam);

    /**
     * 删除
     *
     * @param kfId
     * @return
     */
    Integer delete(Long kfId);
}
