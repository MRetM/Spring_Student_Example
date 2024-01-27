package com.ai.jwd48.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.jwd48.model.Student;

@Component
public class StudentRepo extends DBContext {

	// Save Student Data to Database
	public int saveStudent(Student student) {

		// Get Connection
		Connection conn = getConnection();
		
		// Execute Insert Query
		int result =0;
		try {
			PreparedStatement ps = conn.prepareStatement(
"Insert Into Student (Name , Age, Address, Email, Phone_Number, Father_Name, Gender)"
							+ "VALUES (?,?,?,?,?,?,?);");

			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getEmail());
			ps.setString(5, student.getPhoneNumber());
			ps.setString(6, student.getFatherName());
			ps.setString(7, student.getGender());
//			ps.setString(8, student.getBatchName());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;

	}

	public List<Student> findAllStudent() {

		List<Student> students = new ArrayList<Student>();

		Connection conn = getConnection();
		try {
PreparedStatement ps = conn.prepareStatement("select * from student Order By Id desc");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("Id"));
				student.setName(rs.getString("Name"));
				student.setAge(rs.getInt("Age"));
				student.setAddress(rs.getString("Address"));
				student.setEmail(rs.getString("Email"));
				student.setFatherName(rs.getString("Father_Name"));
				student.setPhoneNumber(rs.getString("Phone_Number"));
				student.setGender(rs.getString("Gender"));
				//student.setBatchName(rs.getString("Batch_Name"));

				students.add(student);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return students;
	}

	public Student findStudentById(int id) {

		Student student = null;

		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from student where Id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				student = new Student();
				student.setId(rs.getInt("Id"));
				student.setName(rs.getString("Name"));
				student.setAge(rs.getInt("Age"));
				student.setAddress(rs.getString("Address"));
				student.setEmail(rs.getString("Email"));
				student.setFatherName(rs.getString("Father_Name"));
				student.setPhoneNumber(rs.getString("Phone_Number"));
				student.setGender(rs.getString("Gender"));
			//	student.setBatchName(rs.getString("Batch_Name"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return student;
	}

	public int update(Student student) {
		// Get Connection
		Connection conn = getConnection();
		// Execute Insert Query
		int result = 0;
		try {
PreparedStatement ps = conn.prepareStatement(
"Update student set Name = ? , Age = ? , Address = ? , Email = ? , Phone_Number = ? , Father_Name = ? , Gender = ? where Id = ?");
			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getEmail());
			ps.setString(5, student.getPhoneNumber());
			ps.setString(6, student.getFatherName());
			ps.setString(7, student.getGender());
			ps.setInt(8, student.getId());
			 result = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public int delete(int id) {
		// Get Connection
		Connection conn = getConnection();
		// Execute Insert Query
		int result =0;
		try {
			PreparedStatement ps = conn.prepareStatement("Delete from student  where Id = ?");

			ps.setInt(1, id);
			result = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}


}