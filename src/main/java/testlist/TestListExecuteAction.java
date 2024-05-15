package testlist;

import java.util.List;

import bean.Subject;
import bean.Teacher;
import bean.Test;
import dao.TestDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestListExecuteAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {
		
		HttpSession session=request.getSession();
		Teacher teacher=new Teacher();
		teacher=(Teacher)session.getAttribute("teacher");
		
		int entYear = Integer.parseInt(request.getParameter("f1"));
		String classNum = request.getParameter("f2");
		String subject_cd = request.getParameter("f3");
		int num = Integer.parseInt(request.getParameter("f4"));
		
		TestDAO dao = new TestDAO();
		Subject subject = new Subject();
		subject.setCd(subject_cd);
		
		List<Test> list= dao.filter(entYear, classNum, subject, num, teacher.getSchool());
		
	}
}