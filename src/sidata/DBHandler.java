/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidata;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import sidata.entity.Operator;
/**
 *
 * @author syubban
 */
public class DBHandler {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    public DBHandler(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sidata_db","root","");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public List<Operator> getListOperator(){
        List<Operator> operators = new ArrayList<>();
        
        try {
            preparedStatement = connection.prepareStatement("select * from operator");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                operators.add(new Operator(
                    resultSet.getInt("operator_id"),
                    resultSet.getString("operator_name"),
                    resultSet.getString("operator_position"),
                    resultSet.getString("operator_mobilenumber"),
                    resultSet.getString("operator_email"),
                    resultSet.getString("operator_institution")
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
                
            }
            
            try {
                if(connection != null){
                    connection.close();
                }
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
        
        return operators;
    }
}
