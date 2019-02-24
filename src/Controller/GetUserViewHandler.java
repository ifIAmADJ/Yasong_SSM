package Controller;

import Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class GetUserViewHandler {

    @Autowired
    UserDao userDao;

    @RequestMapping("/getUserView1")
    public @ResponseBody Map<String, Object> tryGetUserView(@CookieValue(value = "user_id",required = false)String user_id)
    {
        Map<String, Object> returnMap=new HashMap<>();
        if(user_id!=null)
        {
            try {

                returnMap = userDao.GetUserViewInDB(user_id);
                returnMap.put("code","0");

            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }else{
            returnMap.put("code","1");
            returnMap.put("msg","您的cookie过期了。");
        }
        return returnMap;
    }


}
