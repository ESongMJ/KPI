package cn.songmj.kpi.mapper;

import cn.songmj.kpi.entity.KpiContent;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface KpiContentMapper extends BaseMapper<KpiContent> {
    /**
     * 自定义分页查询
     * 联合绩效站点表，查询站点名称
     * @param pagination
     * @param kpiContent
     * @return
     */
    List<KpiContent> selectJoinPage(Pagination pagination, KpiContent kpiContent);
}
