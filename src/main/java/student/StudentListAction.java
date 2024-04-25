package student;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentListAction extends Action{
	public String execute(
		HttpServletRequest req, HttpServletResponse res
	) throws Exception {
		
		HttpSession session= req.getSession();
		
		
	}
	
}