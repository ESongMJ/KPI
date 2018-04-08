package cn.songmj.kpi.data.impl;

import cn.songmj.kpi.data.RoleData;
import cn.songmj.kpi.entity.Role;
import cn.songmj.kpi.mapper.RoleMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author meijie.song123
 * @since 2018-03-23
 */
@Service
public class RoleDataImpl extends ServiceImpl<RoleMapper, Role> implements RoleData {

    @Override
    public List<Role> list(Role role) {
        EntityWrapper<Role> ew = new EntityWrapper<>();
        if (role.getRoleName() != null) {
            ew.like("role_name", "%"+role.getRoleName()+"%").or();
        }
        if (role.getRoleDescription() != null) {
            ew.like("role_description", "%"+role.getRoleDescription()+"%");
        }

        return baseMapper.selectList(ew);
    }
}
