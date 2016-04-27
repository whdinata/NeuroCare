package universityofedinburgh.neurocare.entity;

import java.io.Serializable;

/**
 * Created by whdinata on 4/27/16.
 */
public class Patient implements Serializable{
    private String name;
    private String id;
    private String gender;
    private String birthdate;
    private String disease;
    private boolean isInpatient;

    public Patient(String name, String id, String gender, boolean isInpatient){
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.isInpatient = isInpatient;
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isInpatient() {
        return isInpatient;
    }

    public void setIsInpatient(boolean isInpatient) {
        this.isInpatient = isInpatient;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
