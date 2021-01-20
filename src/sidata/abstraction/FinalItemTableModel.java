/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidata.abstraction;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sidata.entity.Assessment;
import sidata.entity.Device;
import sidata.entity.Operator;
import sidata.entity.QualityParameter;
import sidata.entity.SampleElement;
import sidata.entity.SampleType;
import sidata.entity.Standard;
import sidata.entity.Unit;

/**
 *
 * @author syubban
 */
public class FinalItemTableModel <T> extends AbstractTableModel {
    private List<T> li = new ArrayList();
    private String[] columnNames = {};
    
    public FinalItemTableModel(List<T> li, String[] columnNames){
        this.li = li;
        this.columnNames = columnNames;
    }
   

    @Override
    public String getColumnName(int columnIndex){
         return columnNames[columnIndex];
    }

    @Override     
    public int getRowCount() {
        return li.size();
    }

    @Override        
    public int getColumnCount() {
        return columnNames.length; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        if(li.get(rowIndex) instanceof Unit){
            Unit object = (Unit) li.get(rowIndex);
            switch (columnIndex) {
                case 0: 
                    return object.getUnitId();
                case 1:
                    return object.getUnitName();
                case 2:
                    return object.getUnitDescription();
            }
        }else if(li.get(rowIndex) instanceof Standard){
            Standard object = (Standard) li.get(rowIndex);
            switch (columnIndex) {
                case 0: 
                    return object.getStandardId();
                case 1:
                    return object.getStandardName();
                case 2:
                    return object.getStandardDescription();
            }
        }else if(li.get(rowIndex) instanceof SampleType){
            SampleType object = (SampleType) li.get(rowIndex);
            switch (columnIndex) {
                case 0: 
                    return object.getStId();
                case 1:
                    return object.getStName();
                case 2:
                    return object.getStDate();
                case 3:
                    return object.getStLocation();
                case 4: 
                    return object.getStDescription();
            }
        }else if(li.get(rowIndex) instanceof SampleElement){
            SampleElement object = (SampleElement) li.get(rowIndex);
            switch (columnIndex) {
                case 0: 
                    return object.getSeId();
                case 1:
                    return object.getSeName();
                case 2:
                    return object.getSeDescription();
            }
        }else if(li.get(rowIndex) instanceof Device){
            Device object = (Device) li.get(rowIndex);
            switch (columnIndex) {
                case 0: 
                    return object.getDeviceId();
                case 1:
                    return object.getDeviceName();
                case 2:
                    return object.getDescription();
            }
        }else if(li.get(rowIndex) instanceof Operator){
            Operator object = (Operator) li.get(rowIndex);
            switch (columnIndex) {
                case 0: 
                    return object.getId();
                case 1:
                    return object.getName();
                case 2:
                    return object.getMobilenumber();
                case 3:
                    return object.getEmail();
                case 4:
                    return object.getInstitution();
            }
        }else if(li.get(rowIndex) instanceof Assessment) {
            Assessment object = (Assessment) li.get(rowIndex);
            switch (columnIndex) {
                case 0: 
                    return object.getAssessmentId();
                case 1:
                    return object.getUser().getId();
                case 2:
                    return object.getDevice().getDeviceId();
                case 3:
                    return object.getStandard().getStandardId();
                case 4:
                    return object.getSampleElement().getSeId();
                case 5:
                    return object.getTestDate();
                case 6:
                    return object.getAssmName();
                case 7:
                    return object.getAssmCode();
            }
        }else {
            QualityParameter object = (QualityParameter) li.get(rowIndex);
            switch (columnIndex) {
                case 0: 
                    return object.getQpId();
                case 1:
                    return object.getQpStandard().getStandardId();
                case 2:
                    return String.valueOf(object.getQpUnit().getUnitId()) + " " + object.getQpUnit().getUnitName();
                case 3:
                    return String.valueOf(object.getQpParameter()) + " " + object.getQpStandard().getStandardName();
                case 4:
                    return object.getQpAnalysisResult();
                case 5:
                    return object.getQpTestingMethod();
                case 6:
                    return object.getQpNotes();
                case 7:
                    return object.getQpDescription();
            }
        }

        return null;
    }
}
