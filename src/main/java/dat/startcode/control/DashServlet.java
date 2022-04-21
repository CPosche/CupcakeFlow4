package dat.startcode.control;

import dat.startcode.model.DTO.Views;
import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.ICupcakePart;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.DashMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "DashServlet", value = "/DashServlet")
public class DashServlet extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("errormessage", "you do not have permission to enter this site");
        request.getRequestDispatcher("error.jsp").forward(request, response);
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //HttpSession session = request.getSession();
        String page = request.getParameter("Dashpage");
        Map<String, ArrayList<ICupcakePart>> cupcakefactory = (Map<String, ArrayList<ICupcakePart>>) getServletContext().getAttribute("cupcakefactory");
        DashMapper dashMapper = new DashMapper(connectionPool, cupcakefactory);
        Map<String, ArrayList<Views>> dashViews = dashMapper.getDashViews();
        request.setAttribute("views", dashViews);
        request.setAttribute("Dashpage", page);
        request.getRequestDispatcher("Dashboard.jsp").forward(request,response);

    }
}
