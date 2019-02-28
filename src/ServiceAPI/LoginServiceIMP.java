package ServiceAPI;

import Dao.UserDao;
import Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("loginService")
public class LoginServiceIMP implements LoginService {

    @Autowired
    UserDao userDao;

    @Override
   @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String login(String username, String password) {

        if(userDao.Validation(username,password)!=null)
        {
            return "success";
        }else
        {
            return "exist";
        }

    }
}
