/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Thanh Nam
 */
public class thoi_quen implements Serializable {
    private String id;
    private  String name;
    private Date ngaybatdau;
    private Date ngayketthuc;
    
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
