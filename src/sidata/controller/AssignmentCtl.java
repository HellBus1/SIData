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
            preparedStatement = dbhandler.getConnection().prepareStatement("select * from assignment inner join user on user.user_id = assignment.assignment_user_id where user.user_position_id = 1");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Operator user = new Operator();

                Operator operator = new Operator(
                    resultSet.getInt("user_id"),
                    resultSet.getString("user_name"),
                    resultSet.getInt("user_position_id"),
                    resultSet.getString("user_mobile_num"),
                    resultSet.getString("user_email"),
                    resultSet.getString("user_institution"),
                    resultSet.getInt("user_status"),
                    resultSet.getString("regis_number")
                );
                
                assignmentList.add(new Assignment(
                    resultSet.getInt("assignment_id"),
                    operator,
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
            preparedStatement = dbhandler.getConnection().prepareStatement("insert into assignment (assignment_user_id, assignment_name)" +
                    " values (?, ?)");
            preparedStatement.setInt(1, assignment.getOperator().getId());
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
            preparedStatement = dbhandler.getConnection().prepareStatement("update assignment set assignment_user_id = ?, assignment_name = ? where assignment_id = ?");
            preparedStatement.setInt(1, assignment.getOperator().getId());
            preparedStatement.setString(2, assignment.getAssignmentName());
            preparedStatement.setInt(3, assignment.getAssignmentId());
          
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
    
    public List<Operator> getListOperator() {
        List<Operator> operatorList = new ArrayList<>();
        
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("select * from user where user_position_id = 1");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){                                      
                operatorList.add(new Operator(
                    resultSet.getInt("user_id"),
                    resultSet.getString("user_name"),
                    resultSet.getInt("user_position_id"),
                    resultSet.getString("user_mobile_num"),
                    resultSet.getString("user_email"),
                    resultSet.getString("user_institution"),
                    resultSet.getInt("user_status"),
                    resultSet.getString("regis_number")
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
        
        return operatorList;
    }
    
}
