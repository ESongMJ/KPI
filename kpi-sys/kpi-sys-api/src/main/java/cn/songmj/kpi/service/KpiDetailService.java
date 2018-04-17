package cn.songmj.kpi.service;


import cn.songmj.kpi.param.KpiDetailParam;
import com.baomidou.mybatisplus.plugins.Page;

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

    /**
     * 根据用户以及类型(科研或者教学)获取分页信息
     *
     * @param kpiDetailParam
     * @return
     */
    Page<KpiDetailParam> pageByUser(KpiDetailParam kpiDetailParam);

    /**
     * 根据id更新状态信息
     *
     * @param kpiDetailParam
     * @return
     */
    Integer updateStatus(KpiDetailParam kpiDetailParam);
}
