package www.xly.com.controller;

import jdk.nashorn.internal.objects.NativeJSON;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import www.xly.com.entity.User;
import www.xly.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    private String check;
    //生成验证码
    private String createCheck(){
        String chars = "0123456789ABCDEFJHIJKLMPOPQRSTUVWXYZ";
        char[] rands = new char[4];
        for(int i=0;i<4;i++){
            int rand = (int)(Math.random()*36);
            rands[i]=chars.charAt(rand);
        }
        this.check = new String(rands);
        return this.check;
    }

    //页面初始化
    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest request){
        request.setAttribute("check",this.createCheck());
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user!=null){
            request.setAttribute("phone",user.getPhone());
        }
        return "login";
    }

    //更新验证码
    @ResponseBody
    @RequestMapping("/toLogin/updateCheck")
    public String updateCheck(HttpServletRequest request){
        return this.createCheck();
    }

    //处理登录功能
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        String phone = request.getParameter("phone");
        String pw = request.getParameter("password");
        String check = request.getParameter("check");
        if(check==null){
            request.setAttribute("check",this.createCheck());
            return "login";
        }

        User user = userService.queryByPhone(phone);

        if(this.check.equals(check)&&user!=null&&pw.equals(user.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            Cookie cookie = new Cookie("username",user.getPhone());
            cookie.setMaxAge(100);
            cookie.setPath("/java22e");
            response.addCookie(cookie);

            request.setAttribute("user",user);
            return "main";
        }

        if(!this.check.equals(check)){
            request.setAttribute("msg","验证码错误!");
        }else if(user==null){
            request.setAttribute("err_user","用户不存在!");
        }else if(!pw.equals(user.getPassword())){
            request.setAttribute("err_pw","密码错误!");
        }
        request.setAttribute("check",this.createCheck());
        request.setAttribute("phone",phone);
        request.setAttribute("pw",pw);

        return "login";
    }

    //免密登录
    @ResponseBody
    @RequestMapping("/toLogin/freeLogin")
    public String fastLogin(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user==null){
            return "0";
        }
        Cookie []cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if("username".equals(cookie.getName())){
                return "1";
            }
        }
        return "0";
    }
    @RequestMapping("/freeLogin")
    public String main(HttpServletRequest request){
        Cookie []cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if("username".equals(cookie.getName())){
                HttpSession session = request.getSession();
                User user = (User)session.getAttribute("user");
                request.setAttribute("user",user);
                return "main";
            }
        }
        return "login";
    }

    //注册用户
    @ResponseBody
    @RequestMapping(value = "/toLogin/register",produces = "text/html; charset=utf-8")
    public String register(HttpServletRequest request, HttpServletResponse response){
        String phone = request.getParameter("phone");
        String pw = request.getParameter("password");
        String check = request.getParameter("check");
        if(check==null){
            request.setAttribute("check",this.createCheck());
            return "login";
        }
        if(!check.equals(this.check)){
            return "{\"status\":0,\"data\":\"验证码错误!\"}";
        }
        User user = userService.queryByPhone(phone);

        if(user!=null){
            return "{\"status\":1,\"data\":\"该用户已存在，去登录!\"}";
        }
        User newUser = new User();
        newUser.setPhone(phone);
        newUser.setPassword(pw);

        userService.insert(newUser);

        HttpSession session = request.getSession();
        session.setAttribute("user",userService.queryByPhone(phone));
        Cookie cookie = new Cookie("username",newUser.getPhone());
        cookie.setMaxAge(100);
        cookie.setPath("/java22e");
        response.addCookie(cookie);

        return "{\"status\":true,\"data\":null}";
    }

    //修改密码
    @ResponseBody
    @RequestMapping(value = "/toLogin/updatePw",produces = "text/html; charset=utf-8")
    public String updatePw(HttpServletRequest request,HttpServletResponse response){
        String phone = request.getParameter("phone");
        String pw = request.getParameter("password");
        String check = request.getParameter("check");

        if(check==null){
            request.setAttribute("check",this.createCheck());
            return "login";
        }
        if(!check.equals(this.check)){
            return "{\"status\":0,\"data\":\"验证码错误!\"}";
        }

        User user = userService.queryByPhone(phone);
        if(user==null){
            System.out.print(phone);
            return "{\"status\":1,\"data\":\"该用户不存在，去注册？\"}";
        }

        user.setPassword(pw);
        userService.update(user);
        HttpSession session = request.getSession();
        session.setAttribute("user",userService.queryByPhone(phone));
        Cookie cookie = new Cookie("username",user.getPhone());
        cookie.setMaxAge(100);
        cookie.setPath("/java22e");
        response.addCookie(cookie);

        return "{\"status\":true,\"data\":\"修改成功，点击前往主页面\"}";
    }

    //修改姓名
    @ResponseBody
    @RequestMapping(value = "/toLogin/updateUserName",produces = "text/html; charset=utf-8")
    public String updateUserName(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        String username = request.getParameter("username");
        if(username==null){
            request.setAttribute("check",this.createCheck());
            return "login";
        }

        if(user==null){
            return  "{\"status\":0,\"data\":\"登录超时，请重新登录!\"}";
        }

        user.setUsername(username);
        userService.update(user);
        session.setAttribute("user",userService.queryByPhone(user.getPhone()));
        Cookie cookie = new Cookie("username",user.getPhone());
        cookie.setMaxAge(100);
        cookie.setPath("/java22e");
        response.addCookie(cookie);

        return "{\"status\":true,\"data\":\"修改成功，点击刷新页面\"}";
    }

    //注销用户
    @ResponseBody
    @RequestMapping(value = "/toLogin/logoutUser",produces = "text/html; charset=utf-8")
    public String logoutUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user!=null){
            userService.deleteById(user.getId());
            session.removeAttribute("user");
        }
        Cookie []cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("username")){
                cookie.setMaxAge(-1);
            }
        }
        return "{\"status\":true,\"data\":\"/toLogin\"}";
    }
}
