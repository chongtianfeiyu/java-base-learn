package cn.evilcoder.innotation;

/**
 * Created by huangshanqi on 2016/5/4.
 */
@Database("innotation_db")
@Table("innotation_table")
public class UserTable extends Entity{

    @Column(value = "id")
    private long id;

    @Column("username")
    private String username;

    @Column("password")
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
