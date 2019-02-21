package Entity;

public class UserPoem {

    private Integer poem_code;
    private String nickname;
    private String avanta_path;
    private String title;
    private String text;
    private Integer comments_number;
    private Integer like_number;
    private Integer mark_number;

    public UserPoem()
    {
        super();
    }

    public UserPoem(Integer poem_code, String nickname, String avanta_path, String title, String text, Integer comments_number, Integer like_number, Integer mark_number) {
        this.poem_code = poem_code;
        this.nickname = nickname;
        this.avanta_path = avanta_path;
        this.title = title;
        this.text = text;
        this.comments_number = comments_number;
        this.like_number = like_number;
        this.mark_number = mark_number;
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

    @Override
    public String toString() {
        return "UserPoem{" +
                "poem_code=" + poem_code +
                ", nickname='" + nickname + '\'' +
                ", avanta_path='" + avanta_path + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", comments_number=" + comments_number +
                ", like_number=" + like_number +
                ", mark_number=" + mark_number +
                '}';
    }
}
