package testlist;

import bean.Test;
import dao.TestDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TestListAction extends Action {
	
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		
		HttpSession session=request.getSession();
		
		String f1=request.getParameter("ent_year");
		String f2=request.getParameter("class_num");
		String f3=request.getParameter("subject_cd");
		String f4=request.getParameter("no");
		
		TestDAO dao=new TestDAO();
		Test test=dao.search(f1, f2, f3, f4);
		
		
	}
	
	
	public void setTestListSubject(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
				
	}
	
	
	public void setTestListStudent(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
					
	}
}

