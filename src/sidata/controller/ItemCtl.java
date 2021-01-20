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
import sidata.entity.Assessment;
import sidata.entity.Device;
import sidata.entity.Operator;
import sidata.entity.QualityParameter;
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
    PreparedStatement preparedStatement, selectStatement;
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
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from unit where unit_name like ?");
                preparedStatement.setString(1, "%" + params + "%");
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
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from standard where standard_name like ?");
                preparedStatement.setString(1, "%" + params + "%");
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
            System.out.println("Insert Operator Error" + e);
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
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from sample_type where st_name like ?");
                preparedStatement.setString(1, "%" + params + "%");
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
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from sample_element where se_name like ?");
                preparedStatement.setString(1, "%" + params + "%");
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
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from device where device_name like ?");
                preparedStatement.setString(1, "%" + params + "%");
            }
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                devices.add(new Device(
                    resultSet.getInt("device_id"),
                    resultSet.getString("device_name"),
                    resultSet.getString("description")
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
            preparedStatement = dbhandler.getConnection().prepareStatement("insert into device (device_name, description)" +
                    " values (?, ?)");
            preparedStatement.setString(1, device.getDeviceName());
            preparedStatement.setString(2, device.getDescription());
            
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
            preparedStatement = dbhandler.getConnection().prepareStatement("update device set device_name = ?, description = ? where device_id = ?");
            preparedStatement.setString(1, device.getDeviceName());
            preparedStatement.setString(2, device.getDescription());
            preparedStatement.setInt(3, device.getDeviceId());
          
            preparedStatement.executeUpdate();
            flag = true;
        }catch(SQLException se){
            //Handle errors for JDBC
            System.out.println("Insert Operator JDBC Error" + se);
        }catch(Exception e){
            System.out.println("Insert Operator Error" + e);
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
    
    // Supervisor
    public List<Operator> getListSupervisor(String params) {
        List<Operator> operators = new ArrayList<>();
        
        try {
            if("".equals(params)){
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from user where user_position_id = 2");
            }else{
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from user where user_name like ? or user_position_id = 2");
                preparedStatement.setString(1, "%" + params + "%");
            }
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                operators.add(new Operator(
                    resultSet.getInt("user_id"),
                    resultSet.getString("user_name"),
                    resultSet.getInt("user_position_id"),
                    resultSet.getString("user_mobile_num"),
                    resultSet.getString("user_email"),
                    resultSet.getString("user_institution"),
                    resultSet.getInt("user_status")
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
    
    public boolean addNewSupervisor (Operator operator) {
        boolean flag = false;
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("insert into device (user_name, user_position_id, user_mobile_num, user_email, user_institution)" +
                    " values (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, operator.getName());
            preparedStatement.setInt(2, operator.getPosition_id());
            preparedStatement.setString(3, operator.getMobilenumber());
            preparedStatement.setString(4, operator.getEmail());
            preparedStatement.setString(4, operator.getInstitution());
            
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
    
    public boolean editNewSupervisor(Operator operator) {
        boolean flag = false;
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("update user set user_name = ?, user_position_id = ?, user_mobile_num = ?, user_email = ?, user_institution = ? where user_id = ?");
            preparedStatement.setString(1, operator.getName());
            preparedStatement.setInt(2, operator.getPosition_id());
            preparedStatement.setString(3, operator.getMobilenumber());
            preparedStatement.setString(4, operator.getEmail());
            preparedStatement.setString(5, operator.getInstitution());
            preparedStatement.setInt(6, operator.getId());
          
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
    
    public List<Device> getAssociatedDevice(int user_id) {
        List<Device> devices = new ArrayList<>();
        
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("select * from `device` inner join `user_device_pivot` on `device`.`device_id` = `user_device_pivot`.pivot_device_id where `user_device_pivot`.`pivot_user_id` = ?");
            preparedStatement.setInt(1, user_id);
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                devices.add(new Device(
                    resultSet.getInt("device_id"),
                    resultSet.getString("device_name"),
                    resultSet.getString("description")
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
    
    public boolean unEnrollDevice(int idUser, int idDevice) {
        boolean flag = false;
        System.out.println("id user : " + String.valueOf(idUser) + String.valueOf(idDevice));
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("delete from user_device_pivot where pivot_user_id = ? and pivot_device_id = ?");
            preparedStatement.setInt(1, idUser);
            preparedStatement.setInt(2, idDevice);
          
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
        System.out.println("flag : " + String.valueOf(flag));
        return flag;
    } 
    
    public boolean enrollDevice(int idUser, int idDevice) {
        boolean flag = false;
        try {
            selectStatement = dbhandler.getConnection().prepareStatement("select * from user_device_pivot where pivot_user_id = ? and pivot_device_id = ?");
            selectStatement.setInt(1, idUser);
            selectStatement.setInt(2, idDevice);
            ResultSet rs = selectStatement.executeQuery();
            if(!rs.next()){
                preparedStatement = dbhandler.getConnection().prepareStatement("insert into user_device_pivot (pivot_user_id, pivot_device_id) values (?, ?)");
                preparedStatement.setInt(1, idUser);
                preparedStatement.setInt(2, idDevice);

                preparedStatement.executeUpdate();
                flag = true;   
            }else{
                flag = false;
            }
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
        System.out.println("flag : " + String.valueOf(flag));
        return flag;
    } 

    // Quality Paramter
    public List<QualityParameter> getListQualityParamter(String params){
        List<QualityParameter> qualityParams = new ArrayList<>();
        
        try {
            if("".equals(params)){
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from `quality_parameter` " + 
                        " inner join `standard` on `quality_parameter`.qp_standard_id = `standard`.standard_id" + 
                        " inner join `unit` on `quality_parameter`.qp_unit_id = `unit`.unit_id");
            }else{
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from `quality_parameter`" + 
                        " inner join `standard` on `quality_parameter`.qp_standard_id = `standard`.standard_id" + 
                        " inner join `unit` on `quality_parameter`.qp_unit_id = `unit`.unit_id"+
                        " where device_name like ?");
                preparedStatement.setString(1, "%" + params + "%");
            }
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                qualityParams.add(new QualityParameter(
                    resultSet.getInt("qp_id"),
                    new Standard(
                        resultSet.getInt("standard_id"),
                        resultSet.getString("standard_name"),
                        resultSet.getString("standard_description")
                    ),
                    new Unit(
                        resultSet.getInt("unit_id"),
                        resultSet.getString("unit_name"),
                        resultSet.getString("unit_description") 
                    ),
                    resultSet.getString("qp_parameter"),
                    resultSet.getString("qp_analysis_result"),
                    resultSet.getString("qp_testing_method"),
                    resultSet.getString("qp_notes"),
                    resultSet.getString("qp_description")
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
        
        return qualityParams;
    }
    
    public boolean editQualityParameter(QualityParameter operator) {
        boolean flag = false;
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("update quality_parameter set qp_standard_id = ?, qp_unit_id = ?, qp_parameter = ?, " + 
                    "qp_analysis_result = ?, qp_testing_method = ?, qp_notes = ?, qp_description = ? where qp_id = ?");
            
            String[] splittedStandard = operator.getQpStandard().getStandardName().split(" ");
            String[] splittedUnit = operator.getQpUnit().getUnitName().split(" ");
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            
            sb1.append(splittedStandard[0]);
            sb2.append(splittedUnit[0]);
            
//            System.out.println("standard id : " + sb1.toString());
//            System.out.println("unit id : " + sb2.toString());
            
            preparedStatement.setInt(1, Integer.valueOf(sb1.toString()));
            preparedStatement.setInt(2, Integer.valueOf(sb2.toString()));
            preparedStatement.setString(3, operator.getQpParameter());
            preparedStatement.setString(4, operator.getQpAnalysisResult());
            preparedStatement.setString(5, operator.getQpTestingMethod());
            preparedStatement.setString(6, operator.getQpNotes());
            preparedStatement.setString(7, operator.getQpDescription());
            preparedStatement.setInt(8, operator.getQpId());
            
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
    
    public boolean addQualityParameter(QualityParameter operator) {
        boolean flag = false;
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement(
            "insert into quality_parameter (qp_standard_id, qp_unit_id, qp_parameter, qp_analysis_result, qp_testing_method, qp_notes, qp_description) values (?, ?, ?, ?, ?, ?, ?)");
            String[] splittedStandard = operator.getQpStandard().getStandardName().split(" ");
            String[] splittedUnit = operator.getQpUnit().getUnitName().split(" ");
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            
            sb1.append(splittedStandard[0]);
            sb2.append(splittedUnit[0]);
            
            preparedStatement.setInt(1, Integer.valueOf(sb1.toString()));
            preparedStatement.setInt(2, Integer.valueOf(sb2.toString()));
            preparedStatement.setString(3, operator.getQpParameter());
            preparedStatement.setString(4, operator.getQpAnalysisResult());
            preparedStatement.setString(5, operator.getQpTestingMethod());
            preparedStatement.setString(6, operator.getQpNotes());
            preparedStatement.setString(7, operator.getQpDescription());
            
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
    
    // Operator
    public List<Operator> getListOperator(String params) {
        List<Operator> operators = new ArrayList<>();
        
        try {
            if("".equals(params)){
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from user where user_position_id = 1");
            }else{
                preparedStatement = dbhandler.getConnection().prepareStatement("select * from user where user_name like ? or user_position_id = 1");
                preparedStatement.setString(1, "%" + params + "%");
            }
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                operators.add(new Operator(
                    resultSet.getInt("user_id"),
                    resultSet.getString("user_name"),
                    resultSet.getInt("user_position_id"),
                    resultSet.getString("user_mobile_num"),
                    resultSet.getString("user_email"),
                    resultSet.getString("user_institution"),
                    resultSet.getInt("user_status")
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
}
