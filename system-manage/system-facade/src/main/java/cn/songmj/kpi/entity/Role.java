package cn.songmj.kpi.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
public class Role extends Model<Role> implements Serializable {

    @TableId("role_id")
    private Long roleId;
    @TableField("role_name")
    private String roleName;
    @TableField("role_description")
    private String roleDescription;

    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }
}
