package subject;

import bean.School;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class Subject_delAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
	String cd = request.getAttribute("cd").toString();
	
	HttpSession session = request.getSession();
	School school = request.getAttribute("school");
	
	return "subject-del.jsp";
//
//	Subject subject = null;
//	
//	String subjectCd = "../Subject/subjec.cd";
//	subject.setCd(subjectCd);
//	SubjectDAO dao=new SubjectDAO();
//	dao.delete(subject);  
//
//	if(dao.delete(subject)) {
//		return "../Subject/subject-entrycomp.jsp";
//	}  else {
//		return "../Subject/subject-entry.jsp"; // subject-entry.jspに遷移
//	}
//
//	}

	}
}
       