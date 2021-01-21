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
public class Assignment {
    private int assignmentId;
    private Operator operator;
    private String assignmentName;
    
    public Assignment() {
        
    }
    
    public Assignment(int assignmentId, Operator operator, String assignmentName) {
        this.assignmentId = assignmentId;
        this.operator = operator;
        this.assignmentName = assignmentName;
    }

    /**
     * @return the assignmentId
     */
    public int getAssignmentId() {
        return assignmentId;
    }

    /**
     * @param assignmentId the assignmentId to set
     */
    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    /**
     * @return the assessment
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @param assessment the assessment to set
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * @return the assignmentName
     */
    public String getAssignmentName() {
        return assignmentName;
    }

    /**
     * @param assignmentName the assignmentName to set
     */
    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }
}
