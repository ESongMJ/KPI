package cn.songmj.kpi.param;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 分页参数
 * </p>
 *
 * @author meijie.song
 * @date 2018/4/9
 **/
@Data
public class PageParam implements Serializable{
    private Integer currentPage;

    private Integer pageSize;
}
