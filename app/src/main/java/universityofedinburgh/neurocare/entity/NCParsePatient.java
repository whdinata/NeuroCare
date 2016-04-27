package universityofedinburgh.neurocare.entity;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by whdinata on 4/27/16.
 */
@ParseClassName("Patient")
public class NCParsePatient extends ParseObject{
    private static final String ID = "patientId";
    private static final String NAME = "name";
    private static final String GENDER = "gender";
    private static final String IS_INPATIENT = "isInpatient";
    private static final String BIRTHDATE = "birthdate";
    private static final String DISEASE = "disease";

    public void setId(String id){
        put(ID, id);
    }

    public String getId(){
        return getString(ID);
    }

    public void setName(String name){
        put(NAME, name);
    }

    public String getName(){
        return getString(NAME);
    }

    public void setGender(String gender){
        put(GENDER, gender);
    }

    public String getGender(){
        return getString(GENDER);
    }

    public void setIsInpatient(boolean isInpatient){
        put(IS_INPATIENT, isInpatient);
    }

    public boolean isInpatient(){
        return getBoolean(IS_INPATIENT);
    }

    public void setBirthdate(String birthdate){
        put(BIRTHDATE, birthdate);
    }

    public String getBirthdate(){
        return getString(BIRTHDATE);
    }

    public void setDisease(String disease){
        put(DISEASE, disease);
    }

    public String getDisease(){
        return getString(DISEASE);
    }
}
