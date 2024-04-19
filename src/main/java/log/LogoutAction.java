package log;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class LogoutAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		if (session.getAttribute("teacher")!=null) {
			session.removeAttribute("teacher");
			return "../Log/logout-out.jsp";
		}
		
		return "../Log/logout-error.jsp";
	}
}
