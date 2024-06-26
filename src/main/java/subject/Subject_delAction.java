package subject;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class Subject_delAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {
		
			HttpSession session=request.getSession();
			Teacher teacher= new Teacher();
			teacher = (Teacher)session.getAttribute("teacher");
			
			School school=teacher.getSchool();
			SubjectDAO dao=new SubjectDAO();
			
			String cd = request.getParameter("cd");
			Subject subject = dao.get(cd, school);

			session.setAttribute("del_subject", subject);

			return "../Subject/subject-del.jsp";

		}
}