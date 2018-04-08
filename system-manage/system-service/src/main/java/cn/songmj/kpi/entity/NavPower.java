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
    private Integer npId;
    /**
     * 角色
     */
    @TableField("role_id")
    private Integer roleId;
    /**
     * 版块
     */
    @TableField("nav_id")
    private Integer navId;

    @Override
    protected Serializable pkVal() {
        return this.npId;
    }
}
