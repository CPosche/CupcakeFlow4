package dat.startcode.model.persistence;

import dat.startcode.model.DTO.OrderView;
import dat.startcode.model.DTO.Views;
import dat.startcode.model.entities.CupcakeTop;
import dat.startcode.model.entities.ICupcakePart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DashMapper implements IDashMapper {

    ConnectionPool connectionPool;

    public DashMapper(ConnectionPool connectionPool)
    {
        this.connectionPool = connectionPool;
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
        String sql = "select * from order_view";

        try (Connection connection = connectionPool.getConnection()){

            try (PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("cupcaketop_id");
                    String name = rs.getString("cupcaketop_name");
                    float topPrice = rs.getFloat("cupcaketop_price");
//                    orders.add(new OrderView(1, "b@b.dk", 200, now(), false, ));
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return orders;
    }

    @Override
    public ArrayList<Views> getDashCustomers() {
        return null;
    }
}
