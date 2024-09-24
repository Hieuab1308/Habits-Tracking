/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Thanh Nam
 */
public class thoi_quen {
    private  String name;
    private int id;
    private String mota;
    private String ngaybatdau;
    private String tinhtrang;
    private int muctieuhangngay;
    private int theodoitiendo;
    private int egodz;
    public thoi_quen() {
    }

    public thoi_quen(String name, int id, String mota, String ngaybatdau, String tinhtrang, int muctieuhangngay, int theodoitiendo) {
        this.name = name;
        this.id = id;
        this.mota = mota;
        this.ngaybatdau = ngaybatdau;
        this.tinhtrang = tinhtrang;
        this.muctieuhangngay = muctieuhangngay;
        this.theodoitiendo = theodoitiendo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(String ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public int getMuctieuhangngay() {
        return muctieuhangngay;
    }

    public void setMuctieuhangngay(int muctieuhangngay) {
        this.muctieuhangngay = muctieuhangngay;
    }

    public int getTheodoitiendo() {
        return theodoitiendo;
    }

    public void setTheodoitiendo(int theodoitiendo) {
        this.theodoitiendo = theodoitiendo;
    }
}
