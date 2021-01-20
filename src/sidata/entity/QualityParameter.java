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
public class QualityParameter {
    private int qpId;
    private Standard qpStandard;
    private Unit qpUnit;
    private String qpParameter;
    private String qpAnalysisResult;
    private String qpTestingMethod;
    private String qpNotes;
    private String qpDescription;
    
    public QualityParameter() {
        
    }
    
    public QualityParameter(int qpId, Standard qpStandard, Unit qpUnit,
            String qpParameter, String qpAnalysisResult, String qpTestingMethod, 
            String qpNotes, String qpDescription) {
        this.qpId = qpId;
        this.qpStandard = qpStandard;
        this.qpUnit = qpUnit;
        this.qpParameter = qpParameter;
        this.qpAnalysisResult = qpAnalysisResult;
        this.qpTestingMethod = qpTestingMethod;
        this.qpNotes = qpNotes;
        this.qpDescription = qpDescription;
    }

    /**
     * @return the qpId
     */
    public int getQpId() {
        return qpId;
    }

    /**
     * @param qpId the qpId to set
     */
    public void setQpId(int qpId) {
        this.qpId = qpId;
    }

    /**
     * @return the qpStandard
     */
    public Standard getQpStandard() {
        return qpStandard;
    }

    /**
     * @param qpStandard the qpStandard to set
     */
    public void setQpStandard(Standard qpStandard) {
        this.qpStandard = qpStandard;
    }

    /**
     * @return the qpUnit
     */
    public Unit getQpUnit() {
        return qpUnit;
    }

    /**
     * @param qpUnit the qpUnit to set
     */
    public void setQpUnit(Unit qpUnit) {
        this.qpUnit = qpUnit;
    }

    /**
     * @return the qpParameter
     */
    public String getQpParameter() {
        return qpParameter;
    }

    /**
     * @param qpParameter the qpParameter to set
     */
    public void setQpParameter(String qpParameter) {
        this.qpParameter = qpParameter;
    }

    /**
     * @return the qpAnalysisResult
     */
    public String getQpAnalysisResult() {
        return qpAnalysisResult;
    }

    /**
     * @param qpAnalysisResult the qpAnalysisResult to set
     */
    public void setQpAnalysisResult(String qpAnalysisResult) {
        this.qpAnalysisResult = qpAnalysisResult;
    }

    /**
     * @return the qpTestingMethod
     */
    public String getQpTestingMethod() {
        return qpTestingMethod;
    }

    /**
     * @param qpTestingMethod the qpTestingMethod to set
     */
    public void setQpTestingMethod(String qpTestingMethod) {
        this.qpTestingMethod = qpTestingMethod;
    }

    /**
     * @return the qpNotes
     */
    public String getQpNotes() {
        return qpNotes;
    }

    /**
     * @param qpNotes the qpNotes to set
     */
    public void setQpNotes(String qpNotes) {
        this.qpNotes = qpNotes;
    }

    /**
     * @return the qpDescription
     */
    public String getQpDescription() {
        return qpDescription;
    }

    /**
     * @param qpDescription the qpDescription to set
     */
    public void setQpDescription(String qpDescription) {
        this.qpDescription = qpDescription;
    }
    
    
}
