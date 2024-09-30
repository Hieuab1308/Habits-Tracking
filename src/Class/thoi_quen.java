
package Class;

import java.io.Serializable;
import java.util.Date;


public class thoi_quen implements Serializable {
    private String id;                      // mã thói quen
    private  String name;                   //tên thói quen
    private Date ngaybatdau;                   // ngày bắt đầu
    private Date ngayketthuc;               //ngày kết thúc
    
    public thoi_quen() {
    }

    public thoi_quen(String id,String name, Date ngaybatdau, Date ngayketthuc) {
        this.id = id;
        this.name = name;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;

    }
    
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(Date ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }
    public Date getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(Date ngayketthuc){
        this.ngayketthuc = ngayketthuc;
    }
}
