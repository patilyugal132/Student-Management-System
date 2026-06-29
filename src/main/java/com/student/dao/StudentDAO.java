package com.student.dao;
import com.student.model.Student;
import com.student.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
public class StudentDAO {

    public boolean saveStudent(String name, int age) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "insert into students(name,age) values(?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, age);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "select * from students";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Student s = new Student();

                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));

                students.add(s);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return students;
    }
    public boolean deleteStudent(int id) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "delete from students where id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows =
                    ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
    public boolean updateStudent(int id,
                                 String name,
                                 int age) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "update students set name=?, age=? where id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, id);

            int rows =
                    ps.executeUpdate();

            return rows > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }
    public Student getStudentById(int id) {

        Student student = null;

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "select * from students where id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                student = new Student();

                student.setId(
                        rs.getInt("id"));

                student.setName(
                        rs.getString("name"));

                student.setAge(
                        rs.getInt("age"));
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return student;
    }
    public int getStudentCount() {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "select count(*) from students";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                count = rs.getInt(1);

            }

        } catch(Exception e) {

            e.printStackTrace();

        }

        return count;
    }
}