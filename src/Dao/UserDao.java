package Dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    /**
     * 该方法用于验证用户的身份，在登陆界面使用。
     * @param account   账户名
     * @param password  账户密码。
     * @return 若账户名不存在或者账户密码错误，则不返回字符串。
     */
    String Validation(@Param("account") String account,@Param("password") String password);

}
