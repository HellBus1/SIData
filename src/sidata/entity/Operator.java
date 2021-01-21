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
    private int id;
    private String name;
    private int position_id;
    private String mobilenumber;
    private String email;
    private String institution;
    private int status;
    private String regisNumber;
    
    public Operator(){
        
    }
    
    public Operator(
        int id,
        String name,
        int position_id,
        String mobilenumber,
        String email,
        String institution,
        int status,
        String regisNumber
    ){
        this.id = id;
        this.name = name;
        this.position_id = position_id;
        this.mobilenumber = mobilenumber;
        this.email = email;
        this.institution  = institution;
        this.status = status;
        this.regisNumber = regisNumber;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the position_id
     */
    public int getPosition_id() {
        return position_id;
    }

    /**
     * @param position_id the position_id to set
     */
    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    /**
     * @return the mobilenumber
     */
    public String getMobilenumber() {
        return mobilenumber;
    }

    /**
     * @param mobilenumber the mobilenumber to set
     */
    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the institution
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * @param institution the institution to set
     */
    public void setInstitution(String institution) {
        this.institution = institution;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
    
    public void setRegisNumber(String regisNumber) {
        this.regisNumber = regisNumber;
    }
    
    public String getRegisnNumber() {
        return this.regisNumber;
    }
          
}
