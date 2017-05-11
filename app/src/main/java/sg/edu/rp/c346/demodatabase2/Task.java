package sg.edu.rp.c346.demodatabase2;

/**
 * Created by 15017420 on 11/5/2017.
 */

public class Task {
    private int Id;
    private String description;
    private String date;

    public Task(int Id, String description, String date) {
        this.Id = Id;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return Id;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }
}
