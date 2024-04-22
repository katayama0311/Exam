package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.TestListSubject;

public class TestListSubjectDAO extends DAO{
//	このSQLミスってる可能性が95%ぐらいあるんで先に謝罪しときます...
//  私の頭ではこれが限界でした...
//  あとは加藤大先生を頼ってください...
	private String baseSql = "select c.ent_year as year, a.class_num as clanum, a.student_no as stuno, c.name as name, a.subject_cd as subcd, a.no as no1, a.point as point1, b.no as no2, b.point as point2 from test as a left join test as b on a.student_no = b.student_no and a.subject_cd = b.subject_cd join student as c on a.student_no = c.no join school as d on a.school_cd = d.cd where a.no = 1 and a.no <> b.no";
	
	public List<TestListSubject> postFilter(ResultSet rSet)  throws Exception {
		List<TestListSubject> list = new ArrayList<>();
		while(rSet.next()) {
			TestListSubject listsub = new TestListSubject();
			listsub.setEntYear(rSet.getInt("ent_year"));
			listsub.setClassNum(rSet.getString("class"));
			listsub.setStudentNo(rSet.getString("no"));
			listsub.setStudentName(rSet.getString("name"));
			if (rSet.getInt("no1") == 1 || rSet.getInt("no1") == 2) {
				listsub.putPoint(rSet.getInt("no1"), rSet.getInt("point1"));
			}
			if (rSet.getInt("no2") == 2) {
				listsub.putPoint(rSet.getInt("no2"), rSet.getInt("point2"));
			}
			list.add(listsub);	
		}
		return list;
	}
	
	public List<TestListSubject> filter(int entYear, String classNum, String subject, School school) throws Exception {
		List<TestListSubject> list = new ArrayList<>();
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(baseSql + " and (c.ent_year = ? and a.class_num = ? and a.student_no = ? and a.subject_cd = ?)");
		st.setInt(1, entYear);
		st.setString(2, classNum);
		st.setString(3, subject);
		st.setString(4, school.getCd());
		ResultSet rs = st.executeQuery();
		
		list = postFilter(rs);
		st.close();
		con.close();

		return list;
	}
}
