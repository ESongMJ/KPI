package cn.songmj.kpi.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 版块权限
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
@TableName("nav_power")
public class NavPower extends Model<NavPower> implements Serializable {

    @TableId("np_id")
    private Long npId;
    /**
     * 角色id
     */
    @TableField("role_id")
    private Long roleId;
    /**
     * 版块id
     */
    @TableField("nav_id")
    private Long navId;
    /**
     * 角色名称
     */
    @TableField(exist = false)
    private String roleName;
    /**
     * 版块名称
     */
    @TableField(exist = false)
    private String navName;

    @Override
    protected Serializable pkVal() {
        return this.npId;
    }
}
