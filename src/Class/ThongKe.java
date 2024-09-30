
package Class;

import java.io.Serializable;


public class ThongKe implements Serializable{
    private int userId;                    // ID người dùng
    private String habitId;                 // ID thói quen
    private int songaythuchien;             //sô ngày thực hiện thói quen
    private int songaykhongthuchien;        //số ngày không thực hiện thói quen

    // Constructor
    
    public ThongKe(){};
    public ThongKe(int userId, String habitId, int songaythuchien, int songaykhongthuchien) {
        this.userId = userId;
        this.habitId = habitId;
        this.songaythuchien = songaythuchien;
        this.songaykhongthuchien = songaykhongthuchien;
        
    }

    // Getter và Setter
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getHabitId() {
        return habitId;
    }

    public void setHabitId(String habitId) {
        this.habitId = habitId;
    }

    public int getSongaythuchien(){
        return songaythuchien;
    }
    public void SetSongaythuchien(int songaythuchien){
        this.songaythuchien = songaythuchien;
    }
    public int getSongaykhongthuchien(){
        return songaykhongthuchien;
    }
    public void setSongaykhongthuchien(int songaykhongthuchien){
        this.songaykhongthuchien = songaykhongthuchien;
    }

}
