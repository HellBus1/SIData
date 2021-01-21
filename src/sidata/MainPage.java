/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidata;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import sidata.controller.ItemCtl;
import sidata.controller.ReportHandler;
import sidata.database.UserStatic;
import sidata.entity.Assessment;
import sidata.entity.Device;
import sidata.entity.Operator;
import sidata.entity.QualityParameter;
import sidata.entity.Report;
import sidata.entity.SampleElement;
import sidata.entity.SampleType;
import sidata.form.AssessmentForm;
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
    
    private String currentPanel;
    private JDialog addDialog;
    private AssessmentForm assessmentForm;
    private List<SampleType> sampleList;
    private List<Device> testingDevice;
    private List<Device> deviceList;
    private List<SampleElement> simpleElementList;
    private List<Operator> operatorList;
    private List<QualityParameter> qp;
    private ItemCtl itemCtl;
    private ReportHandler reportHandler;
    
    List<String> typeList = new ArrayList<>();
    List<String> testingDevices = new ArrayList<>();
    List<String> devices = new ArrayList<>();
    List<String> elements = new ArrayList<>();
    List<String> operators = new ArrayList<>();
    
    /**
     * Creates new form MainPage
     */
    public MainPage() {
//        initComponents();
        myCustomInitComponents();
    }
    
    private void myCustomInitComponents(){
        
        sampleList = new ArrayList<>();
        testingDevice = new ArrayList<>();
        deviceList = new ArrayList<>();
        simpleElementList = new ArrayList<>();
        operatorList = new ArrayList<>();
        qp = new ArrayList<>();
        itemCtl = new ItemCtl();
        reportHandler = new ReportHandler();
        
        sampleList.addAll(itemCtl.getListSampleType(""));
        testingDevice.addAll(itemCtl.getListDevice(""));
        deviceList.addAll(itemCtl.getListDevice(""));
        simpleElementList.addAll(itemCtl.getListSampleElement(""));
        operatorList.addAll(itemCtl.getListOperator(""));
        qp.addAll(itemCtl.getListQualityParamter(""));
        
        for(SampleType type : sampleList){
            typeList.add(type.getStId() + " " + type.getStName());
        }
        for(Device device : testingDevice){
            testingDevices.add(device.getDeviceId() + " " + device.getDeviceName());
            devices.add(device.getDeviceId() + " " + device.getDeviceName());
        }
        for(Operator operator : operatorList){
            operators.add(operator.getId() + " " + operator.getName());
        }
        for(SampleElement element : simpleElementList){
            elements.add(element.getSeId() + " " + element.getSeName());
        }
        
        sideBar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        createReport = new javax.swing.JLabel();
        viewReport = new javax.swing.JLabel();
        if(UserStatic.getUserPositionId() == 3){
            viewReport.setVisible(false);
            createReport.setVisible(false);
        }
        viewOperator = new javax.swing.JLabel();
        viewAssignment = new javax.swing.JLabel();
        viewData = new javax.swing.JLabel();
        if(UserStatic.getUserPositionId() != 3){
            viewData.setVisible(false);
        }
        viewProfile = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        mainPage = new javax.swing.JPanel();
        this.setResizable(false);
        addDialog = new JDialog(this, "Add New Report", true);

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
                showForm();
                addDialog.setVisible(true);
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
    
    private void showForm() {

        assessmentForm = new AssessmentForm(typeList, testingDevices, devices, elements, operators, qp, (assm, ids) -> {
            try {
                this.addAssm(assm, ids);
            } catch (ParseException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }, false, new Report());
//        JPanel jpanel = new JPanel();
        JScrollPane js = new JScrollPane(assessmentForm, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.addDialog.setSize(600, 800);
        this.addDialog.add(js);
    }
    
    private void addAssm(Assessment assm, List<Integer> ids) throws ParseException {
        if(this.reportHandler.addAssessment(assm, ids)){
            this.addDialog.setVisible(false);
        }
    }
    
    private void changeWhenEnter(JLabel label){
        label.setForeground(new java.awt.Color(204, 204, 204));
    }
    
    private void changeWhenRelease(JLabel label){
        label.setForeground(new java.awt.Color(255, 255, 255));
    }
    
    private void removePanel(String toPanel) {
        Container context = this.getContentPane();
  
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
                currentPanel = "View Profile";
                removeCustomPanel(context);
                setLayouting(new ViewProfilePanel());
                context.validate();
                context.repaint();
            }break;
            case "View Data Master": {
                currentPanel = "View Data Master";
                removeCustomPanel(context);
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
        
        //Loop through the components
        

            //Find the components you want to remove
            if("View Operator".equals(this.currentPanel)){
                Component[] componentList = context.getComponents();
                for(Component c : componentList){
                    if((c instanceof ViewReportPanel) ||
                            (c instanceof ViewProfilePanel) || 
                            (c instanceof ViewDataMasterPanel) ||
                            (c instanceof ViewAssignmentPanel)){
                        context.remove(c);
                        context.validate();
                        context.repaint();
                    }
                }
            }else if("View Report".equals(this.currentPanel)){
                Component[] componentList = context.getComponents();
                for(Component c : componentList){
                    if((c instanceof ViewOperatorPanel) ||
                            (c instanceof ViewProfilePanel) || 
                            (c instanceof ViewDataMasterPanel) ||
                            (c instanceof ViewAssignmentPanel)){
                        context.remove(c);
                        context.validate();
                        context.repaint();
                    }
                }
            }
            else if("View Assignment".equals(this.currentPanel)){
                Component[] componentList = context.getComponents();
                for(Component c : componentList){
                    if((c instanceof ViewOperatorPanel) ||
                            (c instanceof ViewProfilePanel) || 
                            (c instanceof ViewDataMasterPanel) ||
                            (c instanceof ViewReportPanel)){
                        context.remove(c);
                        context.validate();
                        context.repaint();
                    }
                }
            }            
            else if("View Profile".equals(this.currentPanel)){
                Component[] componentList = context.getComponents();
                for(Component c : componentList){
                    if((c instanceof ViewOperatorPanel) ||
                            (c instanceof ViewAssignmentPanel) || 
                            (c instanceof ViewDataMasterPanel) ||
                            (c instanceof ViewReportPanel)){
                        context.remove(c);
                        context.validate();
                        context.repaint();
                    }
                }
            }
            else if("View Data Master".equals(this.currentPanel)){
                Component[] componentList = context.getComponents();
                for(Component c : componentList){
                    if((c instanceof ViewOperatorPanel) ||
                            (c instanceof ViewAssignmentPanel) || 
                            (c instanceof ViewProfilePanel) ||
                            (c instanceof ViewReportPanel)){
                        context.remove(c);
                        context.validate();
                        context.repaint();
                    }
                }
            }
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
                .addGap(18, 18, 18)
                .addComponent(viewData)
                .addGap(18, 18, 18)
                .addComponent(viewProfile)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGap(0, 534, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createReportMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_createReportMouseClicked


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
