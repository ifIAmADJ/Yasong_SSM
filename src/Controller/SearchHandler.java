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

    //根据关键字搜索用户。
    @RequestMapping("/searchUser")
    public @ResponseBody List<Map<String,Object>> trySearchUser(@RequestParam("keyWord") String KeyWord,@RequestParam("start") Integer start,@RequestParam("count") Integer count)
    {
        if(start<1)start=1;
        if(count<1)count=1;
        Page page=new Page();
        page.setPageSize(count);
        page.setTotalItems(searchDao.CountFoundUsers(KeyWord));
        page.setCurrentPage(start);
        return searchDao.SearchUserByKeyWord(KeyWord,(page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize());
    }

    //根据关键字搜索用户作品。
    @RequestMapping("/searchUserPoems")
    public @ResponseBody List<Map<String,Object>> trySearchUserPoems(@RequestParam("keyWord") String KeyWord,@RequestParam("start") Integer start,@RequestParam("count") Integer count)
    {
        if(start<1)start=1;
        if(count<1)count=1;
        Page page=new Page();
        page.setPageSize(count);
        page.setTotalItems(searchDao.CountFoundUserPoems(KeyWord));
        page.setCurrentPage(start);
        return searchDao.SearchUserPoemsByKeyWord(KeyWord,(page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize());
    }

    //根据关键字搜索诗人。
    @RequestMapping("/searchPoets")
    public @ResponseBody List<Map<String,Object>> trySearchPoets(@RequestParam("keyWord") String KeyWord,@RequestParam("start") Integer start,@RequestParam("count") Integer count)
    {
        if(start<1)start=1;
        if(count<1)count=1;
        Page page=new Page();
        page.setPageSize(count);
        page.setTotalItems(searchDao.CountFoundPoets(KeyWord));
        page.setCurrentPage(start);
        return searchDao.SearchPoetsByKeyWord(KeyWord,(page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize());
    }


    //根据关键字搜索古代作品。
    @RequestMapping("/searchClassicalPoems")
    public @ResponseBody List<Map<String,Object>> tryClassicalPoems(@RequestParam("keyWord") String KeyWord,@RequestParam("start") Integer start,@RequestParam("count") Integer count)
    {
        if(start<1)start=1;
        if(count<1)count=1;
        Page page=new Page();
        page.setPageSize(count);
        page.setTotalItems(searchDao.CountFoundClassicalPoems(KeyWord));
        page.setCurrentPage(start);
        return searchDao.SearchClassicalPoemsByKeyWord(KeyWord,(page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize());
    }

}
