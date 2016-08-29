package ghpackage;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class AjaxServlet extends HttpServlet  
{  
  
    protected void doGet(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException  
    {  
  
       
        String value1 = request.getParameter("v1");  
        
        System.out.print(value1);
    }  
  
    protected void doPost(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException  
    {  
  
         
   fff(request,response);
        
         
  
    }  
    String fff(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
    	String value1 = request.getParameter("v1");  
    	return value1;
    }
  
}  
