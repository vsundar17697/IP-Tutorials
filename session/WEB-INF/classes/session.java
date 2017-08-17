import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class session extends HttpServlet{

    public void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException,IOException{
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        Integer count;
        count = 0;
        HttpSession session = req.getSession();
        // out.println("<HTML>"); out.println("<HEAD><TITLE>session</TITLE></HEAD>");  
        // out.println("<BODY> <H2>");
        if(session.isNew()){
            out.println("Welcome for the first time! ");
            count = 1;
            session.setAttribute("count", count);
        }
        else{
            count = (Integer)(session.getAttribute("count"));
            count++;            
            out.println("Visits : " + count);
            session.setAttribute("count", count);
        }
        // out.println("output</h2></body></html>");
    }

}