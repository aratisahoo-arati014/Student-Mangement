package com.cglia.sms.dao.impl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cglia.sms.dao.StudentDao;
import com.cglia.sms.db.Dbutil;
import com.cglia.sms.model.Student;

public class StudentImpl implements StudentDao{

	@Override
	public Integer save(Student student) {
		final String query = "INSERT INTO STUDENT (FIRSTNAME, LASTNAME, EMAIL, MOBILE_NO, GENDER, DEPT ) values (?,?,?,?,?,?)";
		int out=0;
		try (
				Connection con = Dbutil.getConnection();
				PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);)
		{
			ps.setString(1, student.getFirstname());
			ps.setString(2, student.getLastname());
			ps.setString(3, student.getEmail());
			ps.setLong  (4, student.getMobile_no());
			ps.setString(5, student.getGender());
			ps.setString(6, student.getDept());
			out = ps.executeUpdate(); 
			if (out != 0) {
				try (ResultSet rs = ps.getGeneratedKeys()) {
					if (rs.next()) {
						Integer id = rs.getInt(1);
						System.out.println("Employee saved with id=" + id);
						return id;
					}
				}
			} 
			else {
				System.out.println("Employee save failed");
				return out;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}

	@Override
	public Student getById(Integer id) {
		final String query="FORM STUDENT WHERE ID=?";
		Student stu=null;
		try(Connection con=Dbutil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
			stmt.setInt(1, id);
			try(ResultSet rs=stmt.executeQuery()){
				if(rs.next()) {
					stu=new Student(id, query, query, query, null, query, query);
					stu.setId(rs.getInt("id"));
					stu.setFirstname(rs.getString("firstname"));
					stu.setLastname(rs.getString("lastname"));
					stu.setEmail(rs.getString("email"));
					stu.setMobile_no(rs.getLong("mobile_no"));
					stu.setGender(rs.getString("gender"));
					stu.setDept(rs.getString("dept"));
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return stu;
	}
	@Override
	public int update(Student student) {
		final String query="UPADTE STUDENT SET FIRSTNAME=?, LASTNAME=?, EMAIL=?, MOBILE_NO=?, DEPT=? WHERE ID=?";
		int count=0;
		try(Connection con=Dbutil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
			stmt.setString(1, student.getFirstname());
			stmt.setString(2, student.getLastname());
			stmt.setString(3, student.getEmail());
			stmt.setLong(4, student.getMobile_no());
			stmt.setString(5, student.getDept());
			count=stmt.executeUpdate();
			if(count!=0) {
				System.out.println("Employee with ID:"+student.getId()+"is updated ");
			}else {
				System.out.println("update failed");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteById(Integer id) {
		final String query="DELETE FROM STUDENT WHERE ID=?";
		int count=0;
		try(Connection con=Dbutil.getConnection();
				PreparedStatement stmt=con.prepareStatement(query)){
			stmt.setInt(1,id);
			count=stmt.executeUpdate();
			if(count!=0) {
				System.out.println("Employee with ID"+id+"is deleted");
			}
			else {
				System.out.println("Deleted failed");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Student> getAll() {
		final String query="SELECT * FROM STUDENT ";
		List<Student> list=new ArrayList<>();
		try(Connection con=Dbutil.getConnection();
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(query);){
			while(rs.next()) {
				Student stu=new Student(null, query, query, query, null, query, query);
				stu.setId(rs.getInt("id"));
				stu.setFirstname(rs.getString("firstname"));
				stu.setLastname(rs.getString("lastname"));
				stu.setEmail(rs.getString("email"));
				stu.setMobile_no(rs.getLong("mobile_no"));
				stu.setDept(rs.getString("dept"));

				list.add(stu);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
