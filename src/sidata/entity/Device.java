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
public class Device {
    private int deviceId;
    private String deviceName;
    private Operator user;
    private String description;
    
    
    public Device(){
        
    }
    
    public Device(int deviceId, String deviceName, Operator user, String description){
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.user = user;
        this.description = description;
    }

    /**
     * @return the deviceId
     */
    public int getDeviceId() {
        return deviceId;
    }

    /**
     * @param deviceId the deviceId to set
     */
    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * @return the deviceName
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * @param deviceName the deviceName to set
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}
