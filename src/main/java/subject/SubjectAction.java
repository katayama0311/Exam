package subject;

import java.util.List;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession(); // セッションの開始
		Teacher teacher= new Teacher();
		teacher = (Teacher)session.getAttribute("teacher");
		
		School school=teacher.getSchool();
		SubjectDAO dao=new SubjectDAO();
		List<Subject> list=dao.filter(school);  

		session.setAttribute("subject_list", list); // 科目一覧をsubject_listという名前で保存

		return "../Subject/subject-list.jsp"; // subject-list.jspに遷移

	}
}

