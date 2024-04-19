//package dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import bean.School;
//import bean.Teacher;
//
//public class TeacherDAO extends DAO{
//	public Teacher login(String id, String password) throws Exception {
//
//		Teacher teacher = new Teacher();
//		School school = new School();
//		
//		Connection con = getConnection();
//		
//		PreparedStatement st = con.prepareStatement(
//			"select * from teacher join school on teacher.school_cd = school.cd where id = ? and password = ?");
//		st.setString(1, id);
//		st.setString(2, password);
//		ResultSet rs=st.executeQuery();
//		
//		if (rs.next()) {
//			teacher.setId(id);
//			teacher.setPassword(password);
//			teacher.setName(rs.getString("name"));
//			school.setCd(rs.getString("name"));
//			teacher.setSchool(school);
//			
//			st.close();
//			con.close();
//			
//			return teacher;
//		}
//		
//		st.close();
//		con.close();
//		
//		return teacher;
//	}
//}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.School;
import bean.Teacher;

public class TeacherDAO extends DAO{
	public Teacher login(String id, String password) throws Exception {
	
	    Teacher teacher = null;
	    Connection con = null;
	    PreparedStatement st = null;
	    ResultSet rs = null;
	
	    try {
	        con = getConnection();
	        st = con.prepareStatement("select * from teacher join school on teacher.school_cd = school.cd where id = ? and password = ?");
	        st.setString(1, id);
	        st.setString(2, password);
	        rs = st.executeQuery();
	
	        if (rs.next()) {
	            teacher = new Teacher();
	            teacher.setId(id);
	            teacher.setPassword(password);
	            teacher.setName(rs.getString("name"));
	            
	            School school = new School();
	            school.setCd(rs.getString("cd")); // 正しいカラム名を使用
	            teacher.setSchool(school);
	        }
	    } finally {
	        if (rs != null) {
	            rs.close();
	        }
	        if (st != null) {
	            st.close();
	        }
	        if (con != null) {
	            con.close();
	        }
	    }
	
	    return teacher;
	}
}

//package dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import bean.Teacher;
//
//public class TeacherDAO extends DAO {
//	public Teacher search(String id, String password)
//			throws Exception {
//			Teacher teacher=null;
//
//			Connection con=getConnection();
//
//			PreparedStatement st;
//			st=con.prepareStatement(
//					"select * from teacher where id=? and password=?");
//			st.setString(1, id);
//			st.setString(2, password);
//			ResultSet rs=st.executeQuery();
//
//			while (rs.next()) {
//				teacher=new Teacher();
//				teacher.setId(rs.getString("id"));
//				teacher.setName(rs.getString("name"));
//				teacher.setPassword(rs.getString("password"));
//				}
//
//				st.close();
//				con.close();
//				return teacher;
//		}
//}
