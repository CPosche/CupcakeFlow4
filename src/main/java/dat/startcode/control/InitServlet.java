package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.CupcakeMapper;
import dat.startcode.model.persistence.UserMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InitServlet", value = "/InitServlet")
public class InitServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
        CupcakeMapper cupcakeMapper = new CupcakeMapper(connectionPool);
        ServletContext appScope = getServletContext();
        appScope.setAttribute("cupcakefactory", cupcakeMapper.getTopBot());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
