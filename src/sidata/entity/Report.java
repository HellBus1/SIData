/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidata.entity;

import java.util.List;

/**
 *
 * @author syubban
 */
public class Report {
    
    private Assessment assessment;
    private List<QualityParameter> qualityParameter;
    
//    public Report(){
//        
//    }
    
    public Report(Assessment assessment, List<QualityParameter> qualityParameter){
        this.assessment = assessment;
        this.qualityParameter = qualityParameter;
    }

    /**
     * @return the assessment
     */
    public Assessment getAssessment() {
        return assessment;
    }

    /**
     * @param assessment the assessment to set
     */
    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    /**
     * @return the qualityParameter
     */
    public List<QualityParameter> getQualityParameter() {
        return qualityParameter;
    }
    
        /**
     * @param qualityParameter the qualityParameter to set
     */
    public void setQualityParameter(List<QualityParameter> qualityParameter) {
        this.qualityParameter = qualityParameter;
    }
}
