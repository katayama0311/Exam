package subject;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class Subject_delexeAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {
		
		HttpSession session=request.getSession(); // セッションの開始
		Teacher teacher= new Teacher();
		teacher = (Teacher)session.getAttribute("teacher");
		
		
		Subject subject = new Subject();
		subject = (Subject)session.getAttribute("del_subject");
		session.removeAttribute("del_subject");
		subject.setSchool(teacher.getSchool());
		
		SubjectDAO dao = new SubjectDAO();
		
		dao.delete(subject);
		
		return "../Subject/subject-delcomp.jsp";
	}
}
