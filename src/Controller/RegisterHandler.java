package Controller;

import Dao.UserDao;
import Entity.User;
import Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterHandler {

    @Autowired
    RegisterService registerService;

    @Autowired
    UserDao userDao;

    @RequestMapping("/regist")
    public @ResponseBody Map<String,Object>
    tryRegist(HttpServletResponse response,@RequestBody Map<String,String> map)
    {
        //初始化一个HashMap返回数据用。
        Map<String,Object> returnMap=new HashMap<>();
        Cookie cookie;

        //通过map参数获取用户注册得设置得账号，密码。
        String getSettedUsername=map.get("username");
        String getSettedPassword=map.get("password");
        //交付给Register服务层。
        if(registerService.regist(getSettedUsername,getSettedPassword).equals("success"))
        {
           User returnUser = userDao.GetUserInDB(getSettedUsername);

//           returnMap=userDao.GetUserViewInDB(returnUser.getUser_id());
             returnMap.put("code","0");
             returnMap.put("msg","注册成功");
//            注册完毕后将cookie返回到客户端当中。
            cookie=new Cookie("user_id",returnUser.getUser_id());
            cookie.setMaxAge(60*60*24);
            cookie.setPath("/");
            response.addCookie(cookie);

        }else
        {
            returnMap.put("code","1");
            returnMap.put("msg","该用户名已经存在。");

        }

        return returnMap;
    }

}
