package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import bean.School;
import bean.Subject;

public class SubjectDAO  extends DAO{
	public Subject get(String cd, School school) throws Exception {
		
		Connection con = getConnection();
	
		PreparedStatement st = con.prepareStatement(
			"select * from subject join school on subject.school_cd = school.cd where cd = ? and school_cd = ?");
		st.setString(1, cd);
		st.setString(2, school.getCd());
		ResultSet rs = st.executeQuery();
		
			
			Subject subject = new Subject();
			School school = new School();
			subject.setCd(cd);
			subject.setName(rs.getString("name"));
			school.setCd(rs.getString("cd"));
			school.setName(rs.getString("name"));
			subject.setSchool(school);
			
			st.close();
			con.close();
			
			return subject;	
	}
	
	public List<Subject> filter(School school) throws Exception {
		
		List<Subject> list = new ArrayList<>();
		
		Connection con = getConnection();
		
		PreparedStatement st2 = con.prepareStatement(
			"select * from subject join school on subject.school_cd = school.cd where school_cd = ?");
		
	}
}
