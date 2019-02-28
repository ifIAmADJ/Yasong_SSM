package Controller;

import Dao.UserDao;
import Services.SupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SupplementHandler {

    @Autowired
    SupplementService supplementService;

    @Autowired
    UserDao userDao;

    //完善用户信息。
    @RequestMapping(value = "/supplement")
    public @ResponseBody Map<String,Object>
    trySupplement(@CookieValue(value = "user_id",required = false)String user_id, @RequestBody  Map<String, String> getParams)
    {
        Map<String,Object> resultMap=new HashMap<>();

        if(user_id!=null)
        {
            String hasNewNickname=getParams.get("nickname");
            String hasNewSex=getParams.get("sex");
            String hasNewSignature=getParams.get("signature");

            if(hasNewNickname==null){hasNewNickname="none";}
            if(hasNewSex==null){hasNewSex="none";}
            if(hasNewSignature==null){hasNewSignature="none";}

            //当用户更新完毕之后，返回完整的用户信息。
            if(supplementService.supplementInform(user_id,hasNewNickname,hasNewSex,hasNewSignature).equals("success"))
            {
//                resultMap=userDao.GetUserViewInDB(user_id);
                resultMap.put("msg","完善资料成功");
                resultMap.put("code","0");
                return resultMap;
            }
        }else
        {
            resultMap.put("code","1");
            resultMap.put("msg","您的cookie过期了。");
        }
        return resultMap;
    }
}
