package cn.songmj.kpi.param;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 分页参数
 * </p>
 *
 * @author meijie.song
 * @date 2018/4/9
 **/
@Getter
@Setter
public class PageParam implements Serializable{
    private Integer currentPage;

    private Integer pageSize;
}
