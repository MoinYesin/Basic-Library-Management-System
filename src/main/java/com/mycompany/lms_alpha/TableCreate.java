/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lms_alpha;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author moiny
 */
public class TableCreate {

    Connection conn = JavaConnect.ConnectDb();

    public void ensureAccountTableExists() {
        String createTableSQL = """
        CREATE TABLE IF NOT EXISTS account (
            
            Username VARCHAR(255) NOT NULL UNIQUE PRIMARY KEY,
            Name VARCHAR(255) NOT NULL,
            Password VARCHAR(255) NOT NULL,
            SecQ VARCHAR(255) NOT NULL,
            Answer VARCHAR(255) NOT NULL
        )
    """;

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Account table verified or created successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ensuring account table exists: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void ensureBooksTableExists() {
        String createBooksTableSQL = """
                                     CREATE TABLE IF NOT EXISTS books (
                                     
                                        BookID INT AUTO_INCREMENT PRIMARY KEY,
                                        Name VARCHAR(255) NOT NULL,
                                        Author VARCHAR(255) NOT NULL,
                                        Edition VARCHAR(50),
                                        Publisher VARCHAR(255),
                                        Price DECIMAL(10, 2),
                                        Quantity INT
                                     );
                                     """;
        
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createBooksTableSQL);
            System.out.println("Books table verified or created successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ensuring books table exists: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void ensureStudentsTableExists(){
        String createStudentsTableSQL = """
                                     CREATE TABLE IF NOT EXISTS students(
                                     StudentCode INT AUTO_INCREMENT PRIMARY KEY,
                                     Name VARCHAR(255) NOT NULL,
                                     FathersName VARCHAR(255) NOT NULL,
                                     Department VARCHAR(50) NOT NULL,
                                     Year INT NOT NULL,
                                     Semester VARCHAR(50) NOT NULL,
                                     PhoneNo VARCHAR(50)
                                     );
                                     """;
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createStudentsTableSQL);
            System.out.println("Students table verified or created successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ensuring Students table exists: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void ensureIssueTableExists() {
        String createIssueTableSQL = """
                                     CREATE TABLE IF NOT EXISTS issue (
                                        
                                        IssueID INT AUTO_INCREMENT PRIMARY KEY,
                                        BookID INT,
                                        Name VARCHAR(255) NOT NULL,
                                        Author VARCHAR(255) NOT NULL,
                                        Edition VARCHAR(50),
                                        Publisher VARCHAR(255),
                                        Price DECIMAL(10, 2),
                                        Quantity INT,
                                        StudentCode INT,
                                        SName VARCHAR(255) NOT NULL,
                                        Department VARCHAR(50),
                                        Semester VARCHAR(50),
                                        PhoneNo VARCHAR(50),
                                        Time VARCHAR(50)
                                     );
                                     """;
        
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createIssueTableSQL);
            System.out.println("Issue table verified or created successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ensuring Issue table exists: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void ensureIssueHistoryTableExists() {
        String createIssueTableSQL = """
                                     CREATE TABLE IF NOT EXISTS issueHistory (
                                        
                                        IssueID INT AUTO_INCREMENT PRIMARY KEY,
                                        BookID INT,
                                        Name VARCHAR(255) NOT NULL,
                                        Author VARCHAR(255) NOT NULL,
                                        Edition VARCHAR(50),
                                        Publisher VARCHAR(255),
                                        Price DECIMAL(10, 2),
                                        Quantity INT,
                                        StudentCode INT,
                                        SName VARCHAR(255) NOT NULL,
                                        Department VARCHAR(50),
                                        Semester VARCHAR(50),
                                        PhoneNo VARCHAR(50),
                                        Time VARCHAR(50),
                                        ReturnTime VARCHAR(50)
                                     );
                                     """;
        
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createIssueTableSQL);
            System.out.println("Issue History table verified or created successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ensuring Issue table exists: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
