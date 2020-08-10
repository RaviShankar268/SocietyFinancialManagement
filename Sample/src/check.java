import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname=request.getParameter("name");
		String password=request.getParameter("pass");
		String f="";
		
		
		if(uname.equals("ravi") && password.equals("2698"))
		{
			f="/home.jsp";
		}
		else
			{f="/fail.jsp";}
		RequestDispatcher rd=getServletContext().getRequestDispatcher(f);
		rd.forward(request,response);
	}
}
