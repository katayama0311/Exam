package student;

import java.util.List;

import bean.Student;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentUpdateAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {
		
		HttpSession session=request.getSession();
		Teacher teacher=new Teacher();
		teacher=(Teacher)session.getAttribute("teacher");
		
		ClassNumDAO classdao=new ClassNumDAO();
		List<String> classlist=classdao.filter(teacher.getSchool());
		
		StudentDAO studentdao=new StudentDAO();
		
		String no = request.getParameter("no");
		Student stu = studentdao.get(no);
		
		session.setAttribute("classlist", classlist);
		request.setAttribute("student", stu);
		
		return "../Student/student-update.jsp";
	}
}
