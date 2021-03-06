package cn.songmj.kpi.mapper;

import cn.songmj.kpi.entity.KpiOfUser;
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
public interface KpiOfUserMapper extends BaseMapper<KpiOfUser> {
    /**
     * 批量插入
     * 分发表单
     *
     * @param kuList
     * @return
     */
    Integer insertBatch(@Param("list") List<KpiOfUser> kuList);

    /**
     * 查询指定用户的绩效表单
     *
     * @param userId
     * @param page
     * @return
     */
    List<KpiOfUser> selectPageByUser(Pagination page, @Param("userId") Long userId);

    /**
     * 列表查询
     *
     * @param userId
     * @return
     */
    List<KpiOfUser> selectPageByUser(@Param("userId") Long userId);

    /**
     * 根据id连接表单表查询
     *
     * @param userId
     * @return
     */
    KpiOfUser selectFormById(Long userId);
}
