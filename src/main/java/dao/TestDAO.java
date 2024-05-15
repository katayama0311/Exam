package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Test;

public class TestDAO extends DAO{
	public Test get(Student student, Subject subject, School school, int no) throws Exception {
		Connection con=getConnection();
		 PreparedStatement st=con.prepareStatement(
			 "select * from student inner join test on student.no = test.student_no inner join subject on test.subject_cd = subject.cd where student.no = ? and sbject.cd = ? and test.school_cd = ? and test.no = ?");
		 st.setString(1, student.getNo());
		 st.setString(2, subject.getCd());
		 st.setString(3, school.getCd());
		 st.setInt(4, no);
		 
		 ResultSet rs=st.executeQuery();
		 Test test = new Test();
		 
		 if (rs.next()) {
			 test.setStudent(student);
			 test.setSubject(subject);
			 test.setSchool(school);
			 test.setNo(no);
			 test.setPoint(rs.getInt("point"));
		 }
		 st.close();
		 con.close();
		 
		 return test;
	}
	
	public List<Test> postFilter(ResultSet rSet, School school) throws Exception {
		List<Test> list = new ArrayList<>();
		while(rSet.next()) {
			Test test = new Test();
			Student stu = new Student();
			test.setClassNum(rSet.getString("t.class_num"));
			test.setPoint(rSet.getInt("t.point"));
			test.setSchool(school);
			stu.setEntYear(rSet.getInt("s.ent_year"));
			stu.setNo(rSet.getString("s.no"));
			stu.setName(rSet.getString("s.name"));
			test.setStudent(stu);
			
			list.add(test);
		}
		return list;
	}
	
	public List<Test> filter(int entYear, String classNum, Subject subject, int num, School school) throws Exception {
		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
			"select s.ent_year, t.class_num, s.no, s.name, t.point from test as t inner join student as s on t.student_no = s.no and t.class_num = s.class_num and t.school_cd = s.school_cd where s.ent_year=? and t.class_num=? and t.subject_cd=? and t.no=?");
		st.setInt(1, entYear);
		st.setString(2, classNum);
		st.setString(3, subject.getCd());
		st.setInt(4, num);
		st.setString(5, school.getCd());
		
		ResultSet rs = st.executeQuery();
		
		List<Test> list = postFilter(rs, school);
		st.close();
		con.close();
		
		return list;
	}	
	
	public boolean save(Test test) throws Exception {
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
			"update test set school_cd=?, point=? where subject_cd=? and student_no=? and no=?");
		
		boolean isSave = true;
		
		st.setString(1, test.getSchool().getCd());
		st.setInt(2, test.getPoint());
		st.executeUpdate();
		st.close();
		
		con.close();
		return isSave;
	}
}

