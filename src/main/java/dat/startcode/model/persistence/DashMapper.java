package dat.startcode.model.persistence;

import dat.startcode.model.DTO.DTOOrderLine;
import dat.startcode.model.DTO.OrderView;
import dat.startcode.model.DTO.Views;
import dat.startcode.model.entities.CupcakeBot;
import dat.startcode.model.entities.CupcakeTop;
import dat.startcode.model.entities.ICupcakePart;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DashMapper implements IDashMapper {

    ConnectionPool connectionPool;
    Map<String, ArrayList<ICupcakePart>> cupcakefactory;

    public DashMapper(ConnectionPool connectionPool, Map<String, ArrayList<ICupcakePart>> cupcakefactory)
    {
        this.cupcakefactory = cupcakefactory;
        this.connectionPool = connectionPool;
        System.out.println(cupcakefactory.size());
    }

    @Override
    public Map<String, ArrayList<Views>> getDashViews() {
       Map<String, ArrayList<Views>> dashViews = new HashMap<>();
       dashViews.put("orders", getDashOrders());
       dashViews.put("customers", getDashCustomers());
       return dashViews;
    }

    @Override
    public ArrayList<Views> getDashOrders() {
        Logger.getLogger("web").log(Level.INFO, "");
        ArrayList<Views> orders = new ArrayList<>();
        String sql = "SELECT o.order_id, o.order_created, o.order_isPayed, u.user_email FROM cupcake.order o inner join cupcake.user u on o.FK_user_id = u.user_id";

        try (Connection connection = connectionPool.getConnection()){

            try (PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("order_id");
                    Timestamp ts = rs.getTimestamp("order_created");
                    boolean isPayed = (1 == rs.getInt("order_isPayed"));
                    System.out.println(isPayed);
                    String userEmail = rs.getString("user_email");
                    orders.add(new OrderView(id, userEmail, ts, isPayed, getOrderlines(id)));
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return orders;
    }

    private ArrayList<DTOOrderLine> getOrderlines(int orderID) {
        ArrayList<DTOOrderLine> orderlines = new ArrayList<>();
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "SELECT ct.cupcaketop_id, cb.cupcakebottom_id, ol.orderline_amount FROM cupcake.orderline ol\n" +
                "inner join cupcake.cupcaketops ct on ol.FK_cupcaketop_id = ct.cupcaketop_id\n" +
                "inner join cupcake.cupcakebottoms cb on ol.FK_cupcakebot_id = cb.cupcakebottom_id\n" +
                "WHERE FK_order_id = ?";

        try (Connection connection = connectionPool.getConnection()){

            try (PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, orderID);
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int ctId = rs.getInt("cupcaketop_id");
                    int cbId = rs.getInt("cupcakebottom_id");
                    int amount = rs.getInt("orderline_amount");
                    orderlines.add(new DTOOrderLine((CupcakeTop) cupcakefactory.get("toppings").get(ctId-1), (CupcakeBot) cupcakefactory.get("bottoms").get(cbId-1), amount));
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return orderlines;
    }

    @Override
    public ArrayList<Views> getDashCustomers() {
        return null;
    }
}
