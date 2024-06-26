package testlist;

import java.util.List;

import bean.Subject;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestListAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {
		
		HttpSession session=request.getSession();
		Teacher teacher=new Teacher();
		teacher=(Teacher)session.getAttribute("teacher");
		
		ClassNumDAO classdao=new ClassNumDAO();
		List<String> classlist=classdao.filter(teacher.getSchool());
		
		SubjectDAO subdao=new SubjectDAO();
		List<Subject> sublist=subdao.filter(teacher.getSchool());
		
		session.setAttribute("classlist", classlist);
		session.setAttribute("sublist", sublist);
		
		return "../Grades/grades-list.jsp";
	}
//	
//	public String setTestListSubject(
//			HttpServletRequest request, HttpServletResponse response
//		) throws Exception {
//		
//			HttpSession session=request.getSession();
//			Teacher teacher=new Teacher();
//			teacher=(Teacher)session.getAttribute("teacher");
//			
//			int entYear = Integer.parseInt(request.getParameter("f1"));
//			String classNum = request.getParameter("f2");
//			String subject_cd = request.getParameter("f3");
//			
//			TestDAO dao = new TestDAO();
//			Subject subject = new Subject();
//			subject.setCd(subject_cd);
//			
//			List<TestListSubject> list= dao.filter(entYear, classNum, subject, school);
//	}
//	
}