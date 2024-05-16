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

public class TestSubjectListAction extends Action {
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
		
		return "../Grades/grades-subject-list.jsp";
	}
}