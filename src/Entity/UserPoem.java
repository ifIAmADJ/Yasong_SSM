package Entity;

import java.sql.Time;
import java.sql.Timestamp;

public class UserPoem {

    private Integer poem_code;
    private String nickname;
    private String avanta_path;
    private String achievement;
    private String title;
    private String text;
    private String background_path;
    private String logo_path;
    private Integer comments_number;
    private Integer like_number;
    private Integer mark_number;
    private Object submit_date;

    public UserPoem()
    {
        super();
    }

    public UserPoem(Integer poem_code, String nickname, String avanta_path,String achievement,String title, String text,String background_path ,String logo_path,Integer comments_number, Integer like_number, Integer mark_number,Object submit_date) {
        this.poem_code = poem_code;
        this.nickname = nickname;
        this.avanta_path = avanta_path;
        this.achievement=achievement;
        this.title = title;
        this.text = text;
        this.background_path=background_path;
        this.comments_number = comments_number;
        this.like_number = like_number;
        this.mark_number = mark_number;
        this.submit_date=submit_date;
        this.logo_path=logo_path;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvanta_path() {
        return avanta_path;
    }

    public void setAvanta_path(String avanta_path) {
        this.avanta_path = avanta_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPoem_code() {
        return poem_code;
    }

    public void setPoem_code(Integer poem_code) {
        this.poem_code = poem_code;
    }

    public String getBackground_path() {
        return background_path;
    }

    public void setBackground_path(String background_path) {
        this.background_path = background_path;
    }

    public Integer getComments_number() {
        return comments_number;
    }

    public void setComments_number(Integer comments_number) {
        this.comments_number = comments_number;
    }

    public Integer getLike_number() {
        return like_number;
    }

    public void setLike_number(Integer like_number) {
        this.like_number = like_number;
    }

    public Integer getMark_number() {
        return mark_number;
    }

    public void setMark_number(Integer mark_number) {
        this.mark_number = mark_number;
    }

    public Object getSubmit_date() {
        return submit_date;
    }

    public void setSubmit_date(Object submit_date) {
        this.submit_date = submit_date;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getLogo_path() {
        return logo_path;
    }

    public void setLogo_path(String logo_path) {
        this.logo_path = logo_path;
    }

    @Override
    public String toString() {
        return "UserPoem{" +
                "poem_code=" + poem_code +
                ", nickname='" + nickname + '\'' +
                ", avanta_path='" + avanta_path + '\'' +
                ", achievement='" + achievement + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", background_path='" + background_path + '\'' +
                ", logo_path='" + logo_path + '\'' +
                ", comments_number=" + comments_number +
                ", like_number=" + like_number +
                ", mark_number=" + mark_number +
                ", submit_date=" + submit_date +
                '}';
    }
}
