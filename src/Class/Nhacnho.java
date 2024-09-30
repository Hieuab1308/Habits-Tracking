
package Class;

import java.io.Serializable;
import java.util.Date;


public class Nhacnho implements Serializable{
    private int Idnhacnho;                //id cần nhắc nhở
    private String habitId;                // id thói quen   
    private Date thoiGianNhacNho;          //thời gian nhắc nhở
    private String tinNhan;                //tin nhắn nhắc nhở
    private String loaiThongBao;            // loại thông báo
    
    public Nhacnho(){};
    public Nhacnho(int Idnhacnho, String habitId, Date thoiGianNhacNho, String tinNhan, String loaiThongBao) {
        this.Idnhacnho = Idnhacnho;
        this.habitId = habitId;
        this.thoiGianNhacNho = thoiGianNhacNho;
        this.tinNhan = tinNhan;
        this.loaiThongBao = loaiThongBao;
    }
    public int getIdnhacnho() {
        return Idnhacnho;
    }

    public void setIdnhacnho(int Idnhacnho) {
        this.Idnhacnho = Idnhacnho;
    }

    public String getHabitId() {
        return habitId;
    }

    public void setHabitId(String habitId) {
        this.habitId = habitId;
    }

    public Date getThoiGianNhacNho() {
        return thoiGianNhacNho;
    }

    public void setThoiGianNhacNho(Date thoiGianNhacNho) {
        this.thoiGianNhacNho = thoiGianNhacNho;
    }

    public String getTinNhan() {
        return tinNhan;
    }

    public void setTinNhan(String tinNhan) {
        this.tinNhan = tinNhan;
    }

    public String getLoaiThongBao() {
        return loaiThongBao;
    }

    public void setLoaiThongBao(String loaiThongBao) {
        this.loaiThongBao = loaiThongBao;
    }


}
