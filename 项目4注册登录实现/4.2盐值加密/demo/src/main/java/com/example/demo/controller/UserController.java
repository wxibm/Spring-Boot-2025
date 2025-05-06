package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.MD5;
import com.example.demo.utils.ReturnRandom;
import com.example.demo.utils.ReturnT;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    private String IMAGE_CODE_SESSION = "IMAGE_CODE";

    @PostMapping("/login")
    public ReturnT<User> login(@RequestBody User user) {
        System.out.println("开始验证用户名和密码==========");
        return userService.login(user.getUserName(), MD5.encrypt(user.getPassword()));
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

    @GetMapping("/salt")
    public String salt(@RequestParam(name="password") String password) {
        String salt=MD5.getRandomSalt(6);
        System.out.println("盐值为："+salt);
        //随机生成的字符串在用户注册的时候生成，需要单独设字段添加到用户表中
        return("盐值加密的新密码为："+MD5.encrypt(password+salt));
    }

}
