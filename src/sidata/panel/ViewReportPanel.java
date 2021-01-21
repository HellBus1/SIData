/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidata.panel;

import com.google.gson.Gson;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import sidata.MainPage;
import sidata.abstraction.FinalItemTableModel;
import sidata.controller.ItemCtl;
import sidata.controller.ReportHandler;
import sidata.entity.Assessment;
import sidata.entity.Assignment;
import sidata.entity.Device;
import sidata.entity.Operator;
import sidata.entity.QualityParameter;
import sidata.entity.Report;
import sidata.entity.SampleElement;
import sidata.entity.SampleType;
import sidata.form.AssessmentForm;

/**
 *
 * @author syubban
 */
public class ViewReportPanel extends javax.swing.JPanel {
    
    private List<Report> reportList;
    private List<Assessment> assessmentList;
    private ReportHandler handler;
    private JDialog addDialog;
    private AssessmentForm assessmentForm;
    private List<SampleType> sampleList;
    private List<Device> testingDevice;
    private List<Device> deviceList;
    private List<SampleElement> simpleElementList;
    private List<Operator> operatorList;
    private List<QualityParameter> qp;
    JFrame topFrame;
    private String [] columnName = {"Assessment ID", "Assessment User ID", "Assessment Device ID", "Assessment Standard ID", "Assessment Sample Element ID", "Assessment Test Date", "Assessment Name", "Assessment Code"};

    List<String> typeList = new ArrayList<>();
    List<String> testingDevices = new ArrayList<>();
    List<String> devices = new ArrayList<>();
    List<String> elements = new ArrayList<>();
    List<String> operators = new ArrayList<>();
    
    private ItemCtl itemCtl;
    
    Report reporting;
    /**
     * Creates new form ViewDataMaster
     */
    public ViewReportPanel() {
//        initComponents();
        handler = new ReportHandler();
        myCustomInitComponents();
    }
    
    private void myCustomInitComponents(){
        sampleList = new ArrayList<>();
        testingDevice = new ArrayList<>();
        deviceList = new ArrayList<>();
        simpleElementList = new ArrayList<>();
        operatorList = new ArrayList<>();
        qp = new ArrayList<>();
        topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        assessmentList = new ArrayList<>();
        reportList = new ArrayList<>();
        viewReportLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        printBtn = new javax.swing.JButton();
        idReport = new javax.swing.JLabel();
        itemCtl = new ItemCtl();

        setBackground(new java.awt.Color(255, 255, 255));

        viewReportLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viewReportLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewReportLabel.setText("View Report");
        viewReportLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        viewReportLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        
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
        
        addDialog = new JDialog(topFrame, "Detail Report", true);
        reportList.addAll(this.handler.getListReport(""));
        
        for(Report report : reportList){
            assessmentList.add(new Assessment(
                report.getAssessment().getAssessmentId(),
                report.getAssessment().getUser(),
                report.getAssessment().getDevice(),
                report.getAssessment().getStandard(),
                report.getAssessment().getSampleElement(),
                report.getAssessment().getTestDate(),
                report.getAssessment().getAssmName(),
                report.getAssessment().getAssmCode()
            ));
        }

        jTable1.setModel(new FinalItemTableModel(assessmentList, columnName));
        setTableListener();
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("View Assignment");
        jButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                if (e.getClickCount() == 1) {
                     showAssignmentList();
                }
            }
        });

        printBtn.setText("Print Report");
        printBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                if (e.getClickCount() == 1) {
                    PrinterJob printerJob = PrinterJob.getPrinterJob();
                    if (printerJob.printDialog()) {
                        try {printerJob.print();}
                        catch (PrinterException exc) {
                            System.out.println(exc);
                         }
                     }   
                }
            }
        });
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(viewReportLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(printBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idReport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(viewReportLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(printBtn)
                    .addComponent(idReport))
                .addContainerGap(190, Short.MAX_VALUE))
        );
    }
    
    private void showAssignmentList() {
        List<Assignment> assignments = new ArrayList<>();
        JDialog assignmentDialog = new JDialog();
        String [] columnNames = { "Assignment ID", "Assessment ID", "Assignment Name" };
        
        assignments.addAll(this.handler.getListAssignment(Integer.valueOf(idReport.getText())));
        
        JTable assignmentTable = new JTable();
        assignmentTable.setModel(new FinalItemTableModel(assignments, columnNames));
        JScrollPane jScroll = new JScrollPane();
        jScroll.setViewportView(assignmentTable);
        
        assignmentDialog.setSize(400, 300);
        assignmentDialog.add(jScroll);
        assignmentDialog.setVisible(true);
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
                    
                    for(Report report : reportList){
                        if(report.getAssessment().getAssessmentId() == Integer.valueOf(jTable.getValueAt(row, 0).toString())){
                            reporting = new Report(report.getAssessment(), report.getQualityParameter());
                            break;
                        }
                    }
//                    addDetailModalComponent(new SampleElement(
//                        Integer.valueOf(jTable.getValueAt(row, 0).toString()),
//                        jTable.getValueAt(row, 1).toString(),
//                        jTable.getValueAt(row, 2).toString()    
//                    ));
//                    
                    idReport.setText(String.valueOf(Integer.valueOf(jTable.getValueAt(row, 0).toString())));
                    showForm();
                    
                    System.out.println(valueInCell);
                }
            }
        });
    }
    
    private void showForm() {
        System.out.println(operators.size());
        assessmentForm = new AssessmentForm(typeList, testingDevices, devices, elements, operators, qp, (assm, ids) -> {
            try {
                this.updateReport(assm, ids);
            } catch (ParseException ex) {
                Logger.getLogger(ViewReportPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }, true, reporting);
//        JPanel jpanel = new JPanel();
        JScrollPane js = new JScrollPane(assessmentForm, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.addDialog.setSize(600, 800);
        this.addDialog.add(js);
        this.addDialog.setVisible(true);
    }
    
    private void updateReport(Assessment params, List<Integer> qualityParamIndex) throws ParseException { 
        if(this.handler.updateAssessment(params, qualityParamIndex)){
            jTable1 = new javax.swing.JTable();
            jTable1.setModel(new FinalItemTableModel(assessmentList, columnName));
            setTableListener();
            jScrollPane1.setViewportView(jTable1);
            this.addDialog.setVisible(false);
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

        viewReportLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        printBtn = new javax.swing.JButton();
        idReport = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        viewReportLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viewReportLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewReportLabel.setText("View Report");
        viewReportLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        viewReportLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        jButton1.setText("View Assignment");

        printBtn.setText("Print Report");

        idReport.setText("-1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(viewReportLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(printBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idReport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(viewReportLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(printBtn)
                    .addComponent(idReport))
                .addContainerGap(190, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel idReport;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton printBtn;
    private javax.swing.JLabel viewReportLabel;
    // End of variables declaration//GEN-END:variables
}
