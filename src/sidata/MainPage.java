/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidata;

import java.awt.event.*;
import javax.swing.JLabel;

/**
 *
 * @author syubban
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form MainPage
     */
    public MainPage() {
//        initComponents();
        myCustomComponents();
    }
    
    private void myCustomComponents(){
        
        SideBar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        createReport = new javax.swing.JLabel();
        viewReport = new javax.swing.JLabel();
        viewOperator = new javax.swing.JLabel();
        viewAssignment = new javax.swing.JLabel();
        viewData = new javax.swing.JLabel();
        viewProfile = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        MainPage = new javax.swing.JPanel();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SideBar.setBackground(new java.awt.Color(102, 102, 102));
        SideBar.setForeground(new java.awt.Color(102, 102, 102));

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
                System.out.println("clicked");
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
                System.out.println("clicked");
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
                System.out.println("clicked");
            }
        });

        viewData.setForeground(new java.awt.Color(255, 255, 255));
        viewData.setText("View Data");
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
                System.out.println("clicked");
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
                System.out.println("clicked");
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SIData");


        javax.swing.GroupLayout SideBarLayout = new javax.swing.GroupLayout(SideBar);
        SideBar.setLayout(SideBarLayout);
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

        MainPage.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout MainPageLayout = new javax.swing.GroupLayout(MainPage);
        MainPage.setLayout(MainPageLayout);
        MainPageLayout.setHorizontalGroup(
            MainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
        );
        MainPageLayout.setVerticalGroup(
            MainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(MainPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MainPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    
    private void changeWhenEnter(JLabel label){
        label.setForeground(new java.awt.Color(204, 204, 204));
    }
    
    private void changeWhenRelease(JLabel label){
        label.setForeground(new java.awt.Color(255, 255, 255));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SideBar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        createReport = new javax.swing.JLabel();
        viewReport = new javax.swing.JLabel();
        viewOperator = new javax.swing.JLabel();
        viewAssignment = new javax.swing.JLabel();
        viewData = new javax.swing.JLabel();
        viewProfile = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        MainPage = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SideBar.setBackground(new java.awt.Color(102, 102, 102));
        SideBar.setForeground(new java.awt.Color(102, 102, 102));

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

        javax.swing.GroupLayout SideBarLayout = new javax.swing.GroupLayout(SideBar);
        SideBar.setLayout(SideBarLayout);
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

        MainPage.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout MainPageLayout = new javax.swing.GroupLayout(MainPage);
        MainPage.setLayout(MainPageLayout);
        MainPageLayout.setHorizontalGroup(
            MainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 836, Short.MAX_VALUE)
        );
        MainPageLayout.setVerticalGroup(
            MainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(MainPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MainPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JPanel MainPage;
    private javax.swing.JPanel SideBar;
    private javax.swing.JLabel createReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel viewAssignment;
    private javax.swing.JLabel viewData;
    private javax.swing.JLabel viewOperator;
    private javax.swing.JLabel viewProfile;
    private javax.swing.JLabel viewReport;
    // End of variables declaration//GEN-END:variables
}
