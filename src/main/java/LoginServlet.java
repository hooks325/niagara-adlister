import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nedwaldie on 1/30/17.
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login", "/profile"})
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        if (user.getUsername().equalsIgnoreCase("admin") && user.getPassword().equalsIgnoreCase("password")) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/profile.jsp").forward(request,response);
        } else {
            response.sendRedirect("/login");
        }
    }
}
