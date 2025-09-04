package org.example;

import java.sql.*;
import java.util.Scanner;

public class StudentCRUDWithSearch {
    static final String URL = "jdbc:mysql://localhost:3306/student_db";
    static final String USER = "root"; // your MySQL username
    static final String PASSWORD = "HappyHomes02"; // your MySQL password

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            while (true) {
                System.out.println("\n===== Student CRUD Menu =====");
                System.out.println("1. Create Student");
                System.out.println("2. Read All Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Search Student");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        createStudent(conn, sc);
                        break;
                    case 2:
                        readStudents(conn);
                        break;
                    case 3:
                        updateStudent(conn, sc);
                        break;
                    case 4:
                        deleteStudent(conn, sc);
                        break;
                    case 5:
                        searchStudent(conn, sc);
                        break;
                    case 6:
                        conn.close();
                        sc.close();
                        System.out.println("✅ Exiting program.");
                        return;
                    default:
                        System.out.println("❌ Invalid choice. Try again.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CREATE
    public static void createStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        System.out.print("Enter Enrollment Date (YYYY-MM-DD): ");
        String enrollmentDate = sc.nextLine();

        String sql = "INSERT INTO students (name, email, age, phone, address, course, enrollment_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, email);
        pstmt.setInt(3, age);
        pstmt.setString(4, phone);
        pstmt.setString(5, address);
        pstmt.setString(6, course);
        pstmt.setDate(7, Date.valueOf(enrollmentDate));

        int rows = pstmt.executeUpdate();
        System.out.println(rows > 0 ? "✅ Student added successfully." : "❌ Failed to add student.");
        pstmt.close();
    }

    // READ
    public static void readStudents(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\nID\tName\tEmail\tAge\tPhone\tAddress\tCourse\tEnrollment Date");
        System.out.println("--------------------------------------------------------------------------------------");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("email") + "\t" +
                    rs.getInt("age") + "\t" +
                    rs.getString("phone") + "\t" +
                    rs.getString("address") + "\t" +
                    rs.getString("course") + "\t" +
                    rs.getDate("enrollment_date"));
        }
        rs.close();
        stmt.close();
    }

    // UPDATE
    public static void updateStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter New Name: ");
        String name = sc.nextLine();
        System.out.print("Enter New Email: ");
        String email = sc.nextLine();
        System.out.print("Enter New Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter New Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter New Address: ");
        String address = sc.nextLine();
        System.out.print("Enter New Course: ");
        String course = sc.nextLine();
        System.out.print("Enter New Enrollment Date (YYYY-MM-DD): ");
        String enrollmentDate = sc.nextLine();

        String sql = "UPDATE students SET name=?, email=?, age=?, phone=?, address=?, course=?, enrollment_date=? WHERE id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, email);
        pstmt.setInt(3, age);
        pstmt.setString(4, phone);
        pstmt.setString(5, address);
        pstmt.setString(6, course);
        pstmt.setDate(7, Date.valueOf(enrollmentDate));
        pstmt.setInt(8, id);

        int rows = pstmt.executeUpdate();
        System.out.println(rows > 0 ? "✅ Student updated successfully." : "❌ No student found with that ID.");
        pstmt.close();
    }

    // DELETE
    public static void deleteStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        String sql = "DELETE FROM students WHERE id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        int rows = pstmt.executeUpdate();
        System.out.println(rows > 0 ? "✅ Student deleted successfully." : "❌ No student found with that ID.");
        pstmt.close();
    }

    // SEARCH
    public static void searchStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.println("Search by: 1. ID  2. Name");
        int option = sc.nextInt();
        sc.nextLine();

        String sql;
        PreparedStatement pstmt;

        if (option == 1) {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            sql = "SELECT * FROM students WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
        } else {
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();
            sql = "SELECT * FROM students WHERE name LIKE ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + name + "%");
        }

        ResultSet rs = pstmt.executeQuery();
        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.println("\nID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Email: " + rs.getString("email"));
            System.out.println("Age: " + rs.getInt("age"));
            System.out.println("Phone: " + rs.getString("phone"));
            System.out.println("Address: " + rs.getString("address"));
            System.out.println("Course: " + rs.getString("course"));
            System.out.println("Enrollment Date: " + rs.getDate("enrollment_date"));
            System.out.println("-----------------------------------");
        }
        if (!found) {
            System.out.println("❌ No matching student found.");
        }

        rs.close();
        pstmt.close();
    }
}
