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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import sidata.abstraction.FinalItemTableModel;
import sidata.abstraction.FinalTableModel;
import sidata.controller.ItemCtl;
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
public class UnitsPanel extends javax.swing.JPanel {
    private ItemCtl itemController;
    private List<Unit> unitList;
    private JDialog addDialog, detailDialog;
    JFrame topFrame;
    private Label lblName, lblDescription;
    private JTextField txtName, txtDescription;
    private String [] columnName = {"Unit ID", "Unit Name", "Unit Description"};
    
    /**
     * Creates new form DevicesPanel
     */
    public UnitsPanel() {
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
        devices = new javax.swing.JLabel();
        
        topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        addDialog = new JDialog(topFrame, "Add New Unit", true);
        id = new javax.swing.JLabel();
        
        itemController = new ItemCtl();
        unitList.addAll(this.itemController.getListUnit(""));

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

        addNewDevice.setText("Add New Data");
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
                    
                    addDetailModalComponent(new Unit(
                        Integer.valueOf(jTable.getValueAt(row, 0).toString()),
                        jTable.getValueAt(row, 1).toString(),
                        jTable.getValueAt(row, 2).toString()    
                    ));
                    
                    id.setText(String.valueOf(Integer.valueOf(jTable.getValueAt(row, 0).toString())));
                    detailDialog.setVisible(true);
                    
                    System.out.println(valueInCell);
                }
            }
        });
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
    }
    
    private void addDetailModalComponent(Unit unit) {
        JButton edit = new JButton("Edit Unit");
        detailDialog = new JDialog(topFrame, "Detail Operator", true);
        detailDialog.setName("detail dialog");
        this.detailDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                resetDetailJDialog();
            }
        });
                
        JPanel panel = new JPanel();
        
        Label lblNames, lblid, lblDescriptions;
        JTextField txtNames, txtId, txtDescriptions;

        JPanel mainPanel = new JPanel(new GridLayout(0, 2));
        
        // Label initialization       
        lblNames = new Label("Name");
        lblid = new Label("ID");
        lblDescriptions = new Label("Description");
        
        // Textfield initialization
        txtNames = new JTextField(16);
        txtNames.setText(unit.getUnitName());
        
        txtId = new JTextField(16);
        txtId.setText(String.valueOf(unit.getUnitId()));
        txtId.setEnabled(false);
        
        txtDescriptions = new JTextField();
        txtDescriptions.setText(unit.getUnitDescription());
        
        // Plotting in panel
        mainPanel.add(lblid);
        mainPanel.add(txtId);
        mainPanel.add(lblNames);
        mainPanel.add(txtNames);
        mainPanel.add(lblDescriptions);
        mainPanel.add(txtDescriptions);

        panel.add(mainPanel);
        panel.add(edit);
        
        edit.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        editFunc(new Unit(unit.getUnitId(), txtNames.getText(), txtDescriptions.getText()));
                    }
                }
            }
        );
        
        this.detailDialog.setSize(400, 400);
        this.detailDialog.add(panel);
    }
    
    private void editFunc(Unit unit) {
        if(this.itemController.editNewUnit(unit)){
            resetContent("");
            this.detailDialog.setVisible(false);
        }
    }
    
    private void addFunc() {
        Unit unit = new Unit();
        String name = txtName.getText();
        String description = txtDescription.getText();
        
        unit.setUnitName(name);
        unit.setUnitDescription(description);
        
//        System.out.println("namae : " + name);
        if(!name.equals("") && name != null) {
            if(this.itemController.addNewUnit(unit)){
                resetContent("");
                this.addDialog.setVisible(false);
            }
        }else{
           JOptionPane.showMessageDialog(topFrame, "Name cannot be empty"); 
        }
    }
    
    private void addModalComponent() {
        JPanel panel = new JPanel();
        JButton add = new JButton("Add Unit");

        JPanel mainPanel = new JPanel(new GridLayout(0, 2));
        
        // Label initialization       
        lblName = new Label("Name");
        lblDescription = new Label("Description");
        
        // Textfield initialization
        txtName = new JTextField(16);
        txtDescription = new JTextField();
        
        // Plotting in panel
        mainPanel.add(lblName);
        mainPanel.add(txtName);
        mainPanel.add(lblDescription);
        mainPanel.add(txtDescription);
        

        panel.add(mainPanel);
        panel.add(add);
        
        add.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                       addFunc(); 
                    }
                }
            }
        );
        this.addDialog.setSize(400, 400);
        this.addDialog.add(panel);
    }
    
    private void resetContent(String params) {
        unitList.clear();
        unitList.addAll(this.itemController.getListUnit(params));
        
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

        devices.setText("Units");

        id.setBackground(new java.awt.Color(255, 255, 255));
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
                        .addGap(18, 18, 18)
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
