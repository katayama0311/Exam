package subject;



import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class Subject_entryAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

//		HttpSession session=request.getSession(); // セッションの開始
//		
//		Teacher teacher= new Teacher();
//		teacher = (Teacher)session.getAttribute("teacher");
//		School school=teacher.getSchool();
		
		Subject subject = new Subject();
//		TODO:必要な情報を取得
		String cd=request.getParameter("cd");
		subject.setCd(cd);
		String name=request.getParameter("name");
		subject.setName(name);
		SubjectDAO dao=new SubjectDAO();
		if(dao.save(subject)) {
			return "../Subject/subject-entrycomp.jsp";
		}  else {
			return "../Subject/subject-entry.jsp"; // subject-entry.jspに遷移
		}
		
		

	}
}