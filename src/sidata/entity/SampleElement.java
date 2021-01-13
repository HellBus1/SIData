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
public class SampleElement {
    private int seId;
    private String seName;
    private String seDescription;
    
    public SampleElement(){
        
    }
    
    public SampleElement(int seId, String seName, String seDescription){
        this.seId = seId;
        this.seName = seName;
        this.seDescription = seDescription;
    }

    /**
     * @return the seId
     */
    public int getSeId() {
        return seId;
    }

    /**
     * @param seId the seId to set
     */
    public void setSeId(int seId) {
        this.seId = seId;
    }

    /**
     * @return the seName
     */
    public String getSeName() {
        return seName;
    }

    /**
     * @param seName the seName to set
     */
    public void setSeName(String seName) {
        this.seName = seName;
    }

    /**
     * @return the seDescription
     */
    public String getSeDescription() {
        return seDescription;
    }

    /**
     * @param seDescription the seDescription to set
     */
    public void setSeDescription(String seDescription) {
        this.seDescription = seDescription;
    }
    
    
}
