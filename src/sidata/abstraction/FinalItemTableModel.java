/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidata.abstraction;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
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
        }

        return null;
    }
}
