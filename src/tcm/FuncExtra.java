package tcm;

import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class FuncExtra {

    Connection con;
    PreparedStatement pst;

    public boolean emailValidation(String mail) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9]+\\@[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$");
        Matcher m = p.matcher(mail);
        return m.matches();
    }

    public boolean contactValidation(String contact) {
        Pattern p = Pattern.compile("^01\\d{9}$");
        Matcher m = p.matcher(contact);
        return m.matches();
    }

    public String totalStudentCount() {
        String count = "";
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select count(s_id) from students");
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                count = set.getString(1);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return count;
    }

    public String totalBatchCount() {
        String count = "";
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select count(batchid) from batch");
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                count = set.getString(1);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return count;
    }

    public String totalIncome() {
        String count = "";
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select sum(pay) from payment");
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                count = set.getString(1);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return count;
    }

    public String totalExpense() {
        String count = "";
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select sum(pay) from salary");
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                count = set.getString(1);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return count;
    }

    public double netAmount() {
        return Double.parseDouble(new FuncExtra().totalIncome()) - Double.parseDouble(new FuncExtra().totalExpense());
    }

    public String selectGetData(String tableName, String setColumnName, int columnNumber, String whereColumnName) {
        String getData = "";
        try {
            con = MyConnection.getConnection();
            pst = con.prepareStatement("select * from " + tableName + " where " + whereColumnName + "=?");
            pst.setString(1, setColumnName);
            ResultSet set = pst.executeQuery();
            while (set.next()) {
                getData = set.getString(columnNumber);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return getData;
    }

    /**
     *
     * @param setData
     * @return
     */
    public boolean emptyFld(String setData) {

        if (setData.equals("")) {
            JOptionPane.showMessageDialog(null, "Empty Field!");
            return false;
        } else {
            return true;
        }
    }

    public boolean emptyDateFld(Date setDat) {

        if (setDat == null) {
            JOptionPane.showMessageDialog(null, "Empty Date Field!");
            return false;
        } else {
            return true;
        }
    }

    public int deduction(int daysAbsent) {

        int daysInMonth = 30; // total number of days in the month
        int deduction = 0; // initialize the deduction to 0

        for (int i = 1; i <= daysInMonth; i++) {
            if (i % 3 == 0 && daysAbsent >= i) { // check if it's a multiple of 3 and the employee was absent on that day
                deduction += 1; // increment the deduction by 1
            }
        }
        return deduction;
    }

    public int monthToReturnValue(String selectedMonth) {
        //String selectedMonth = (String) monthComboBox.getSelectedItem();
        int monthIndex = 0;

        switch (selectedMonth) {
            case "January":
                monthIndex = 1;
                break;
            case "February":
                monthIndex = 2;
                break;
            case "March":
                monthIndex = 3;
                break;
            case "April":
                monthIndex = 4;
                break;
            case "May":
                monthIndex = 5;
                break;
            case "June":
                monthIndex = 6;
                break;
            case "July":
                monthIndex = 7;
                break;
            case "August":
                monthIndex = 8;
                break;
            case "September":
                monthIndex = 9;
                break;
            case "October":
                monthIndex = 10;
                break;
            case "November":
                monthIndex = 11;
                break;
            case "December":
                monthIndex = 12;
                break;
            // Add more cases for other months here
        }
        return monthIndex;
    }

}
