package cn.songmj.kpi.controller;


import cn.songmj.kpi.entity.Mail;
import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.param.MailParam;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.service.MailReceiveService;
import cn.songmj.kpi.service.MailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author meijie.song123
 * @since 2018-03-23
 */
@RestController
@RequestMapping("/mail")
public class MailController extends BaseController {
    @Resource
    private MailService mailService;
    @Resource
    private MailReceiveService mailReceiveService;
    @PostMapping("/send")
    public Result send(@RequestParam("mail") MailParam mailParam, @RequestParam("udis[]") String[] uidList) {
        Mail mail = mailService.save(mailParam);
        // 若保存成功
        if (mail.getMailId() != null) {
            // 发送邮件
            mailReceiveService.send(mail.getMailId(), Arrays.asList(uidList));
        }
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
    @PostMapping("/save")
    public Result save(MailParam mailParam) {
        mailService.save(mailParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
    @PostMapping("/get/one")
    public Result getMail(String userId) {
        MailParam mailParam = mailService.getMail(userId);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), mailParam);
    }
}

