import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by nedwaldie on 1/31/17.
 */
@WebServlet(name = "AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get all the ads as a list of objecet
        List<Ad> ads = DaoFactory.getAdsDao().all();

        // assign that variable to the data sent to the view
        request.setAttribute("ads", ads);

        // render the view
        request.getRequestDispatcher("ads/index.jsp").forward(request, response);
    }
}
