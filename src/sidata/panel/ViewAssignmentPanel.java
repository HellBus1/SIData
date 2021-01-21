/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidata.panel;

import com.google.gson.Gson;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import sidata.abstraction.FinalItemTableModel;
import sidata.abstraction.FinalTableModel;
import sidata.controller.AssignmentCtl;
import sidata.database.UserStatic;
import sidata.entity.Assessment;
import sidata.entity.Assignment;
import sidata.entity.Operator;
import sidata.entity.Unit;

/**
 *
 * @author syubban
 */
public class ViewAssignmentPanel extends javax.swing.JPanel {
    private List<Assignment> assignmentList;
    private List<Operator> operatorList;
    private List<String> dropListValue;
    private AssignmentCtl assignmentCtl;
    private Operator operator;
    private Assignment assignment;
    private String [] columnName = { "Assignment ID", "User ID", "Assignment Name" };
    private JDialog addDialog, detailDialog;
    JFrame topFrame;
    
    /**
     * Creates new form ViewDataMaster
     */
    public ViewAssignmentPanel() {
//        initComponents();
        myCustomInitComponents();
    }
    
    private void myCustomInitComponents(){
        viewAssignmentLabel = new javax.swing.JLabel();
        addNewAssignment = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        idReport = new javax.swing.JLabel();
        cancelAssignment = new javax.swing.JButton();
        
        assignmentCtl = new AssignmentCtl();
        
        assignmentList = new ArrayList<>();
        assignmentList.addAll(this.assignmentCtl.getListAssignment());
        
        operatorList = new ArrayList<>();
        operatorList.addAll(this.assignmentCtl.getListOperator());
        
        dropListValue = new ArrayList<>();
        for(Operator operator : operatorList){
            dropListValue.add(operator.getId()+ " " + operator.getName());
        }
        
        topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        addDialog = new JDialog(topFrame, "Add New Assignment", true);
        
        setBackground(new java.awt.Color(255, 255, 255));

        viewAssignmentLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viewAssignmentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewAssignmentLabel.setText("View Assignment");
        viewAssignmentLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        viewAssignmentLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        addNewAssignment.setText("Add new Assignment");
        addNewAssignment.addMouseListener(
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

        jTable1.setModel(new FinalItemTableModel(assignmentList, columnName));
        setTableListener();
        jScrollPane1.setViewportView(jTable1);

        idReport.setText("-1");

        cancelAssignment.setText("Cancel Assignment");
        if(UserStatic.getUserPositionId() == 1){
            cancelAssignment.setVisible(false);
            addNewAssignment.setVisible(false);
        }
        cancelAssignment.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        try {
                            if(assignmentCtl.deleteAssignment(Integer.valueOf(idReport.getText()))){
                                resetContent();
                            }
                        } catch (ParseException ex) {
                            Logger.getLogger(ViewAssignmentPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(viewAssignmentLabel)
                .addContainerGap(329, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelAssignment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idReport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addNewAssignment)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(viewAssignmentLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNewAssignment)
                    .addComponent(idReport)
                    .addComponent(cancelAssignment))
                .addContainerGap(148, Short.MAX_VALUE))
        );
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
                    
                    Assignment assignment = new Assignment();
//                    jTable.getValueAt(row, 1).toString()

                    for(Assignment assign : assignmentList){
                        if(assign.getAssignmentId() == Integer.valueOf(jTable.getValueAt(row, 0).toString())){
                            assignment = new Assignment();
                            assignment.setAssignmentId(assign.getAssignmentId());
                            assignment.setOperator(assign.getOperator());
                            assignment.setAssignmentName(assign.getAssignmentName());
                            break;
                        }
                    }

                    addDetailModalComponent(assignment);
                    
                    idReport.setText(String.valueOf(Integer.valueOf(jTable.getValueAt(row, 0).toString())));
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
    
    private void addDetailModalComponent(Assignment unit) {
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
        
        Label assignmentId, assessmentId, assignmentName;
        JTextField txtId, txtName;
        JComboBox comboBox = new JComboBox(this.dropListValue.toArray());
        comboBox.getModel().setSelectedItem(unit.getOperator().getId()+ " " + unit.getOperator().getName());

        JPanel mainPanel = new JPanel(new GridLayout(0, 2));
        
        // Label initialization       
        assignmentId = new Label("Assignment ID");
        assessmentId = new Label("Assessment ID");
        assignmentName = new Label("Assignment Name");
        
        // Textfield initialization
        txtId = new JTextField(16);
        txtId.setText(String.valueOf(unit.getAssignmentId()));
        txtId.setEnabled(false);
        
        txtName = new JTextField();
        txtName.setText(unit.getAssignmentName());
        
        // Plotting in panel
        mainPanel.add(assignmentId);
        mainPanel.add(txtId);
        mainPanel.add(assessmentId);
        mainPanel.add(comboBox);
        mainPanel.add(assignmentName);
        mainPanel.add(txtName);

        panel.add(mainPanel);
        
        if(UserStatic.getUserPositionId() != 1){
            panel.add(edit);
        }
        
        edit.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        Operator operator = new Operator();         
                        operator.setId(getObjectId(comboBox.getSelectedItem().toString()));
                        
                        Assignment assignment = new Assignment(
                            Integer.valueOf(txtId.getText()),
                            operator,
                            txtName.getText()
                        );
                        try {
                            editFunc(assignment);
                        } catch (ParseException ex) {
                            Logger.getLogger(ViewAssignmentPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        );
        
        this.detailDialog.setSize(400, 400);
        this.detailDialog.add(panel);
    }
    
    public void editFunc(Assignment assignment) throws ParseException {
//        Gson gson = new Gson();
//        System.out.println(gson.toJson(assignment));
        if(this.assignmentCtl.editAssignment(assignment)){
            resetContent();
            this.detailDialog.setVisible(false);
        }
    }
    
    public void addFunc(Assignment assignment) throws ParseException {
        if(this.assignmentCtl.addAssignment(assignment)){
            resetContent();
            this.addDialog.setVisible(false);
        }
    }
    
    private void addModalComponent() {
        JPanel panel = new JPanel();
        JButton add = new JButton("Add Assignment");
        
        Label assignmentLabel, assignmentID;
        JTextField assignmentName = new JTextField(16);
        JComboBox comboBox = new JComboBox(this.dropListValue.toArray());

        JPanel mainPanel = new JPanel(new GridLayout(0, 2));
        
        // Label initialization       
        assignmentLabel = new Label("Assignment Name");
        assignmentID = new Label("Assessment ID");
        
        // Plotting in panel
        mainPanel.add(assignmentID);
        mainPanel.add(comboBox);
        mainPanel.add(assignmentLabel);
        mainPanel.add(assignmentName);
        

        panel.add(mainPanel);
        panel.add(add);
        
        add.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                       
                        Operator operator = new Operator();         
                        operator.setId(getObjectId(comboBox.getSelectedItem().toString()));
                        
                        Assignment assignment = new Assignment(
                            0,
                            operator,
                            assignmentName.getText()
                        );
                        
                        try { 
                            addFunc(assignment);
                        } catch (ParseException ex) {
                            Logger.getLogger(ViewAssignmentPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        );
        this.addDialog.setSize(400, 400);
        this.addDialog.add(panel);
    }
    
    private int getObjectId(String value){
        String[] splittedStandard = value.split(" ");
        StringBuilder sb1 = new StringBuilder();

        sb1.append(splittedStandard[0]);
        
        return Integer.valueOf(sb1.toString());
    }
    
    public void resetContent() {
        assignmentList.clear();
        assignmentList.addAll(this.assignmentCtl.getListAssignment());
        
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
        jTable1.setModel(new FinalItemTableModel(assignmentList, columnName));
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

        viewAssignmentLabel = new javax.swing.JLabel();
        addNewAssignment = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        idReport = new javax.swing.JLabel();
        cancelAssignment = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        viewAssignmentLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viewAssignmentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewAssignmentLabel.setText("View Assignment");
        viewAssignmentLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        viewAssignmentLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        addNewAssignment.setText("Add new Assignment");
        addNewAssignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewAssignmentActionPerformed(evt);
            }
        });

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

        idReport.setText("-1");

        cancelAssignment.setText("Cancel Assignment");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(viewAssignmentLabel)
                .addContainerGap(329, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelAssignment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idReport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addNewAssignment)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(viewAssignmentLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNewAssignment)
                    .addComponent(idReport)
                    .addComponent(cancelAssignment))
                .addContainerGap(148, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addNewAssignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewAssignmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addNewAssignmentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewAssignment;
    private javax.swing.JButton cancelAssignment;
    private javax.swing.JLabel idReport;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel viewAssignmentLabel;
    // End of variables declaration//GEN-END:variables
}
