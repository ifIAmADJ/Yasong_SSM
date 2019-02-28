package Controller;

import Dao.ClassicalPoemsDao;
import Entity.Page;
import Services.MarkClassicalPoem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ClassicalPoemHandler {

    @Autowired
    ClassicalPoemsDao classicalPoemsDao;

    @Autowired
    MarkClassicalPoem markClassicalPoem;

    //收藏这首古诗
    @RequestMapping("/markThisClassicalPoem")
    public @ResponseBody Map<String,String>
    markThisClassicalPoem(@CookieValue( value = "user_id",required = false)String user_id, @RequestParam Integer poem_code)
    {
        Map<String,String> resultMap=new HashMap<>();
        if(user_id!=null) {
                if(markClassicalPoem.markThisClassicalPoem(user_id,poem_code))
                {
                    resultMap.put("code","0");
                    resultMap.put("msg","收藏成功");
                }else
                {
                    resultMap.put("code","1");
                    resultMap.put("crash","收藏失败");
                }

        } else{
                resultMap.put("code","1");
                resultMap.put("msg","您的Cookie已经过期了。");
        }
        return  resultMap;

    }

    //获取这首诗所有的信息
    @RequestMapping("/browseClassicalPoem")
    public @ResponseBody Map<String,Object> browseClassicalPoem(@RequestParam Integer poem_code)
    {
        try {

            System.out.println( classicalPoemsDao.browseClassicalPoem(poem_code));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
       return classicalPoemsDao.browseClassicalPoem(poem_code);
    }

    //对这首诗发表评价
    @RequestMapping("/putComment2ClassicalPoem")
    public @ResponseBody Map<String,String> putComment2ClassicalPoem(@CookieValue("user_id") String user_id, @RequestBody Map<String,Object> map)
    {
        Map<String,String> resultMap =new HashMap<>();

       if(user_id!=null)
       {
           try {
               Timestamp timestamp=new Timestamp(System.currentTimeMillis());
               classicalPoemsDao.putComment2ClassicalPoem((Integer)map.get("poem_code"),timestamp, user_id, (String) map.get("comment_text"));
               resultMap.put("code","0");
               resultMap.put("msg","评论成功");
           }catch (Exception e)
           {
               e.printStackTrace();
           }
       }else
       {
           resultMap.put("code","1");
           resultMap.put("msg","您的Cookie过期了。");
       }

       return  resultMap;
    }

    //分页获取这首诗所有的评价
    @RequestMapping("/getCommentsByClassicalPoemCode")
    public @ResponseBody List<Map<String,Object>> getCommentsByClassicalPoemCode(@RequestParam("poem_code")Integer poem_code, @RequestParam("start")Integer start, @RequestParam("count")Integer count)
    {
            if (start<1)start=1;
            if(count<1)count=1;
            Page page = new Page();
            page.setTotalItems(classicalPoemsDao.CountCommentsByClassicalPoemCode(poem_code));
            page.setPageSize(count);
            page.setCurrentPage(start);

            return classicalPoemsDao.getCommentsByClassicalPoemCode(poem_code, (page.getCurrentPage() - 1) * page.getPageSize(),page.getPageSize());

    }

    //获取所有收藏的用户作品
    @RequestMapping("/getMarkedClassicalPoems")
    public @ResponseBody Map<String,Object> getMarkedUserPoems(@CookieValue(value = "user_id",required = false)String user_id,@RequestParam("start")Integer start,@RequestParam("count")Integer count)
    {
        Map<String,Object> resultMap=new HashMap<>();

        if(user_id!=null)
        {
            Page page=new Page();
            List<Map<String, Object>> items;
            try {
                page.setTotalItems(classicalPoemsDao.CountAllMarkedClassicalPoems(user_id));
                page.setCurrentPage(start);
                page.setPageSize(count);

                 items= classicalPoemsDao.getMarkedClassicalPoems(user_id,(page.getCurrentPage() - 1) * page.getPageSize(), page.getPageSize());

                resultMap.put("data", items);
                resultMap.put("code", "0");
            }catch (Exception e)
            {
                e.printStackTrace();
                resultMap.put("code","1");
                resultMap.put("crash","获取数据异常。");
            }
        }else
        {
            resultMap.put("code","1");
            resultMap.put("msg","您的身份已经过期.");
        }

        return resultMap;

    }

    //不再收藏这首古诗。
    @RequestMapping("/deleteMarkedClassicalPoems")
    public @ResponseBody Map<String,String> deleteMarkedClassicalPoems(@CookieValue("user_id")String user_id,@RequestParam("poem_code")Integer poem_code)
    {
        Map<String,String> resultMap=new HashMap<>();

        if(user_id!=null)
        {
            if(markClassicalPoem.deleteMarkedClassicalPoems(user_id, poem_code))
            {
                resultMap.put("code","0");
                resultMap.put("msg","取消收藏成功");
            }else
            {
                resultMap.put("code","1");
                resultMap.put("crash","操作失败，您可能没有收藏过这首古诗。");
            }
        }else
        {
            resultMap.put("code","1");
            resultMap.put("msg","您的Cookie过期了。");
        }
        return  resultMap;
    }
}
