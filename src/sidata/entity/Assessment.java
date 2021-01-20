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
public class Assessment {
    private int assessment_id;
    private Operator user;
    private Device device;
    private Standard standard;
    private SampleElement sampleElement;
    private String testDate;
    private String assmName;
    private String assmCode;
    
    public Assessment() {
        
    }
    
    public Assessment(int assessment_id,
            Operator user,
            Device device,
            Standard standard,
            SampleElement sampleElement,
            String testDate,
            String assmName,
            String assmCode) {
        this.assessment_id = assessment_id;
        this.user = user;
        this.device = device;
        this.standard = standard;
        this.sampleElement = sampleElement;
        this.testDate = testDate;
        this.assmName = assmName;
        this.assmCode = assmCode;
    }
    
    public int getAssessmentId(){
        return this.assessment_id;
    }
    
    public void setAssessmentId(int assessment_id){
        this.assessment_id = assessment_id;
    }

    /**
     * @return the user
     */
    public Operator getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Operator user) {
        this.user = user;
    }

    /**
     * @return the device
     */
    public Device getDevice() {
        return device;
    }

    /**
     * @param device the device to set
     */
    public void setDevice(Device device) {
        this.device = device;
    }

    /**
     * @return the standard
     */
    public Standard getStandard() {
        return standard;
    }

    /**
     * @param standard the standard to set
     */
    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    /**
     * @return the sampleElement
     */
    public SampleElement getSampleElement() {
        return sampleElement;
    }

    /**
     * @param sampleElement the sampleElement to set
     */
    public void setSampleElement(SampleElement sampleElement) {
        this.sampleElement = sampleElement;
    }

    /**
     * @return the testDate
     */
    public String getTestDate() {
        return testDate;
    }

    /**
     * @param testDate the testDate to set
     */
    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    /**
     * @return the assmName
     */
    public String getAssmName() {
        return assmName;
    }

    /**
     * @param assmName the assmName to set
     */
    public void setAssmName(String assmName) {
        this.assmName = assmName;
    }

    /**
     * @return the assmCode
     */
    public String getAssmCode() {
        return assmCode;
    }

    /**
     * @param assmCode the assmCode to set
     */
    public void setAssmCode(String assmCode) {
        this.assmCode = assmCode;
    }
    
    
}
