package Controller;

import Dao.ClassicalPoemsDao;
import Dao.UserDao;
import Dao.UserPoemsDao;
import Entity.Page;
import Entity.UserPoem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomePageHandler {

    @Autowired
    UserDao userDao;

    @Autowired
    ClassicalPoemsDao classicalPoemsDao;

    @Autowired
    UserPoemsDao userPoemsDao;

    //主页中获取自己的头像。
    @RequestMapping("/getAvanta")
    public @ResponseBody Map<String, Object> getAvanta(@CookieValue(value = "user_id",required = false)String user_id)
    {
        Map<String,Object> resultMap=new HashMap<>();

        if(user_id!=null)
        {
            resultMap.put("avanta_path", userDao.selectAvanta_pathByUser_id(user_id));
            resultMap.put("code","0");
        }else
        {
            resultMap.put("msg","您的cookie已经过期了。");
            resultMap.put("code","1");
        }

        return resultMap;
    }

    //获取日推
    @RequestMapping("/getDailyPoem")
    public @ResponseBody Map<String,Object> getDailyPoem()
    {
        try {
            System.out.println(classicalPoemsDao.getDailyPoem());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return classicalPoemsDao.getDailyPoem();
    }

    //按照点赞高低的顺序获取用户诗
    @RequestMapping("/getUserPoemsByLikenum")
    public @ResponseBody List<UserPoem>getUserPoemsByLikenum(@RequestParam("start")Integer start,@RequestParam("count")Integer count)
    {
        Page page=new Page();
        //通过DAO查询到所有的数据。
        if(start<1)start=1;
        if(count<0)count=0;
        page.setTotalItems(userPoemsDao.getTotalItems());
        //由前端返回当前页面
        page.setCurrentPage(start);
        page.setPageSize(count);
        //模拟分页
        return userPoemsDao.getUserPoemsByListOrderByLike_num((start - 1) * page.getPageSize(), page.getPageSize());

    }

    //按照时间顺序获取用户诗
    @RequestMapping("/getUserPoemsByDate")
    public @ResponseBody List<UserPoem>getUserPoemsByDate(@RequestParam("start")Integer start,@RequestParam("count")Integer count)
    {
        Page page=new Page();
        //通过DAO查询到所有的数据。
        if(start<1)start=1;
        if(count<0)count=0;
        page.setTotalItems(userPoemsDao.getTotalItems());
        //由前端返回当前页面
        page.setCurrentPage(start);
        page.setPageSize(count);
        //模拟分页
        return userPoemsDao.getUserPoemsByListOrderByDatetime((start-1)*page.getPageSize(),page.getPageSize());
    }

    //点击侧拉框时，弹出用户的简略信息
    @RequestMapping("/getUserView")
    public @ResponseBody Map<String,Object> getUserView(@CookieValue(value = "user_id",required = false)String user_id)
    {
        Map<String,Object> resultMap=new HashMap<>();

        if(user_id!=null)
        {
            resultMap.put("nickname",userDao.selectNicknameByUser_id(user_id));
            resultMap.put("avanta_path",userDao.selectAvanta_pathByUser_id(user_id));
            resultMap.put("points",userDao.selectPointsByUser_id(user_id));
            resultMap.put("achievement",userDao.selectAchievementByUser_id(user_id));
            resultMap.put("code","0");
        }else
        {
            resultMap.put("msg","您的cookie已经过期了。");
            resultMap.put("code","1");
        }
        return resultMap;
    }


}
