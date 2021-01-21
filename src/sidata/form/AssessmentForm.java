/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidata.form;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import sidata.abstraction.FinalItemTableModel;
import sidata.controller.ReportHandler;
import sidata.entity.Assessment;
import sidata.entity.Device;
import sidata.entity.Operator;
import sidata.entity.QualityParameter;
import sidata.entity.Report;
import sidata.entity.SampleElement;
import sidata.entity.Standard;
import sidata.entity.Unit;

/**
 *
 * @author syubban
 */
public class AssessmentForm extends javax.swing.JPanel {
    private List<String> typeList = new ArrayList<>();
    private List<String> testingDevices = new ArrayList<>();
    private List<String> devices = new ArrayList<>();
    private List<String> elements = new ArrayList<>();
    private List<String> operators = new ArrayList<>();
    private List<QualityParameter> parameters = new ArrayList<>();
    private List<QualityParameter> resParameters = new ArrayList<>();
    private QualityParameter qualityParameter;
    private List<Integer> listId = new ArrayList<>();
    private String [] columnName = {"Qp ID", "Qp Standard", "Qp Unit", "Qp Parameter", "Qp Analysis Result", "Qp Testing Method", "Qp Notes", "Qp Description"};
    private AddAssessment assmFunc;
    boolean isEdit;
    private Report report;
    private ReportHandler handler = new ReportHandler();
            
     /**
     * Creates new form AssessmentForm
     * @param typeList
     * @param testingDevices
     * @param devices
     * @param elements
     * @param operators
     * @param qp
     * @param assm
     */
    public AssessmentForm(List<String> typeList, 
            List<String> testingDevices, 
            List<String> devices, 
            List<String> elements, 
            List<String> operators,
            List<QualityParameter> qp,
            AddAssessment assmFunc,
            boolean isEdit,
            Report report) {
        this.typeList = typeList;
        this.testingDevices = testingDevices;
        this.devices = devices;
        this.elements = elements;
        this.operators = operators;
        this.parameters.addAll(qp);
        this.assmFunc = assmFunc;
        this.isEdit = isEdit;
        this.report = report;
        if(isEdit){
            myCustomEditInitComponent();   
        }else{
            myCustomInitComponent();
        }
//        initComponents();
    }
    
    private void myCustomInitComponent() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        addQualityParams = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        addAssessment = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        id = new JLabel();
        idAssignment = new javax.swing.JLabel();
        
        txtCode = new javax.swing.JTextField();
        txtCode.setText("910213");
        
        
        txtLocation = new javax.swing.JTextField();
        txtLocation.setText("jalan");
        
        txtSamplingID = new javax.swing.JTextField();
        txtSamplingID.setText("123");
        
        txtRegis = new javax.swing.JTextField();
        txtRegis.setText("coba");
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

        txtDate = new javax.swing.JFormattedTextField(df);
        txtDate.setText(new Timestamp(System.currentTimeMillis()).toString());
        txtTestingDate = new javax.swing.JFormattedTextField(df);
        txtTestingDate.setText(new Timestamp(System.currentTimeMillis()).toString());
        
        jButton2.setText("jButton2");
        jLabel1.setText("Code");
        jLabel2.setText("Sample Type");
        jLabel3.setText("Date");
        jLabel4.setText("Testing Date");
        jLabel5.setText("Testing Device");
        jLabel6.setText("Device");
        jLabel7.setText("Location");
        jLabel8.setText("Sampling ID");
        jLabel9.setText("Sample Element");
        jLabel11.setText("Assignment Registration");
        jLabel12.setText("Operator");
        jLabel13.setText("Photos");

        comboSampleType = new javax.swing.JComboBox(this.typeList.toArray());
        comboDevice1 = new javax.swing.JComboBox(this.testingDevices.toArray());
        comboDevice2 = new javax.swing.JComboBox(this.devices.toArray());
        comboSample = new javax.swing.JComboBox(this.elements.toArray());
        comboOperator = new javax.swing.JComboBox(this.operators.toArray());

        jTable2.setModel(new FinalItemTableModel(this.resParameters, columnName));
        jTable2.setName("added_quality_params");
        jScrollPane2.setViewportView(jTable2);

        addQualityParams.setText("Add Quality Parameter");
        addQualityParams.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
//                        System.out.println(resParameters.size());
                        if(!resParameters.contains(qualityParameter)){
                            listId.add(qualityParameter.getQpId());
                            resParameters.add(qualityParameter);   
                        }
                        resetTable();
                    }
                }
            }
        );

        jTable3.setModel(new FinalItemTableModel(this.parameters, columnName));
        this.setTableListener();
        jScrollPane3.setViewportView(jTable3);

        addAssessment.setText("Add Assessment");
        addAssessment.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {

                        Operator user = new Operator();
                        user.setName(comboOperator.getSelectedItem().toString());
                        
                        Device device = new Device();
                        device.setDeviceName(comboDevice2.getSelectedItem().toString());
                        
                        Standard standard = new Standard();
                        standard.setStandardName(comboOperator.getSelectedItem().toString());
                        
                        SampleElement sampleElement = new SampleElement();
                        sampleElement.setSeName(comboSample.getSelectedItem().toString());
                        
                        Assessment assessment = new Assessment(
                            0,
                            user,
                            device,
                            standard,
                            sampleElement,
                            txtDate.getText(),
                            txtRegis.getText(),
                            txtCode.getText()
                        );
                        assmFunc.execute(assessment, listId, Integer.valueOf(idAssignment.getText()));
                    }
                }
            }
        );

        jLabel10.setText("Quality Parameter");

        jLabel14.setText("Associated Quality Parameter");
        
        if(handler.hasReport() != 0){
            idAssignment.setText(String.valueOf(handler.hasReport()));
        }else{
            idAssignment.setText("Assignment ID");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLocation)
                            .addComponent(txtSamplingID)
                            .addComponent(comboSampleType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboDevice1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboDevice2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboSample, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCode)
                            .addComponent(txtDate)
                            .addComponent(txtTestingDate)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRegis)
                            .addComponent(comboOperator, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(addAssessment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(id))
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addQualityParams)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idAssignment)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboSampleType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTestingDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDevice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboDevice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSamplingID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboSample, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboOperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(id))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addQualityParams)
                    .addComponent(idAssignment))
                .addGap(36, 36, 36)
                .addComponent(addAssessment, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }
    
    private void setTableListener() {
        jTable3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                if (e.getClickCount() == 1) {
                    
                    final JTable jTable= (JTable)e.getSource();
                    final int row = jTable.getSelectedRow();
                    final int column = jTable.getSelectedColumn();
                    final String valueInCell = (String)jTable.getValueAt(row, 0).toString();
                    
                    Standard standard = new Standard();
                    Unit unit = new Unit();
                    
                    String[] splittedStandard = jTable.getValueAt(row, 2).toString().split(" ");
                    StringBuilder sb1 = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    sb1.append(splittedStandard[0]);
                    sb2.append(splittedStandard[1]);
                    sb2.append(' ');
                    sb2.append(splittedStandard[2]);
                    standard.setStandardId(Integer.valueOf(jTable.getValueAt(row, 1).toString()));
                    unit.setUnitId(Integer.valueOf(sb1.toString()));
                    unit.setUnitName(sb2.toString());
                    
                    qualityParameter = new QualityParameter();
                    qualityParameter.setQpId(Integer.valueOf(jTable.getValueAt(row, 0).toString()));
                    qualityParameter.setQpStandard(standard);
                    qualityParameter.setQpUnit(unit);
                    qualityParameter.setQpParameter(jTable.getValueAt(row, 3).toString());
                    qualityParameter.setQpAnalysisResult(jTable.getValueAt(row, 4).toString());
                    qualityParameter.setQpTestingMethod(jTable.getValueAt(row, 5).toString());
                    qualityParameter.setQpNotes(jTable.getValueAt(row, 6).toString());
                    qualityParameter.setQpDescription(jTable.getValueAt(row, 7).toString());
                    
                    id.setText(String.valueOf(Integer.valueOf(jTable.getValueAt(row, 0).toString())));
                    
//                    System.out.println(valueInCell);
                }
            }
        });
    }
    
    private void resetTable() {
        Component[] componentList = this.getComponents();

        //Loop through the components
        for(Component c : componentList){

            //Find the components you want to remove
            if(c.getName() == null ? this.jTable2.getName() == null : c.getName().equals(this.jTable2.getName())){
                
                //Remove it
                this.remove(c);
            }
        }

        //IMPORTANT
        this.revalidate();
        this.repaint();
        
        jTable2.setModel(new FinalItemTableModel(this.resParameters, columnName));
        jTable2.setName("added_quality_params");
        jScrollPane2.setViewportView(jTable2);
    }
    
    public interface AddAssessment {
        public void execute(Assessment assm, List<Integer> ids, int idReport);
    }
    
    private void myCustomEditInitComponent() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        addQualityParams = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        addAssessment = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        id = new JLabel();
        idAssignment = new javax.swing.JLabel();
        
        txtCode = new javax.swing.JTextField();
        txtCode.setText(this.report.getAssessment().getAssmCode());
        
        
        txtLocation = new javax.swing.JTextField();
        txtLocation.setText("");
        
        txtSamplingID = new javax.swing.JTextField();
        txtSamplingID.setText(String.valueOf(this.report.getAssessment().getSampleElement().getSeId()));
        
        txtRegis = new javax.swing.JTextField();
        txtRegis.setText(String.valueOf(this.report.getAssessment().getUser().getRegisnNumber()));
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

        txtDate = new javax.swing.JFormattedTextField(df);
        txtDate.setText(new Timestamp(System.currentTimeMillis()).toString());
        txtTestingDate = new javax.swing.JFormattedTextField(df);
        txtTestingDate.setText(this.report.getAssessment().getTestDate());
        
        jButton2.setText("jButton2");
        jLabel1.setText("Code");
        jLabel2.setText("Sample Type");
        jLabel3.setText("Date");
        jLabel4.setText("Testing Date");
        jLabel5.setText("Testing Device");
        jLabel6.setText("Device");
        jLabel7.setText("Location");
        jLabel8.setText("Sampling ID");
        jLabel9.setText("Sample Element");
        jLabel11.setText("Assignment Registration");
        jLabel12.setText("Operator");
        jLabel13.setText("Photos");

        comboSampleType = new javax.swing.JComboBox(this.typeList.toArray());
        comboDevice1 = new javax.swing.JComboBox(this.testingDevices.toArray());
        comboDevice2 = new javax.swing.JComboBox(this.devices.toArray());
        comboSample = new javax.swing.JComboBox(this.elements.toArray());
        comboOperator = new javax.swing.JComboBox(this.operators.toArray());
        
        
        resParameters.addAll(this.report.getQualityParameter());


        jTable2.setModel(new FinalItemTableModel(this.resParameters, columnName));
        jTable2.setName("added_quality_params");
        jScrollPane2.setViewportView(jTable2);

        addQualityParams.setText("Add Quality Parameter");
        addQualityParams.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
//                        System.out.println(resParameters.size());
                        if(!resParameters.contains(qualityParameter)){
                            listId.add(qualityParameter.getQpId());
                            resParameters.add(qualityParameter);   
                        }
                        resetTable();
                    }
                }
            }
        );

        jTable3.setModel(new FinalItemTableModel(this.parameters, columnName));
        this.setTableListener();
        jScrollPane3.setViewportView(jTable3);

        addAssessment.setText("Edit Report");
        addAssessment.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {

                        Operator user = new Operator();
                        user.setName(comboOperator.getSelectedItem().toString());
                        
                        Device device = new Device();
                        device.setDeviceName(comboDevice2.getSelectedItem().toString());
                        
                        Standard standard = new Standard();
                        standard.setStandardName(comboOperator.getSelectedItem().toString());
                        
                        SampleElement sampleElement = new SampleElement();
                        sampleElement.setSeName(comboSample.getSelectedItem().toString());
                        
                        Assessment assessment = new Assessment(
                            0,
                            user,
                            device,
                            standard,
                            sampleElement,
                            txtDate.getText(),
                            txtRegis.getText(),
                            txtCode.getText()
                        );
                        assmFunc.execute(assessment, listId, Integer.valueOf(idAssignment.getText()));
                    }
                }
            }
        );

        jLabel10.setText("Quality Parameter");

        jLabel14.setText("Associated Quality Parameter");
        
        if(handler.hasReport() != 0){
            idAssignment.setText(String.valueOf(handler.hasReport()));
        }else{
            idAssignment.setText("Assignment ID");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLocation)
                            .addComponent(txtSamplingID)
                            .addComponent(comboSampleType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboDevice1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboDevice2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboSample, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCode)
                            .addComponent(txtDate)
                            .addComponent(txtTestingDate)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRegis)
                            .addComponent(comboOperator, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(addAssessment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(id))
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addQualityParams)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idAssignment)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboSampleType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTestingDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDevice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboDevice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSamplingID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboSample, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboOperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(id))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addQualityParams)
                    .addComponent(idAssignment))
                .addGap(36, 36, 36)
                .addComponent(addAssessment, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        txtSamplingID = new javax.swing.JTextField();
        txtRegis = new javax.swing.JTextField();
        comboSampleType = new javax.swing.JComboBox<>();
        comboDevice1 = new javax.swing.JComboBox<>();
        comboDevice2 = new javax.swing.JComboBox<>();
        comboSample = new javax.swing.JComboBox<>();
        comboOperator = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        addQualityParams = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        addAssessment = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        txtDate = new javax.swing.JFormattedTextField();
        txtTestingDate = new javax.swing.JFormattedTextField();
        idAssignment = new javax.swing.JLabel();

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

        jButton2.setText("jButton2");

        jLabel1.setText("Code");

        jLabel2.setText("Sample Type");

        jLabel3.setText("Date");

        jLabel4.setText("Testing Date");

        jLabel5.setText("Testing Device");

        jLabel6.setText("Device");

        jLabel7.setText("Location");

        jLabel8.setText("Sampling ID");

        jLabel9.setText("Sample Element");

        jLabel11.setText("Assignment Registration");

        jLabel12.setText("Operator");

        jLabel13.setText("Photos");

        comboSampleType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboDevice1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboDevice2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboSample.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboOperator.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        addQualityParams.setText("Add Quality Parameter");
        addQualityParams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addQualityParamsActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        addAssessment.setText("Add Assessment");

        jLabel10.setText("Quality Parameter");

        jLabel14.setText("Associated Quality Parameter");

        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("jLabel15");

        idAssignment.setText("Assignment ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLocation)
                            .addComponent(txtSamplingID)
                            .addComponent(comboSampleType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboDevice1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboDevice2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboSample, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCode)
                            .addComponent(txtDate)
                            .addComponent(txtTestingDate)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRegis)
                            .addComponent(comboOperator, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(addAssessment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(id))
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addQualityParams)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idAssignment)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboSampleType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTestingDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDevice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboDevice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSamplingID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboSample, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboOperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(id))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addQualityParams)
                    .addComponent(idAssignment))
                .addGap(36, 36, 36)
                .addComponent(addAssessment, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addQualityParamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addQualityParamsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addQualityParamsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAssessment;
    private javax.swing.JButton addQualityParams;
    private javax.swing.JComboBox<String> comboDevice1;
    private javax.swing.JComboBox<String> comboDevice2;
    private javax.swing.JComboBox<String> comboOperator;
    private javax.swing.JComboBox<String> comboSample;
    private javax.swing.JComboBox<String> comboSampleType;
    private javax.swing.JLabel id;
    private javax.swing.JLabel idAssignment;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField txtCode;
    private javax.swing.JFormattedTextField txtDate;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtRegis;
    private javax.swing.JTextField txtSamplingID;
    private javax.swing.JFormattedTextField txtTestingDate;
    // End of variables declaration//GEN-END:variables
}
