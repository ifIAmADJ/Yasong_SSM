package Dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ClassicalPoemsDao {

    Map<String,Object> getDailyPoem();

    String ifThisClassicalPoemHasMarked(@Param("user_id") String user_id,@Param("poem_code") Integer poem_code);
    boolean markThisClassicalPoem(@Param("user_id") String user_id,@Param("poem_code") Integer poem_code);
}
