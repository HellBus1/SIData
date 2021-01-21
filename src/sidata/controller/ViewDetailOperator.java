/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidata.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import sidata.database.DBHandler;
import sidata.entity.Operator;

/**
 *
 * @author syubban
 */
public class ViewDetailOperator {
    private DBHandler dbhandler;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    public ViewDetailOperator() {
        try {
            this.dbhandler = DBHandler.getInstance();
        } catch (SQLException e) {
            System.out.println("Failed to make instance" + e.getMessage());
        }
    }
    
    public List<Operator> getListOperator() {
        List<Operator> operators = new ArrayList<>();
        
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("select * from user where user_status != 0");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                operators.add(new Operator(
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
        
        return operators;
    }
    
    public boolean addNewOperator(Operator operator) {
        boolean flag = false;
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("insert into user (user_name, user_position_id, user_mobile_num, user_email, user_institution, user_status)" +
                    " values (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, operator.getName());
            preparedStatement.setInt(2, operator.getPosition_id());
            preparedStatement.setString(3, operator.getMobilenumber());
            preparedStatement.setString(4, operator.getEmail());
            preparedStatement.setString(5, operator.getInstitution());
            preparedStatement.setInt(6, operator.getStatus());
          
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
    
    public boolean editOperator(Operator operator) {
        boolean flag = false;
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("update user set user_name = ?, user_position_id = ?, user_mobile_num = ?, user_email = ?, user_institution = ?, user_status = ? where user_id = ?");
            preparedStatement.setString(1, operator.getName());
            preparedStatement.setInt(2, operator.getPosition_id());
            preparedStatement.setString(3, operator.getMobilenumber());
            preparedStatement.setString(4, operator.getEmail());
            preparedStatement.setString(5, operator.getInstitution());
            preparedStatement.setInt(6, operator.getStatus());
            preparedStatement.setInt(7, operator.getId());
          
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
    
    public boolean deactivateOperator(int id) {
        boolean flag = false;
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("update user set user_status = 0 where user_id = ?");
            preparedStatement.setInt(1, id);
          
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
    
}
