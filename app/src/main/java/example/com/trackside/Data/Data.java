package example.com.trackside.Data;

/**
 * Created by User on 7/14/2017.
 */

public class Data {


    public int imageId;
    public String txt;



    public Data(String text, int imageId) {

        this.txt=text;
        this.imageId = imageId;
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
}
