package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.MailReceive;
import cn.songmj.kpi.facade.MailReceiveFacade;
import cn.songmj.kpi.mapper.MailReceiveMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author meijie.song123
 * @since 2018-03-23
 */
@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class MailReceiveFacadeImpl extends ServiceImpl<MailReceiveMapper, MailReceive> implements MailReceiveFacade {

    @Override
    public Integer send(Long mailId, List<String> uidList) {
        int count = 0;
        for (String uid : uidList) {
            MailReceive mailReceive = new MailReceive();
            mailReceive.setMailId(mailId);
            mailReceive.setUserId(Long.parseLong(uid));
            mailReceive.setMrStatus(1);
            count += baseMapper.insert(mailReceive);
        }
        return count;
    }
}
