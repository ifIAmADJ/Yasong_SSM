package Entity;

public class Data extends Inform{

    private Integer code;
    private String account;
    private String password;

    public Data()
    {
        super();
    }

    public Data(Integer code, String account, String password) {
        this.code = code;
        this.account = account;
        this.password = password;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
