/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidata.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sidata.abstraction.FinalTableModel;
import sidata.controller.ViewDetailOperator;
import sidata.entity.Operator;

/**
 *
 * @author syubban
 */
public class ViewOperatorPanel extends javax.swing.JPanel {
    private ViewDetailOperator viewDetailOperator;
    private List<Operator> operators;
    private JDialog addNewOperatorDialog, detailOperator;
    JFrame topFrame;
    
    private Label lblName, lblPosition, lblMobile, lblEmail, lblInstitution;
    private JTextField txtName, txtMobile, txtEmail, txtInstitution;
    private JComboBox dropPosition;
    
    public ViewOperatorPanel() {
//        initComponents();
        myCustomInitComponents();
    }

    private void myCustomInitComponents(){
        viewOperatorLabel = new javax.swing.JLabel();
        addNewOperator = new javax.swing.JButton();
        operators = new ArrayList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        idOperator = new javax.swing.JLabel();
        deactivateOperator = new javax.swing.JButton();
        topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        
        addNewOperatorDialog = new JDialog(topFrame, "Add New Operator", true);
        detailOperator = new JDialog(topFrame, "Detail Operator", true);
        
        viewDetailOperator = new ViewDetailOperator();
        operators.addAll(this.viewDetailOperator.getListOperator());

        setBackground(new java.awt.Color(255, 255, 255));

        viewOperatorLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viewOperatorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewOperatorLabel.setText("View Operator");
        viewOperatorLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        viewOperatorLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        addNewOperator.setText("Add New Operator");
        addNewOperator.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        addOperatorModalComponent();
                        addNewOperatorDialog.setVisible(true);
                    }
                }
            }
        );

        jTable1.setModel(new FinalTableModel(operators));
        setTableListener();
        jScrollPane1.setViewportView(jTable1);
        
        idOperator.setForeground(new java.awt.Color(255, 255, 255));
        idOperator.setText("jLabel1");

        deactivateOperator.setText("Deactivate Operator");
        deactivateOperator.setPreferredSize(new java.awt.Dimension(139, 25));
        deactivateOperator.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    String ids = idOperator.getText();
                    if(!"".equals(ids) || ids != null){
                        viewDetailOperator.deactivateOperator(Integer.valueOf(ids));
                        resetContent();
                    }
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(viewOperatorLabel)
                        .addGap(0, 341, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addNewOperator, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idOperator)
                        .addGap(18, 18, 18)
                        .addComponent(deactivateOperator, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(viewOperatorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNewOperator, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idOperator)
                    .addComponent(deactivateOperator, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }
    
    private void addOperatorModalComponent() {
        JPanel panel = new JPanel();
        JButton add = new JButton("Add Operator");

        JPanel mainPanel = new JPanel(new GridLayout(0, 2));
        String s1[] = { "1", "2", "3" }; 
        
        // Label initialization       
        lblName = new Label("Name");
        lblPosition = new Label("Position");
        lblMobile = new Label("Mobile");
        lblEmail = new Label("Email");
        lblInstitution = new Label("Institution");
        
        // Textfield initialization
        txtName = new JTextField(16);
        txtMobile = new JTextField(16);
        txtEmail = new JTextField(16);
        txtInstitution = new JTextField(16);
        
        // Combobox initialization
        dropPosition = new JComboBox(s1);
        
        // Plotting in panel
        mainPanel.add(lblName);
        mainPanel.add(txtName);
        
        mainPanel.add(lblPosition);
        mainPanel.add(dropPosition);
        
        mainPanel.add(lblMobile);
        mainPanel.add(txtMobile);
        
        mainPanel.add(lblEmail);
        mainPanel.add(txtEmail);
        
        mainPanel.add(lblInstitution);
        mainPanel.add(txtInstitution);

        panel.add(mainPanel);
        panel.add(add);
        
        add.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                       addOperatorFunc(); 
                    }
                }
            }
        );
        this.addNewOperatorDialog.setSize(400, 400);
        this.addNewOperatorDialog.add(panel);
    }
    
    private void addOperatorFunc() {
        Operator operator = new Operator();
        String name = txtName.getText();
        String position = dropPosition.getSelectedItem().toString();
        String mobileNum = txtMobile.getText();
        String email = txtEmail.getText();
        String institution = txtInstitution.getText();
        
        operator.setName(name);
        operator.setPosition_id(Integer.valueOf(position));
        operator.setMobilenumber(mobileNum);
        operator.setEmail(email);
        operator.setInstitution(institution);
        operator.setStatus(1);
        
        if(this.viewDetailOperator.addNewOperator(operator)){
            resetContent();
            this.addNewOperatorDialog.setVisible(false);
        }
    }
    
    private void resetContent() {
        operators.clear();
        operators.addAll(this.viewDetailOperator.getListOperator());
        
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
        jTable1.setModel(new FinalTableModel(operators));
        setTableListener();
        jScrollPane1.setViewportView(jTable1);
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
                    
                    addDetailModalComponent(new Operator(
                        Integer.valueOf(jTable.getValueAt(row, 0).toString()),
                        jTable.getValueAt(row, 1).toString(),
                        Integer.valueOf(jTable.getValueAt(row, 2).toString()),
                        jTable.getValueAt(row, 3).toString(),
                        jTable.getValueAt(row, 4).toString(),
                        jTable.getValueAt(row, 5).toString(),
                        Integer.valueOf(jTable.getValueAt(row, 6).toString())
                    ));
                    idOperator.setText(String.valueOf(Integer.valueOf(jTable.getValueAt(row, 0).toString())));
                    detailOperator.setVisible(true);
                    System.out.println(valueInCell);
                }
            }
        });
    }
    
    private void addDetailModalComponent(Operator operator) {
        JPanel panel = new JPanel();
        System.out.println(operator.getName());
        
        Label lblName, lblPosition, lblMobile, lblEmail, lblInstitution;
        JTextField txtName, txtMobile, txtEmail, txtInstitution;
        JComboBox dropPosition;

        JPanel mainPanel = new JPanel(new GridLayout(0, 2));
        String val = (String.valueOf(operator.getPosition_id()) != null) ? String.valueOf(operator.getPosition_id()) : "";
        String s1[] = { val }; 
        
        // Label initialization       
        lblName = new Label("Name");
        lblPosition = new Label("Position");
        lblMobile = new Label("Mobile");
        lblEmail = new Label("Email");
        lblInstitution = new Label("Institution");
        
        // Textfield initialization
        txtName = new JTextField(16);
        txtName.setText(operator.getName());
        txtName.setEnabled(false);
        
        txtMobile = new JTextField(16);
        txtMobile.setText(operator.getMobilenumber());
        txtMobile.setEnabled(false);
        
        txtEmail = new JTextField(16);
        txtEmail.setText(operator.getEmail());
        txtEmail.setEnabled(false);
        
        txtInstitution = new JTextField(16);
        txtInstitution.setText(operator.getInstitution());
        txtInstitution.setEnabled(false);
        
        // Combobox initialization
        dropPosition = new JComboBox(s1);
        
        // Plotting in panel
        mainPanel.add(lblName);
        mainPanel.add(txtName);
        
        mainPanel.add(lblPosition);
        mainPanel.add(dropPosition);
        
        mainPanel.add(lblMobile);
        mainPanel.add(txtMobile);
        
        mainPanel.add(lblEmail);
        mainPanel.add(txtEmail);
        
        mainPanel.add(lblInstitution);
        mainPanel.add(txtInstitution);

        panel.add(mainPanel);
        
        this.detailOperator.setSize(400, 400);
        this.detailOperator.add(panel);
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    /*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewOperatorLabel = new javax.swing.JLabel();
        addNewOperator = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        idOperator = new javax.swing.JLabel();
        deactivateOperator = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        viewOperatorLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viewOperatorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewOperatorLabel.setText("View Operator");
        viewOperatorLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        viewOperatorLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        addNewOperator.setText("Add New Operator");
        addNewOperator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewOperatorActionPerformed(evt);
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

        idOperator.setText("jLabel1");

        deactivateOperator.setText("Deactivate Operator");
        deactivateOperator.setPreferredSize(new java.awt.Dimension(139, 25));
        deactivateOperator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deactivateOperatorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(viewOperatorLabel)
                        .addGap(0, 341, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addNewOperator, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idOperator)
                        .addGap(18, 18, 18)
                        .addComponent(deactivateOperator, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(viewOperatorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNewOperator, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idOperator)
                    .addComponent(deactivateOperator, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addNewOperatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewOperatorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addNewOperatorActionPerformed

    private void deactivateOperatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deactivateOperatorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deactivateOperatorActionPerformed
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewOperator;
    private javax.swing.JButton deactivateOperator;
    private javax.swing.JLabel idOperator;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel viewOperatorLabel;
    // End of variables declaration//GEN-END:variables
}
