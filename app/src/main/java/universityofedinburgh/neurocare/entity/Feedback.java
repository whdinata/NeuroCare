package universityofedinburgh.neurocare.entity;

import java.io.Serializable;

/**
 * Created by whdinata on 4/27/16.
 */
public class Feedback implements Serializable {
    private String id;
    private String admission;
    private String week;
    private String issue;
    private String createdDate;
    private String recipientIds;
    private boolean mdt;

    public Feedback(NCParseFeedback feedback){
        id = feedback.getObjectId();
        admission = feedback.getAdmission();
        week = feedback.getWeek();
        issue = feedback.getIssue();
        createdDate = feedback.getCreatedDate();
        recipientIds = feedback.getRecipientIds();
        mdt = feedback.isMdt();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getRecipientIds() {
        return recipientIds;
    }

    public void setRecipientIds(String recipientIds) {
        this.recipientIds = recipientIds;
    }

    public boolean isMdt() {
        return mdt;
    }

    public void setMdt(boolean mdt) {
        this.mdt = mdt;
    }
}
