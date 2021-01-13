/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidata.entity;

/**
 *
 * @author syubban
 */
public class Standard {
    private int standardId;
    private String standardName;
    private String standardDescription;
    
    public Standard(){
        
    }
    
    public Standard(int standardId, String standardName, String standardDescription){
        this.standardId = standardId;
        this.standardName = standardName;
        this.standardDescription = standardDescription;
    }

    /**
     * @return the standardId
     */
    public int getStandardId() {
        return standardId;
    }

    /**
     * @param standardId the standardId to set
     */
    public void setStandardId(int standardId) {
        this.standardId = standardId;
    }

    /**
     * @return the standardName
     */
    public String getStandardName() {
        return standardName;
    }

    /**
     * @param standardName the standardName to set
     */
    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }       
    
    public void setStandardDescription(String standardDescription) {
        this.standardDescription = standardDescription;
    }
    
    public String getStandardDescription(){
        return standardDescription;
    }
    
}
