package student;

import bean.Teacher;
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
		
		String 
	}
}
