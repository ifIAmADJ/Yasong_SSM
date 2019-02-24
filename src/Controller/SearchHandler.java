package Controller;

import Dao.SearchDao;
import Entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class SearchHandler {

    @Autowired
    SearchDao searchDao;

    //这是通过分页查询的方式。如果不需要进行分页查询。则返回到原改动。
    @RequestMapping("/searchUser")
    public @ResponseBody List<Map<String,Object>> trySearchUser(@RequestParam("keyWord") String KeyWord,@RequestParam("start") Integer start,@RequestParam("count") Integer count)
    {
        Page page=new Page();
        page.setPageSize(count);
        page.setTotalItems(searchDao.CountFoundUsers(KeyWord));
        page.setCurrentPage(start);
        System.out.println(searchDao.CountFoundUsers(KeyWord));
        return searchDao.SearchUserByKeyWord(KeyWord,(page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize());
    }

    @RequestMapping("/searchUserPoems")
    public @ResponseBody List<Map<String,Object>> trySearchUserPoems(@RequestParam("keyWord") String KeyWord)
    {
        return searchDao.SearchUserPoemsByKeyWord(KeyWord);
    }

    @RequestMapping("/searchPoets")
    public @ResponseBody List<Map<String,Object>> trySearchPoets(@RequestParam("keyWord") String KeyWord)
    {
        return searchDao.SearchPoetsByKeyWord(KeyWord);
    }

    @RequestMapping("/searchClassicalPoems")
    public @ResponseBody List<Map<String,Object>> tryClassicalPoems(@RequestParam("keyWord") String KeyWord)
    {
        return searchDao.SearchClassicalPoemsByKeyWord(KeyWord);
    }


}
