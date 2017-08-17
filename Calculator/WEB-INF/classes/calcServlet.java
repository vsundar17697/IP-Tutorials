import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class calcServlet extends HttpServlet{
    public void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        int x = Integer.parseInt(req.getParameter("valueX"));
        int y = Integer.parseInt(req.getParameter("valueY"));
        String operation = req.getParameter("op");
        out.println("<HTML>"); out.println("<HEAD><TITLE>Calculator</TITLE></HEAD>");  
        out.println("<BODY> <H2>");
        int ans = 0;
        switch(operation){
            case "+":
                ans = x + y;
                break;
            case "-":
                ans = x - y;
                break;
            case "*":
                ans = x * y;
                break;
            case "/":
                ans = x/y;
                break;
        }
        // out.println("output</h2></body></html>");
        out.println(x + " " + operation + " " + y + " = " + ans + "</h2></body></html>");

    }
}