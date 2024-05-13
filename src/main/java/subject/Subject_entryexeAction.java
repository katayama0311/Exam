package subject;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class Subject_entryexeAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {
		
		HttpSession session=request.getSession(); // セッションの開始
		Teacher teacher= new Teacher();
		teacher = (Teacher)session.getAttribute("teacher");
		
		String cd = request.getParameter("cd");
		String name = request.getParameter("name");
		
		Subject subject = new Subject();
		subject.setCd(cd);
		subject.setName(name);
		subject.setSchool(teacher.getSchool());
		
		SubjectDAO dao = new SubjectDAO();
		
		if (dao.get(cd, teacher.getSchool()).getCd() == null) {
			dao.save(subject);
			return "../Subject/subject-entrycomp.jsp";
		} else {
			request.setAttribute("Onaji", -1);
			return "../Subject/subject-entry.jsp";
		}
	}
}
