package cn.songmj.kpi.facade.impl;

import cn.songmj.kpi.entity.Mail;
import cn.songmj.kpi.entity.MailReceive;
import cn.songmj.kpi.facade.MailReceiveFacade;
import cn.songmj.kpi.mapper.MailReceiveMapper;
import cn.songmj.kpi.param.MailParam;
import cn.songmj.kpi.param.MailReceiveParam;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
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
            mailReceive.setMrDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
            count += baseMapper.insert(mailReceive);
        }
        return count;
    }

    @Override
    public Page<MailReceiveParam> page(MailParam mailParam) {
        Mail mail = getMailByParam(mailParam);
        Page<MailReceive> page = new Page<>();
        // 设置分页参数
        page.setSize(mailParam.getPageSize());
        page.setCurrent(mailParam.getCurrentPage());
        // 查询数据
        List<MailReceive> mrList = baseMapper.page(page, mail);
        // 数据类型转换
        List<MailReceiveParam> mrParamList = mrList.stream().map(mr -> {
            MailReceiveParam mrParam = new MailReceiveParam();
            BeanUtils.copyProperties(mr, mrParam);
            MailParam mParam = new MailParam();
            // 防止实体属性转换失败
            BeanUtils.copyProperties(mr.getMail(), mParam);
            mrParam.setMail(mParam);
            return mrParam;
        }).collect(Collectors.toList());
        Page<MailReceiveParam> mrParamPage = new Page<>();
        BeanUtils.copyProperties(page, mrParamPage);
        mrParamPage.setRecords(mrParamList);

        return mrParamPage;
    }

    @Override
    public Integer deleteBatch(List<String> mrList) {
        return baseMapper.deleteBatchIds(mrList);
    }

    @Override
    public Integer batchMarkMailRead(List<String> mrIdList) {
        int count = 0;
        for (String mrId : mrIdList) {
            count += markMailRead(mrId);
        }
        return count;
    }

    @Override
    public Integer markMailRead(String mrId) {
        MailReceive mailReceive = new MailReceive();
        mailReceive.setMrId(Long.parseLong(mrId));
        // 致状态为已读
        mailReceive.setMrStatus(2);
        return baseMapper.updateById(mailReceive);
    }

    @Override
    public MailReceiveParam readMail(String mrId) {
        MailReceiveParam mailReceiveParam = new MailReceiveParam();
        MailParam mailParam = new MailParam();
        MailReceive mailReceive = baseMapper.readMail(mrId);
        BeanUtils.copyProperties(mailReceive, mailReceiveParam);
        BeanUtils.copyProperties(mailReceive.getMail(), mailParam);
        mailReceiveParam.setMail(mailParam);
        return mailReceiveParam;
    }

    @Override
    public Integer deleteById(String mrId) {
        return baseMapper.deleteById(mrId);
    }

    private Mail getMailByParam(MailParam mailParam) {
        Mail mail = new Mail();
        BeanUtils.copyProperties(mailParam, mail);
        return mail;
    }
}
