package cn.songmj.kpi.service;

import cn.songmj.kpi.param.NavPowerParam;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
public interface NavPowerService {
    /**
     * 分页获取角色列表
     *
     * @param navPowerParam
     * @return
     */
    Page<NavPowerParam> page(NavPowerParam navPowerParam);

    /**
     * 验证保存数据的唯一性
     * @param navPowerParam
     * @return 1.true 重复  2.false 没重复
     */
    boolean checkRepeat(NavPowerParam navPowerParam);
    /**
     * 保存版块
     * 1.当npId不为null或者-1时调用插入接口
     * 2.反之调用更新接口
     * @param navPowerParam
     * @return
     */
    Integer save(NavPowerParam navPowerParam);

    /**
     * 删除角色
     *
     * @param npId
     * @return
     */
    Integer delete(Long npId);
}
