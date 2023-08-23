package tcm;

import java.sql.*;
import db.MyConnection;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class OtherManage extends javax.swing.JPanel {

    DefaultTableModel dft, dftsalary, dftresult, dftcertificate;
     double roundedAmount=0.00;

    /**
     * Creates new form OtherManage
     */
    public OtherManage() {
        initComponents();
        dft = new DefaultTableModel(new String[]{"payment_id", "student_id", "student_name", "course_name", "batch_id", "course_fee", "pay", "due", "status", "Last Up"}, 0);
        jTable1.setModel(dft);
        dataShowTable();
        //salary
        dftsalary = new DefaultTableModel(new String[]{"salary_id", "month", "id", "name", "salary", "pay", "due", "status", "Last update"}, 0);
        salaryTable.setModel(dftsalary);
        dataShowSalaryTable();
        teacherAndStaffIdShow();

        salaryId.setText(new AutoIdGenated().autoIdGenated("salary", "salary_id", "SL-"));

        batchIdShowOnResultTable();
        dftresult = new DefaultTableModel(new String[]{"student_id", "student_name", "course_name", "batch_id", "mark", "result"}, 0);
        resultTable.setModel(dftresult);
        dataShowResultTable();

        studentIdShowOnCertificatePage();
        dftcertificate = new DefaultTableModel(new String[]{"cirtificate_no", "student_id", "student_name", "batch_id", "date"}, 0);
        tableCertificatePage.setModel(dftcertificate);
        dataShowCertificateTable();
    }

    Connection con;
    PreparedStatement pst;

    public void dataShowTable() {
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from payment");
            ResultSet set = pst.executeQuery();
            dft.setRowCount(0);
            while (set.next()) {

                Object[] data = {set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5), set.getString(6), set.getString(7), set.getString(8), set.getString(9), set.getString(11)};
                dft.addRow(data);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void dataShowSalaryTable() {
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from salary");
            ResultSet set = pst.executeQuery();
            dftsalary.setRowCount(0);
            while (set.next()) {

                Object[] data = {set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5), set.getString(6), set.getString(7), set.getString(8), set.getString(10)};

                dftsalary.addRow(data);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void dataShowResultTable() {
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from result");
            ResultSet set = pst.executeQuery();
            dftresult.setRowCount(0);
            while (set.next()) {

                Object[] data = {set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5), set.getString(6)};

                dftresult.addRow(data);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void dataShowCertificateTable() {
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from cirtificate_issue");
            ResultSet set = pst.executeQuery();
            dftcertificate.setRowCount(0);
            while (set.next()) {

                Object[] data = {set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5)};

                dftcertificate.addRow(data);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void teacherAndStaffIdShow() {
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select staff_id,fname,lname,salary from staff "
                    + "UNION ALL select teacherid,fname,lname,salary from teacher");
            ResultSet set = pst.executeQuery();
            while (set.next()) {

                teacherAndStaffId.addItem(set.getString(1));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void batchIdShowOnResultTable() {
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from batch");
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                batchIdAttendencePage.addItem(set.getString(2));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void studentIdShowOnResultPage() {
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from students where batch_id=?");
            pst.setString(1, batchIdAttendencePage.getSelectedItem().toString());
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                studentIdAttendencePage.addItem(set.getString(2));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void studentIdShowOnCertificatePage() {
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from result");
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                studentIdCertificatePage.addItem(set.getString(1));
            }

        } catch (Exception e) {
            System.out.println(e);
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

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        paymentId = new javax.swing.JTextField();
        student_name = new javax.swing.JTextField();
        payAmount = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        paymentReceved = new javax.swing.JButton();
        paymentRefresh = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        salaryId = new javax.swing.JTextField();
        teacherOrStaffName = new javax.swing.JTextField();
        PaysalaryAmount = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        payBtnaddSalary = new javax.swing.JButton();
        courseRefresh1 = new javax.swing.JButton();
        payText = new javax.swing.JLabel();
        salaryAmount1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        teacherAndStaffId = new javax.swing.JComboBox<>();
        Month = new javax.swing.JLabel();
        salaryMonth = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        payBtnaddSalary1 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        salaryTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        batchIdAttendencePage = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        studentNameAttendencePage = new javax.swing.JTextField();
        studentIdAttendencePage = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        examMark = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        studentIdCertificatePage = new javax.swing.JComboBox<>();
        studentNameCertificatePage = new javax.swing.JTextField();
        BatchIdCertificatePage = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jDateChooserCertificatePage = new com.toedter.calendar.JDateChooser();
        certificateIssue = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableCertificatePage = new javax.swing.JTable();

        setBackground(new java.awt.Color(227, 232, 255));

        jTabbedPane2.setBackground(new java.awt.Color(227, 232, 255));
        jTabbedPane2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTabbedPane2.setName(""); // NOI18N

        jPanel2.setBackground(new java.awt.Color(227, 232, 255));

        jPanel7.setBackground(new java.awt.Color(227, 232, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment Info", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("Payment ID:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("Student Name:");

        student_name.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setText("Amount:");

        paymentReceved.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        paymentReceved.setText("Received");
        paymentReceved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentRecevedActionPerformed(evt);
            }
        });

        paymentRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        paymentRefresh.setText("REFRESH");
        paymentRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentRefreshActionPerformed(evt);
            }
        });

        jButton5.setForeground(new java.awt.Color(0, 255, 0));
        jButton5.setText("PaySlip");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(student_name, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(paymentId, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(payAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(168, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(paymentReceved)
                        .addGap(42, 42, 42)
                        .addComponent(jButton5)
                        .addGap(41, 41, 41)
                        .addComponent(paymentRefresh)
                        .addGap(124, 124, 124))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(student_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(payAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentRefresh)
                    .addComponent(jButton5)
                    .addComponent(paymentReceved))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(227, 232, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Table", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Payment", jPanel2);

        jPanel3.setBackground(new java.awt.Color(227, 232, 255));

        jPanel9.setBackground(new java.awt.Color(227, 232, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salary Info", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText("Salary ID:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setText("Teacher/Staff Name:");

        salaryId.setEditable(false);
        salaryId.setBackground(new java.awt.Color(204, 204, 255));

        teacherOrStaffName.setEditable(false);

        PaysalaryAmount.setForeground(new java.awt.Color(51, 255, 51));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setText("Salary:");

        payBtnaddSalary.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        payBtnaddSalary.setForeground(new java.awt.Color(51, 255, 51));
        payBtnaddSalary.setText("Pay");
        payBtnaddSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBtnaddSalaryActionPerformed(evt);
            }
        });

        courseRefresh1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        courseRefresh1.setText("Refresh");
        courseRefresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseRefresh1ActionPerformed(evt);
            }
        });

        payText.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        payText.setForeground(new java.awt.Color(51, 255, 51));
        payText.setText("Payable:");

        salaryAmount1.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setText("ID:");

        teacherAndStaffId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                teacherAndStaffIdItemStateChanged(evt);
            }
        });

        Month.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Month.setText("Month:");

        salaryMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        salaryMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryMonthActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Make Salary");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        payBtnaddSalary1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        payBtnaddSalary1.setText("Delete");
        payBtnaddSalary1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBtnaddSalary1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(salaryId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(teacherOrStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(Month)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(salaryMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(57, 57, 57)
                        .addComponent(payBtnaddSalary1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(payText)
                    .addComponent(payBtnaddSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(teacherAndStaffId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(salaryAmount1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PaysalaryAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(courseRefresh1))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(teacherAndStaffId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salaryId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(teacherOrStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(salaryAmount1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Month)
                                .addComponent(salaryMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(payText))
                            .addComponent(PaysalaryAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(courseRefresh1)
                    .addComponent(payBtnaddSalary)
                    .addComponent(payBtnaddSalary1))
                .addGap(27, 27, 27))
        );

        jPanel10.setBackground(new java.awt.Color(227, 232, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Table", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jScrollPane2.setBackground(new java.awt.Color(227, 232, 255));

        salaryTable.setModel(new javax.swing.table.DefaultTableModel(
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
        salaryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salaryTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(salaryTable);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Salary", jPanel3);

        jPanel4.setBackground(new java.awt.Color(227, 232, 255));

        jPanel16.setBackground(new java.awt.Color(227, 232, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Result", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N
        jPanel16.setPreferredSize(new java.awt.Dimension(728, 503));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel20.setText("Batch ID:");

        batchIdAttendencePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchIdAttendencePageActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel21.setText("Student ID:");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel22.setText("Student Name:");

        studentIdAttendencePage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                studentIdAttendencePageItemStateChanged(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel23.setText("Exam Mark:");

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Add Result");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(batchIdAttendencePage, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentNameAttendencePage, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(269, 269, 269)))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(studentIdAttendencePage, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(examMark, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(212, 212, 212))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(batchIdAttendencePage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(studentIdAttendencePage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(studentNameAttendencePage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(examMark, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addGap(20, 20, 20))
        );

        resultTable.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        resultTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(resultTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3))
                .addGap(0, 23, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Result", jPanel4);

        jPanel5.setBackground(new java.awt.Color(227, 232, 255));

        jPanel1.setBackground(new java.awt.Color(227, 232, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Certificate Issue", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 24))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Student ID:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Student Name:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Batch ID:");

        studentIdCertificatePage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                studentIdCertificatePageItemStateChanged(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Issue Date:");

        certificateIssue.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        certificateIssue.setText("Certificate Issue");
        certificateIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                certificateIssueActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Print Certificate");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BatchIdCertificatePage)
                            .addComponent(studentIdCertificatePage, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(certificateIssue)
                        .addGap(16, 16, 16)))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateChooserCertificatePage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(studentNameCertificatePage, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(studentIdCertificatePage, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentNameCertificatePage, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel11)
                        .addComponent(BatchIdCertificatePage, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooserCertificatePage, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(certificateIssue)
                    .addComponent(jButton3))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        tableCertificatePage.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tableCertificatePage);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Cirtificate", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void paymentRecevedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentRecevedActionPerformed
        // TODO add your handling code here:
        try {
            String stts = "";
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from payment where payment_id=?");
            pst.setString(1, paymentId.getText());
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                stts = set.getString(9);
            }

            if (stts.equals("Paid")) {
                JOptionPane.showMessageDialog(this, "Amount already Paid", "Success", JOptionPane.WARNING_MESSAGE);
            } else {
                pst = con.prepareStatement("update payment set pay=pay+?, due=course_fee-pay, status=if(course_fee=pay,'Paid','Unpaid') Where payment_id=?");
                pst.setString(2, paymentId.getText());
                pst.setDouble(1, Double.parseDouble(payAmount.getText()));
                int query = pst.executeUpdate();
                if (query > 0) {
                    JOptionPane.showMessageDialog(this, "Pay Successfully", "Success", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Fail", "Fail", JOptionPane.ERROR_MESSAGE);

                }
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_paymentRecevedActionPerformed

    private void paymentRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentRefreshActionPerformed
        // TODO add your handling code here:
        dataShowTable();
    }//GEN-LAST:event_paymentRefreshActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        paymentId.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString());
        student_name.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 2).toString());
        payAmount.setText("");

    }//GEN-LAST:event_jTable1MouseClicked

    private void payBtnaddSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBtnaddSalaryActionPerformed
        // TODO add your handling code here:
        if (salaryTable.getSelectedRow() != -1) {
            try {
                String stts = "";
                con = MyConnection.getConnection();
                pst = con.prepareStatement("select * from salary where salary_id=?");
                pst.setString(1, salaryId.getText());
                ResultSet set = pst.executeQuery();
                while (set.next()) {
                    stts = set.getString(8);
                }

                if (stts.equals("Paid")) {
                    JOptionPane.showMessageDialog(this, "Amount already Paid", "Success", JOptionPane.WARNING_MESSAGE);
                } else {
                    pst = con.prepareStatement("update salary set pay=pay+?, due=salary-pay, status=if(salary=pay,'Paid','Unpaid') Where salary_id=?");
                    pst.setString(2, salaryId.getText());
                    pst.setDouble(1, Double.parseDouble(PaysalaryAmount.getText()));
                    int query = pst.executeUpdate();
                    if (query > 0) {
                        JOptionPane.showMessageDialog(this, "Pay Successfully", "Success", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Fail", "Fail", JOptionPane.ERROR_MESSAGE);

                    }
                }

                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please Select Row", "Fail", JOptionPane.ERROR_MESSAGE);
        }
        dataShowSalaryTable();
        PaysalaryAmount.setText("");
    }//GEN-LAST:event_payBtnaddSalaryActionPerformed

    private void courseRefresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseRefresh1ActionPerformed
        // TODO add your handling code here:
        dataShowSalaryTable();
        salaryId.setText(new AutoIdGenated().autoIdGenated("salary", "salary_id", "SL-"));
        PaysalaryAmount.setText("");
    }//GEN-LAST:event_courseRefresh1ActionPerformed

    private void salaryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salaryTableMouseClicked
        // TODO add your handling code here:
        salaryId.setText(salaryTable.getModel().getValueAt(salaryTable.getSelectedRow(), 0).toString());
        teacherAndStaffId.setSelectedItem(salaryTable.getModel().getValueAt(salaryTable.getSelectedRow(), 2).toString());
        salaryMonth.setSelectedItem(salaryTable.getModel().getValueAt(salaryTable.getSelectedRow(), 1).toString());

    }//GEN-LAST:event_salaryTableMouseClicked

    private void teacherAndStaffIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_teacherAndStaffIdItemStateChanged
        // TODO add your handling code here:
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select staff_id,fname,lname,salary from staff where staff_id=?"
                    + "UNION ALL select teacherid,fname,lname,salary from teacher where teacherid=?");
            pst.setString(1, teacherAndStaffId.getSelectedItem().toString());
            pst.setString(2, teacherAndStaffId.getSelectedItem().toString());
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                teacherOrStaffName.setText(set.getString(2) + " " + set.getString(3));
                salaryAmount1.setText(set.getString(4));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_teacherAndStaffIdItemStateChanged

    private void studentIdAttendencePageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_studentIdAttendencePageItemStateChanged
        // TODO add your handling code here:
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from students where s_id=?");
            pst.setString(1, studentIdAttendencePage.getSelectedItem().toString());
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                studentNameAttendencePage.setText(set.getString(3) + " " + set.getString(4));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_studentIdAttendencePageItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String idMatch = new FuncExtra().selectGetData("salary", teacherAndStaffId.getSelectedItem().toString(), 3, "id");
        if (!idMatch.equals(teacherAndStaffId.getSelectedItem().toString())) {
            try {
                con = MyConnection.getConnection();
                pst = con.prepareStatement("insert into salary(salary_id, month, id, name, salary, pay, due, status)"
                        + "values(?,?,?,?,?,?,?,?)");
                pst.setString(2, salaryMonth.getSelectedItem().toString());
                pst.setString(1, salaryId.getText());
                pst.setString(3, teacherAndStaffId.getSelectedItem().toString());
                pst.setString(4, teacherOrStaffName.getText());
                pst.setDouble(5, roundedAmount);
                pst.setDouble(6, 0.00);
                pst.setDouble(7, roundedAmount);
                pst.setString(8, "Unpaid");
                int query1 = pst.executeUpdate();
                if (query1 > 0) {
                    JOptionPane.showMessageDialog(this, "Make Successfully", "Success", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Fail", "Fail", JOptionPane.ERROR_MESSAGE);

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(this, "This Id already make Salary.", "Fail", JOptionPane.ERROR_MESSAGE);
        }
        dataShowSalaryTable();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (new FuncExtra().emptyFld(examMark.getText())) {
            String corsName = "";
            String corsNameExist = "";
            String result = "";
            double mark = Double.parseDouble(examMark.getText());
            if (80 <= mark) {
                result = "A+";
            } else if (70 <= mark) {
                result = "A";
            } else if (60 <= mark) {
                result = "B";
            } else if (50 <= mark) {
                result = "C";
            } else if (40 <= mark) {
                result = "D";
            } else if (39 >= mark) {
                result = "Fail";
            }

            try {
                con = MyConnection.getConnection();
                pst = con.prepareStatement("select * from result where student_name=?");
                pst.setString(1, studentNameAttendencePage.getText());
                ResultSet setexist = pst.executeQuery();
                while (setexist.next()) {
                    corsNameExist = setexist.getString(3);
                }
                con = MyConnection.getConnection();
                pst = con.prepareStatement("select * from students where s_id=?");
                pst.setString(1, studentIdAttendencePage.getSelectedItem().toString());
                ResultSet set = pst.executeQuery();
                while (set.next()) {
                    corsName = set.getString(13);
                }
                if (corsNameExist.equals(corsName)) {
                    JOptionPane.showMessageDialog(this, "Already added", "Error", JOptionPane.WARNING_MESSAGE);
                } else {

                    con = MyConnection.getConnection();
                    pst = con.prepareStatement("insert into result (student_id, student_name, course_name, batch_id, mark, result)"
                            + "values(?,?,?,?,?,?)");

                    pst.setString(1, studentIdAttendencePage.getSelectedItem().toString());
                    pst.setString(2, studentNameAttendencePage.getText());
                    pst.setString(3, corsName);
                    pst.setString(4, batchIdAttendencePage.getSelectedItem().toString());
                    pst.setDouble(5, Double.parseDouble(examMark.getText()));
                    pst.setString(6, result);
                    int query = pst.executeUpdate();
                    if (query > 0) {
                        JOptionPane.showMessageDialog(this, "Added Successfully", "Success", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Fail", "Fail", JOptionPane.ERROR_MESSAGE);

                    }
                }
                con.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        dataShowResultTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void studentIdCertificatePageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_studentIdCertificatePageItemStateChanged
        // TODO add your handling code here:
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from result where student_id=?");
            pst.setString(1, studentIdCertificatePage.getSelectedItem().toString());
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                studentNameCertificatePage.setText(set.getString(2));
                BatchIdCertificatePage.setText(set.getString(4));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_studentIdCertificatePageItemStateChanged

    private void certificateIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_certificateIssueActionPerformed
        // TODO add your handling code here:
        if (new FuncExtra().emptyDateFld(jDateChooserCertificatePage.getDate())) {
            String idMatch = new FuncExtra().selectGetData("cirtificate_issue", studentIdCertificatePage.getSelectedItem().toString(), 2, "student_id");
            if (!idMatch.equals(studentIdCertificatePage.getSelectedItem().toString())) {
                String paidMatch = new FuncExtra().selectGetData("payment", studentIdCertificatePage.getSelectedItem().toString(), 9, "student_id");
                String MarkMatch = new FuncExtra().selectGetData("result", studentIdCertificatePage.getSelectedItem().toString(), 5, "student_id");
                if (paidMatch.equals("Paid") && 39 < Double.parseDouble(MarkMatch)) {
                    try {
                        con = MyConnection.getConnection();
                        pst = con.prepareStatement("insert into cirtificate_issue (cirtificate_no, student_id, student_name, batch_id, date)"
                                + "values(?,?,?,?,?)");
                        pst.setString(1, new AutoIdGenated().autoIdGenated("cirtificate_issue", "cirtificate_no", "CR3"));
                        pst.setString(2, studentIdCertificatePage.getSelectedItem().toString());
                        pst.setString(3, studentNameCertificatePage.getText());
                        pst.setString(4, BatchIdCertificatePage.getText());
                        pst.setDate(5, new java.sql.Date(jDateChooserCertificatePage.getDate().getTime()));

                        int query = pst.executeUpdate();
                        if (query > 0) {
                            JOptionPane.showMessageDialog(this, "Added Successfully", "Success", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "Fail", "Fail", JOptionPane.ERROR_MESSAGE);

                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "This student Fail Or payment Unpaid!", "Fail", JOptionPane.ERROR_MESSAGE);

                }
            } else {
                JOptionPane.showMessageDialog(this, "This Id already Issued.", "Fail", JOptionPane.ERROR_MESSAGE);
            }
        }
        dataShowCertificateTable();
    }//GEN-LAST:event_certificateIssueActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (tableCertificatePage.getSelectedRow() != -1) {
            new CertificatePage(tableCertificatePage.getModel().getValueAt(tableCertificatePage.getSelectedRow(), 0).toString()).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Please select row!", "Fail", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (resultTable.getSelectedRow() != -1) {
            try {
                con = MyConnection.getConnection();
                pst = con.prepareStatement("delete from result where student_id=?");
                pst.setString(1, resultTable.getModel().getValueAt(resultTable.getSelectedRow(), 0).toString());
                int query = pst.executeUpdate();

                pst = con.prepareStatement("delete from cirtificate_issue where student_id=?");
                pst.setString(1, resultTable.getModel().getValueAt(resultTable.getSelectedRow(), 0).toString());
                pst.executeUpdate();

                if (query > 0) {
                    JOptionPane.showMessageDialog(this, "Delete Successfully", "Success", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Fail", "Fail", JOptionPane.ERROR_MESSAGE);

                }
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select row!", "Fail", JOptionPane.ERROR_MESSAGE);
        }
        dataShowResultTable();
        dataShowCertificateTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void batchIdAttendencePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchIdAttendencePageActionPerformed
        // TODO add your handling code here:
        studentIdAttendencePage.removeAllItems();
        studentIdShowOnResultPage();
    }//GEN-LAST:event_batchIdAttendencePageActionPerformed

    private void payBtnaddSalary1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBtnaddSalary1ActionPerformed
        // TODO add your handling code here:
        if (salaryTable.getSelectedRow() != -1) {
            try {
                con = MyConnection.getConnection();
                pst = con.prepareStatement("delete from salary where salary_id=?");
                pst.setString(1, salaryTable.getModel().getValueAt(salaryTable.getSelectedRow(), 0).toString());
                int query = pst.executeUpdate();

                if (query > 0) {
                    JOptionPane.showMessageDialog(this, "Delete Successfully", "Success", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Fail", "Fail", JOptionPane.ERROR_MESSAGE);

                }
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select row!", "Fail", JOptionPane.ERROR_MESSAGE);
        }
        dataShowSalaryTable();
        PaysalaryAmount.setText("");
    }//GEN-LAST:event_payBtnaddSalary1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1) {
            String paidMatch = new FuncExtra().selectGetData("payment", jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 1).toString(), 9, "student_id");
            if (paidMatch.equals("Paid")) {
                new Invoice(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString()).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Payment Unpaid", "Fail", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Please select row!", "Fail", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void salaryMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryMonthActionPerformed
        // TODO add your handling code here:
        int absentDay = 0;
        try {
            int monthValue = new FuncExtra().monthToReturnValue(salaryMonth.getSelectedItem().toString());
            con = MyConnection.getConnection();
            pst = con.prepareStatement("SELECT COUNT(*) FROM teacher_attendance \n"
                    + "WHERE MONTH(date)=? AND YEAR(date)=YEAR(CURDATE()) AND attendance='Absent' AND teacher_id=?");
            pst.setString(1, String.valueOf(monthValue));
            pst.setString(2, teacherAndStaffId.getSelectedItem().toString());
            ResultSet setexist = pst.executeQuery();
            while (setexist.next()) {
                absentDay = setexist.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        double amountSalaryNet = Double.parseDouble(salaryAmount1.getText());
        double NetAmounttotal = amountSalaryNet - amountSalaryNet / 30 * new FuncExtra().deduction(absentDay);
        DecimalFormat df = new DecimalFormat("#.##");
        roundedAmount = Double.parseDouble(df.format(NetAmounttotal));
        PaysalaryAmount.setText(String.valueOf(roundedAmount));

    }//GEN-LAST:event_salaryMonthActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BatchIdCertificatePage;
    private javax.swing.JLabel Month;
    private javax.swing.JTextField PaysalaryAmount;
    private javax.swing.JComboBox<String> batchIdAttendencePage;
    private javax.swing.JButton certificateIssue;
    private javax.swing.JButton courseRefresh1;
    private javax.swing.JTextField examMark;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooserCertificatePage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField payAmount;
    private javax.swing.JButton payBtnaddSalary;
    private javax.swing.JButton payBtnaddSalary1;
    private javax.swing.JLabel payText;
    private javax.swing.JTextField paymentId;
    private javax.swing.JButton paymentReceved;
    private javax.swing.JButton paymentRefresh;
    private javax.swing.JTable resultTable;
    private javax.swing.JTextField salaryAmount1;
    private javax.swing.JTextField salaryId;
    private javax.swing.JComboBox<String> salaryMonth;
    private javax.swing.JTable salaryTable;
    private javax.swing.JComboBox<String> studentIdAttendencePage;
    private javax.swing.JComboBox<String> studentIdCertificatePage;
    private javax.swing.JTextField studentNameAttendencePage;
    private javax.swing.JTextField studentNameCertificatePage;
    private javax.swing.JTextField student_name;
    private javax.swing.JTable tableCertificatePage;
    private javax.swing.JComboBox<String> teacherAndStaffId;
    private javax.swing.JTextField teacherOrStaffName;
    // End of variables declaration//GEN-END:variables
}
