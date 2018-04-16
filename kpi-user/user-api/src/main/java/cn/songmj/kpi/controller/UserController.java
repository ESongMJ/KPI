package cn.songmj.kpi.controller;


import cn.songmj.kpi.enums.StatusCode;
import cn.songmj.kpi.param.UserParam;
import cn.songmj.kpi.result.Result;
import cn.songmj.kpi.service.UserService;
import cn.songmj.kpi.util.CookieUtil;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author meijie.song123
 * @since 2018-03-23
 */
@RestController
@RequestMapping("/sys/user")
public class UserController extends BaseController {
    @Resource
    private UserService userService;
    @Resource
    private DefaultKaptcha defaultKaptcha;

    @PostMapping("/page")
    public Result page(UserParam userParam) {
        Page<UserParam> paramPage = userService.page(userParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), paramPage);
    }
    @PostMapping("/list")
    public Result list(UserParam userParam) {
        List<UserParam> userParamList = userService.list(userParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), userParamList);
    }
    @PostMapping("/uid/list")
    @CrossOrigin
    public Result listUserIds(UserParam userParam) {
        List<Long> uids = userService.listUserIds(userParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), uids);
    }
    @PostMapping("/save")
    public Result save(UserParam userParam) {
        userService.save(userParam);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
    @PostMapping("/delete")
    public Result delete(Long userId) {
        userService.delete(userId);
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg());
    }
    @PostMapping("/checkLogin")
    public Result checkLogin(HttpServletRequest request) {
        UserParam userParam = (UserParam) getSessionValue(request, "user");
        if (userParam == null) {
            return view(StatusCode.LOGOUT.getCode(), StatusCode.LOGOUT.getMsg());
        }
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), userParam);
    }
    @PostMapping("/getUser")
    @CrossOrigin
    public Result getLoginUser(Long userId) {
        UserParam userParam = userService.getUserById(userId);

        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), userParam);
    }
    @PostMapping("/login")
    public Result login(HttpServletRequest request, HttpServletResponse response, UserParam userParam, String code) {
        if (!verifyCode(request, code)) {
            return view(StatusCode.FAIL.getCode(), "验证码输入错误");
        }
        List<UserParam> userParamList = userService.list(userParam);
        if (userParamList.size() != 1) {
            return view(StatusCode.FAIL.getCode(), "用户名错误");
        }
        UserParam userParam1 = new UserParam();
        BeanUtils.copyProperties(userParamList.get(0), userParam1);
        if (!userParam1.getUserPassword().equals(userParam.getUserPassword())) {
            return view(StatusCode.FAIL.getCode(), "密码错误");
        }
        setSessionValue(request, "user", userParam1);
        response.addCookie(bindUserToCookie(userParam1));
        return view(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), userParam1);
    }
    private Cookie bindUserToCookie(UserParam userParam) {
        Cookie userCookie = new Cookie("user_id", String.valueOf(userParam.getUserId()));
        userCookie.setMaxAge(60 * 60 * 24);
        userCookie.setPath("/");
        return userCookie;
    }

    public Boolean verifyCode(HttpServletRequest request, String code) {
        String key = "verifyCode";
        if (code.equals(getSessionValue(request, key))) {
            return true;
        }
        return false;
    }
    /**
     * 获取登录验证码接口
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @GetMapping("/verifyCode")
    public Object getVerifyCode(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            setSessionValue(httpServletRequest, "verifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        byte[] captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        try {
            ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
            responseOutputStream.write(captchaChallengeAsJpeg);
            responseOutputStream.flush();
            responseOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

