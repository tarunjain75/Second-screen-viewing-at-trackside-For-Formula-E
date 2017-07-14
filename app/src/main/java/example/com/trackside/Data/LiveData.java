package example.com.trackside.Data;

/**
 * Created by User on 7/14/2017.
 */

public class LiveData {
    public int imageId;
    public String txt;
    public String name;
    public String lap;



    public LiveData(String text, int imageId, String name, String lap) {

        this.txt=text;
        this.imageId = imageId;
        this.name=name;
        this.lap=lap;
    }
    public int getImageId() {

        return imageId;
    }

    public void setImageId(int imageId) {

        this.imageId = imageId;
    }

    public String getTxt() {

        return txt;
    }

    public void setTxt(String txt) {

        this.txt = txt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getLap() {
        return lap;
    }

    public void setLap(String lap) {
        this.lap = lap;
    }

}
