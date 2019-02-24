package Controller;

import Dao.ClassicalPoemsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ClassicalPoemHandler {

    @Autowired
    ClassicalPoemsDao classicalPoemsDao;

    @RequestMapping("/markThisClassicalPoem")
    public @ResponseBody Map<String,String>
    markThisClassicalPoem(@CookieValue( value = "user_id",required = false)String user_id, @RequestParam Integer poem_code)
    {
        Map<String,String> resultMap=new HashMap<>();
        if(user_id!=null) {

            String flag=null;
            try {
              flag = classicalPoemsDao.ifThisClassicalPoemHasMarked(user_id,poem_code);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            if(flag!=null)
            {
                resultMap.put("msg","您已经收藏过了。");
                resultMap.put("code","1");
            }else
            {
                //如果没有收藏过。
                if(classicalPoemsDao.markThisClassicalPoem(user_id,poem_code))
                {
                    resultMap.put("code","0");
                    resultMap.put("msg","已添加到收藏");
                }
            }
        } else{
                resultMap.put("code","1");
                resultMap.put("msg","您的Cookie已经过期了。");
        }

        return  resultMap;

    }

}
