package testlist;

import bean.Teacher;
import dao.TestListSubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestListSubjectAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {
		
			HttpSession session=request.getSession();
			Teacher teacher=new Teacher();
			teacher=(Teacher)session.getAttribute("teacher");
			
			TestListSubjectDAO testlistsubjectdao=new TestListSubjectDAO();
			List<TestListSubject> testlistsubjectlist=testlistsubjectdao.filter(teacher.getSchool());
			
			session.setAttribute("testlistsubjectlist", testlistsubjectlist);
			
			return 
	}
}