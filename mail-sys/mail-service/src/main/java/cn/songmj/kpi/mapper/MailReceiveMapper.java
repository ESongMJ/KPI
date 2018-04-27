package cn.songmj.kpi.mapper;

import cn.songmj.kpi.entity.Mail;
import cn.songmj.kpi.entity.MailReceive;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author meijie.song
 * @since 2018-03-23
 */
public interface MailReceiveMapper extends BaseMapper<MailReceive> {
    /**
     *
     * @param pagination
     * @param mail
     * @return
     */
    List<MailReceive> page(Pagination pagination, Mail mail);

    /**
     *
     * @param mrId
     * @return
     */
    MailReceive readMail(String mrId);
}
