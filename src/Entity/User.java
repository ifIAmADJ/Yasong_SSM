package Entity;

import java.sql.Timestamp;

/**
 * 这个实体类装载了用户的所有信息。
 */
public class User {

//    在数据库中的主键。会加密成MD5码。
    private String user_id;
//    用户的账号。
    private String username;
//    用户的昵称。
    private String nickname;
//    用户的密码。
    private String password;
//    用户的性别。
    private String sex;
//    用户的经验值。
    private Integer exp;
//    用户的等级。
    private Integer level;
//    用户的积分。
    private Integer points;
//    统计用户的评论数量。
    private Integer comments;
//    统计用户的粉丝数量。
    private Integer fans;
//    统计用户获得的点赞数。
    private Integer likenum;
//    统计用户发布的作品数量。
    private Integer productions;
//    用户的个性签名。
    private String signature;
//    获取用户的头像存储路径。
    private String avanta_path;
//    用户首次注册的时间。
    private Timestamp join_date;
//    用户最后一次注册的时间。
    private Timestamp last_login_date;

    public User()
    {
        super();
    }

//    ----set和get方法-------------//


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public Integer getLikenum() {
        return likenum;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }

    public Integer getProductions() {
        return productions;
    }

    public void setProductions(Integer productions) {
        this.productions = productions;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAvanta_path() {
        return avanta_path;
    }

    public void setAvanta_path(String avanta_path) {
        this.avanta_path = avanta_path;
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

    public User(String user_id, String username, String nickname, String password, String sex, int exp, int level, int point, int comments, int fans, int likenum, int productions, String signature, String avantor_path, Timestamp join_date, Timestamp last_login_date) {
        this.user_id = user_id;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.sex = sex;
        this.exp = exp;
        this.level = level;
        this.points = point;
        this.comments = comments;
        this.fans = fans;
        this.likenum = likenum;
        this.productions = productions;
        this.signature = signature;
        this.avanta_path = avantor_path;
        this.join_date = join_date;
        this.last_login_date = last_login_date;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", exp=" + exp +
                ", level=" + level +
                ", points=" + points +
                ", comments=" + comments +
                ", fans=" + fans +
                ", likenum=" + likenum +
                ", productions=" + productions +
                ", signature='" + signature + '\'' +
                ", avanta_path='" + avanta_path + '\'' +
                ", join_date=" + join_date +
                ", last_login_date=" + last_login_date +
                '}';
    }
}
