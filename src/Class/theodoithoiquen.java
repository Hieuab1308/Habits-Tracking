
package Class;

import java.io.Serializable;
import java.util.Date;


public class theodoithoiquen implements Serializable {
    private String habitId;                //id của thói quen
    private int userId;                    //id người dùng
    private Date ngay;                     //ngày theo dõi
    private boolean trangThai;              //trạng thái(hoàn thành và chưa hoàn thành)
    
   public theodoithoiquen(){};
   public theodoithoiquen(String habitId, int userId, Date ngay, boolean trangThai) {
        this.habitId = habitId;
        this.userId = userId;
        this.ngay = ngay;
        this.trangThai = trangThai;
    }
   public String getHabitId() {
        return habitId;
    }

    public void setHabitId (String habitId) {
        this.habitId = habitId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    
}
