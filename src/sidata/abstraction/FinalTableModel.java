/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidata.abstraction;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sidata.entity.Operator;

/**
 *
 * @author syubban
 */
public class FinalTableModel extends AbstractTableModel {

    private List<Operator> li = new ArrayList();
    private String[] columnNames = {"ID", "Name", "Position", "Mobile Number", "Email", "Institution", "Status"};

    public FinalTableModel(List<Operator> list){
         this.li = list;
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
        Operator si = li.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return si.getId();
            case 1:
                return si.getName();
            case 2:
                return si.getPosition_id();
            case 3:
                return si.getMobilenumber();
            case 4:
                return si.getEmail();
            case 5:
                return si.getInstitution();
            case 6:
                return si.getStatus(); 
           }
           return null;
   }

   @Override
   public Class<?> getColumnClass(int columnIndex){
          switch (columnIndex){
             case 0:
               return Integer.class;
             case 1:
               return String.class;
             case 2:
               return Integer.class;
             case 3:
               return String.class;
             case 4:
               return String.class;
             case 5:
               return String.class;
             case 6:
               return Integer.class;
             }
             return null;
      }
 }
