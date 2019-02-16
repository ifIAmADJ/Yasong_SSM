package Entity;

import java.sql.Timestamp;

public class User {

//    用户的账户。主键。
    private String account;
//    用户的昵称。
    private String nickname;
//    用户的密码。
    private String password;
//    用户的性别。
    private String sex;
//    用户的经验值。
    private int exp;
//    用户的等级。
    private int level;
//    用户的积分。
    private int point;
//    统计用户的评论数量。
    private int comments;
//    统计用户的粉丝数量。
    private int fans;
//    统计用户获得的点赞数。
    private int likenum;
//    统计用户发布的作品数量。
    private int productions;
//    用户的个性签名。
    private String signature;
//    获取用户的头像存储路径。
    private String avantor_path;
//    用户首次注册的时间。
    private Timestamp join_date;
//    用户最后一次注册的时间。
    private Timestamp last_login_date;

    public User()
    {
        super();
    }

//    ----set和get方法-------------//


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public int getLikenum() {
        return likenum;
    }

    public void setLikenum(int likenum) {
        this.likenum = likenum;
    }

    public int getProductions() {
        return productions;
    }

    public void setProductions(int productions) {
        this.productions = productions;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAvantor_path() {
        return avantor_path;
    }

    public void setAvantor_path(String avantor_path) {
        this.avantor_path = avantor_path;
    }

    public Timestamp getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Timestamp join_date) {
        this.join_date = join_date;
    }

    public Timestamp getLast_login_date() {
        return last_login_date;
    }

    public void setLast_login_date(Timestamp last_login_date) {
        this.last_login_date = last_login_date;
    }

    public User(String account, String nickname, String password, String sex, int exp, int level, int point, int comments, int fans, int likenum, int productions, String signature, String avantor_path, Timestamp join_date, Timestamp last_login_date) {
        this.account = account;
        this.nickname = nickname;
        this.password = password;
        this.sex = sex;
        this.exp = exp;
        this.level = level;
        this.point = point;
        this.comments = comments;
        this.fans = fans;
        this.likenum = likenum;
        this.productions = productions;
        this.signature = signature;
        this.avantor_path = avantor_path;
        this.join_date = join_date;
        this.last_login_date = last_login_date;
    }
}
