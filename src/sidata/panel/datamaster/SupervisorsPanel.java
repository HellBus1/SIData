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
import sidata.entity.Device;
import sidata.entity.Operator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author syubban
 */
public class SupervisorsPanel extends javax.swing.JPanel {
    private ItemCtl itemController;
    private List<Operator> unitList;
    private List<Device> enrolledDevice;
    private List<Device> allDevice;
    private JDialog addDialog, detailDialog;
    JFrame topFrame;
    private Label lblName, lblPosition, lblMobile, lblEmail, lblInstitution, lblDescription;
    private JTextField txtName, txtDescription, txtMobile, txtEmail, txtInstitution;
    private String [] columnName = {"Supervisor ID", "Supervisor Name", "Supervisor Mobile", "Supervisor Email", "Supervisor Institution", "Supervisor Registration Number"};
    private String [] deviceColumn = {"Device ID", "Device Name", "Device Description" };
    
    private JComboBox dropPosition;
    
    /**
     * Creates new form DevicesPanel
     */
    public SupervisorsPanel() {
//        initComponents();
        myInitsComponent();
    }
    
   private void myInitsComponent() {
        txtSearch = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        addNewDevice = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        devices = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        unenrollBtn = new javax.swing.JButton();
        enrollBtn = new javax.swing.JButton();
        unenrollLbl = new javax.swing.JLabel();
        enrollLbl = new javax.swing.JLabel();

        txtSearch.setText("Search by Name");

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        addNewDevice = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        unitList = new ArrayList<>();
        allDevice = new ArrayList<>();
        devices = new javax.swing.JLabel();
        
        topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        addDialog = new JDialog(topFrame, "Add New Unit", true);
        id = new javax.swing.JLabel();
        
        itemController = new ItemCtl();
        unitList.addAll(this.itemController.getListSupervisor(""));
        
        enrolledDevice = new ArrayList<>();
        allDevice.addAll(this.itemController.getListDevice(""));

        jTable2.setModel(new FinalItemTableModel(unitList, columnName));
        jTable2.setName("tabel_supervisor");
        setTableListener(2);
        jScrollPane2.setViewportView(jTable2);

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

        devices.setText("Supervisor");

        id.setText("jLabel1");


        jTable3.setModel(new FinalItemTableModel(enrolledDevice, deviceColumn));
        jTable3.setName("table_associated");
        setTableListener(3);
        jScrollPane3.setViewportView(jTable3);

        jTable4.setModel(new FinalItemTableModel(allDevice, deviceColumn));
        jTable4.setName("table_device");
        setTableListener(4);
        jScrollPane4.setViewportView(jTable4);

        unenrollBtn.setText("Unenroll");
        unenrollBtn.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        String stringid = unenrollLbl.getText();
                        String idUser = id.getText();
//                        System.out.println("id User : " + idUser + " id Device : " + stringid);
                        if(itemController.unEnrollDevice(Integer.valueOf(idUser), Integer.valueOf(stringid))){
                            resetAssociatedTable(Integer.valueOf(idUser));
                        }

                    }
                }
            }
        );

        enrollBtn.setText("Enroll");
        enrollBtn.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        String stringid = enrollLbl.getText();
                        String idUser = id.getText();
                        int id = Integer.valueOf(stringid);
                        if(itemController.enrollDevice(Integer.valueOf(idUser), Integer.valueOf(stringid))){
                            resetAssociatedTable(Integer.valueOf(idUser));
                        }
                    }
                }
            }
        );

        unenrollLbl.setForeground(new java.awt.Color(240, 240, 240));
        unenrollLbl.setText("jLabel1");

        enrollLbl.setForeground(new java.awt.Color(240, 240, 240));
        enrollLbl.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 73, Short.MAX_VALUE)
                                .addComponent(enrollBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(unenrollLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(enrollLbl))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(unenrollBtn)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                    .addContainerGap()))
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
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(unenrollBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unenrollLbl)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(enrollLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(enrollBtn))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNewDevice)
                    .addComponent(jButton1)
                    .addComponent(id))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(153, Short.MAX_VALUE)))
        );
    }
   
    private void handleSearch() {
        String name = this.txtSearch.getText();
        resetContent(name);
    }
   
    private void setTableListener(int table) {
        switch (table) {
            case 2:
                jTable2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(final MouseEvent e) {
                        if (e.getClickCount() == 1) {
                            final JTable jTable= (JTable)e.getSource();
                            final int row = jTable.getSelectedRow();
                            final int column = jTable.getSelectedColumn();
                            final String valueInCell = (String)jTable.getValueAt(row, 0).toString();
                            
                            resetAssociatedTable(Integer.valueOf(jTable.getValueAt(row, 0).toString()));
                            
                            addDetailModalComponent(new Operator(
                                Integer.valueOf(jTable.getValueAt(row, 0).toString()),
                                jTable.getValueAt(row, 1).toString(),
                                2,
                                jTable.getValueAt(row, 2).toString(),
                                jTable.getValueAt(row, 3).toString(),
                                jTable.getValueAt(row, 4).toString(),
                                1,
                                jTable.getValueAt(row, 5).toString()
                            ));
                            
                            id.setText(String.valueOf(Integer.valueOf(jTable.getValueAt(row, 0).toString())));
                            detailDialog.setVisible(true);
                            
                            System.out.println(valueInCell);
                        }
                    }
                }); break;
            case 3:
                jTable3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(final MouseEvent e) {
                        if (e.getClickCount() == 1) {
                            final JTable jTable= (JTable)e.getSource();
                            final int row = jTable.getSelectedRow();
                            final int column = jTable.getSelectedColumn();
                            final String valueInCell = (String)jTable.getValueAt(row, 0).toString();
                            
                            unenrollLbl.setText(String.valueOf(Integer.valueOf(jTable.getValueAt(row, 0).toString())));
                            addDetailDeviceModalComponent(new Device(
                                Integer.valueOf(jTable.getValueAt(row, 0).toString()),
                                jTable.getValueAt(row, 1).toString(),
                                jTable.getValueAt(row, 2).toString()    
                            ));
                            detailDialog.setVisible(true);
                            
                            System.out.println(valueInCell);
                        }
                    }
                }); break;
            case 4:
                jTable4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(final MouseEvent e) {
                        if (e.getClickCount() == 1) {
                            final JTable jTable= (JTable)e.getSource();
                            final int row = jTable.getSelectedRow();
                            final int column = jTable.getSelectedColumn();
                            final String valueInCell = (String)jTable.getValueAt(row, 0).toString();
      
                            enrollLbl.setText(String.valueOf(Integer.valueOf(jTable.getValueAt(row, 0).toString())));
                            addDetailDeviceModalComponent(new Device(
                                Integer.valueOf(jTable.getValueAt(row, 0).toString()),
                                jTable.getValueAt(row, 1).toString(),
                                jTable.getValueAt(row, 2).toString()    
                            ));
                            detailDialog.setVisible(true);
                            
                            System.out.println(valueInCell);
                        }
                    }
                }); break;
            default:
                break;
        }
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
    
    private void resetAssociatedTable(int id){
        enrolledDevice.clear();
        enrolledDevice.addAll(this.itemController.getAssociatedDevice(id));
        
        Component[] componentList = this.getComponents();

        //Loop through the components
        for(Component c : componentList){

            //Find the components you want to remove
            if(c.getName() != null){
                if(c.getName().equals("table_associated")){
                    //Remove it
                    this.remove(c);   
                }
            }
        }

        //IMPORTANT
        this.revalidate();
        this.repaint();
        
        jTable3 = new JTable();
        jTable3.setModel(new FinalItemTableModel(enrolledDevice, columnName));
        jTable3.setName("table_associated");
        setTableListener(3);
        jScrollPane3.setViewportView(jTable3);
    }
    
    private void resetDevice() {
        allDevice.clear();
        allDevice.addAll(this.itemController.getListDevice(""));
        
        Component[] componentList = this.getComponents();

        //Loop through the components
        for(Component c : componentList){

            //Find the components you want to remove
            if(c.getName() != null){
                if(c.getName().equals("table_device")){
                    //Remove it
                    this.remove(c);   
                }
            }
        }

        //IMPORTANT
        this.revalidate();
        this.repaint();
        
        jTable4 = new JTable();
        jTable4.setModel(new FinalItemTableModel(allDevice, columnName));
        jTable4.setName("table_device");
        setTableListener(4);
        jScrollPane3.setViewportView(jTable4);
    }
    
    private void addDetailModalComponent(Operator operator) {
        JButton edit = new JButton("Edit");
        detailDialog = new JDialog(topFrame, "Detail Operator", true);
        detailDialog.setName("detail dialog");
        this.detailDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                resetDetailJDialog();
            }
        });
                
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
        
        txtMobile = new JTextField(16);
        txtMobile.setText(operator.getMobilenumber());
        
        txtEmail = new JTextField(16);
        txtEmail.setText(operator.getEmail());
        
        txtInstitution = new JTextField(16);
        txtInstitution.setText(operator.getInstitution());
        
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
        
        edit.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                       editFunc(new Operator(
                            operator.getId(),
                            txtName.getText(),
                            operator.getPosition_id(),
                            txtMobile.getText(),
                            txtEmail.getText(),
                            txtInstitution.getText(),
                            operator.getStatus(),
                            operator.getRegisnNumber()
                       )); 
                    }
                }
            }
        );
        
        panel.add(mainPanel);
        panel.add(edit);
       
        
        this.detailDialog.setSize(400, 400);
        this.detailDialog.add(panel);
    }
    
    private void editFunc(Operator unit) {
        if(this.itemController.editNewSupervisor(unit)){
            resetContent("");
            this.detailDialog.setVisible(false);
        }
    }
    
    private void addFunc() {
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
        
//        System.out.println("namae : " + name);
        if(!name.equals("") && name != null) {
            if(!position.equals("") && position != null){
                if(!mobileNum.equals("") && mobileNum != null){
                    if(!email.equals("") && email != null){
                        if(!institution.equals("") && position != null){
                            if(this.itemController.addNewSupervisor(operator)){
                                resetContent("");
                                this.addDialog.setVisible(false);
                            }
                        }else{
                            JOptionPane.showMessageDialog(topFrame, "Institution cannot be empty"); 
                        }
                    }else{
                        JOptionPane.showMessageDialog(topFrame, "Email cannot be empty"); 
                    }
                }else{
                    JOptionPane.showMessageDialog(topFrame, "Mobile Number cannot be empty"); 
                }
            }else{
                JOptionPane.showMessageDialog(topFrame, "Position cannot be empty"); 
            }
        }else{
           JOptionPane.showMessageDialog(topFrame, "Name cannot be empty"); 
        }
    }
    
    private void addModalComponent() {
        JPanel panel = new JPanel();
        JButton add = new JButton("Add Operator");

        JPanel mainPanel = new JPanel(new GridLayout(0, 2));
        String s1[] = { "2" }; 
        
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
        unitList.addAll(this.itemController.getListSupervisor(params));
        
        Component[] componentList = this.getComponents();

        //Loop through the components
        for(Component c : componentList){
            //Find the components you want to remove
            if(c.getName() == "tabel_supervisor"){
                //Remove it
                this.remove(c);
            }
        }

        //IMPORTANT
        this.revalidate();
        this.repaint();
        
        jTable2 = new javax.swing.JTable();
        jTable2.setModel(new FinalItemTableModel(unitList, columnName));
        jTable2.setName("tabel_supervisor");
        setTableListener(2);
        jScrollPane2.setViewportView(jTable2);
    }
    
    private void addDetailDeviceModalComponent(Device unit) {
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
        txtNames.setText(unit.getDeviceName());
        txtNames.setEnabled(false);
        
        txtId = new JTextField(16);
        txtId.setText(String.valueOf(unit.getDeviceId()));
        txtId.setEnabled(false);
        
        txtDescriptions = new JTextField();
        txtDescriptions.setText(unit.getDescription());
        txtDescriptions.setEnabled(false);
        
        // Plotting in panel
        mainPanel.add(lblid);
        mainPanel.add(txtId);
        mainPanel.add(lblNames);
        mainPanel.add(txtNames);
        mainPanel.add(lblDescriptions);
        mainPanel.add(txtDescriptions);

        panel.add(mainPanel);
        
        this.detailDialog.setSize(400, 400);
        this.detailDialog.add(panel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearch = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        addNewDevice = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        devices = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        unenrollBtn = new javax.swing.JButton();
        enrollBtn = new javax.swing.JButton();
        unenrollLbl = new javax.swing.JLabel();
        enrollLbl = new javax.swing.JLabel();

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

        devices.setText("Supervisor");

        id.setForeground(new java.awt.Color(240, 240, 240));
        id.setText("jLabel1");

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

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable4);

        unenrollBtn.setText("Unenroll");

        enrollBtn.setText("Enroll");

        unenrollLbl.setForeground(new java.awt.Color(240, 240, 240));

        enrollLbl.setForeground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(enrollBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(unenrollLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(enrollLbl))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(unenrollBtn)
                                .addGap(0, 59, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                    .addContainerGap()))
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
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(unenrollBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unenrollLbl)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(enrollLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(enrollBtn))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNewDevice)
                    .addComponent(jButton1)
                    .addComponent(id))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(153, Short.MAX_VALUE)))
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
    private javax.swing.JButton enrollBtn;
    private javax.swing.JLabel enrollLbl;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JButton unenrollBtn;
    private javax.swing.JLabel unenrollLbl;
    // End of variables declaration//GEN-END:variables
}
