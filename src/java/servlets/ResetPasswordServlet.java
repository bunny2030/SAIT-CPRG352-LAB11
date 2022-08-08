package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;

public class ResetPasswordServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        if(request.getParameter("uuid") != null){
            HttpSession session = request.getSession();
            session.setAttribute("uuid", request.getParameter("uuid"));
            getServletContext().getRequestDispatcher("/WEB-INF/reset_new_password.jsp").forward(request, response);
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
        return;
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.getAttribute("uuid") != null){
            String uuid = session.getAttribute("uuid").toString();
            String password = request.getParameter("userPassword");
            
            AccountService as = new AccountService();
            
            boolean changed = as.changePassword(uuid, password);
            
            if(changed){
                getServletContext().getRequestDispatcher("/WEB-INF/reset_new_password.jsp").forward(request, response);
                return;
            }
            else{
                getServletContext().getRequestDispatcher("/WEB-INF/reset_new_password.jsp").forward(request, response);
                return;
            }
        }
        
        String email = request.getParameter("userEmail");
        
        AccountService as = new AccountService();
        String path = getServletContext().getRealPath("/WEB-INF");
        
        String url = "http://localhost:8084/resetPass";
        
        boolean result = as.resetPassword(email, path, url);
        
        if(result){
            getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
            return;
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
            return;
        }
        
    }
}