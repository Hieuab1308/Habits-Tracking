package Class;
import java.io.Serializable;

public class admin implements Serializable {
    private String id;            //tên đăng nhập
//    private int id;                 // id 
    private String email;           // email
    private String matkhau;         //mật khẩu đăng nhập
    private boolean role;            // vai trò (admin và user)  

    public admin(){}
    public admin( String id, String email, String matkhau, boolean role) {
        this.id = id;

        this.email = email;
        this.matkhau = matkhau;
        this.role = role;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    } 
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getmatkhau() {
        return matkhau;
    }
    public void setPass(String matkhau) {
        this.matkhau = matkhau;
    }
    public boolean getRole(){
        return role;
    }
}
