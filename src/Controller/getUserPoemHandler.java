package Controller;

import Dao.UserPoemsDao;
import Entity.UserPoem;
import Service.GetUserPoemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class getUserPoemHandler {

    @Autowired
    GetUserPoemsService userPoemsService;

    @Autowired
    UserPoemsDao userPoemsDao;

    @RequestMapping("/getUserPoems")
    public @ResponseBody  List<UserPoem>
    getUserPoems(@RequestParam("start") Integer start,@RequestParam("count") Integer count)
    {
        return userPoemsService.getUserPoems(start,count);
    }


}
