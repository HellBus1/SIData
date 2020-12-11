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
public class Operator {
    private int operatorId;
    private String operatorName;
    private String operatorPosition;
    private String operatorMobilenumber;
    private String operatorEmail;
    private String operatorInstitution;
    
    public Operator(
        int operatorId,
        String operatorName,
        String operatorPosition,
        String operatorMobilenumber,
        String operatorEmail,
        String operatorInstitution
    ){
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.operatorPosition = operatorPosition;
        this.operatorMobilenumber = operatorMobilenumber;
        this.operatorEmail = operatorEmail;
        this.operatorInstitution = operatorInstitution;
    }

    /**
     * @return the operatorId
     */
    public int getOperatorId() {
        return operatorId;
    }

    /**
     * @param operatorId the operatorId to set
     */
    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * @return the operatorName
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * @param operatorName the operatorName to set
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    /**
     * @return the operatorPosition
     */
    public String getOperatorPosition() {
        return operatorPosition;
    }

    /**
     * @param operatorPosition the operatorPosition to set
     */
    public void setOperatorPosition(String operatorPosition) {
        this.operatorPosition = operatorPosition;
    }

    /**
     * @return the operatorMobilenumber
     */
    public String getOperatorMobilenumber() {
        return operatorMobilenumber;
    }

    /**
     * @param operatorMobilenumber the operatorMobilenumber to set
     */
    public void setOperatorMobilenumber(String operatorMobilenumber) {
        this.operatorMobilenumber = operatorMobilenumber;
    }

    /**
     * @return the operatorEmail
     */
    public String getOperatorEmail() {
        return operatorEmail;
    }

    /**
     * @param operatorEmail the operatorEmail to set
     */
    public void setOperatorEmail(String operatorEmail) {
        this.operatorEmail = operatorEmail;
    }

    /**
     * @return the operatorInstitution
     */
    public String getOperatorInstitution() {
        return operatorInstitution;
    }

    /**
     * @param operatorInstitution the operatorInstitution to set
     */
    public void setOperatorInstitution(String operatorInstitution) {
        this.operatorInstitution = operatorInstitution;
    }
    
    
}
