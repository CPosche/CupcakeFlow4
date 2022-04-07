package dat.startcode.control;

import dat.startcode.model.DTO.DTOOrderLine;
import dat.startcode.model.DTO.DTOShoppingCart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Updatet", value = "/Updatet")
public class Updatet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DTOShoppingCart cart = (DTOShoppingCart) session.getAttribute("cart");
        String top = request.getParameter("topping");
        String bot = request.getParameter("bottom");
        int amount = Integer.parseInt(request.getParameter("amountOf"));
        addOrderLine(cart, "choko", "vanilla", 10, 20, 5);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    public void addOrderLine(DTOShoppingCart cart, String top, String bot, int topPrice, int botPrice, int amount){
        cart.setOrderLines(new DTOOrderLine(top, bot, topPrice, botPrice, amount));
        cart.sum();
    }
}
