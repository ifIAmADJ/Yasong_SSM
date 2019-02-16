package Dao;

import Entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    /**
     * 该方法用于验证用户的身份，在登陆界面使用。
     * @param username 账号名
     * @param password  账户密码。
     * @return 若账户名不存在或者账户密码错误，则不返回字符串。
     */
    String Validation(@Param("username") String username,@Param("password") String password);

    /**
     *该方法用于注册时，检验用户设置得账号是否已经存在。
     * @param username 需要提供用户设置得账号。
     * @return  若该账号已经被创建，则返回字符串。
     */
    String IsvValidUsername(@Param("username")String username);

    /**
     * 该方法用于注册时，将完整的新用户插入到数据库中。
     * @param user 需要提供用户的名字。
     * @return  当添加成功时，返回true。
     */
    boolean InsertUser2DB(@Param("user")User user);
    /**
     * 该方法用于获取用户的完整信息。
     * @param username 需要提供用户名。
     * @return 将尝试返回完整的用户模型。
     */
    User GetUserInDB(@Param("username")String username);

}