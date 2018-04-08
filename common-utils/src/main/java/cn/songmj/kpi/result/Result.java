package cn.songmj.kpi.result;

import com.baomidou.mybatisplus.plugins.Page;
import lombok.Data;

import java.util.List;

/**
 * <p>
 *     返回结果封装
 * </p>
 *
 * @author meijie.song
 * @date 2018/3/9
 * @time 下午 4:34
 **/
@Data
public class Result<T> {
    /**
     * 结果码
     */
    private String code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 数据数组
     */
    private List<T> dataList;
    /**
     * 单个对象数据
     */
    private T data;

    private Page<T> pageData;

    public Result(String code, String msg, List<T> dataList) {
        this.code = code;
        this.msg = msg;
        this.dataList = dataList;
    }

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(String code, String msg, Page<T> pageData) {
        this.code = code;
        this.msg = msg;
        this.pageData = pageData;
    }
}
