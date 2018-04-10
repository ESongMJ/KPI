package cn.songmj.kpi.service;

import cn.songmj.kpi.param.NavParam;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
public interface NavService {
    /**
     * 分页获取版块列表
     *
     * @param navParam
     * @return
     */
    Page<NavParam> page(NavParam navParam);

    /**
     * 列表查询
     * @param navParam
     * @return
     */
    List<NavParam> list(NavParam navParam);
    /**
     * 保存版块
     * 1.当navId不为null或者-1时调用插入接口
     * 2.反之调用更新接口
     * @param navParam
     * @return
     */
    Integer save(NavParam navParam);

    /**
     * 删除版块
     *
     * @param navId
     * @return
     */
    Integer delete(Long navId);
}
