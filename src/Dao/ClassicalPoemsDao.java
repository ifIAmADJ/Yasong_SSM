package Dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.print.DocFlavor;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Repository
public interface ClassicalPoemsDao {

    Map<String,Object> getDailyPoem();

    /**
     ** 检测这首诗是否已经被收藏过
     * @param user_id 需要提供用户id
     * @param poem_code 需要提供收藏的poem_code
     */
    String ifThisClassicalPoemHasMarked(@Param("user_id") String user_id,@Param("poem_code") Integer poem_code);

    /**
     * 收藏这首诗
     * @param user_id 需要提供用户id
     * @param poem_code 需要提供收藏的poem_code
     */
    boolean markThisClassicalPoem(@Param("user_id") String user_id, @Param("poem_code") Integer poem_code, @Param("marked_date")Date marked_date);


    /**
     * 获取一首诗的完整视图。
     * @param poem_code 提供必要的poem_code
     * @return 返回相关属性。
     */
    Map<String,Object>browseClassicalPoem(@Param("poem_code")Integer poem_code);

    /**
     * 将古诗的评论添加到数据库当中。
     * @param poem_code 提供收藏的poem_code
     * @param comment_date 记录评论的时间
     * @param user_id 提供评论的user_id
     * @param comment_text 提供评论的内容。
     * @return 插入数据库成功时，返回true。
     */
    boolean  putComment2ClassicalPoem
            (@Param("poem_code")Integer poem_code, @Param("comment_date")Timestamp comment_date
            ,@Param("user_id")String user_id,@Param("comment_text")String comment_text);

    /**
     * 获取一首古诗的所有的评论。
     * @param poem_code 古诗的poem_code
     * @param start 分页的当前页
     * @param count 每一页显示的个数。
     * @return 返回List。
     */
    List<Map<String,Object>>getCommentsByClassicalPoemCode(@Param("poem_code")Integer poem_code,@Param("start")Integer start,@Param("count")Integer count);
    Integer CountCommentsByClassicalPoemCode(@Param("poem_code")Integer poem_code);


    /**
     * 获取用户收藏的所有古诗。
     * @param start 当前页。
     * @param count 每一页显示的数量。
     * @return 返回视图。
     */
    List<Map<String,Object>>getMarkedClassicalPoems(@Param("user_id")String user_id,@Param("start")Integer start,@Param("count")Integer count);
    Integer CountAllMarkedClassicalPoems(@Param("user_id")String user_id);

    /**
     * 不再收藏这首古诗。
     * @param user_id 提供user_id
     * @param poem_code 提供要删除收藏的poem_id
     * @return 如果删除成功则返回true。
     */
    boolean deleteMarkedClassicalPoems(@Param("user_id")String user_id,@Param("poem_code")Integer poem_code);

    /**
     * 这首古诗的收藏数+1
     * @param poem_code 提供古诗的poem_code
     * @return 操作成功时返回true。
     */
    boolean addMarkedNumber(@Param("poem_code")Integer poem_code);
    /**
     * 这首古诗的收藏数-1
     * @param poem_code 提供古诗的poem_code
     * @return 操作成功时返回true。
     */
    boolean subMarkedNumber(@Param("poem_code")Integer poem_code);
}
