package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;

public class ClassNumDAO extends DAO {
	public List<String> filter(School school) throws Exception {
		List<String> list = new ArrayList<>();
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
			"select class_num from class_num where school_cd = ?");
		st.setString(1, school.getCd());
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String str;
			str = rs.getString("class_num");
			list.add(str);
		}
		
		st.close();
		con.close();
			
		return list;
	}
	
	public List<String> search(String scd) throws Exception {
		List<String> class_num=new ArrayList<>();
		
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"select * from class_num where school_cd = ?");
		st.setString(1, scd);
		ResultSet rs=st.executeQuery();
		while (rs.next()) {
			String p=new String();
			p.setSchool_cd(rs.getString("school_cd"));
			p.setClass_num(rs.getString("class_num"));
			class_num.add(p);
		}
		
		st.close();
		con.close();
		
		return class_num;
	}
}
