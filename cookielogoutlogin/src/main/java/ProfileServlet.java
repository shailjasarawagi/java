import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ProfileServlet")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("link.jsp").include(request, response);

        Cookie ck[] = request.getCookies();
        if (ck != null) {
            for(Cookie cookie :ck){
                if(cookie.getName().equals("name")){
                    if (!cookie.getValue().equals("") || cookie.getValue() != null) {
                        out.print("<b>Welcome to Profile</b>");
                        out.print("<br>Welcome, " + cookie.getValue());
                        break;
                }
                    else {
                        out.print("Please login first");
                        request.getRequestDispatcher("login.jsp").include(request, response);
                    }
            }  else {
                    out.print("Please login first");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                }

            }
        }
        }
    }
