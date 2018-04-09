package cn.songmj.kpi.facade;

import cn.songmj.kpi.entity.Nav;
import cn.songmj.kpi.param.NavParam;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  版块接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface NavFacade extends IService<Nav> {
    /**
     * 分页获取版块列表
     *
     * @param navParam
     * @return
     */
    Page<NavParam> page(NavParam navParam);

    /**
     * 列表查询
     * @return
     */
    List<NavParam> list();
    /**
     * 增加版块
     *
     * @param navParam
     * @return
     */
    Integer insert(NavParam navParam);

    /**
     * 更新版块
     *
     * @param navParam
     * @return
     */
    Integer update(NavParam navParam);

    /**
     * 删除版块
     *
     * @param navId
     * @return
     */
    Integer delete(Long navId);
}
