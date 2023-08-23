package tcm;

import java.sql.*;
import db.MyConnection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AddCourse extends javax.swing.JPanel {

    DefaultTableModel dft, dft1, dftAtten, dftTeaAtten,dftStaffAtten;

    /**
     * Creates new form AddCourse
     */
    public AddCourse() {
        initComponents();
        //Course Page
        dft = new DefaultTableModel(new String[]{"course_id", "course_name", "course_Duration", "course_fee"}, 0);
        jTable1.setModel(dft);
        //batch page
        dft1 = new DefaultTableModel(new String[]{"batchid", "courseid", "coursename", "duration", "teacherid", "teachername", "schedule", "total_class"}, 0);
        jTable2.setModel(dft1);

        dataShowOnCourseTable();
        ShowCourseIdToBatchTable();
        ShowTeacherIdToBatchTable();
        dataShowTable1();
        courseId.setText(new AutoIdGenated().autoIdGenated("course", "course_id", "CS-"));
        batchId.setText(new AutoIdGenated().autoIdGenated("batch", "batchid", "BH-"));
        //student attendence page
        dftAtten = new DefaultTableModel(new String[]{"date", "batch_id", "student_id", "student_name", "attendance"}, 0);
        tableStudentAddendence.setModel(dftAtten);
        ShowStudentDataAttendenceTable();
        batchIdShowOnStudentAttendance();

        teacherIdShowOnTeacherAttendance();
        dftTeaAtten = new DefaultTableModel(new String[]{"date", "teacher_id", "teacher_name", "attendance"}, 0);
        tableteacherAddendance.setModel(dftTeaAtten);
        showTeacherAttendance();
        
        dftStaffAtten = new DefaultTableModel(new String[]{"date", "staff_id", "staff_name", "attendance"}, 0);
        tableStaffAddendence.setModel(dftStaffAtten);
        staffIdShowOnStaffAttendance();
        showStaffAttendance();
    }
    Connection con;
    PreparedStatement pst;

    public void dataShowOnCourseTable() {
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from course");
            ResultSet set = pst.executeQuery();
            dft.setRowCount(0);
            while (set.next()) {

                Object[] data = {set.getString(2), set.getString(3), set.getString(4), set.getString(5)};

                dft.addRow(data);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void dataShowTable1() {
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from batch");
            ResultSet set = pst.executeQuery();
            dft1.setRowCount(0);
            while (set.next()) {

                Object[] data = {set.getString(2), set.getString(3), set.getString(4), set.getString(5), set.getString(6), set.getString(7), set.getString(8), set.getString(9)};

                dft1.addRow(data);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void ShowCourseIdToBatchTable() {
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from course");
            ResultSet set = pst.executeQuery();
            //dft.setRowCount(0);
            while (set.next()) {
                batchTableCourseId.addItem(set.getString(2));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void ShowTeacherIdToBatchTable() {
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from teacher");
            ResultSet set = pst.executeQuery();
            //dft.setRowCount(0);
            while (set.next()) {
                batchTableteacherId.addItem(set.getString(2));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void ShowStudentDataAttendenceTable() {
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from attendance");
            ResultSet set = pst.executeQuery();
            dftAtten.setRowCount(0);
            while (set.next()) {

                Object[] data = {set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5)};
                dftAtten.addRow(data);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void batchIdShowOnStudentAttendance() {
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

    public void studentIdShowOnStudentAttendance() {
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

    public void teacherIdShowOnTeacherAttendance() {
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from teacher");
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                TeacherIdAttendencePage.addItem(set.getString(2));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void showTeacherAttendance() {
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from teacher_attendance");
            ResultSet set = pst.executeQuery();
            dftTeaAtten.setRowCount(0);
            while (set.next()) {

                Object[] data = {set.getString(1), set.getString(2), set.getString(3), set.getString(4)};
                dftTeaAtten.addRow(data);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void staffIdShowOnStaffAttendance() {
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from staff");
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                staffIdAttendance.addItem(set.getString(2));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void showStaffAttendance() {
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from staff_attendace");
            ResultSet set = pst.executeQuery();
            dftStaffAtten.setRowCount(0);
            while (set.next()) {

                Object[] data = {set.getString(1), set.getString(2), set.getString(3), set.getString(4)};
                dftStaffAtten.addRow(data);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
     public boolean veriText() {

        if (courseId.getText().equals("") || courseName.getText().equals("")
            || CourseDuration.getText().equals("") || CourseFee.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Missing Data");
            return false;
        } else {
            return true;
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

        jRadioButton1 = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        courseId = new javax.swing.JTextField();
        CourseFee = new javax.swing.JTextField();
        courseName = new javax.swing.JTextField();
        CourseDuration = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        courseAdd = new javax.swing.JButton();
        courseUpdate = new javax.swing.JButton();
        courseDelete = new javax.swing.JButton();
        courseRefresh = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        batchDuration = new javax.swing.JTextField();
        batchTableCourseName = new javax.swing.JTextField();
        batchId = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        batchAdd = new javax.swing.JButton();
        batchUpdate = new javax.swing.JButton();
        batchDelete = new javax.swing.JButton();
        batchRefresh = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        batchTableTeacherName = new javax.swing.JTextField();
        batchTableteacherId = new javax.swing.JComboBox<>();
        batchTableCourseId = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        batchTableSchedule = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        totalClass = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        batchIdAttendencePage = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        studentNameAttendencePage = new javax.swing.JTextField();
        jDateChooserStudentAttendencePage = new com.toedter.calendar.JDateChooser();
        PresentCheckBoxstudentAttendencePage = new javax.swing.JCheckBox();
        AbsentCheckBoxstudentAttendencePage = new javax.swing.JCheckBox();
        addStudentAttendence = new javax.swing.JButton();
        studentIdAttendencePage = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableStudentAddendence = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        TeacherNameAttendencePage = new javax.swing.JTextField();
        jDateChooserTeacherAttendencePage = new com.toedter.calendar.JDateChooser();
        PresentCheckBoxTeacherAttendencePage = new javax.swing.JCheckBox();
        AbsentCheckBoxTeacherAttendencePage = new javax.swing.JCheckBox();
        AddTeacherAttendencePage = new javax.swing.JButton();
        TeacherIdAttendencePage = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableteacherAddendance = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        staffNameAttendance = new javax.swing.JTextField();
        jDateChooserStaffAttendance = new com.toedter.calendar.JDateChooser();
        presentCheckBoxStaffAttendance = new javax.swing.JCheckBox();
        absentCheckBoxStaffAttendance = new javax.swing.JCheckBox();
        jButton9 = new javax.swing.JButton();
        staffIdAttendance = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableStaffAddendence = new javax.swing.JTable();

        jRadioButton1.setText("jRadioButton1");

        setBackground(new java.awt.Color(227, 232, 255));

        jTabbedPane1.setBackground(new java.awt.Color(227, 232, 255));

        jPanel1.setBackground(new java.awt.Color(227, 232, 255));

        jPanel2.setBackground(new java.awt.Color(227, 232, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Course Info", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("Course ID:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("Course Name:");

        courseId.setBackground(new java.awt.Color(215, 215, 248));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setText("Course Duration:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel10.setText("Course Fee:");

        courseAdd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        courseAdd.setText("ADD");
        courseAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseAddActionPerformed(evt);
            }
        });

        courseUpdate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        courseUpdate.setText("UPDATE");
        courseUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseUpdateActionPerformed(evt);
            }
        });

        courseDelete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        courseDelete.setText("DELETE");
        courseDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseDeleteActionPerformed(evt);
            }
        });

        courseRefresh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        courseRefresh.setText("REFRESH");
        courseRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(380, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(courseId, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(CourseDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(courseAdd)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(courseUpdate)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(CourseFee, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(courseDelete)
                                .addGap(40, 40, 40)
                                .addComponent(courseRefresh)
                                .addGap(31, 31, 31)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(CourseDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CourseFee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseAdd)
                    .addComponent(courseUpdate)
                    .addComponent(courseRefresh)
                    .addComponent(courseDelete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 235, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Course Manage", jPanel1);

        jPanel3.setBackground(new java.awt.Color(227, 232, 255));

        jPanel9.setBackground(new java.awt.Color(227, 232, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Batch Info", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setText("Course ID:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel12.setText("Course Name:");

        batchTableCourseName.setEditable(false);
        batchTableCourseName.setBackground(new java.awt.Color(204, 204, 204));
        batchTableCourseName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        batchId.setBackground(new java.awt.Color(215, 215, 248));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel13.setText("Batch ID:");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel14.setText("Duration:");

        batchAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        batchAdd.setText("ADD");
        batchAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchAddActionPerformed(evt);
            }
        });

        batchUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        batchUpdate.setText("UPDATE");
        batchUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchUpdateActionPerformed(evt);
            }
        });

        batchDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        batchDelete.setText("DELETE");
        batchDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchDeleteActionPerformed(evt);
            }
        });

        batchRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        batchRefresh.setText("REFRESH");
        batchRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchRefreshActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel15.setText("Teacher ID:");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel16.setText("Teacher Name:");

        batchTableTeacherName.setEditable(false);
        batchTableTeacherName.setBackground(new java.awt.Color(204, 204, 204));

        batchTableteacherId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                batchTableteacherIdItemStateChanged(evt);
            }
        });

        batchTableCourseId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                batchTableCourseIdItemStateChanged(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel17.setText("Schedule:");

        batchTableSchedule.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "09:00AM-11:00AM", "11:30AM-01:30PM", "03:00PM-05:00PM" }));
        batchTableSchedule.setSelectedIndex(-1);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setText("Total Class:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(batchTableSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(batchAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(batchUpdate)))
                        .addGap(179, 179, 179)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(batchDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(batchRefresh))
                            .addComponent(totalClass, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addGap(27, 27, 27)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(batchTableteacherId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(batchId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(batchTableCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12)
                            .addComponent(jLabel1))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(batchDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(batchTableCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(batchTableTeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(batchTableCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(batchTableCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(batchId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batchDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batchTableTeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(batchTableteacherId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(batchTableSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(totalClass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batchAdd)
                    .addComponent(batchUpdate)
                    .addComponent(batchRefresh)
                    .addComponent(batchDelete))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(227, 232, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Table", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Batch Manage", jPanel3);

        jPanel11.setBackground(new java.awt.Color(227, 232, 255));

        jPanel16.setBackground(new java.awt.Color(227, 232, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student Attendance", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N
        jPanel16.setPreferredSize(new java.awt.Dimension(728, 503));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel20.setText("Batch ID:");

        batchIdAttendencePage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                batchIdAttendencePageItemStateChanged(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel21.setText("Student ID:");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel22.setText("Student Name:");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel23.setText("Date:");

        buttonGroup1.add(PresentCheckBoxstudentAttendencePage);
        PresentCheckBoxstudentAttendencePage.setText("Present");

        buttonGroup1.add(AbsentCheckBoxstudentAttendencePage);
        AbsentCheckBoxstudentAttendencePage.setText("Absent");

        addStudentAttendence.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        addStudentAttendence.setText("Add");
        addStudentAttendence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentAttendenceActionPerformed(evt);
            }
        });

        studentIdAttendencePage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                studentIdAttendencePageItemStateChanged(evt);
            }
        });

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(AbsentCheckBoxstudentAttendencePage)
                                .addGap(67, 67, 67)
                                .addComponent(PresentCheckBoxstudentAttendencePage)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(addStudentAttendence, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(batchIdAttendencePage, javax.swing.GroupLayout.Alignment.LEADING, 0, 140, Short.MAX_VALUE)
                                    .addComponent(studentNameAttendencePage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(269, 269, 269)))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooserStudentAttendencePage, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(studentIdAttendencePage, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(148, 148, 148))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(batchIdAttendencePage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(studentIdAttendencePage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(studentNameAttendencePage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooserStudentAttendencePage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AbsentCheckBoxstudentAttendencePage)
                    .addComponent(PresentCheckBoxstudentAttendencePage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addStudentAttendence)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        tableStudentAddendence.setModel(new javax.swing.table.DefaultTableModel(
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
        tableStudentAddendence.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableStudentAddendenceMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableStudentAddendence);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 728, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Student", jPanel13);

        jPanel17.setBackground(new java.awt.Color(227, 232, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Teacher Attendance", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N
        jPanel17.setPreferredSize(new java.awt.Dimension(728, 503));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel25.setText("Teacher ID:");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel26.setText("Teacher Name:");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel27.setText("Date:");

        buttonGroup1.add(PresentCheckBoxTeacherAttendencePage);
        PresentCheckBoxTeacherAttendencePage.setText("Present");

        buttonGroup1.add(AbsentCheckBoxTeacherAttendencePage);
        AbsentCheckBoxTeacherAttendencePage.setText("Absent");

        AddTeacherAttendencePage.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        AddTeacherAttendencePage.setText("Add");
        AddTeacherAttendencePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTeacherAttendencePageActionPerformed(evt);
            }
        });

        TeacherIdAttendencePage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TeacherIdAttendencePageItemStateChanged(evt);
            }
        });

        jButton2.setText("Delete");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel27))
                .addGap(22, 22, 22)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(TeacherIdAttendencePage, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TeacherNameAttendencePage, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserTeacherAttendencePage, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddTeacherAttendencePage, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(AbsentCheckBoxTeacherAttendencePage)
                                .addGap(18, 18, 18)
                                .addComponent(PresentCheckBoxTeacherAttendencePage))
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel27))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(TeacherIdAttendencePage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TeacherNameAttendencePage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooserTeacherAttendencePage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(AbsentCheckBoxTeacherAttendencePage)
                                .addComponent(PresentCheckBoxTeacherAttendencePage)))))
                .addGap(37, 37, 37)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddTeacherAttendencePage)
                    .addComponent(jButton2))
                .addGap(24, 24, 24))
        );

        tableteacherAddendance.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tableteacherAddendance);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Teacher", jPanel14);

        jPanel18.setBackground(new java.awt.Color(227, 232, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Staff Attendance", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N
        jPanel18.setPreferredSize(new java.awt.Dimension(728, 503));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel29.setText("Staff ID:");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel30.setText("Staff Name:");

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel31.setText("Date:");

        buttonGroup1.add(presentCheckBoxStaffAttendance);
        presentCheckBoxStaffAttendance.setText("Present");

        buttonGroup1.add(absentCheckBoxStaffAttendance);
        absentCheckBoxStaffAttendance.setText("Absent");

        jButton9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton9.setText("Add");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        staffIdAttendance.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                staffIdAttendanceItemStateChanged(evt);
            }
        });

        jButton3.setText("Delete");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staffIdAttendance, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooserStaffAttendance, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(absentCheckBoxStaffAttendance))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30)))
                .addGap(18, 19, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(staffNameAttendance, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(presentCheckBoxStaffAttendance)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(staffNameAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(staffIdAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31)
                    .addComponent(jDateChooserStaffAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(absentCheckBoxStaffAttendance)
                        .addComponent(presentCheckBoxStaffAttendance)))
                .addGap(44, 44, 44)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton3))
                .addGap(27, 27, 27))
        );

        tableStaffAddendence.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tableStaffAddendence);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Staff", jPanel15);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 79, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add Attendance", jPanel11);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableStudentAddendenceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStudentAddendenceMouseClicked
        // TODO add your handling code here:
        //studentIdAttendencePage.setText(tableStudentAddendence.getModel().getValueAt(tableStudentAddendence.getSelectedRow(), 0).toString());
        //studentNameAttendencePage.setText(tableStudentAddendence.getModel().getValueAt(tableStudentAddendence.getSelectedRow(), 1).toString()+" "+tableStudentAddendence.getModel().getValueAt(tableStudentAddendence.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tableStudentAddendenceMouseClicked

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

    private void addStudentAttendenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentAttendenceActionPerformed
        // TODO add your handling code here:
        if(new FuncExtra().emptyDateFld(jDateChooserStudentAttendencePage.getDate())){
            String atndn = "";
        if (PresentCheckBoxstudentAttendencePage.isSelected()) {
            atndn = "Present";
        } else if (AbsentCheckBoxstudentAttendencePage.isSelected()) {
            atndn = "Absent";
        }
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("insert into attendance (date, batch_id, student_id, student_name, attendance)"
                    + "values(?,?,?,?,?)");
            pst.setDate(1, new java.sql.Date(jDateChooserStudentAttendencePage.getDate().getTime()));
            pst.setString(2, batchIdAttendencePage.getSelectedItem().toString());
            pst.setString(3, studentIdAttendencePage.getSelectedItem().toString());
            pst.setString(4, studentNameAttendencePage.getText());
            pst.setString(5, atndn);

            int query = pst.executeUpdate();
            if (query > 0) {
                JOptionPane.showMessageDialog(this, "Added Successfully", "Success", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Fail", "Fail", JOptionPane.ERROR_MESSAGE);

            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        }
        ShowStudentDataAttendenceTable();
    }//GEN-LAST:event_addStudentAttendenceActionPerformed

    private void batchIdAttendencePageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchIdAttendencePageItemStateChanged
        // TODO add your handling code here:

        studentIdAttendencePage.removeAllItems();
        studentIdShowOnStudentAttendance();
    }//GEN-LAST:event_batchIdAttendencePageItemStateChanged

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        batchTableteacherId.setSelectedItem(jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 4).toString());
        batchId.setText(jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 0).toString());
        batchTableSchedule.setSelectedItem(jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 6).toString());
        totalClass.setText(jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 7).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void batchTableCourseIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchTableCourseIdItemStateChanged
        // TODO add your handling code here:
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from course where course_id=?");
            pst.setString(1, batchTableCourseId.getSelectedItem().toString());
            ResultSet set = pst.executeQuery();
            //dft.setRowCount(0);
            while (set.next()) {
                batchTableCourseName.setText(set.getString(3));
                batchDuration.setText(set.getString(4));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_batchTableCourseIdItemStateChanged

    private void batchTableteacherIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_batchTableteacherIdItemStateChanged
        // TODO add your handling code here:
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from teacher where teacherid=?");
            pst.setString(1, batchTableteacherId.getSelectedItem().toString());
            ResultSet set = pst.executeQuery();
            //dft.setRowCount(0);
            while (set.next()) {
                batchTableTeacherName.setText(set.getString(3) + " " + set.getString(4));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_batchTableteacherIdItemStateChanged

    private void batchRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchRefreshActionPerformed
        // TODO add your handling code here:
        dataShowTable1();
    }//GEN-LAST:event_batchRefreshActionPerformed

    private void batchDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchDeleteActionPerformed
        // TODO add your handling code here:
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("delete from batch Where batchid=?");
            pst.setString(1, batchId.getText());

            int query = pst.executeUpdate();
            if (query > 0) {
                JOptionPane.showMessageDialog(this, "Delete Successfully", "Success", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Fail", "Fail", JOptionPane.ERROR_MESSAGE);

            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_batchDeleteActionPerformed

    private void batchUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchUpdateActionPerformed
        // TODO add your handling code here:
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("update batch set teacherid=?, teachername=?, schedule=?, total_class=? where batchid=?");
            pst.setString(5, batchId.getText());

            pst.setString(1, batchTableteacherId.getSelectedItem().toString());
            pst.setString(2, batchTableTeacherName.getText());
            pst.setString(3, batchTableSchedule.getSelectedItem().toString());
            pst.setString(4, totalClass.getText());

            int query = pst.executeUpdate();
            if (query > 0) {
                JOptionPane.showMessageDialog(this, "Update Successfully", "Success", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Fail", "Fail", JOptionPane.ERROR_MESSAGE);

            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_batchUpdateActionPerformed

    private void batchAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchAddActionPerformed
        // TODO add your handling code here:
       if(new FuncExtra().emptyFld(totalClass.getText())){
            try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("insert into batch (batchid, courseid, coursename, duration, teacherid, teachername, schedule, total_class)"
                    + "values(?,?,?,?,?,?,?,?)");
            pst.setString(1, batchId.getText());
            pst.setString(2, batchTableCourseId.getSelectedItem().toString());
            pst.setString(3, batchTableCourseName.getText());
            pst.setString(4, batchDuration.getText());
            pst.setString(5, batchTableteacherId.getSelectedItem().toString());
            pst.setString(6, batchTableTeacherName.getText());
            pst.setString(7, batchTableSchedule.getSelectedItem().toString());
            pst.setString(8, totalClass.getText());

            int query = pst.executeUpdate();
            if (query > 0) {
                JOptionPane.showMessageDialog(this, "Added Successfully", "Success", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Fail", "Fail", JOptionPane.ERROR_MESSAGE);

            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
       }
    }//GEN-LAST:event_batchAddActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        courseId.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString());
        courseName.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 1).toString());
        CourseDuration.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 2).toString());
        CourseFee.setText(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 3).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void courseRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseRefreshActionPerformed
        // TODO add your handling code here:
        dataShowOnCourseTable();
    }//GEN-LAST:event_courseRefreshActionPerformed

    private void courseDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseDeleteActionPerformed
        // TODO add your handling code here:
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("delete from course Where course_id=?");
            pst.setString(1, courseId.getText());

            int query = pst.executeUpdate();
            if (query > 0) {
                JOptionPane.showMessageDialog(this, "Delete Successfully", "Success", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Fail", "Fail", JOptionPane.ERROR_MESSAGE);

            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_courseDeleteActionPerformed

    private void courseUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseUpdateActionPerformed
        // TODO add your handling code here:
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("update course set course_name=?, course_Duration=?, course_fee=? Where course_id=?");
            pst.setString(4, courseId.getText());
            pst.setString(1, courseName.getText());
            pst.setString(2, CourseDuration.getText());
            pst.setString(3, CourseFee.getText());

            int query = pst.executeUpdate();
            if (query > 0) {
                JOptionPane.showMessageDialog(this, "Update Successfully", "Success", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Fail", "Fail", JOptionPane.ERROR_MESSAGE);

            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_courseUpdateActionPerformed

    private void courseAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseAddActionPerformed
        // TODO add your handling code here:
        if(veriText()){
            try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("insert into course (course_id, course_name, course_Duration, course_fee)"
                    + "values(?,?,?,?)");
            pst.setString(1, courseId.getText());
            pst.setString(2, courseName.getText());
            pst.setString(3, CourseDuration.getText());
            pst.setDouble(4, Double.parseDouble(CourseFee.getText()));

            int query = pst.executeUpdate();
            if (query > 0) {
                JOptionPane.showMessageDialog(this, "Added Successfully", "Success", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Fail", "Fail", JOptionPane.ERROR_MESSAGE);

            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        }
    }//GEN-LAST:event_courseAddActionPerformed

    private void TeacherIdAttendencePageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TeacherIdAttendencePageItemStateChanged
        // TODO add your handling code here:
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from teacher where teacherid=?");
            pst.setString(1, TeacherIdAttendencePage.getSelectedItem().toString());
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                TeacherNameAttendencePage.setText(set.getString(3) + " " + set.getString(4));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_TeacherIdAttendencePageItemStateChanged

    private void AddTeacherAttendencePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTeacherAttendencePageActionPerformed
        // TODO add your handling code here:
        String atndn = "";
        if (PresentCheckBoxTeacherAttendencePage.isSelected()) {
            atndn = "Present";
        } else if (AbsentCheckBoxTeacherAttendencePage.isSelected()) {
            atndn = "Absent";
        }
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("insert into teacher_attendance (date, teacher_id, teacher_name, attendance)"
                    + "values(?,?,?,?)");
            pst.setDate(1, new java.sql.Date(jDateChooserTeacherAttendencePage.getDate().getTime()));
            pst.setString(2, TeacherIdAttendencePage.getSelectedItem().toString());
            pst.setString(3, TeacherNameAttendencePage.getText());
            pst.setString(4, atndn);

            int query = pst.executeUpdate();
            if (query > 0) {
                JOptionPane.showMessageDialog(this, "Added Successfully", "Success", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Fail", "Fail", JOptionPane.ERROR_MESSAGE);

            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        showTeacherAttendance();
    }//GEN-LAST:event_AddTeacherAttendencePageActionPerformed

    private void staffIdAttendanceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_staffIdAttendanceItemStateChanged
        // TODO add your handling code here:
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from staff where staff_id=?");
            pst.setString(1, staffIdAttendance.getSelectedItem().toString());
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                staffNameAttendance.setText(set.getString(3) + " " + set.getString(4));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_staffIdAttendanceItemStateChanged

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        String atndn = "";
        if (presentCheckBoxStaffAttendance.isSelected()) {
            atndn = "Present";
        } else if (absentCheckBoxStaffAttendance.isSelected()) {
            atndn = "Absent";
        }
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("insert into staff_attendace (date, staff_id, staff_name, attendance)"
                    + "values(?,?,?,?)");
            pst.setDate(1, new java.sql.Date(jDateChooserStaffAttendance.getDate().getTime()));
            pst.setString(2, staffIdAttendance.getSelectedItem().toString());
            pst.setString(3, staffNameAttendance.getText());
            pst.setString(4, atndn);

            int query = pst.executeUpdate();
            if (query > 0) {
                JOptionPane.showMessageDialog(this, "Added Successfully", "Success", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Fail", "Fail", JOptionPane.ERROR_MESSAGE);

            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        showStaffAttendance();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        if (tableStudentAddendence.getSelectedRow() != -1) {
//            try {
//                con = MyConnection.getConnection();
//                pst = con.prepareStatement("delete from attendance where student_id=?");
//                pst.setString(1, resultTable.getModel().getValueAt(resultTable.getSelectedRow(), 0).toString());
//                int query = pst.executeUpdate();
//
//                pst = con.prepareStatement("delete from cirtificate_issue where student_id=?");
//                pst.setString(1, resultTable.getModel().getValueAt(resultTable.getSelectedRow(), 0).toString());
//                pst.executeUpdate();
//
//                if (query >0) {
//                    JOptionPane.showMessageDialog(this, "Delete Successfully", "Success", JOptionPane.WARNING_MESSAGE);
//                } else {
//                    JOptionPane.showMessageDialog(this, "Fail", "Fail", JOptionPane.ERROR_MESSAGE);
//
//                }
//            } catch (Exception e) {
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Please select row!", "Fail", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox AbsentCheckBoxTeacherAttendencePage;
    private javax.swing.JCheckBox AbsentCheckBoxstudentAttendencePage;
    private javax.swing.JButton AddTeacherAttendencePage;
    private javax.swing.JTextField CourseDuration;
    private javax.swing.JTextField CourseFee;
    private javax.swing.JCheckBox PresentCheckBoxTeacherAttendencePage;
    private javax.swing.JCheckBox PresentCheckBoxstudentAttendencePage;
    private javax.swing.JComboBox<String> TeacherIdAttendencePage;
    private javax.swing.JTextField TeacherNameAttendencePage;
    private javax.swing.JCheckBox absentCheckBoxStaffAttendance;
    private javax.swing.JButton addStudentAttendence;
    private javax.swing.JButton batchAdd;
    private javax.swing.JButton batchDelete;
    private javax.swing.JTextField batchDuration;
    private javax.swing.JTextField batchId;
    private javax.swing.JComboBox<String> batchIdAttendencePage;
    private javax.swing.JButton batchRefresh;
    private javax.swing.JComboBox<String> batchTableCourseId;
    private javax.swing.JTextField batchTableCourseName;
    private javax.swing.JComboBox<String> batchTableSchedule;
    private javax.swing.JTextField batchTableTeacherName;
    private javax.swing.JComboBox<String> batchTableteacherId;
    private javax.swing.JButton batchUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton courseAdd;
    private javax.swing.JButton courseDelete;
    private javax.swing.JTextField courseId;
    private javax.swing.JTextField courseName;
    private javax.swing.JButton courseRefresh;
    private javax.swing.JButton courseUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooserStaffAttendance;
    private com.toedter.calendar.JDateChooser jDateChooserStudentAttendencePage;
    private com.toedter.calendar.JDateChooser jDateChooserTeacherAttendencePage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JCheckBox presentCheckBoxStaffAttendance;
    private javax.swing.JComboBox<String> staffIdAttendance;
    private javax.swing.JTextField staffNameAttendance;
    private javax.swing.JComboBox<String> studentIdAttendencePage;
    private javax.swing.JTextField studentNameAttendencePage;
    private javax.swing.JTable tableStaffAddendence;
    private javax.swing.JTable tableStudentAddendence;
    private javax.swing.JTable tableteacherAddendance;
    private javax.swing.JTextField totalClass;
    // End of variables declaration//GEN-END:variables
}
