package cn.songmj.kpi.dto;

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
public class NavDto implements Serializable {

    private Integer navId;
    private String navName;
    /**
     * 版块跳转url  若type为标题则为空
     */
    private String navUrl;
    /**
     * 版块类型 1.标题 2.导向
     */
    private String navType;
    /**
     * 字体图标名称
     */
    private String navIco;
    /**
     * 父级版块
     */
    private Integer navParent;
    /**
     * 状态
     */
    private String navStatus;
    /**
     * 版块备注
     */
    private String navTips;
}
