package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LogoutHandler {

    //用户注销。
    @RequestMapping("/logout")
    public @ResponseBody Map<String,Object> tryLogout(HttpServletRequest request, HttpServletResponse response)
    {
        Map<String,Object> resultMap=new HashMap<>();
      //搜索关于user_id的cookie，并将其删掉。
        Cookie[] cookies=request.getCookies();

        for (Cookie c :
                cookies) {
           if(c.getName().equals("user_id"))
           {
               c.setMaxAge(0);
               response.addCookie(c);
           }
        }
        resultMap.put("code","0");
        resultMap.put("msg","退出成功");

        return resultMap;
    }

}
