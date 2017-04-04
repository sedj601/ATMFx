/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseHandler;

import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author Sedrick
 */
public class DBHandler {

    final String dbResourseString = "jdbc:sqlite:ATMFx.db";

    public void createNewAccount(String firstName, String lastName, String streetAddress, String city, String state, String zip, boolean createChecking, boolean createSavings)
    {
        String sqlQuery = "INSERT INTO Person(first_name, last_name, street_address, city, state, zip) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(dbResourseString);
                PreparedStatement ps = conn.prepareStatement(sqlQuery);) {
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, streetAddress);
            ps.setString(4, city);
            ps.setString(5, state);
            ps.setString(6, zip);
            ps.execute();
        }
        catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (createChecking) {
            int lastPersonID = getLastID("Person");
            createNewAccoutNumber(lastPersonID);
            int tempAccountNumber = getLastID("Account_Numbers");

            String sqlQuery2 = "UPDATE Person SET checking_account_number = ?";
            try (Connection conn = DriverManager.getConnection(dbResourseString);
                    PreparedStatement pstmt = conn.prepareCall(sqlQuery2)) {
                pstmt.setInt(1, tempAccountNumber);
                pstmt.execute();
            }
            catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            String sqlQuery2 = "UPDATE Person SET checking_account_number = ?";
            try (Connection conn = DriverManager.getConnection(dbResourseString);
                    PreparedStatement pstmt = conn.prepareCall(sqlQuery2)) {
                pstmt.setInt(1, 0);
                pstmt.execute();
            }
            catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (createSavings) {
            int lastPersonID = getLastID("Person");
            createNewAccoutNumber(lastPersonID);
            int tempAccountNumber = getLastID("Account_Numbers");

            String sqlQuery2 = "UPDATE Person SET savings_account_number = ?";
            try (Connection conn = DriverManager.getConnection(dbResourseString);
                    PreparedStatement pstmt = conn.prepareCall(sqlQuery2)) {
                pstmt.setInt(1, tempAccountNumber);
                pstmt.execute();
            }
            catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            String sqlQuery2 = "UPDATE Person SET checking_account_number = ?";
            try (Connection conn = DriverManager.getConnection(dbResourseString);
                    PreparedStatement pstmt = conn.prepareCall(sqlQuery2)) {
                pstmt.setInt(1, 0);
                pstmt.execute();
            }
            catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void initialDepositChecking(double amount)
    {

    }

    public void initialDepositSavings(double amount)
    {

    }

    public int getLastID(String table)
    {
        int lastID = -1;

        try (Connection conn = DriverManager.getConnection(dbResourseString);
                PreparedStatement pstmt = createPreparedStatement(conn, table);
                ResultSet rs = pstmt.executeQuery();) {
            while (rs.next()) {
                lastID = rs.getInt("seq");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lastID;
    }

    private PreparedStatement createPreparedStatement(Connection con, String table) throws SQLException
    {
        String sql = "select seq from sqlite_sequence where name = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, table);
        return ps;
    }

    private void createNewAccoutNumber(int userID)
    {
        String sql = "INSERT INTO Account_Numbers (person_id) VALUES(?)";
        try (Connection conn = DriverManager.getConnection(dbResourseString);
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, userID);
        }
        catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
