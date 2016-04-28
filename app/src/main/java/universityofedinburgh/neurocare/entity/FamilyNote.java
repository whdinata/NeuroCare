package universityofedinburgh.neurocare.entity;

import java.io.Serializable;

/**
 * Created by aliakbars on 27/04/16.
 */
public class FamilyNote implements Serializable {

    private String id;
    private String description;
    private String createdDate;
    private String recipientIds; // Patient ID
    private String creator; // User ID of family members

    public FamilyNote(String id, String description, String createdDate, String recipientIds, String creator){
        this.id = id;
        this.description = description;
        this.createdDate = createdDate;
        this.recipientIds = recipientIds;
        this.creator = creator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
