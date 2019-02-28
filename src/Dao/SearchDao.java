package Dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SearchDao {

    List<Map<String,Object>> SearchUserByKeyWord(@Param("keyWord") String keyWord,@Param("start") Integer start,@Param("count") Integer count);
    List<Map<String,Object>> SearchUserPoemsByKeyWord(@Param("keyWord") String keyWord,@Param("start") Integer start,@Param("count") Integer count);
    List<Map<String,Object>> SearchPoetsByKeyWord(@Param("keyWord") String keyWord,@Param("start") Integer start,@Param("count") Integer count);
    List<Map<String,Object>> SearchClassicalPoemsByKeyWord(@Param("keyWord") String keyWord,@Param("start") Integer start,@Param("count") Integer count);
    Integer CountFoundUsers(@Param("keyWord") String keyWord);
    Integer CountFoundUserPoems(@Param("keyWord") String keyWord);
    Integer CountFoundPoets(@Param("keyWord") String keyWord);
    Integer CountFoundClassicalPoems(@Param("keyWord") String keyWord);
}
