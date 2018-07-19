package com.example.ktws.controller;

import com.example.ktws.domain.User;
import com.example.ktws.service.UserService;
import com.example.ktws.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Iterable<UserInfo> getAllUsers(){
        List<User> users = (List<User>) userService.getAllUsers();
        List<UserInfo> userInfos = new ArrayList<>();
        for (User user : users) {
            UserInfo userInfo = new UserInfo();
            userInfo.setName(user.getName());
            userInfo.setCoursenum(user.getCourses().size());
            userInfo.setEmail(user.getEmail());
            userInfo.setPhone(user.getPhone());
            userInfos.add(userInfo);
        }
        return userInfos;
    }

    @PostMapping("/add")
    public User addNewUser(@RequestBody Map map){
        User n = new User();
        n.setName((String)map.get("name"));
        n.setPwd((String)map.get("pwd"));
        n.setEmail((String)map.get("email"));
        n.setPhone((String)map.get("phone"));
        return userService.addNewUser(n);
    }

    @PostMapping("/update")
    public boolean updateUser(@RequestBody Map map, HttpServletRequest request){
        String mode = (String) map.get("mode");
        User u = (User)request.getSession().getAttribute("User");
        if(u == null){
            System.out.println("no user in session!");
            return false;
        }

        if("0".equals(mode)){
            String oldPwd = (String) map.get("oldPwd");
            String newPwd = (String) map.get("newPwd");
            if(userService.updatePwd(oldPwd, newPwd, u)){
                u.setPwd(newPwd);
                request.setAttribute("User",u);
            }
            else {
                System.out.println("wrong old pwd!");
                return false;
            }
        }
        else if("1".equals(mode)){
            String newEmail = (String)map.get("newEmail");
            userService.updateEmail(newEmail, u);
            u.setEmail(newEmail);
            request.setAttribute("User",u);
        }
        else if("2".equals(mode)){
            String newPhone = (String)map.get("newPhone");
            userService.updatePhone(newPhone, u);
            u.setPhone(newPhone);
            request.setAttribute("User",u);
        }
        else {
            System.out.println("mode error!");
            return false;
        }
        return true;
    }

    @PostMapping("/delete")
    public boolean deleteUser(HttpServletRequest request){
        User u = (User)request.getSession().getAttribute("User");
        request.getSession().invalidate();
        return userService.deleteUser(u);
    }

    @PostMapping("/login")
    public boolean checkUsers(@RequestBody Map map, HttpServletRequest request) {
        User u = userService.login((String)map.get("name"),(String)map.get("pwd"));
        if(u == null){
            return false;
        }
        request.getSession().setAttribute("User",u);
        return true;
    }

    @PostMapping("/logout")
    public boolean logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return true;
    }

    @GetMapping("/checkDup")
    public boolean findUsers(@RequestParam String name){
        return userService.checkDup(name);
    }
}