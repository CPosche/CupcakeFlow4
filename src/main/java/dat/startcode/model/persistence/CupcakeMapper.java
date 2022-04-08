package dat.startcode.model.persistence;

import dat.startcode.model.DTO.DTOShoppingCart;
import dat.startcode.model.entities.CupcakeBot;
import dat.startcode.model.entities.CupcakeTop;
import dat.startcode.model.entities.ICupcakePart;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public DTOShoppingCart makeOrder(DTOShoppingCart cart) throws DatabaseException {
        DTOShoppingCart shopCart = cart;

        String orderSql = "";



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
