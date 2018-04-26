package cn.songmj.kpi.service.impl;

import cn.songmj.kpi.facade.MailReceiveFacade;
import cn.songmj.kpi.service.MailReceiveService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songmj123
 * @since 2018-03-23
 */
@Service
public class MailReceiveServiceImpl implements MailReceiveService {
    @Reference(
            version = "1.0.0",
            application = "${dubbo.application.id}"
    )
    private MailReceiveFacade mailReceiveFacade;

    @Override
    public Integer send(Long mailId, List<String> uidList) {
        return mailReceiveFacade.send(mailId, uidList);
    }
}
