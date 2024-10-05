
package Class;

import java.io.Serializable;

/**
 *
 * @author Pamlamdi
 */
public class user implements Serializable {
    private String id;            //tên đăng nhập
//    private int id;                 // id 
    private String email;           // email
    private String matkhau;         //mật khẩu đăng nhập
    private boolean role;            // vai trò (addmin và ưeser)   
   

    public user(){}
    public user( String id, String email, String matkhau, boolean role) {
        this.id = id;
//        this.name = name;
        this.email = email;
        this.matkhau = matkhau;
        this.role = role;
        
    }
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

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
    public void setRole(boolean role){
        this.role = role;
    }

    public String getemail() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
