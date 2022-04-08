package dat.startcode.control;

import dat.startcode.model.DTO.DTOOrderLine;
import dat.startcode.model.DTO.DTOShoppingCart;
import dat.startcode.model.entities.CupcakeBot;
import dat.startcode.model.entities.CupcakeTop;
import dat.startcode.model.entities.ICupcakePart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "Updatet", value = "/Updatet")
public class Updatet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DTOShoppingCart cart = (DTOShoppingCart) session.getAttribute("cart");
        Map<String, ArrayList<ICupcakePart>> cupcakefactory = (Map<String, ArrayList<ICupcakePart>>) getServletContext().getAttribute("cupcakefactory");
        CupcakeTop top = (CupcakeTop) cupcakefactory.get("toppings").get(Integer.parseInt(request.getParameter("topping"))-1);
        CupcakeBot bot = (CupcakeBot) cupcakefactory.get("bottoms").get(Integer.parseInt(request.getParameter("bottom"))-1);
        int amount = Integer.parseInt(request.getParameter("amountOf"));
        addOrderLine(cart, top, bot, top.getPrice(), bot.getPrice(), amount);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void addOrderLine(DTOShoppingCart cart, CupcakeTop top, CupcakeBot bot, float topPrice, float botPrice, int amount){
        cart.setOrderLines(new DTOOrderLine(top, bot, topPrice, botPrice, amount));
        cart.sum();
    }
}
