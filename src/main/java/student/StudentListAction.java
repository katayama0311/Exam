package student;

import java.util.List;

import bean.School;
import bean.Student;
import bean.Teacher;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentListAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();
		Teacher teacher=new Teacher();
		teacher=(Teacher)session.getAttribute("teacher");
		School school=teacher.getSchool();
		StudentDAO studentdao=new StudentDAO();
		List<Student> studentlist=studentdao.filter(school);

		session.setAttribute("student_list", studentlist);
		
		return "../Student/student-list.jsp";
	}
}