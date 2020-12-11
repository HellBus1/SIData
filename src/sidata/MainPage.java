/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidata;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;
import sidata.panel.ViewAssignmentPanel;
import sidata.panel.ViewDataMasterPanel;
import sidata.panel.ViewOperatorPanel;
import sidata.panel.ViewProfilePanel;
import sidata.panel.ViewReportPanel;

/**
 *
 * @author syubban
 */
public class MainPage extends javax.swing.JFrame {

//    ViewOperatorPanel viewOperatorPanel;
//    ViewDataMasterPanel viewDataMasterPanel;
//    ViewAssignmentPanel viewAssignmentPanel;
//    ViewReportPanel viewReportPanel;
//    ViewProfilePanel viewProfilePanel;
    private String currentPanel;
    
    /**
     * Creates new form MainPage
     */
    public MainPage() {
//        initComponents();
        myCustomInitComponents();
    }
    
    private void myCustomInitComponents(){
        
        sideBar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        createReport = new javax.swing.JLabel();
        viewReport = new javax.swing.JLabel();
        viewOperator = new javax.swing.JLabel();
        viewAssignment = new javax.swing.JLabel();
        viewData = new javax.swing.JLabel();
        viewProfile = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        mainPage = new javax.swing.JPanel();
        this.setResizable(false);
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sideBar.setBackground(new java.awt.Color(102, 102, 102));
        sideBar.setForeground(new java.awt.Color(102, 102, 102));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Main Menu");

        createReport.setForeground(new java.awt.Color(255, 255, 255));
        createReport.setText("Create Report");
        createReport.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me) {
                changeWhenEnter(createReport);
            }
            
            @Override
            public void mouseExited(MouseEvent me){
                changeWhenRelease(createReport);
            }
            
            @Override
            public void mouseClicked(MouseEvent me){
                System.out.println("clicked");
            }
        });

        viewReport.setForeground(new java.awt.Color(255, 255, 255));
        viewReport.setText("View Report");
        viewReport.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me) {
                changeWhenEnter(viewReport);
            }
            
            @Override
            public void mouseExited(MouseEvent me){
                changeWhenRelease(viewReport);
            }
            
            @Override
            public void mouseClicked(MouseEvent me){
                removePanel("View Report");
            }
        });

        viewOperator.setForeground(new java.awt.Color(255, 255, 255));
        viewOperator.setText("View Operator");
        viewOperator.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me) {
                changeWhenEnter(viewOperator);
            }
            
            @Override
            public void mouseExited(MouseEvent me){
                changeWhenRelease(viewOperator);
            }
            
            @Override
            public void mouseClicked(MouseEvent me){
                removePanel("View Operator");
            }
        });

        viewAssignment.setForeground(new java.awt.Color(255, 255, 255));
        viewAssignment.setText("View Assignment");
        viewAssignment.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me) {
                changeWhenEnter(viewAssignment);
            }
            
            @Override
            public void mouseExited(MouseEvent me){
                changeWhenRelease(viewAssignment);
            }
            
            @Override
            public void mouseClicked(MouseEvent me){
                removePanel("View Assignment");
            }
        });

        viewData.setForeground(new java.awt.Color(255, 255, 255));
        viewData.setText("View Data Master");
        viewData.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me) {
                changeWhenEnter(viewData);
            }
            
            @Override
            public void mouseExited(MouseEvent me){
                changeWhenRelease(viewData);
            }
            
            @Override
            public void mouseClicked(MouseEvent me){
                removePanel("View Data Master");
            }
        });

        viewProfile.setForeground(new java.awt.Color(255, 255, 255));
        viewProfile.setText("View Profile");
        viewProfile.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me) {
                changeWhenEnter(viewProfile);
            }
            
            @Override
            public void mouseExited(MouseEvent me){
                changeWhenRelease(viewProfile);
            }
            
            @Override
            public void mouseClicked(MouseEvent me){
                removePanel("View Profile");
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SIData");


        javax.swing.GroupLayout SideBarLayout = new javax.swing.GroupLayout(sideBar);
        sideBar.setLayout(SideBarLayout);
        SideBarLayout.setHorizontalGroup(
            SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SideBarLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(viewReport)
                    .addComponent(createReport)
                    .addComponent(viewOperator)
                    .addComponent(viewAssignment)
                    .addComponent(viewData)
                    .addComponent(viewProfile))
                .addContainerGap(30, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        SideBarLayout.setVerticalGroup(
            SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SideBarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createReport)
                .addGap(18, 18, 18)
                .addComponent(viewReport)
                .addGap(18, 18, 18)
                .addComponent(viewOperator)
                .addGap(18, 18, 18)
                .addComponent(viewAssignment)
                .addGap(18, 18, 18)
                .addComponent(viewData)
                .addGap(18, 18, 18)
                .addComponent(viewProfile)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        mainPage.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout mainPageLayout = new javax.swing.GroupLayout(mainPage);
        mainPage.setLayout(mainPageLayout);
        mainPageLayout.setHorizontalGroup(
            mainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 836, Short.MAX_VALUE)
        );
        mainPageLayout.setVerticalGroup(
            mainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(mainPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    
    private void changeWhenEnter(JLabel label){
        label.setForeground(new java.awt.Color(204, 204, 204));
    }
    
    private void changeWhenRelease(JLabel label){
        label.setForeground(new java.awt.Color(255, 255, 255));
    }
    
    private void removePanel(String toPanel) {
        Container context = this.getContentPane();
        
//        viewOperatorPanel = new ViewOperatorPanel();
//        viewDataMasterPanel = new ViewDataMasterPanel();
//        viewAssignmentPanel = new ViewAssignmentPanel();
//        viewReportPanel = new ViewReportPanel();
//        viewProfilePanel = new ViewProfilePanel();
  
        switch(toPanel){
            case "View Operator": {
                currentPanel = "View Operator";
                removeCustomPanel(context);
                setLayouting(new ViewOperatorPanel());
                context.validate();
                context.repaint();
            }break;
            case "View Report": {
                currentPanel = "View Report";
                removeCustomPanel(context);
                setLayouting(new ViewReportPanel());
                context.validate();
                context.repaint();
            }break;
            case "View Assignment": {
                currentPanel = "View Assignment";
                removeCustomPanel(context);
                setLayouting(new ViewAssignmentPanel());
                context.validate();
                context.repaint();
            }break;
            case "View Profile": {
                setLayouting(new ViewProfilePanel());
                context.validate();
                context.repaint();
            }break;
            case "View Data Master": {
                setLayouting(new ViewDataMasterPanel());
                context.validate();
                context.repaint();
            }break;
            default:
        }
    }
    
//    private boolean isExist(String title){
//        return java.util.Arrays.asList(this.getComponents()).contains(component);
//    }
    
    private void removeCustomPanel(Container context) {
        context.remove(mainPage);
//        context.remove(viewOperatorPanel);
//        context.remove(viewDataMasterPanel);
//        context.remove(viewAssignmentPanel);
//        context.remove(viewReportPanel);
//        context.remove(viewProfilePanel);
        Component[] componentList = context.getComponents();

        //Loop through the components
        for(Component c : componentList){

            //Find the components you want to remove
            if("View Operator".equals(this.currentPanel)){
                if(c instanceof ViewOperatorPanel){
//                    System.out.println(c);
                    context.remove(c);
                }
            }else if("View Report".equals(this.currentPanel)){
                if(c instanceof ViewReportPanel){
//                    System.out.println(c);
                    context.remove(c);
                }
            }else if("View Assignment".equals(this.currentPanel)){
                if(c instanceof ViewAssignmentPanel){
//                    System.out.println(c);
                    context.remove(c);
                }
            }
        }
        context.validate();
        context.repaint();
    }
    
    private void setLayouting(JPanel panel) {

        Container context = this.getContentPane();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(context);
        context.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 145, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
//        context.setLayout(new BorderLayout());
//        context.add(panel, BorderLayout.CENTER);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideBar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        createReport = new javax.swing.JLabel();
        viewReport = new javax.swing.JLabel();
        viewOperator = new javax.swing.JLabel();
        viewAssignment = new javax.swing.JLabel();
        viewData = new javax.swing.JLabel();
        viewProfile = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        mainPage = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sideBar.setBackground(new java.awt.Color(102, 102, 102));
        sideBar.setForeground(new java.awt.Color(102, 102, 102));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Main Menu");

        createReport.setForeground(new java.awt.Color(255, 255, 255));
        createReport.setText("Create Report");
        createReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createReportMouseClicked(evt);
            }
        });

        viewReport.setForeground(new java.awt.Color(255, 255, 255));
        viewReport.setText("View Report");

        viewOperator.setForeground(new java.awt.Color(255, 255, 255));
        viewOperator.setText("View Operator");

        viewAssignment.setForeground(new java.awt.Color(255, 255, 255));
        viewAssignment.setText("View Assignment");

        viewData.setForeground(new java.awt.Color(255, 255, 255));
        viewData.setText("View Data");

        viewProfile.setForeground(new java.awt.Color(255, 255, 255));
        viewProfile.setText("View Profile");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SIData");

        javax.swing.GroupLayout sideBarLayout = new javax.swing.GroupLayout(sideBar);
        sideBar.setLayout(sideBarLayout);
        sideBarLayout.setHorizontalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(viewReport)
                    .addComponent(createReport)
                    .addComponent(viewOperator)
                    .addComponent(viewAssignment)
                    .addComponent(viewData)
                    .addComponent(viewProfile))
                .addContainerGap(30, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        sideBarLayout.setVerticalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(createReport)
                .addGap(18, 18, 18)
                .addComponent(viewReport)
                .addGap(18, 18, 18)
                .addComponent(viewOperator)
                .addGap(18, 18, 18)
                .addComponent(viewAssignment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewData)
                .addGap(18, 18, 18)
                .addComponent(viewProfile)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        mainPage.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout mainPageLayout = new javax.swing.GroupLayout(mainPage);
        mainPage.setLayout(mainPageLayout);
        mainPageLayout.setHorizontalGroup(
            mainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 836, Short.MAX_VALUE)
        );
        mainPageLayout.setVerticalGroup(
            mainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(mainPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createReportMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_createReportMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
      
      public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel createReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainPage;
    private javax.swing.JPanel sideBar;
    private javax.swing.JLabel viewAssignment;
    private javax.swing.JLabel viewData;
    private javax.swing.JLabel viewOperator;
    private javax.swing.JLabel viewProfile;
    private javax.swing.JLabel viewReport;
    // End of variables declaration//GEN-END:variables
}
