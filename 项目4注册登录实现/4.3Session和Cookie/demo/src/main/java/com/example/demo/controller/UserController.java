package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.ReturnRandom;
import com.example.demo.utils.ReturnT;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    private String IMAGE_CODE_SESSION = "IMAGE_CODE";

    @PostMapping("/login")
    public ReturnT<User> login(@RequestBody User _user,HttpSession session) {
        System.out.println("开始验证用户名和密码==========");
        ReturnT<User> user=userService.login(_user.getUserName(), _user.getPassword());
        if (user.getCode() == 200)
            session.setAttribute("userName", _user.getUserName());
        return user;
    }

    @PostMapping("/login2")
    public ReturnT<User> login(@RequestBody User _user,HttpServletResponse response) {
        System.out.println("开始验证用户名和密码==========");
        ReturnT<User> user=userService.login(_user.getUserName(), _user.getPassword());
        if (user.getCode() == 200) {
//            创建Cookie对象
            Cookie cookieUserName = new Cookie("userName", _user.getUserName());
            Cookie cookiePassword = new Cookie("password", _user.getPassword());
            cookieUserName.setMaxAge(3600);
            cookiePassword.setMaxAge(3600);
//            代表所有路径下都会携带此cookie信息
            cookieUserName.setPath("/");
//            通知客户端保存Cookie
            response.addCookie(cookieUserName);
            response.addCookie(cookiePassword);
        }
        return user;
    }

    @GetMapping("/sessions")
    public void getSessions(HttpServletRequest request) {
        HttpSession sessions = request.getSession(false);
        if (sessions != null) {
//            获取session中所有的键值
            Enumeration<?> enumeration = sessions.getAttributeNames();
//            遍历enumeration
            while (enumeration.hasMoreElements()) {
                String name = enumeration.nextElement().toString();
                Object value = sessions.getAttribute(name);
                System.out.println("Session的name = " + name + "，value = " + value);
            }
        } else {
            System.out.println("session为空");
        }
    }

    @DeleteMapping("/logout")
    public String deleteSession(HttpServletRequest request, HttpServletResponse response) {
//        getSession(false)方法被用来获取session，如果当前没有session，则返回null
        HttpSession session = request.getSession(false);
//        session.removeAttribute("username");
        if (session != null) {
            session.invalidate(); // 删除session
        }
        System.out.println("所有session已删除");
        return ("所有session已删除");
    }

    @GetMapping("/cookies")
    public void getCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println("Cookie的name = " + name + "，value = " + value);
            }
        }
        else{
            System.out.println("cookie为空");
        }
    }

    @DeleteMapping(value = "/cookies")
    public String deleteCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
//                将每个cookie的过期时间设置为0
                cookie.setMaxAge(0);
//                通过response.addCookie(cookie)方法将更新后的cookie添加到响应中
                response.addCookie(cookie);
            }
            System.out.println("所有cookie已删除");
            return ("所有cookie已删除");
        } else {
            System.out.println("未读取到cookie");
            return ("未读取到cookie");
        }
    }

    @GetMapping("/list")
    public String list(HttpSession session) {
        // 判断session是否存在
        if (session != null && session.getAttribute("userName") != null) {
            // session存在
            String userName = (String) session.getAttribute("userName");
            System.out.println("当前用户是：" + userName);
            return ("当前用户是：" + userName);
        } else {
            // session不存在
            System.out.println("session不存在，请先登录");
            return ("session不存在，请先登录");
        }
    }

    @RequestMapping("/getImgCode")
    public void getImgCode(HttpServletRequest request, HttpServletResponse response) {
        int width = 80;
        int height = 30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics graphics = image.getGraphics();
        //设置画笔颜色为白色
        graphics.setColor(Color.white);
        //填充图片
        graphics.fillRect(0, 0, width, height);
        //设置画笔颜色为黑色
        graphics.setColor(Color.black);
        //设置字体的小大
        graphics.setFont(new Font("黑体", Font.BOLD, 24));
        //产生4个随机验证码
        String checkCode = ReturnRandom.getCheckCode();
        //将验证码放入HttpSession中
        HttpSession session = request.getSession();
        session.setAttribute(IMAGE_CODE_SESSION, checkCode);
        //向图片上写入验证码
        graphics.drawString(checkCode, 15, 25);
        //将内存中的图片输出到浏览器
        try {
            response.setContentType("image/png");
            ImageIO.write(image, "PNG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
