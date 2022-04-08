package dat.startcode.model.persistence;

import dat.startcode.model.DTO.DTOOrderLine;
import dat.startcode.model.DTO.DTOShoppingCart;
import dat.startcode.model.entities.CupcakeBot;
import dat.startcode.model.entities.CupcakeTop;
import dat.startcode.model.entities.ICupcakePart;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CupcakeMapper implements ICupcakeMapper{

    ConnectionPool connectionPool;

    public CupcakeMapper(ConnectionPool connectionPool)
    {
        this.connectionPool = connectionPool;
    }

    @Override
    public Map<String, ArrayList<ICupcakePart>> getTopBot() {
        Map<String, ArrayList<ICupcakePart>> cupcakefactory = new HashMap<>();
        cupcakefactory.put("toppings", getTop());
        cupcakefactory.put("bottoms", getBot());
        return cupcakefactory;
    }

    @Override
    public DTOShoppingCart makeOrder(DTOShoppingCart cart, User user) throws DatabaseException {
        int orderkey = 0;

        String orderSql = "INSERT INTO cupcake.order (FK_user_id) VALUES (?)";
        String olSql = "INSERT INTO cupcake.orderline (FK_cupcaketop_id, FK_cupcakebot_id, FK_order_id, orderline_amount) VALUES (?, ?, ?, ?)";

        try (Connection connection = connectionPool.getConnection()){

            try (PreparedStatement ps = connection.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS)){
                ps.setInt(1, user.getId());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    orderkey = rs.getInt(1);
                }
            }

            try(PreparedStatement olps = connection.prepareStatement(olSql)){
                for (DTOOrderLine ol : cart.getOrderLines()) {
                    olps.setInt(1, ol.getTopping().getId());
                    olps.setInt(2, ol.getBottom().getId());
                    olps.setInt(3, orderkey);
                    olps.setInt(4, ol.getAmount());
                    olps.addBatch();
                }
                olps.executeBatch();
            }

        }catch (SQLException e){
            throw new DatabaseException(Arrays.toString(e.getStackTrace()));
        }

        return cart;
    }

    public ArrayList<ICupcakePart> getTop(){
        Logger.getLogger("web").log(Level.INFO, "");
        ArrayList<ICupcakePart> tops = new ArrayList<>();
        String sql = "select * from cupcaketops";

        try (Connection connection = connectionPool.getConnection()){

            try (PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("cupcaketop_id");
                    String name = rs.getString("cupcaketop_name");
                    float topPrice = rs.getFloat("cupcaketop_price");
                    tops.add(new CupcakeTop(id, name, topPrice));
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return tops;
    }

    public ArrayList<ICupcakePart> getBot(){
        Logger.getLogger("web").log(Level.INFO, "");
        ArrayList<ICupcakePart> bots = new ArrayList<>();
        String sql = "select * from cupcakebottoms";

        try (Connection connection = connectionPool.getConnection()){

            try (PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("cupcakebottom_id");
                    String name = rs.getString("cupcakebottom_name");
                    float botPrice = rs.getFloat("cupcakebottom_price");
                    bots.add(new CupcakeBot(id, name, botPrice));
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return bots;
    }
}
