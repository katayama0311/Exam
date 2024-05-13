package subject;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class Subject_updateAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {
		
			HttpSession session=request.getSession(); // セッションの開始
			Teacher teacher= new Teacher();
			teacher = (Teacher)session.getAttribute("teacher");
			
			School school=teacher.getSchool();
			SubjectDAO dao=new SubjectDAO();
			
			String cd = request.getParameter("cd");
			Subject subject = dao.get(cd, school);

			request.setAttribute("subject", subject); // 科目一覧をsubject_listという名前で保存

			return "../Subject/subject-update.jsp"; // subject-list.jspに遷移

		}
}
