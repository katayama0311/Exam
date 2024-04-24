package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;

public class StudentDAO extends DAO{
	public Student get(String no) throws Exception {
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("select * from student");
				st.setString(1,no);
		ResultSet rs = st.executeQuery();
		
		
	        Student student =new Student();
	        student.setEntYear(rs.getInt("entYear"));
	        student.setNo(no);
	        student.setName(rs.getString("name"));
	        student.setClassNum(rs.getString("classNum"));
	        student.setAttend(rs.getBoolean("isAttend"));
	        
	        st.close();
	        con.close();
	        
	        return student;
	}
	
	public List<Student> postFilter(ResultSet rSet, School school) throws Exception {
		List<Student> list = new ArrayList<>();
		while(rSet.next()) {
			Student liststu = new Student();
			School sch = new School();
			liststu.setEntYear(rSet.getInt("entYear"));
			liststu.setNo(rSet.getString("no"));
			liststu.setName(rSet.getString("name"));
			liststu.setClassNum(rSet.getString("classNum"));
			liststu.setAttend(rSet.getBoolean("attend"));
			sch.setCd(rSet.getString("cd"));
			list.add(liststu);
		}
		return list;
	}
	
	public boolean save(Student student) throws Exception {
			
			Connection con = getConnection();
			
			PreparedStatement st = con.prepareStatement(
				"insert into student (ent_year, no, name, class_num values (?, ?, ?, ?))");
			st.setInt(1, student.getEntYear());
			st.setString(2, student.getNo());
			st.setString(3, student.getName());
			st.setString(4, student.getClassNum());
			
			int rowsInserted = st.executeUpdate();
			
			st.close();
			con.close();
			
			return rowsInserted > 0;
	 }	
}

