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
		
		PreparedStatement st = con.prepareStatement("select * from student join school on student.school_cd = school.cd where no = ?");
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
			Student stu = new Student();
			stu.setEntYear(rSet.getInt("entYear"));
			stu.setNo(rSet.getString("no"));
			stu.setName(rSet.getString("name"));
			stu.setClassNum(rSet.getString("classNum"));
			stu.setAttend(rSet.getBoolean("isAttend"));
			stu.setSchool(school);
			
			list.add(stu);
		}
		return list;
	}
	
	public List<Student> filter(School school, int entYear, String classNum, boolean isAttend) throws Exception{
		List<Student> list = new ArrayList<>();
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
			"select * from student join school on student.school_cd = school.cd where school_cd = ? and ent_year = ? and class_num = ? and is_attend = ?");
		st.setString(1, school.getCd());
		st.setInt(2, entYear);
		st.setString(3, classNum);
		st.setBoolean(4, isAttend);
		
		ResultSet rs = st.executeQuery();
		
		list = postFilter(rs, school);
		st.close();
		con.close();
		
		return list;
	}
	
	public List<Student> filter(School school, int entYear, boolean isAttend) throws Exception {
		List<Student> list = new ArrayList<>();
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select * from student join school on student.school_cd = school.cd where school_cd = ? and ent_year = ? and is_attend = ?");
			st.setString(1, school.getCd());
			st.setInt(2, entYear);
			st.setBoolean(3, isAttend);
			
			ResultSet rs = st.executeQuery();
			
			list = postFilter(rs, school);
			st.close();
			con.close();
			
			return list;
	}
	
	public List<Student> filter(School school, boolean isAttend) throws Exception {
		List<Student> list = new ArrayList<>();
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select * from student join school on student.school_cd = school.cd where school_cd = ? and ent_year = ? and class_num = ? and is_attend = ?");
			st.setString(1, school.getCd());
			st.setBoolean(2, isAttend);
			
			ResultSet rs = st.executeQuery();
			
			list = postFilter(rs, school);
			st.close();
			con.close();
			
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

