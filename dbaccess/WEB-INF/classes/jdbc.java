import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class jdbc extends HttpServlet{
    public void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/test";

        final String USER = "root";
        final String PASS = "";

        Connection conn = null;
        Statement stmt = null;

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        // String formName = req.getParameter("name");
        String formUsername = req.getParameter("username");
        String formPassword = req.getParameter("pwd");
        // String formArmycode = req.getParameter("armycode");

        String title = "Database Resutl";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL , USER , PASS);

            stmt = conn.createStatement();
            String sql;
            // sql = "SELECT username , password , name , armycode from auth";
            sql = "select username,name,password,armycode from auth";
            ResultSet rs = stmt.executeQuery(sql);
            String name = "gg";
            String username = "gg";
            String password="gg";
            String armycode = "gg";

            out.println("<!DOCTYPE>");
            out.println("<HTML>"); out.println("<HEAD><TITLE>JDBC</TITLE></HEAD>");  
            out.println("<BODY>" + formUsername + " " + formPassword + "<br>");
            int status = 0;
            while(rs.next()){
                name = rs.getString("name");
                username = rs.getString("username");
                password = rs.getString("password");
                armycode = rs.getString("armycode");

                // out.println("<H2>Username : " + username + "<br></H2>");
                // out.println("<H2>Name : " + name + "<br></H2>");            
                // out.println("<H2>ArmyCode : " + armycode + "<br></H2>");    

                if(username.equals(formUsername) && password.equals(formPassword) ){
                    out.println("<H1>FINAL</H>");
                    out.println("<H2>Username : " + username + "<br></H2>");
                    out.println("<H2>Name : " + name + "<br></H2>");            
                    out.println("<H2>ArmyCode : " + armycode + "<br></H2>");  
                    status = 1;
                    break;
                }
            }



            if(status == 0){
                out.println("<H1> Invalid username and password </H1>");           
            }

            // rs.next();
            // out.println(rs.getString("username"));
            out.println("</body></html>");

            rs.close();
            stmt.close();
            conn.close();   
        }  
        
        catch(Exception e){
            System.out.println(e);
            out.println("<!DOCTYPE>");
            out.println("<HTML>"); out.println("<HEAD><TITLE>JDBC</TITLE></HEAD>");  
            out.println("<BODY> Error is : " + e + "</BODY>");
            out.println("</HTML>");
        }
    }
}