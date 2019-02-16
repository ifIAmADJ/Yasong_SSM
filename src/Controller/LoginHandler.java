package Controller;

import Dao.UserDao;
import Entity.User;
import Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    Map<String,Object> tryLogin(HttpServletResponse response, HttpServletRequest request, @RequestBody Map<String,String> map)
    {
        Map<String,Object> returnMap=new HashMap<>();

        returnMap.put("code","1");

        if(loginService.login(map.get("username"),map.get("password")).equals("success"))
        {
            User returnUser = userDao.GetUserInDB(map.get("username"));

            returnMap.put("code","0");
            returnMap.put("user_id",returnUser.getUser_id());
            returnMap.put("username",returnUser.getUsername());
            returnMap.put("nickname",returnUser.getNickname());
            returnMap.put("sex",returnUser.getSex());
            returnMap.put("exp",returnUser.getExp());
            returnMap.put("level",returnUser.getLevel());
            returnMap.put("points",returnUser.getPoints());
            returnMap.put("comments",returnUser.getComments());
            returnMap.put("fans",returnUser.getFans());
            returnMap.put("likenum",returnUser.getFans());
            returnMap.put("productions",returnUser.getProductions());
            returnMap.put("signature",returnUser.getSignature());
            returnMap.put("avanta_path",returnUser.getAvanta_path());
        }else
        {
            returnMap.put("code","1");
            returnMap.put("msg","账号或者用户名不正确，请确认。");
        }
        return returnMap;

    }

}
