package ServiceAPI;

import Entity.Page;
import Dao.UserPoemsDao;
import Entity.UserPoem;
import Service.GetUserPoemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("getUserPoemsService")
public class GetUserPoemsServiceImp implements GetUserPoemsService {


    @Autowired
    UserPoemsDao userPoemsDao;

    @Override
    public List<UserPoem> getUserPoems(Integer currentPage,Integer pageSize) {

        Page page=new Page();

        //通过DAO查询到所有的数据。
        page.setTotalItems(userPoemsDao.getTotalItems());
        //由前端返回当前页面
        page.setCurrentPage(currentPage);
        page.setPageSize(pageSize);
        //模拟分页
        List<UserPoem> userPoemList=userPoemsDao.getUserPoemsByList((currentPage-1)*page.getPageSize(),page.getPageSize());

        return userPoemList;

    }
}
