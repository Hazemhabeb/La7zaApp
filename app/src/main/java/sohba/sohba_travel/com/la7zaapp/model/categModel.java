package sohba.sohba_travel.com.la7zaapp.model;

/**
 * Created by ascom on 05/04/2016.
 */
public class categModel {


    private String title;
    private int imageUrl;
    private String image;
    private int id;

    public categModel() {
    }

    public categModel(int id, String title, String image) {
        this.title = title;
        this.image = image;
        this.id = id;
    }

    public categModel(String title, String image, int id) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.image = image;
        this.id = id;
    }

    public categModel(String title, int imageUrl, int id) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public categModel(String title, int image){

        this.title = title;
        this.imageUrl = image;
    }


    public int getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }
}
