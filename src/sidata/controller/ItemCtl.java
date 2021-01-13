package sidata.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sidata.database.DBHandler;
import sidata.entity.Device;
import sidata.entity.Operator;
import sidata.entity.SampleElement;
import sidata.entity.SampleType;
import sidata.entity.Standard;
import sidata.entity.Unit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author syubban
 */
public class ItemCtl {
    private DBHandler dbhandler;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    
    public ItemCtl() {
        try {
            this.dbhandler = DBHandler.getInstance();
        } catch (SQLException e) {
            System.out.println("Failed to make instance" + e.getMessage());
        }
    }
    
    // Unit    
    public List<Unit> getListUnit(String params) {
        List<Unit> units = new ArrayList<>();
        
        try {
            if("".equals(params)){
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from unit");
            }else{
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from unit where unit_name = ?");
                preparedStatement.setString(1, params);
            }
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                units.add(new Unit(
                    resultSet.getInt("unit_id"),
                    resultSet.getString("unit_name"),
                    resultSet.getString("unit_description")
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
        
        return units;
    }
    
    public boolean addNewUnit(Unit unit) {
        boolean flag = false;
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("insert into unit (unit_name, unit_description)" +
                    " values (?, ?)");
            preparedStatement.setString(1, unit.getUnitName());
            preparedStatement.setString(2, unit.getUnitDescription());
          
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
    
    public boolean editNewUnit(Unit unit) {
        boolean flag = false;
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("update unit set unit_name = ?, unit_description = ? where unit_id = ?");
            preparedStatement.setString(1, unit.getUnitName());
            preparedStatement.setString(2, unit.getUnitDescription());
            preparedStatement.setInt(3, unit.getUnitId());
          
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
    
    // Standard
    public List<Standard> getListStandard(String params) {
        List<Standard> standards = new ArrayList<>();
        
        try {
            if("".equals(params)){
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from standard");
            }else{
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from standard where standard_name = ?");
                preparedStatement.setString(1, params);
            }
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                standards.add(new Standard(
                    resultSet.getInt("standard_id"),
                    resultSet.getString("standard_name"),
                    resultSet.getString("standard_description")
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
        
        return standards;
    }
    
    public boolean addNewStandard(Standard standard) {
        boolean flag = false;
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("insert into standard (standard_name, standard_description)" +
                    " values (?, ?)");
            preparedStatement.setString(1, standard.getStandardName());
            preparedStatement.setString(2, standard.getStandardDescription());
          
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
    
    public boolean editNewStandard(Standard standard) {
        boolean flag = false;
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("update standard set standard_name = ?, standard_description = ? where standard_id = ?");
            preparedStatement.setString(1, standard.getStandardName());
            preparedStatement.setString(2, standard.getStandardDescription());
            preparedStatement.setInt(3, standard.getStandardId());
          
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
    
    // Sample Types
    public List<SampleType> getListSampleType(String params) {
        List<SampleType> sampleTypes = new ArrayList<>();
        
        try {
            if("".equals(params)){
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from sample_type");
            }else{
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from sample_type where st_name = ?");
                preparedStatement.setString(1, params);
            }
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                sampleTypes.add(new SampleType(
                    resultSet.getInt("st_id"),
                    resultSet.getString("st_name"),
                    resultSet.getTimestamp("st_date").toString(),
                    resultSet.getString("st_location"),
                    resultSet.getString("st_description")
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
        
        return sampleTypes;
    }
    
    public boolean addNewSampleType (SampleType sampleType) throws ParseException {
        boolean flag = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date parsedDate = (Date) dateFormat.parse(sampleType.getStDate());
        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
        
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("insert into sample_type (st_name, st_date, st_location, st_description)" +
                    " values (?, ?, ?, ?)");
            preparedStatement.setString(1, sampleType.getStName());
            preparedStatement.setTimestamp(2, timestamp);
            preparedStatement.setString(3, sampleType.getStLocation());
            preparedStatement.setString(4, sampleType.getStDescription());
          
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
    
    public boolean editNewSampleType (SampleType sampleType) throws ParseException {
        boolean flag = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date parsedDate = (Date) dateFormat.parse(sampleType.getStDate());
        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
        
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("update sample_type set st_name = ?, st_date = ?, st_location = ?, st_description = ? where st_id = ?");
            preparedStatement.setString(1, sampleType.getStName());
            preparedStatement.setTimestamp(2, timestamp);
            preparedStatement.setString(3, sampleType.getStLocation());
            preparedStatement.setString(4, sampleType.getStDescription());
            preparedStatement.setInt(5, sampleType.getStId());
          
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
    
    // Sample Elements
    public List<SampleElement> getListSampleElement (String params) {
        List<SampleElement> sampleElements = new ArrayList<>();
        
        try {
            if("".equals(params)){
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from sample_element");
            }else{
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from sample_element where se_name = ?");
                preparedStatement.setString(1, params);
            }
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                sampleElements.add(new SampleElement(
                    resultSet.getInt("se_id"),
                    resultSet.getString("se_name"),
                    resultSet.getString("se_description")
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
        
        return sampleElements;
    }
    
    public boolean addNewSampleElement (SampleElement sampleElement) {
        boolean flag = false;
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("insert into sample_element (se_name, se_description)" +
                    " values (?, ?)");
            preparedStatement.setString(1, sampleElement.getSeName());
            preparedStatement.setString(2, sampleElement.getSeDescription());
          
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
    
    public boolean editNewSampleElement (SampleElement sampleElement) {
        boolean flag = false;
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("update sample_element set se_name = ?, se_description = ? where se_id = ?");
            preparedStatement.setString(1, sampleElement.getSeName());
            preparedStatement.setString(2, sampleElement.getSeDescription());
            preparedStatement.setInt(3, sampleElement.getSeId());
          
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
    
    // Device 
    public List<Device> getListDevice(String params) {
        List<Device> devices = new ArrayList<>();
        
        try {
            if("".equals(params)){
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from device");
            }else{
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from device where device_name = ? inner join operator on device.device_user_id = user.user_id");
                preparedStatement.setString(1, params);
            }
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                devices.add(new Device(
                    resultSet.getInt("device_id"),
                    resultSet.getString("device_name"),
                    new Operator(
                        resultSet.getInt("user_id"),
                        resultSet.getString("user_name"),
                        resultSet.getInt("user_position_id"),
                        resultSet.getString("user_mobile_num"),
                        resultSet.getString("user_email"),
                        resultSet.getString("user_institution"),
                        resultSet.getInt("user_status")
                    ),
                    resultSet.getString("device_description")
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
        
        return devices;
    }
    
    public boolean addNewDevice (Device device) {
        boolean flag = false;
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("insert into device (device_name, device_user_id, device_description)" +
                    " values (?, ?, ?)");
            preparedStatement.setString(1, device.getDeviceName());
            preparedStatement.setInt(2, device.getUser().getId());
            preparedStatement.setString(3, device.getDescription());
            
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
    
    public boolean editNewDevice(Device device) {
        boolean flag = false;
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("update device set device_name = ?, device_user_id = ?, device_description = ? where device_id = ?");
            preparedStatement.setString(1, device.getDeviceName());
            preparedStatement.setInt(2, device.getUser().getId());
            preparedStatement.setString(3, device.getDescription());
            preparedStatement.setInt(4, device.getDeviceId());
          
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
