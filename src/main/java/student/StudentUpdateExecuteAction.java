package student;

import bean.Student;
import bean.Teacher;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentUpdateExecuteAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {
			
		HttpSession session=request.getSession();
		Teacher tea = new Teacher();
		tea = (Teacher)session.getAttribute("teacher");
		
		int entYear = Integer.parseInt(request.getParameter("ent_year"));
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String classNum = request.getParameter("class_num");
		boolean isAttend = request.getParameter("is_attend") != null; 
		
		Student stu = new Student();
		stu.setEntYear(entYear);
		stu.setNo(no);
		stu.setName(name);
		stu.setClassNum(classNum);
		stu.setSchool(tea.getSchool());
		stu.setIsAttend(isAttend);
		
		StudentDAO dao = new StudentDAO();
		
		dao.save(stu);
		
		return "../Student/student-update-done.jsp";
	}
}
