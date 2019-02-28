package Dao;


import Entity.UserPoem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


@Repository
public interface UserPoemsDao {

    List<UserPoem> getUserPoemsByListOrderByLike_num(@Param("start") Integer start,@Param("perPageSize")Integer perPageSize);
    List<UserPoem> getUserPoemsByListOrderByDatetime(@Param("start") Integer start,@Param("perPageSize")Integer perPageSize);

    Integer getTotalItems();

    /**
     * 为这首诗点赞。
     * @param poem_code 提供点赞的poem_code
     * @return 数据库操作成功时返回true。
     */
    boolean likeThisPoem(@Param("poem_code")Integer poem_code);

    /**
     * 为了防止多次点赞，点赞时记录此条记录，防止重复刷赞。
     * @param user_id 提供点赞的user_id
     * @param poem_code 提供点赞的poem_code
     * @return 数据库操作成功时返回true.
     */
    boolean logThisLike(@Param("user_id")String user_id,@Param("poem_code")Integer poem_code);
    String ifThisUserPoemIsLiked(@Param("user_id")String user_id,@Param("poem_code")Integer poem_code);

    /**
     * 检测这篇用户作品是否已经被收藏过
     * @param user_id 需要提供用户id
     * @param poem_code 需要提供收藏的poem_code
     * @return
     */
    String ifThisUserPoemHasMarked(@Param("user_id") String user_id,@Param("poem_code") Integer poem_code);

    /**
     * 收藏这条用户作品。
     * @param user_id 需要提供用户id
     * @param poem_code 需要提供收藏的poem_code
     * @return
     */
    boolean markThisUserPoem(@Param("user_id") String user_id, @Param("poem_code") Integer poem_code, @Param("marked_date")Date mark_date);

    /**
     * 获取用户作品的完整视图。
     * @param poem_code 需要提供用户作品的编号。
     * @return
     */
    Map<String,Object> browseThisUserPoem(@Param("poem_code")Integer poem_code);

    /**
     * 对这首用户作品添加评价
     * @param poem_code 需要提供poem_code
     * @param comment_date 需要提供评论时间
     * @param user_id 需要提供评论者的user_id
     * @param comment_text 评论的内容。
     * @return 添加评论成功时返回true。
     */
    boolean  putComment2UserPoem
            (@Param("poem_code")Integer poem_code, @Param("comment_date")Timestamp comment_date
                    ,@Param("user_id")String user_id,@Param("comment_text")String comment_text);

    List<Map<String,Object>>getCommentsByUserPoemCode(@Param("poem_code")Integer poem_code,@Param("start")Integer start,@Param("count")Integer count);
    Integer CountCommentsByUserPoemCode(@Param("poem_code")Integer poem_code);

    /**
     * 获取用户收藏的所有古诗。
     * @param start 当前页。
     * @param count 每一页显示的数量。
     * @return 返回视图。
     */
    List<Map<String,Object>>getMarkedUserPoems(@Param("user_id")String user_id,@Param("start")Integer start,@Param("count")Integer count);
    Integer CountAllMarkedUserPoems(@Param("user_id")String user_id);

    /**
     * 不再收藏这首用户作品。
     * @param user_id 提供user_id
     * @param poem_code 提供要删除收藏的poem_id
     * @return 如果删除成功则返回true。
     */
    boolean deleteMarkedUserPoems(@Param("user_id")String user_id,@Param("poem_code")Integer poem_code);

    /**
     * 返回这首作品的作者。
     * @param poem_code 提供用户作品的编号。
     * @return 返回user_id
     */
    String returnItsAuthor(@Param("poem_code") Integer poem_code);

    /**
     * 这首作品的评论数+1;
     * @param poem_code 提供用户作品的poem_code
     * @return 添加成功时返回boolean。
     */
    boolean addCommentsNumber(@Param("poem_code")Integer poem_code);


    /**
     * 这首作品的收藏数+1;
     * @param poem_code 提供用户作品的poem_code
     * @return 添加成功时返回boolean.
     */
    boolean addMarkedNumber(@Param("poem_code")Integer poem_code);

    /**
     * 这首作品的收藏数-1；
     * @param poem_code 提供用户作品的poem_code
     * @return 添加成功时返回boolean.
     */
    boolean subMarkedNumber(@Param("poem_code")Integer poem_code);


}
