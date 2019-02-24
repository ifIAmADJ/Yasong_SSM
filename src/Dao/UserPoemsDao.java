package Dao;


import Entity.UserPoem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserPoemsDao {

    List<UserPoem> getUserPoemsByListOrderByLike_num(@Param("start") Integer start,@Param("perPageSize")Integer perPageSize);
    List<UserPoem> getUserPoemsByListOrderByDatetime(@Param("start") Integer start,@Param("perPageSize")Integer perPageSize);

    Integer getTotalItems();

}
