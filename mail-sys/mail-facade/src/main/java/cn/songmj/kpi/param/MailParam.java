package cn.songmj.kpi.param;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
public class MailParam extends PageParam implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long mailId;
    /**
     * 撰写人
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    private String mailTitle;
    private String mailContent;
    /**
     * 最后一次修改或者发送时间
     */
    private String mailDate;
    /**
     * 状态， 1.草稿 2.已发送
     */
    private Integer mailStatus;
}
