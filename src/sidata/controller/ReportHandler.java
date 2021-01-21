package sidata.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sidata.database.DBHandler;
import sidata.entity.Assessment;
import sidata.entity.Assignment;
import sidata.entity.Device;
import sidata.entity.Operator;
import sidata.entity.QualityParameter;
import sidata.entity.Report;
import sidata.entity.SampleElement;
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
public class ReportHandler {
    private DBHandler dbhandler;
    PreparedStatement preparedStatement, selectStatement, selectCurrentStatement;
    ResultSet resultSet;
    
    public ReportHandler() {
        try {
            this.dbhandler = DBHandler.getInstance();
        } catch (SQLException e) {
            System.out.println("Failed to make instance" + e.getMessage());
        }
    }
    
    // Assessment
    public boolean addAssessment (Assessment units, List<Integer> id) throws ParseException {
        boolean flag = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date parsedDate = (Date) dateFormat.parse(units.getTestDate());
        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
        
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement(
            "insert into assessment (assm_user_id, assm_device_id, assm_st_id, assm_se_id, assm_test_date, assm_name, assm_code) "
                    + "values (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            String[] splittedUnit = units.getUser().getName().split(" ");
            String[] splittedDevice = units.getDevice().getDeviceName().split(" ");
            String[] splittedStandard = units.getStandard().getStandardName().split(" ");
            String[] splittedSampleElement = units.getSampleElement().getSeName().split(" ");
            
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            
            sb1.append(splittedUnit[0]);
            sb2.append(splittedDevice[0]);
            sb3.append(splittedStandard[0]);
            sb4.append(splittedSampleElement[0]);
            
            preparedStatement.setInt(1, Integer.valueOf(sb1.toString()));
            preparedStatement.setInt(2, Integer.valueOf(sb2.toString()));
            preparedStatement.setInt(3, Integer.valueOf(sb3.toString()));
            preparedStatement.setInt(4, Integer.valueOf(sb4.toString()));
            preparedStatement.setTimestamp(5, timestamp);
            preparedStatement.setString(6, units.getAssmName());
            preparedStatement.setString(7, units.getAssmCode());
            
            if(preparedStatement.executeUpdate() > 0){
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    int ids = (generatedKeys.next()) ? (generatedKeys.getInt(1)) : -1;
                    if(ids == -1){
//                        flag = false;
                        System.out.println("terjadi kesalahan");
                    }else {
                        System.out.println("ids " + ids);
                        if(this.addQualityAssociated(ids, id) ){
                            flag = true;
                        }else{
                            flag = false;
                        }
                    }
                }
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
        
        return flag;
    }  
    
    public boolean updateAssessment (Assessment units, List<Integer> id) throws ParseException {
        boolean flag = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date parsedDate = (Date) dateFormat.parse(units.getTestDate());
        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
        
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement(
            "update assessment set assm_user_id = ?, assm_device_id = ?, assm_st_id = ?, assm_se_id = ?, assm_test_date = ?, assm_name = ?, assm_code = ? "
                    + "where assessment_id = ?", Statement.RETURN_GENERATED_KEYS);
            String[] splittedUnit = units.getUser().getName().split(" ");
            String[] splittedDevice = units.getDevice().getDeviceName().split(" ");
            String[] splittedStandard = units.getStandard().getStandardName().split(" ");
            String[] splittedSampleElement = units.getSampleElement().getSeName().split(" ");
            
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            
            sb1.append(splittedUnit[0]);
            sb2.append(splittedDevice[0]);
            sb3.append(splittedStandard[0]);
            sb4.append(splittedSampleElement[0]);
            
            preparedStatement.setInt(1, Integer.valueOf(sb1.toString()));
            preparedStatement.setInt(2, Integer.valueOf(sb2.toString()));
            preparedStatement.setInt(3, Integer.valueOf(sb3.toString()));
            preparedStatement.setInt(4, Integer.valueOf(sb4.toString()));
            preparedStatement.setTimestamp(5, timestamp);
            preparedStatement.setString(6, units.getAssmName());
            preparedStatement.setString(7, units.getAssmCode());
            preparedStatement.setInt(8, units.getAssessmentId());
            
            if(preparedStatement.executeUpdate() > 0){
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    int ids = (generatedKeys.next()) ? (generatedKeys.getInt(1)) : -1;
                    if(ids == -1){
//                        flag = false;
                        System.out.println("terjadi kesalahan");
                    }else {
                        System.out.println("ids " + ids);
                        if(this.addQualityAssociated(ids, id) ){
                            flag = true;
                        }else{
                            flag = false;
                        }
                    }
                }
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
        
        return flag;
    }  
    
    public boolean addQualityAssociated (int ids, List<Integer> idxs) throws ParseException {
        boolean flag = false;
        
        try {
            for (int idx : idxs){
//                System.out.println("d id nya " + idx);
                if(getQualityParamsWhere(idx, ids)){
                    preparedStatement = dbhandler.getConnection().prepareStatement(
                    "insert into asse_qparam_pivot (pivot_qparam_id, pivot_assessment_id) "
                            + "values (?, ?)");

                    preparedStatement.setInt(1, idx);
                    preparedStatement.setInt(2, ids);

                    preparedStatement.executeUpdate();   
                }
            }
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
    
    public boolean getQualityParamsWhere (int qparam_id, int assessment_id) {
        boolean flag = false;
        
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("select * from asse_qparam_pivot where pivot_qparam_id = ? and pivot_assessment_id = ?");
            preparedStatement.setInt(1, qparam_id);
            preparedStatement.setInt(2, assessment_id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                flag = false;
            }else{
                flag = true;
            }
            resultSet.close();
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
    
    
    public List<Report> getListReport(String params){
        List<Assessment> reports = new ArrayList<>();
        List<Report> newListReports = new ArrayList<>();
        
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("select * from asse_qparam_pivot inner join assessment on `asse_qparam_pivot`.pivot_assessment_id = `assessment`.assessment_id"
                    + " inner join `user` on `assessment`.assm_user_id = `user`.user_id"
                    + " inner join `device` on `assessment`.assm_device_id = `device`.device_id"
                    + " inner join `standard` on `assessment`.assm_st_id = `standard`.standard_id"
                    + " inner join `sample_element` on `assessment`.assm_se_id = `sample_element`.se_id");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Operator user = new Operator();
                user.setId(resultSet.getInt("assm_user_id"));
                user.setName(resultSet.getString("user_name"));
                
                Device device = new Device();
                device.setDeviceId(resultSet.getInt("assm_device_id"));
                device.setDeviceName(resultSet.getString("device_name"));
                
                Standard standard = new Standard();
                standard.setStandardId(resultSet.getInt("assm_st_id"));
                standard.setStandardName(resultSet.getString("standard_name"));
                
                SampleElement element = new SampleElement();
                element.setSeId(resultSet.getInt("assm_se_id"));
                element.setSeName(resultSet.getString("se_name"));
                
                reports.add(new Assessment(
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
            
            for(Assessment assessment : reports){
                List<QualityParameter> listQualityParams = new ArrayList<>();
//                System.out.println("assessment id " + assessment.getAssessmentId());
//                Gson gson = new Gson();
//                System.out.println(gson.toJson(this.getListQualityParamter(assessment.getAssessmentId())));
                listQualityParams.addAll(this.getListQualityParamter(assessment.getAssessmentId()));
                
                Report newReport = new Report(
                    assessment,
                    listQualityParams
                );
                
                newListReports.add(newReport);
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
        
        return newListReports;
    }
    
    private List<QualityParameter> getListQualityParamter(int params){
        List<QualityParameter> qualityParams = new ArrayList<>();
//        System.out.println(params);
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("select * from `asse_qparam_pivot`" + 
                    " inner join `quality_parameter` on `quality_parameter`.qp_standard_id = `asse_qparam_pivot`.pivot_qparam_id" + 
                    " inner join `standard` on `quality_parameter`.qp_standard_id = `standard`.standard_id" + 
                    " inner join `unit` on `quality_parameter`.qp_unit_id = `unit`.unit_id" +
                    " where `asse_qparam_pivot`.pivot_assessment_id = ?");
            preparedStatement.setInt(1, params);
            
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
    
    public List<Assignment> getListAssignment(int assessmentIndex) {
        List<Assignment> assignmentList = new ArrayList<>();
        
        try {
            preparedStatement = dbhandler.getConnection().prepareStatement("select * from assignment inner join assessment on assessment.assessment_id = assignment.assignment_id where assessment.assessment_id = ?");
            preparedStatement.setInt(1, assessmentIndex);
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
}
