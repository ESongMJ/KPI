package cn.songmj.kpi.mapper;

import cn.songmj.kpi.entity.YearEndBonus;
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
public interface YearEndBonusMapper extends BaseMapper<YearEndBonus> {
    /**
     * 根据查询类型分页查询
     *
     * @param yearEndBonus
     * @param type
     * @return
     */
    List<YearEndBonus> selectPageByType(Pagination pagination, @Param("yeb") YearEndBonus yearEndBonus, @Param("type") String type);
}
