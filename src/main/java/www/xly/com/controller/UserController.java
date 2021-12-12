package www.xly.com.controller;

import org.springframework.ui.Model;
import www.xly.com.entity.User;
import www.xly.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //根据ID查询用户
    @RequestMapping("/queryUserById")
    public String queryById(Integer id, Model model){
        User user = userService.queryById(id);
        if(user==null){
            model.addAttribute("err","该用户不存在!");
            return "err";
        }
        model.addAttribute("user",user);
        return "list";
    }
    //根据phone查询用户
    @RequestMapping("/queryUserByPhone")
    public String queryByPhone(String phone, Model model){
        User user = userService.queryByPhone(phone);
        if(user==null){
            model.addAttribute("err","该用户不存在!");
            return "err";
        }
        model.addAttribute("user",user);
        return "list";
    }
    //根据分页查询用户
    @RequestMapping("/queryUsersByLimit")
    public String queryAllByLimit(Integer offset, Integer limit, Model model){
        List<User> users = userService.queryAllByLimit(offset,limit);
        model.addAttribute("users",users);
        return "list";
    }
    //添加新用户
    @RequestMapping("/insertUser")
    public String insert(HttpServletRequest request){
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.queryByPhone(phone);
        if(user!=null){
            request.setAttribute("err","该用户已存在!");
            return "err";
        }
        User newUser = new User();
        newUser.setPhone(phone);
        newUser.setUsername(username);
        newUser.setPassword(password);
        userService.insert(newUser);
        request.setAttribute("insertUser","欢迎新用户加入!");
        return "list";
    }
    //修改用户数据
    @RequestMapping("/updateUser")
    public String update(HttpServletRequest request){
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.queryByPhone(phone);
        if(user==null){
            request.setAttribute("err","该用户不存在!");
            return "err";
        }
        user.setUsername(username!=null?username:user.getUsername());
        user.setPassword(password!=null?password:user.getPassword());
        userService.update(user);
        request.setAttribute("updateUser","修改成功!");
        return "list";
    }
    //删除用户
    @RequestMapping("/deleteUser")
    public String deleteById(HttpServletRequest request){
        String phone = request.getParameter("phone");
        User user = userService.queryByPhone(phone);
        if(user==null){
            request.setAttribute("err","该用户不存在!");
            return "err";
        }
        userService.deleteById(user.getId());
        request.setAttribute("deleteUser","删除用户成功!");
        return "list";
    }
}
