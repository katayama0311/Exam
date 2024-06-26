package student;

import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.Teacher;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentExecuteAction  extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {
		
		HttpSession session=request.getSession();
		Teacher tea = new Teacher();
		tea = (Teacher)session.getAttribute("teacher");
		
		int entYear = Integer.parseInt(request.getParameter("f1"));
		String classNum = request.getParameter("f2");
		boolean isAttend= request.getParameter("f3") != null;
		
		StudentDAO dao = new StudentDAO();
		
		List<Student> list = new ArrayList<>();
		
		if (entYear == -1 && !classNum.equals("notselect")) {
			request.setAttribute("SAKANANOera", -1);
			
		} else if (entYear == -1 && classNum.equals("notselect")) {
			list = dao.filter(tea.getSchool(), isAttend);
			
		} else if (classNum.equals("notselect")) {
			list = dao.filter(tea.getSchool(), entYear, isAttend);
			request.setAttribute("choiceYear", entYear);
			
		} else {
			list = dao.filter(tea.getSchool(), entYear, classNum, isAttend);
			request.setAttribute("choiceYear", entYear);
			request.setAttribute("choiceClass", classNum);
		}
		
		request.setAttribute("studentlist", list);
		
		request.setAttribute("choiceAttend", isAttend);
		
		return "../Student/student-list.jsp";
	}
}
