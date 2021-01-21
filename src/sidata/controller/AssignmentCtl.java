/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidata.controller;

import com.google.gson.Gson;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import sidata.database.DBHandler;
import sidata.entity.Assessment;
import sidata.entity.Assignment;
import sidata.entity.Device;
import sidata.entity.Operator;
import sidata.entity.SampleElement;
import sidata.entity.Standard;

/**
 *
 * @author syubban
 */
public class AssignmentCtl {
    private DBHandler dbhandler;
    PreparedStatement preparedStatement, selectStatement, selectCurrentStatement;
    ResultSet resultSet;
    
    public AssignmentCtl() {
        try {
            this.dbhandler = DBHandler.getInstance();
        } catch (SQLException e) {
            System.out.println("Failed to make instance" + e.getMessage());
        }
    }
    
    public List<Assignment> getListAssignment() {
        List<Assignment> assignmentList = new ArrayList<>();
        
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("select * from assignment inner join assessment on assessment.assessment_id = assignment.assessment_id");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Operator user = new Operator();
                user.setId(resultSet.getInt("assm_user_id"));
                
                Device device = new Device();
                device.setDeviceId(resultSet.getInt("assm_device_id"));
                
                Standard standard = new Standard();
                standard.setStandardId(resultSet.getInt("assm_st_id"));
                
                SampleElement element = new SampleElement();
                element.setSeId(resultSet.getInt("assm_se_id"));
                
                Assessment assessment = new Assessment(
                    resultSet.getInt("assessment_id"),
                    user,
                    device,
                    standard,
                    element,
                    resultSet.getTimestamp("assm_test_date").toString(),
                    resultSet.getString("assm_name"),
                    resultSet.getString("assm_code")
                );
                
                assignmentList.add(new Assignment(
                    resultSet.getInt("assignment_id"),
                    assessment,
                    resultSet.getString("assignment_name")  
                ));
            }
            
//            Gson gson = new Gson();
//            System.out.println(gson.toJson(assignmentList));
            resultSet.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            System.out.println("List Operator JDBC Error" + se);
        }catch(Exception e){
            System.out.println("List Operator Error" + e);
        }finally {
            try {
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            } catch(SQLException se) {
                se.printStackTrace();
            }
           
        }
        
        return assignmentList;
    }
    
    public boolean addAssignment (Assignment assignment) throws ParseException {
        boolean flag = false;
        
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("insert into assignment (assessment_id, assignment_name)" +
                    " values (?, ?)");
            preparedStatement.setInt(1, assignment.getAssessment().getAssessmentId());
            preparedStatement.setString(2, assignment.getAssignmentName());
          
            preparedStatement.executeUpdate();
            flag = true;
        }catch(SQLException se){
            //Handle errors for JDBC
            System.out.println("Insert Operator JDBC Error" + se);
        }catch(Exception e){
            System.out.println("INsert Operator Error" + e);
        }finally {
            try {
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
        
        return flag;
    }
    
    public boolean editAssignment (Assignment assignment) throws ParseException {
        boolean flag = false;
        
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("update assignment set assessment_id = ?, assignment_name = ?");
            preparedStatement.setInt(1, assignment.getAssessment().getAssessmentId());
            preparedStatement.setString(2, assignment.getAssignmentName());
          
            preparedStatement.executeUpdate();
            flag = true;
        }catch(SQLException se){
            //Handle errors for JDBC
            System.out.println("Insert Operator JDBC Error" + se);
        }catch(Exception e){
            System.out.println("INsert Operator Error" + e);
        }finally {
            try {
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
        
        return flag;
    }
    
    public boolean deleteAssignment (int assignmentId) throws ParseException {
        boolean flag = false;
        
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("delete from assignment where assignment_id = ?");
            preparedStatement.setInt(1, assignmentId);
          
            preparedStatement.executeUpdate();
            flag = true;
        }catch(SQLException se){
            //Handle errors for JDBC
            System.out.println("Insert Operator JDBC Error" + se);
        }catch(Exception e){
            System.out.println("INsert Operator Error" + e);
        }finally {
            try {
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
        
        return flag;
    }
    
    public List<Assessment> getListAssessment() {
        List<Assessment> assessmentList = new ArrayList<>();
        
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("select * from assessment");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){                      
                Operator user = new Operator();
                user.setId(resultSet.getInt("assm_user_id"));
                
                Device device = new Device();
                device.setDeviceId(resultSet.getInt("assm_device_id"));
                
                Standard standard = new Standard();
                standard.setStandardId(resultSet.getInt("assm_st_id"));
                
                SampleElement element = new SampleElement();
                element.setSeId(resultSet.getInt("assm_se_id"));
                
                assessmentList.add(new Assessment(
                    resultSet.getInt("assessment_id"),
                    user,
                    device,
                    standard,
                    element,
                    resultSet.getTimestamp("assm_test_date").toString(),
                    resultSet.getString("assm_name"),
                    resultSet.getString("assm_code")
                ));
            }
            
//            Gson gson = new Gson();
//            System.out.println(gson.toJson(assignmentList));
            resultSet.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            System.out.println("List Operator JDBC Error" + se);
        }catch(Exception e){
            System.out.println("List Operator Error" + e);
        }finally {
            try {
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            } catch(SQLException se) {
                se.printStackTrace();
            }
           
        }
        
        return assessmentList;
    }
    
}
