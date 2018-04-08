package cn.songmj.kpi.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 版块
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
public class Nav extends Model<Nav> implements Serializable {

    @TableId("nav_id")
    private Integer navId;
    @TableField("nav_name")
    private String navName;
    /**
     * 版块跳转url  若type为标题则为空
     */
    @TableField("nav_url")
    private String navUrl;
    /**
     * 版块类型 1.标题 2.导向
     */
    @TableField("nav_type")
    private String navType;
    /**
     * 字体图标名称
     */
    @TableField("nav_ico")
    private String navIco;
    /**
     * 父级版块
     */
    @TableField("nav_parent")
    private Integer navParent;
    /**
     * 状态
     */
    @TableField("nav_status")
    private String navStatus;
    /**
     * 版块备注
     */
    @TableField("nav_tips")
    private String navTips;

    @Override
    protected Serializable pkVal() {
        return this.navId;
    }
}
