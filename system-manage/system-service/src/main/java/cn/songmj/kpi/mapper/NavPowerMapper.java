package cn.songmj.kpi.mapper;

import cn.songmj.kpi.entity.NavPower;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface NavPowerMapper extends BaseMapper<NavPower> {
    /**
     * 分页查询权限列表
     * 联合查询出nav和role名称
     * @param navPower
     * @return
     */
    List<NavPower> selectJoinPage(NavPower navPower);
}
