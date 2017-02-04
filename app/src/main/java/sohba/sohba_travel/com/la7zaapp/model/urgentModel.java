package sohba.sohba_travel.com.la7zaapp.model;

/**
 * Created by ascom on 05/04/2016.
 */
public class urgentModel {


    private String hosptialName;
    private String area;
    private String numberPatient;

    public urgentModel(String hosptialName, String area, String numberPatient) {
        this.hosptialName = hosptialName;
        this.area = area;
        this.numberPatient = numberPatient;
    }

    public urgentModel() {
    }

    public String getHosptialName() {
        return hosptialName;
    }

    public void setHosptialName(String hosptialName) {
        this.hosptialName = hosptialName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNumberPatient() {
        return numberPatient;
    }

    public void setNumberPatient(String numberPatient) {
        this.numberPatient = numberPatient;
    }
}
