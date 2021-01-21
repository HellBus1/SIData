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
import sidata.database.DBHandler;
import sidata.database.UserStatic;
import sidata.entity.Operator;

/**
 *
 * @author syubban
 */
public class ProfileHandler {
    private DBHandler dbhandler;
    PreparedStatement preparedStatement, selectStatement;
    ResultSet resultSet;
    
    public ProfileHandler() {
        try {
            this.dbhandler = DBHandler.getInstance();
        } catch (SQLException e) {
            System.out.println("Failed to make instance" + e.getMessage());
        }
    }
    
    public boolean getListUnit(String email, String password) {
        boolean flag = false;
        
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("select * from user where user_email = ? and password = ?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                UserStatic.userId = resultSet.getInt("user_id");
                UserStatic.setUserName(resultSet.getString("user_name"));
                UserStatic.setUserPositionId(resultSet.getInt("user_position_id"));
                UserStatic.setUserMobile(resultSet.getString("user_mobile_num"));
                UserStatic.setUserEmail(resultSet.getString("user_email"));
                UserStatic.setUserInstitution(resultSet.getString("user_institution"));
                UserStatic.setUserStatus(resultSet.getInt("user_status"));
                UserStatic.setUserRegisNumber(resultSet.getString("regis_number"));
                flag = true;
            }else{
                flag = false;
            }
//            Gson gson = new Gson();
//            System.out.println(gson.toJson(UserStatic.getUserName()));
            
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
        
        return flag;
    }
    
    public boolean getListUnitById (int id) {
        boolean flag = false;
        
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("select * from user where user_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                UserStatic.userId = resultSet.getInt("user_id");
                UserStatic.setUserName(resultSet.getString("user_name"));
                UserStatic.setUserPositionId(resultSet.getInt("user_position_id"));
                UserStatic.setUserMobile(resultSet.getString("user_mobile_num"));
                UserStatic.setUserEmail(resultSet.getString("user_email"));
                UserStatic.setUserInstitution(resultSet.getString("user_institution"));
                UserStatic.setUserStatus(resultSet.getInt("user_status"));
                UserStatic.setUserRegisNumber(resultSet.getString("regis_number"));
                flag = true;
            }else{
                flag = false;
            }
//            Gson gson = new Gson();
//            System.out.println(gson.toJson(UserStatic.getUserName()));
            
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
        
        return flag;
    }
    
    public boolean updateUser(Operator operator) {
        boolean flag = false;
        
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("update user set user_name = ?, user_mobile_num = ?, user_email = ?, user_institution = ?, "
                    + "user_status = ? where user_id = ?");
            preparedStatement.setString(1, operator.getName());
            preparedStatement.setString(2, operator.getMobilenumber());
            preparedStatement.setString(3, operator.getEmail());
            preparedStatement.setString(4, operator.getInstitution());
            preparedStatement.setInt(5, operator.getStatus());
            preparedStatement.setInt(6, operator.getId());
            int count = preparedStatement.executeUpdate();
            
            if(count > 0){
                this.getListUnitById(operator.getId());
                flag = true;
            }else{
                flag = false;
            }
//            Gson gson = new Gson();
//            System.out.println(gson.toJson(UserStatic.getUserName()));
            
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
        
        return flag;
    }
}
