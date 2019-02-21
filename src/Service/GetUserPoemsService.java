package Service;

import Entity.UserPoem;

import java.util.List;

public interface GetUserPoemsService {

    List<UserPoem> getUserPoems(Integer currentPage,Integer pageSize);

}
