package subject;

import java.util.List;

import bean.Student;
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

//		セッションからログインしている先生の情報を取得
//		先生の学校情報とcdの情報を取得
		SubjectDAO dao=new SubjectDAO();
		List<Student> list=dao.get("ここにcdを入力", "ここにschoolを入力"); // 学生一覧を取得 

		session.setAttribute("subject_list", list); // 科目一覧をsubject_listという名前で保存

		return "subject-list.jsp"; // subject-list.jspに遷移

	}
}
