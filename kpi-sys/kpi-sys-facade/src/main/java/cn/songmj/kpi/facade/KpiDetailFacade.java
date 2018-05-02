package cn.songmj.kpi.facade;

import cn.songmj.kpi.entity.KpiDetail;
import cn.songmj.kpi.param.KpiDetailParam;
import cn.songmj.kpi.param.StatisticalData;
import cn.songmj.kpi.param.StatisticalObj;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * kpi详情接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface KpiDetailFacade extends IService<KpiDetail> {

    /**
     * 更新
     *
     * @param kpiDetailParam
     * @return
     */
    Integer update(KpiDetailParam kpiDetailParam);

    /**
     * 根据Id更新状态
     * 场景：管理员审核绩效时
     *
     * @param kpiDetailParam
     * @return
     */
    Integer updateStatusById(KpiDetailParam kpiDetailParam);

    /**
     * 插入
     *
     * @param kpiDetailParam
     * @return
     */
    Integer insert(KpiDetailParam kpiDetailParam);

    /**
     * 根据用户和类型
     *
     * @param kpiDetailParam
     * @return
     */
    Page<KpiDetailParam> pageByUser(KpiDetailParam kpiDetailParam);

    /**
     * 查询指定用户的表单的详细申请信息
     * 作用：用户统计绩效申请数据
     *
     * @param kuId
     * @return
     */
    StatisticalObj selectDetail(String kuId);

}
