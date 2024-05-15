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
		PreparedStatement st = con.prepareStatement(
				"select * from student join school on student.school_cd = school.cd where no = ?");
		st.setString(1, no);
		ResultSet rs = st.executeQuery();
		
		Student stu =new Student();
		if (rs.next()) {
	        
	        School sch = new School();
	        stu.setEntYear(rs.getInt("ent_Year"));
	        stu.setNo(no);
	        stu.setName(rs.getString("name"));
	        stu.setClassNum(rs.getString("class_Num"));
	        stu.setIsAttend(rs.getBoolean("is_Attend"));
	        sch.setCd(rs.getString("cd"));
	        sch.setName(rs.getString("name"));
	        stu.setSchool(sch);
		}
	        
	     st.close();
	     con.close();
	        
	     return stu;
	}
	
	public List<Student> postFilter(ResultSet rSet, School school) throws Exception {
		List<Student> list = new ArrayList<>();
		while(rSet.next()) {
			Student stu = new Student();
			stu.setEntYear(rSet.getInt("ent_Year"));
			stu.setNo(rSet.getString("no"));
			stu.setName(rSet.getString("name"));
			stu.setClassNum(rSet.getString("class_Num"));
			stu.setIsAttend(rSet.getBoolean("is_Attend"));
			stu.setSchool(school);
			
			list.add(stu);
		}
		return list;
	}
	
	public List<Student> filter(School school, int entYear, String classNum, boolean isAttend) throws Exception{
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
			"select * from student where school_cd = ? and ent_year = ? and class_num = ? and is_attend = ?");
		st.setString(1, school.getCd());
		st.setInt(2, entYear);
		st.setString(3, classNum);
		st.setBoolean(4, isAttend);
		
		ResultSet rs = st.executeQuery();
		
		List<Student> list = postFilter(rs, school);
		st.close();
		con.close();
		
		return list;
	}
	
	public List<Student> filter(School school, int entYear, boolean isAttend) throws Exception {

		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select * from student where school_cd = ? and ent_year = ? and is_attend = ?");
			st.setString(1, school.getCd());
			st.setInt(2, entYear);
			st.setBoolean(3, isAttend);
			
			ResultSet rs = st.executeQuery();
			
			List<Student> list = postFilter(rs, school);
			st.close();
			con.close();
			
			return list;
	}
	
	public List<Student> filter(School school, boolean isAttend) throws Exception {
	
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
			"select * from student where school_cd = ? and ent_year = ? and class_num = ? and is_attend = ?");
		st.setString(1, school.getCd());
		st.setBoolean(2, isAttend);
		
		ResultSet rs = st.executeQuery();
		List<Student> list = postFilter(rs, school);
		st.close();
		con.close();
			
		return list;
	}
	
	public List<Student> filter(School school) throws Exception {
		
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
			"select * from student where  school_cd = ?");
		st.setString(1, school.getCd());
		
		ResultSet rs=st.executeQuery();
		List<Student> list=postFilter(rs,school);
		st.close();
		con.close();
		
		return list;
	}
	
	public boolean save(Student student) throws Exception {
			
		Connection con = getConnection();
		
		PreparedStatement check = con.prepareStatement(
			"select * from student where no = ?");
		check.setString(1, student.getNo());
		ResultSet line = check.executeQuery();
		
		boolean isSave = true;
		
		if (line.next()) {
			PreparedStatement st = con.prepareStatement(
				"update student set name=?, class_num=?, is_attend=?, school_cd=? where no = ?");
			st.setString(1, student.getName());
			st.setString(2, student.getClassNum());
			st.setBoolean(3, student.getIsAttend());
			st.setString(4, (student.getSchool()).getCd());
			st.setString(5,  student.getNo());
			st.executeUpdate();
			st.close();
			
		}
		
		else {
			PreparedStatement st = con.prepareStatement(
					"insert into student values(?, ?, ?, ?, true, ?)");

			st.setString(1, student.getNo());
			st.setString(2, student.getName());
			st.setInt(3, student.getEntYear());
			st.setString(4, student.getClassNum());
			st.setString(5, (student.getSchool()).getCd());
			st.executeUpdate();	
			st.close();

		}
		check.close();
		con.close();
		return isSave;
	 }	
	
}
