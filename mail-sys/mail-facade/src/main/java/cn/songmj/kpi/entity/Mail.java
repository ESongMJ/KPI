package cn.songmj.kpi.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 站内信
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
@Setter
@Getter
public class Mail extends Model<Mail> implements Serializable {

    @TableId("mail_id")
    private Long mailId;
    /**
     * 撰写人
     */
    @TableField("user_id")
    private Long userId;
    @TableField("mail_title")
    private String mailTitle;
    @TableField("mail_content")
    private String mailContent;
    /**
     * 最后一次修改或者发送时间
     */
    @TableField("mail_date")
    private String mailDate;
    /**
     * 状态， 1.草稿 2.已发送
     */
    @TableField("mail_status")
    private Integer mailStatus;


    @Override
    protected Serializable pkVal() {
        return this.mailId;
    }
}
