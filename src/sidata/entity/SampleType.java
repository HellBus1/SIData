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
public class SampleType {
   private int stId;
   private String stName;
   private String stDate;
   private String stLocation;
   private String stDesription;
   
   public SampleType() {
       
   }
   
   public SampleType(int stId, String stName, String stDate, String stLocation, String stDescription) {
       this.stId = stId;
       this.stName = stName;
       this.stDate = stDate;
       this.stLocation = stLocation;
       this.stDesription = stDescription;
   }

    /**
     * @return the stId
     */
    public int getStId() {
        return stId;
    }

    /**
     * @param stId the stId to set
     */
    public void setStId(int stId) {
        this.stId = stId;
    }

    /**
     * @return the stName
     */
    public String getStName() {
        return stName;
    }

    /**
     * @param stName the stName to set
     */
    public void setStName(String stName) {
        this.stName = stName;
    }

    /**
     * @return the stDate
     */
    public String getStDate() {
        return stDate;
    }

    /**
     * @param stDate the stDate to set
     */
    public void setStDate(String stDate) {
        this.stDate = stDate;
    }

    /**
     * @return the stLocation
     */
    public String getStLocation() {
        return stLocation;
    }

    /**
     * @param stLocation the stLocation to set
     */
    public void setStLocation(String stLocation) {
        this.stLocation = stLocation;
    }
   
   public void setStDescription(String stDescription) {
       this.stDesription = stDescription;
   }
   
   public String getStDescription() {
       return stDesription;
   }
}
