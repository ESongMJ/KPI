package cn.songmj.kpi.enums;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 状态类
 * </p>
 *
 * @author meijie.song
 * @date 2018/3/9
 * @time 下午 4:34
 **/
public enum StatusCode implements Serializable {
    /**
     * 成功状态
     */
    SUCCESS("0", "成功"),
    /**
     * 失败状态
     */
    FAIL("1", "失败"),
    /**
     * 系统错误状态
     */
    ERROR("2", "内部错误"),
    /**
     * 用户未登录状态
     */
    LOGOUT("3", "用户未登录");

    @Getter
    @Setter
    private String code;
    @Getter
    @Setter
    private String msg;

    StatusCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
