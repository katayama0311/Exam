package testlist;

import java.util.List;

import bean.Subject;
import bean.Teacher;
import bean.TestListSubject;
import dao.ClassNumDAO;
import dao.SubjectDAO;
import dao.TestListSubjectDAO;
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
	
	public void setTestListSubject(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {
		
			HttpSession session=request.getSession();
			Teacher teacher=new Teacher();
			teacher=(Teacher)session.getAttribute("teacher");
			
			TestListSubjectDAO testlistsubjectdao=new TestListSubjectDAO();
			List<TestListSubject> testlistsubjectlist=testlistsubjectdao.filter(0, null, null, teacher.getSchool());
			
			session.setAttribute("testlistsubjectlist", testlistsubjectlist);
			
	}
	
}