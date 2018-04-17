package cn.songmj.kpi.mapper;

import cn.songmj.kpi.entity.KpiDetail;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface KpiDetailMapper extends BaseMapper<KpiDetail> {
    /**
     * 根据用户和类型查找用户申请绩效列表
     *
     * @param page
     * @param kpiDetail
     * @param kpType
     * @param kpId
     * @param userId
     * @return
     */
    List<KpiDetail> pageByUser(Pagination page, @Param("kd") KpiDetail kpiDetail, @Param("kpType") Integer kpType, @Param("kpId") Long kpId, @Param("userId") Long userId);

    /**
     * 根据id更新绩效申请状态
     *
     * @param kpiDetail
     * @return
     */
    Integer updateStatus(KpiDetail kpiDetail);
}
