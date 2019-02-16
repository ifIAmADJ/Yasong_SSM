package Controller;

import Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class LoginHandler {

    @Autowired
    LoginService loginService;

    @RequestMapping("/register")
    public @ResponseBody String testConnection(HttpServletResponse response, HttpServletRequest request,@RequestBody Map<String,String> map)
    {
        Cookie[]  cookies=request.getCookies();
        int count=0;

        for (Cookie c :
                cookies) {
            if (c.getName().equals("name")|| c.getName().equals("password") ){count++;}
            System.out.println(c.getName());
            System.out.println(c.getValue());
        }

        Cookie cookie=new Cookie("name","Dingxingyun");
        Cookie cookie1=new Cookie("password","132");

        cookie.setPath("/");
        cookie.setMaxAge(5);
        cookie1.setPath("/");
        cookie.setMaxAge(5);

        if(count<2) {
            System.out.println("看来之前的cookie失效了。");
            response.addCookie(cookie);
            response.addCookie(cookie1);
        }

        System.out.println(map.get("name"));
        System.out.println(map.get("password"));

        loginService.login("asa","asa");

        return "Hello";
    }

}
