package Entity;

public class WarnIng extends Inform {

    private Integer code;
    private String msg;

    public WarnIng()
    {
        super();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public WarnIng(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
