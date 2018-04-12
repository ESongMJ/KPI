package cn.songmj.kpi.facade;

import cn.songmj.kpi.entity.NavPower;
import cn.songmj.kpi.param.NavParam;
import cn.songmj.kpi.param.NavPowerParam;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 版块权限接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface NavPowerFacade extends IService<NavPower> {
    /**
     * 分页获取权限列表
     *
     * @param navPowerParam
     * @return
     */
    Page<NavPowerParam> page(NavPowerParam navPowerParam);

    /**
     * 查询指定数据
     *
     * @param navPowerParam
     * @return
     */
    List<NavPowerParam> list(NavPowerParam navPowerParam);

    /**
     * 增加角色
     *
     * @param navPowerParam
     * @return
     */
    Integer insert(NavPowerParam navPowerParam);

    /**
     * 更新角色信息
     *
     * @param navPowerParam
     * @return
     */
    Integer update(NavPowerParam navPowerParam);

    /**
     * 删除角色
     *
     * @param npId
     * @return
     */
    Integer delete(Long npId);

    /**
     * 获取权限列表
     *
     * @param roleId
     * @return
     */
    List<NavParam> listNav(Long roleId);

}
