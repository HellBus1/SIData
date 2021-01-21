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
public class LoginController {
    private DBHandler dbhandler;
    PreparedStatement preparedStatement, selectStatement;
    ResultSet resultSet;
    
    public LoginController() {
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
}
