package testlist;

import java.util.ArrayList;
import java.util.List;
import bean.Student;
import bean.Subject;
import bean.Test;
import dao.ClassNumDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.TestDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestListAction extends Action {
	
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		
		HttpSession session=request.getSession();
		
		int ent_year=Integer.parseInt(request.getParameter("f1"));
		String class_num=request.getParameter("f2");
		String subject_cd=request.getParameter("f3");
		int no=Integer.parseInt(request.getParameter("f4"));
		
		if(ent_year == 0 || class_num == null || subject_cd == null || no == 0) {
			request.setAttribute("none_error", "入学年度とクラスと科目と回数を選択してください");
			return "エラー画面のjsp";
		}
		
		String scd = request.getParameter("scd");
		
		TestDAO testdao=new TestDAO();
		List<Test> t=testdao.search(ent_year, class_num, subject_cd, no);
		
		StudentDAO studentdao=new StudentDAO();
		List<Student> ent=studentdao.get();
		
		List<Test> s = studentdao.get(ent_year, class_num, subject_cd,no);
		
		if (t.size() != s.size()) {
			List<Test> tas = new ArrayList<>();
			if (t.size() != 0) {
				iflabel:for(Test i:s) {
					for(Test j:t) {
						if(i.getStudent_no() == j.getStudent_no()) {
							tas.add(j);
							continue iflabel;
						}
					}
					tas.add(i);
				}
			} else {
				for(Test i:s) {
					tas.add(i);
				}
			}
			
			ClassNumDAO classdao=new ClassNumDAO();
			List<String> classnumber = classdao.search(scd);
			
			SubjectDAO subjectdao=new SubjectDAO();
			List<Subject> subject=subjectdao.(scd);
			
			session.setAttribute("classnumber", classnumber);
			session.setAttribute("ent", ent);
			session.setAttribute("subject", subject);
			session.setAttribute("no", no);
			session.setAttribute("subject_cd", subject_cd);
			session.setAttribute("ent_year", ent_year);
			session.setAttribute("class_num", class_num);
			session.setAttribute("test", tas);
			
			return "grades-mgt.jsp";
		}
	}
}
			

