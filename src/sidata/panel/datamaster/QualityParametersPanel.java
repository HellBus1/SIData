package sidata.panel.datamaster;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import sidata.abstraction.FinalItemTableModel;
import sidata.controller.ItemCtl;
import sidata.entity.QualityParameter;
import sidata.entity.Standard;
import sidata.entity.Unit;
import sidata.form.QualityParameterForm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author syubban
 */
public class QualityParametersPanel extends javax.swing.JPanel {
    private ItemCtl itemController;
    private List<QualityParameter> unitList;
    
    private List<Standard> standardList;
    private List<Unit> theUnitList;
    
    private JDialog addDialog, detailDialog;
    JFrame topFrame;
    private Label lblName, lblDescription;
    private JTextField txtName, txtDescription;
    private String [] columnName = {"Qp ID", "Qp Standard", "Qp Unit", "Qp Parameter", "Qp Analysis Result", "Qp Testing Method", "Qp Notes", "Qp Description"};
    private QualityParameterForm qform;
    /**
     * Creates new form DevicesPanel
     */
    public QualityParametersPanel() {
//        initComponents();
        myInitsComponent();
    }
    
    private void myInitsComponent() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        addNewDevice = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        unitList = new ArrayList<>();
        standardList = new ArrayList<>();
        theUnitList = new ArrayList<>();
        devices = new javax.swing.JLabel();
        
        topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        addDialog = new JDialog(topFrame, "Add New Quality Parameter", true);
        detailDialog = new JDialog(topFrame, "Detail Quality Parameter", true);
        detailDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                resetDetailJDialog();
            }
        });
        
        addDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                resetAddJDialog();
            }
        });
        
        id = new javax.swing.JLabel();
        
        itemController = new ItemCtl();
        unitList.addAll(this.itemController.getListQualityParamter(""));
        
        standardList.addAll(this.itemController.getListStandard(""));
        theUnitList.addAll(this.itemController.getListUnit(""));
        
        List<String> s1 = new ArrayList<>();
        List<String> s2 = new ArrayList<>();
        
        for(Standard standard : standardList){
            s1.add(String.valueOf(standard.getStandardId()) + " " + standard.getStandardName());
        }

        for(Unit unit : theUnitList){
            s2.add(String.valueOf(unit.getUnitId()) + " " + unit.getUnitName());
        }
        
        jTable1.setModel(new FinalItemTableModel(unitList, columnName));
        setTableListener();
        jScrollPane1.setViewportView(jTable1);

        txtSearch.setText("Search by Name");

        searchBtn.setText("Search");
        searchBtn.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        handleSearch();
                    }
                }
            }
        );

        addNewDevice.setText("Show Modal");
        addNewDevice.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        addModalComponent();
                        addDialog.setVisible(true);
                    }
                }
            }
        );

        jButton1.setText("Edit Data");
        jButton1.setVisible(false);

        devices.setText("Units");
        
        this.qform = new QualityParameterForm(s1, s2, (params) -> this.editFunc(params), (params) -> this.addFunc(params));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addNewDevice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBtn))
                            .addComponent(devices))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(devices)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNewDevice)
                    .addComponent(jButton1))
                .addContainerGap(32, Short.MAX_VALUE))
        );
   }
   
    private void handleSearch() {
        String name = this.txtSearch.getText();
        resetContent(name);
    }
   
    private void setTableListener() {
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                if (e.getClickCount() == 1) {
                    
                    final JTable jTable= (JTable)e.getSource();
                    final int row = jTable.getSelectedRow();
                    final int column = jTable.getSelectedColumn();
                    final String valueInCell = (String)jTable.getValueAt(row, 0).toString();
                    
                    Standard standard = new Standard();
                    Unit unit = new Unit();
                    
                    standard.setStandardName(jTable.getValueAt(row, 1).toString());
                    unit.setUnitName(jTable.getValueAt(row, 2).toString());
                    
                    addDetailModalComponent(new QualityParameter(
                        Integer.valueOf(jTable.getValueAt(row, 0).toString()),
                        standard,
                        unit,
                        jTable.getValueAt(row, 3).toString(),
                        jTable.getValueAt(row, 4).toString(),
                        jTable.getValueAt(row, 5).toString(),
                        jTable.getValueAt(row, 6).toString(),
                        jTable.getValueAt(row, 7).toString()
                    ));
                    
                    id.setText(String.valueOf(Integer.valueOf(jTable.getValueAt(row, 0).toString())));
                    detailDialog.setVisible(true);
                    
                    System.out.println(valueInCell);
                }
            }
        });
    }
    
    private void addDetailModalComponent(QualityParameter quality) {
        this.resetDetailJDialog();
        this.qform.setEditableValue(quality);
        this.detailDialog.setSize(350, 450);
        this.detailDialog.add(this.qform);
    }
    
    private void resetAddJDialog() {
        Component[] componentList = this.getComponents();

        //Loop through the components
        for(Component c : componentList){

            //Find the components you want to remove
            if(c.getName() == null ? this.addDialog.getName() == null : c.getName().equals(this.addDialog.getName())){
                
                //Remove it
                this.remove(c);
            }
        }

        //IMPORTANT
        this.revalidate();
        this.repaint();
        
        addDialog = new JDialog(topFrame, "Add New Quality Parameter", true);
    }
    
    private void resetDetailJDialog() {    
        Component[] componentList = this.getComponents();

        //Loop through the components
        for(Component c : componentList){

            //Find the components you want to remove
            if(c.getName() == null ? this.detailDialog.getName() == null : c.getName().equals(this.detailDialog.getName())){
                
                //Remove it
                this.remove(c);
            }
        }

        //IMPORTANT
        this.revalidate();
        this.repaint();
        
        detailDialog = new JDialog(topFrame, "Detail Quality Parameter", true);
    }
    
    private void editFunc(QualityParameter unit) {
        if(this.itemController.editQualityParameter(unit)){
            resetContent("");
            this.detailDialog.setVisible(false);
        }
    }
    
    private void addFunc(QualityParameter unit) {
        if(!unit.getQpParameter().equals("") && unit.getQpParameter() != null) {
            if(this.itemController.addQualityParameter(unit)){
                resetContent("");
                this.addDialog.setVisible(false);
            }
        }else{
           JOptionPane.showMessageDialog(topFrame, "Name cannot be empty"); 
        }
    }
    
    private void addModalComponent() {
        resetAddJDialog();
        this.addDialog.setSize(350, 450);
        this.addDialog.add(this.qform);
    }
    
    private void resetContent(String params) {
        unitList.clear();
        unitList.addAll(this.itemController.getListQualityParamter(params));
        
        Component[] componentList = this.getComponents();

        //Loop through the components
        for(Component c : componentList){

            //Find the components you want to remove
            if(c instanceof JTable){

                //Remove it
                this.remove(c);
            }
        }

        //IMPORTANT
        this.revalidate();
        this.repaint();
        
        jTable1 = new javax.swing.JTable();
        jTable1.setModel(new FinalItemTableModel(unitList, columnName));
        setTableListener();
        jScrollPane1.setViewportView(jTable1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        addNewDevice = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        devices = new javax.swing.JLabel();
        id = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        txtSearch.setText("Search by Name");

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        addNewDevice.setText("Add New Data");
        addNewDevice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewDeviceActionPerformed(evt);
            }
        });

        jButton1.setText("Edit Data");

        devices.setText("Quality Parameter");

        id.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addNewDevice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(id)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBtn))
                            .addComponent(devices))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(devices)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNewDevice)
                    .addComponent(jButton1)
                    .addComponent(id))
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBtnActionPerformed

    private void addNewDeviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewDeviceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addNewDeviceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewDevice;
    private javax.swing.JLabel devices;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
