package Controller;

import Dao.UserDao;
import Entity.User;
import Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginHandler {

    @Autowired
    LoginService loginService;

    @Autowired
    UserDao userDao;

    @RequestMapping("/login")
    public @ResponseBody
    Map<String,Object> tryLogin(@RequestBody Map<String,String> map,HttpServletResponse response)
    {
        Map<String,Object> returnMap=new HashMap<>();
        Cookie cookie;
        returnMap.put("code","1");

        if(loginService.login(map.get("username"),map.get("password")).equals("success"))
        {
            User returnUser = userDao.GetUserInDB(map.get("username"));

            returnMap=userDao.GetUserViewInDB(returnUser.getUser_id());

            cookie=new Cookie("user_id",returnUser.getUser_id());
            cookie.setMaxAge(60*60*24);
            cookie.setPath("/");
            response.addCookie(cookie);

        }else
        {
            returnMap.put("code","1");
            returnMap.put("msg","账号不存在或者密码不正确，请确认。");
        }
        return returnMap;

    }

}
