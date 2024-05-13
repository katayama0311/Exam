package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;

public class SubjectDAO  extends DAO{
	public Subject get(String cd, School school) throws Exception {
		
		Connection con = getConnection();
	
		PreparedStatement st = con.prepareStatement(
			"select * from subject join school on subject.school_cd = school.cd where subject.cd = ? and school_cd = ?");
		st.setString(1, cd);
		st.setString(2, school.getCd());
		ResultSet rs = st.executeQuery();
		
		Subject subject = new Subject();
		if (rs.next()) {
			subject.setCd(cd);
			subject.setName(rs.getString("name"));
			subject.setSchool(school);
		}
		st.close();
		con.close();
			
		return subject;	
	}
	
	public List<Subject> filter(School school) throws Exception {
		
		List<Subject> list = new ArrayList<>();
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
			"select * from subject where school_cd = ?");
		st.setString(1,school.getCd());
		ResultSet rs = st.executeQuery();
	
		while (rs.next()) {
			Subject subject = new Subject();
			subject.setCd(rs.getString("cd"));
			subject.setName(rs.getString("name"));
			list.add(subject);
		}
		
		st.close();
		con.close();
		
		return list;
	}
	
	public boolean save(Subject subject) throws Exception {
		
		Connection con = getConnection();
		
		PreparedStatement check = con.prepareStatement(
			"select * from subject where cd = ?");
		check.setString(1, subject.getCd());
		ResultSet line = check.executeQuery();
		
		boolean isSave = true;
		
		if (line.next()) {
			PreparedStatement st = con.prepareStatement(
				"update subject set school_cd=?, name=? where cd = ?");
			st.setString(1, (subject.getSchool()).getCd());
			st.setString(2, subject.getName());
			st.setString(3, subject.getCd());
			st.executeUpdate();
			st.close();
		}
		else {
			PreparedStatement st = con.prepareStatement(
				"insert into subject values (?, ?, ?)");
			st.setString(1, (subject.getSchool()).getCd());
			st.setString(2, subject.getCd());
			st.setString(3, subject.getName());
			st.executeUpdate();
			st.close();
		}
		check.close();
		con.close();
		return isSave;
	}
	
	
	public boolean delete(Subject subject) throws Exception {
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
			"delete from subject where cd = ?");
		st.setString(1, subject.getCd());
		st.executeUpdate();
		st.close();
		con.close();
		
		boolean isDelete = true;
		
		return isDelete;
	}
}
