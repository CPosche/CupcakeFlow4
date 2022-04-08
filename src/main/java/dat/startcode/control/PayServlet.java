package dat.startcode.control;

import dat.startcode.model.DTO.DTOShoppingCart;
import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.UserMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "PayServlet", value = "/PayServlet")
public class PayServlet extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserMapper userMapper = new UserMapper(connectionPool);

        int orderID = Integer.parseInt(request.getParameter("confirm"));
        System.out.println(orderID);
        User user = (User) session.getAttribute("user");
        String msg = "";

        try{

            userMapper.pay(orderID,user);
            msg = "Order with id " + orderID + " is paid for";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }catch (DatabaseException e){
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }
}
