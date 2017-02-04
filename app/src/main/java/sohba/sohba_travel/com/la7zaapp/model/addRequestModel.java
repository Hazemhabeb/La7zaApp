package sohba.sohba_travel.com.la7zaapp.model;

/**
 * Created by hazem on 12/9/2016.
 */

public class addRequestModel {
    private String hospital;
    private String area;
    private String bloodType;
    private String patientCase;

    public addRequestModel() {
    }

    public addRequestModel(String hospital, String area, String bloodType, String patientCase) {
        this.hospital = hospital;
        this.area = area;
        this.bloodType = bloodType;
        this.patientCase = patientCase;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getPatientCase() {
        return patientCase;
    }

    public void setPatientCase(String patientCase) {
        this.patientCase = patientCase;
    }
}
