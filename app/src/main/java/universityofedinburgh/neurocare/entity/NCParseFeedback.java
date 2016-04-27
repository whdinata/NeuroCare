package universityofedinburgh.neurocare.entity;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import universityofedinburgh.neurocare.view.NCFeedbackRightSideView;

/**
 * Created by whdinata on 4/27/16.
 */
@ParseClassName("Feedback")
public class NCParseFeedback extends ParseObject{
    private static final String IS_MDT = "isMDT";
    private static final String RECIPIENT_IDS = "recipient_ids";
    private static final String CREATED_DATE = "created_date";
    private static final String WEEK = "Week";
    private static final String PATIENT_ID = "patient_id";
    private static final String ISSUE = "issue";
    private static final String ADMISSION = "admission";

    public NCParseFeedback(){}

    public NCParseFeedback(Feedback feedback){
        setAdmission(feedback.getAdmission());
        setIssue(feedback.getIssue());
    }

    public void setAdmission(String admission){
        put(ADMISSION, admission);
    }

    public String getAdmission(){
        return getString(ADMISSION);
    }

    public void setIssue(String issue){
        put(ISSUE, issue);
    }

    public String getIssue(){
        return getString(ISSUE);
    }

    public void setRecipientIds(String recipientIds){
        put(RECIPIENT_IDS, recipientIds);
    }

    public String getRecipientIds(){
        return getString(RECIPIENT_IDS);
    }

    public void setCreatedDate(String createdDate){
        put(CREATED_DATE, createdDate);
    }

    public String getCreatedDate(){
        return getString(CREATED_DATE);
    }

    public void setWeek(String week){
        put(WEEK, week);
    }

    public String getWeek(){
        return getString(WEEK);
    }

    public void setIsMdt(boolean isMdt){
        put(IS_MDT, isMdt);
    }

    public boolean isMdt(){
        return getBoolean(IS_MDT);
    }
}
