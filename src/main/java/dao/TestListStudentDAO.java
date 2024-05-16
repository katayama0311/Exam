package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.TestListStudent;

public class TestListStudentDAO extends DAO {
	private String baseSql = "select a.name, b.subject_cd, b.no, b.point from subject as a join  test as b on a.cd =b.subject_cd";
	
	public List<TestListStudent> postFilter(ResultSet rset) throws Exception {
		List<TestListStudent> list = new ArrayList<>();
		while(rset.next()) {
			TestListStudent liststu = new TestListStudent();
			liststu.setSubjectName(rset.getString("subject_Name"));
			liststu.setSubjectCd(rset.getString("subject_Cd"));
			liststu.setNum(rset.getInt("num"));
			if(rset.getInt("num") == 1) {
				liststu.setNum(rset.getInt("num"));
				if(rset.getInt("num") == rset.getInt("no1")) {
					liststu.setPoint(rset.getInt("no1"));
				}
				
				if(rset.getInt("num") == rset.getInt("no2")) {
					liststu.setPoint(rset.getInt("no2"));
				}
			}
			liststu.setPoint(rset.getInt("point"));
			
			list.add(liststu);
		}
		
		return list;
	}
	
	public List<TestListStudent> filter(Student student) throws Exception {
		List<TestListStudent> list = new ArrayList<>();
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(baseSql);
		st.setString(1, student.getNo());
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			TestListStudent tlst=new TestListStudent();
			tlst.setSubjectName(rs.getInt())
		}
		st.close();
		con.close();
		
		return list;
	}
	
}