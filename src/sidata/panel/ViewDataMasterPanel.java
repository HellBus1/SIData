/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidata.panel;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JPanel;
import sidata.panel.datamaster.DevicesPanel;
import sidata.panel.datamaster.QualityParametersPanel;
import sidata.panel.datamaster.SampleElementsPanel;
import sidata.panel.datamaster.SampleTypesPanel;
import sidata.panel.datamaster.StandardsPanel;
import sidata.panel.datamaster.SupervisorsPanel;
import sidata.panel.datamaster.UnitsPanel;

/**
 *
 * @author syubban
 */
public class ViewDataMasterPanel extends javax.swing.JPanel {
    
    private CardLayout cardLayout;
    
    /**
     * Creates new form ViewDataMaster
     */
    public ViewDataMasterPanel() {
//        initComponents();
        myCustomInitComponents();
    }
    
    private void myCustomInitComponents(){  
        dataMasterLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        cardLayout = new CardLayout();
        

        setBackground(new java.awt.Color(255, 255, 255));

        dataMasterLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dataMasterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dataMasterLabel.setText("Data Master");
        dataMasterLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dataMasterLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Devices", "Standards", "Units",
        "Sample Types", "Quality Parameter", "Sample Elements", "Supervisors"}));
        
        jComboBox1.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    String item = (String) e.getItem();
                    changePanel(item);
                }
            }
        });
        
        
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(cardLayout);
        jPanel1.add(new JPanel(), "Empty");
        jPanel1.add(new DevicesPanel(), "Device Panel");
        jPanel1.add(new StandardsPanel(), "Standard Panel");
        jPanel1.add(new UnitsPanel(), "Units Panel");
        jPanel1.add(new SampleTypesPanel(), "Sample Types Panel");
        jPanel1.add(new QualityParametersPanel(), "Quality Parameters Panel");
        jPanel1.add(new SampleElementsPanel(), "Sample Element Panel");
        jPanel1.add(new SupervisorsPanel(), "Supervisor Panel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(338, 338, 338)
                                .addComponent(dataMasterLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 361, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(dataMasterLabel)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(450, Short.MAX_VALUE))
        );
    }
    
    private void changePanel(String arguments) {
        
        switch (arguments) {
            case "": {
                System.out.println(arguments);
                cardLayout.show(jPanel1, "Empty");
            }break;
            case "Devices": {
                System.out.println(arguments);
                cardLayout.show(jPanel1, "Device Panel");
             
            }break;
            case "Standards": {
                System.out.println(arguments);
                cardLayout.show(jPanel1, "Standard Panel");

            }break;
            case "Units": {
                System.out.println(arguments);
                cardLayout.show(jPanel1, "Units Panel");

            }break;
            case "Sample Types": {
                System.out.println(arguments);
                cardLayout.show(jPanel1, "Sample Types Panel");

            }break;
            case "Quality Parameter": {
                System.out.println(arguments);
                cardLayout.show(jPanel1, "Quality Parameters Panel");

            }break;
            case "Sample Elements": {
                System.out.println(arguments);
                cardLayout.show(jPanel1, "Sample Element Panel");

            }break;
            case "Supervisors": {
                System.out.println(arguments);
                cardLayout.show(jPanel1, "Supervisor Panel");

            }break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataMasterLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();

        setForeground(new java.awt.Color(240, 240, 240));

        dataMasterLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dataMasterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dataMasterLabel.setText("Data Master");
        dataMasterLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        dataMasterLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(338, 338, 338)
                                .addComponent(dataMasterLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 361, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(dataMasterLabel)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(423, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dataMasterLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
