package Log;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class logoutAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		if (session.getAttribute("customer")!=null) {
			session.removeAttribute("customer");
			return "logout-out.jsp";
		}
		
		return "logout-error.jsp";
	}
}
