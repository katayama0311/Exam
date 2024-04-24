package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Student;

public class StudentDAO extends DAO{
	public Student get(String no) throws Exception {
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("select * from student")
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
	
}
