package cn.songmj.kpi.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
public class User extends Model<User> implements Serializable {

    @TableId("user_id")
    private Long userId;
    @TableField("user_name")
    private String userName;
    /**
     * 性别
     */
    @TableField("user_sex")
    private Integer userSex;
    @TableField("user_age")
    private Integer userAge;
    /**
     * 出生日期
     */
    @TableField("user_birthday")
    private String userBirthday;
    @TableField("user_introduce")
    /**
     * 个人简介
     */
    private String userIntroduce;
    @TableField("user_img")
    private String userImg;
    /**
     * 登录名
     */
    @TableField("user_number")
    private String userNumber;
    /**
     * 密码
     */
    @TableField("user_password")
    private String userPassword;
    /**
     * 学院
     */
    @TableField("user_college")
    private String userCollege;
    /**
     * 研究方向
     */
    @TableField("user_r_o")
    private String userRO;
    /**
     * 职称
     */
    @TableField("user_pro_title")
    private String userProTitle;
    /**
     * 角色
     */
    @TableField("role_id")
    private Long roleId;
    @TableField(exist = false)
    private String roleName;
    /**
     * 岗位
     */
    @TableField("kbr_id")
    private Long kbrId;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
}
