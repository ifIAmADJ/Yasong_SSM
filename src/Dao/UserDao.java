package Dao;

import Entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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

    /**
     * 该方法用于返回用户在页面中呈现的可见视图。
     * @param user_id 需要提供用户的user_id
     * @return 将尝试返回部分的用户模型。
     */
    Map<String,Object> GetUserViewInDB(@Param("user_id")String user_id);

    /**
     * 以下是对用户单独属性操作时的完整信息。
     */
    boolean UpdateNickname(@Param("user_id") String user_id,@Param("nickname")String nickname);
    boolean UpdateSex(@Param("user_id") String user_id,@Param("sex")String sex);
    boolean UpdateSignature(@Param("user_id") String user_id,@Param("signature")String signature);

    /**
     * 浏览其他用户的个人信息。
     * @param user_id 需要提供user_id
     * @return 返回用户的视图。
     */
    Map<String,Object>hisInform(@Param("user_id")String user_id);

    /**该方法返回此用户是否是本用户的关注。
     * @param my_id 使用者的user_id
     * @param his_id 其他用户的user_id
     * 如果已关注，则返回字符串。
     */
    String isPicked(@Param("my_id") String my_id,@Param("his_id") String his_id);

    /**
     * 获取这个人的成就墙。
     * @param user_id 获取user_id
     * @return 以List集合返回。
     */
    List<String> hisAchievements(@Param("user_id")String user_id);

    /**
     * 更换用户的头像。
     * @param user_id 提供用户的user_id。
     * @return 更换成功时返回true。
     */
    boolean putMyNewAvanta(@Param("user_id")String user_id,@Param("avanta_path")String avanta_path);

    /**
     * 获取用户足迹的视图。
     * @param user_id 提供用户的user_id。
     * @return
     */
    Map<String,Object> getMyTrack(@Param("user_id")String user_id);

    /**
     * 获取所有的头像。
     * @return 返回头像的路径集合，通过分页查询实现。
     */
    List<String> getAllAvantas(@Param("start")Integer start,@Param("count")Integer count);

    /**
     * 查询所有的头像数目。
     * @return 返回个数
     */
    Integer countALLAvantas();

    /**
     * 获取用户本人的信息视图。
     * @param user_id 需要提供用户user_id
     * @return 返回用户视图。
     */
    Map<String,Object>getMyInform(@Param("user_id")String user_id);

    /**
     * 关注此人。
     * @param my_id 用户本人的user_id
     * @param his_id 其他用户的user_id
     * @return 操作成功则返回true。
     */
    boolean pickHim(@Param("my_id")String my_id,@Param("his_id")String his_id);

    /**
     * 不再关注此人。
     * @param my_id 用户本人的user_id
     * @param his_id 其他用户的user_id
     * @return 操作成功则返回true。
     */
    boolean dissHim(@Param("my_id")String my_id,@Param("his_id")String his_id);


    /**
     * 获取用户获得成就。以及所有的成就。
     * @param user_id
     * @return
     */
    List<String> getMyAchievements(@Param("user_id")String user_id);
    List<String> getALLAchievements();

    /**
     * 检查用户正在替换的称号是否存在。
     * @param user_id 提供user_id
     * @param achievement 提供即将替换的achievement。
     * @return 若存在则返回字符串。
     */
    String isMyAchievement(@Param("user_id")String user_id,@Param("achievement")String achievement);
    /**
     * 更换用户的展示成就。
     * @param user_id 提供用户的user_id
     * @param achievement 提交要更改的成就。
     * @return 操作成功时，返回true。
     */
    boolean chooseMyNewAchievement(@Param("user_id")String user_id,@Param("achievement")String achievement);

    /**
     * 获取我的关注列表。
     * @param user_id 提供用户的user_id
     * @param start 当前页
     * @param count 每一页显示的个数。
     * @return 返回列表。
     */
    List<Map<String,Object>> getIMarkedUsers(@Param("user_id")String user_id,@Param("start")Integer start,@Param("count")Integer count);
    Integer CountIMarkedUsers(@Param("user_id")String user_id);


    /**
     * 获取我的粉丝列表。
     * @param user_id 提供用户的user_id
     * @param start 当前页
     * @param count 每一页显示的个数。
     * @return 返回列表
     */
    List<Map<String,Object>> whoMarkedMe(@Param("user_id")String user_id,@Param("start")Integer start,@Param("count")Integer count);
    Integer CountWhoMarkedMe(@Param("user_id")String user_id);

    /**
     * 以下是使用user_id作为凭据单独访问用户属性的方法。
     */
    String selectNicknameByUser_id(@Param("user_id") String user_id);
    String selectAvanta_pathByUser_id(@Param("user_id") String user_id);
    String selectPointsByUser_id(@Param("user_id")String user_id);
    String selectAchievementByUser_id(@Param("user_id")String user_id);
    /**
     * 以下是更改用户属性的方法。
     */
    boolean addUserFans(@Param("user_id")String user_id);
    boolean subUserFans(@Param("user_id")String user_id);
    boolean addUserLikenum(@Param("user_id")String user_id);
    boolean subUserLikenum(@Param("user_id")String user_id);
    boolean addUserComments(@Param("user_id")String user_id);
    boolean subUserComments(@Param("user_id")String user_id);


}
