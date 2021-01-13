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
public class Unit {

    private int unitId;
    private String unitName;
    private String unitDescription;
    
    public Unit() {
        
    }
    
    public Unit(int unitId, String unitName, String unitDescription) {
        this.unitId = unitId;
        this.unitName = unitName;
        this.unitDescription = unitDescription;
    }
    
    /**
     * @return the unitId
     */
    public int getUnitId() {
        return unitId;
    }

    /**
     * @param unitId the unitId to set
     */
    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    /**
     * @return the unitName
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * @param unitName the unitName to set
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }    
    
    public void setUnitDescription(String unitDescription) {
        this.unitDescription = unitDescription;
    }
    
    
    public String getUnitDescription() {
        return unitDescription;
    }
}
