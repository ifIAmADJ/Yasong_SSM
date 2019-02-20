package ServiceAPI;

import Dao.UserDao;
import Service.SupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("supplementService")
public class SupplementServiceIMP implements SupplementService {

    @Autowired
    UserDao userDao;

    @Transactional
    @Override
    public String supplementInform(String user_id, String nickname, String sex, String signature) {

        try {
            if (!nickname.equals("none")) {
                userDao.UpdateNickname(user_id,nickname);
            }

            if (!sex.equals("none")) {
                userDao.UpdateSex(user_id,sex);
            }

            if (!signature.equals("none")) {
                userDao.UpdateSignature(user_id,signature);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return "success";
    }
}
