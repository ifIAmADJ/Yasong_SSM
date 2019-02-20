package ServiceAPI;
import Entity.Code2Md5;
import Entity.User;
import Service.RegisterService;
import Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Service("registerService")
public class RegisterServiceIMP implements RegisterService {

    @Autowired
    UserDao userDao;

    @Override
    public String regist(String username, String password) {


        //判断该用户名是否已经重复。
        if(userDao.IsvValidUsername(username)!=null)
        {
            //返回结果。
            return "InvalidUsername";
        }
         else
        {
            //生成注册时的时间戳。
           Timestamp timestamp=new Timestamp(System.currentTimeMillis());
            //使用MD5码生成user_id。根据用户传入的用户名生成。
           String initUser_id=Code2Md5.encryption(username);
            System.out.println("time:"+timestamp);
            System.out.println("initUser_id"+initUser_id);
            //创建User类POJO,进行装载。
            User user=new User(initUser_id,username,"无名侠客",password,"male",0,1,0,0,0,0,0,"Ta很神秘~","/",timestamp,timestamp);
            System.out.println(user.toString());
            //调用持久层接口.
            userDao.InsertUser2DB(user);

            //成功后返回字符串。
            return "success";
        }
    }
}
