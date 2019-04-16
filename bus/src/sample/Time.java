package sample;

public class Time {
    private String day;
    private String month;
    private String year;
    private String deptime;

    public Time(String day, String month, String year, String deptime) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.deptime = deptime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDeptime() {
        return deptime;
    }

    public void setDeptime(String deptime) {
        this.deptime = deptime;
    }
    public String getDeptdate()
    {
        return this.deptime+" "+this.day+"/"+this.month+"/"+this.year;
    }

}
