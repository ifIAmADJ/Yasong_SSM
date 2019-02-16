package ServiceAPI;

import Dao.UserDao;
import Entity.Data;
import Entity.Inform;
import Entity.WarnIng;
import Service.LoginService;
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
    public Inform login(String account, String password) {


        if(userDao.Validation("lijunhu","1234576")!=null)
        {
            return new Data(0,"lijunhu","123456");
        }else
        {
            System.out.println("没这个人！");

            return new WarnIng(1,"账号不存在或者密码错误，请确认。");
        }

    }
}
