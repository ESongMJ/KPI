package cn.songmj.kpi.mapper;

import cn.songmj.kpi.entity.KpiOfUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface KpiOfUserMapper extends BaseMapper<KpiOfUser> {
    /**
     * 批量插入
     * 分发表单
     * @param kuList
     * @return
     */
    Integer insertBatch(@Param("list") List<KpiOfUser> kuList);
}
