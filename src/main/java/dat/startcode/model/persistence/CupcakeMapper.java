package dat.startcode.model.persistence;

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
    public Map[] getTopBot() {
        Map<String, ArrayList<String[]>> top = getTop();
        Map<String, ArrayList<String[]>> bot = getBot();
        return new Map[]{top, bot};
    }

    public Map<String, ArrayList<String[]>> getTop(){
        Map<String, ArrayList<String[]>> topping = new HashMap<>();
        Logger.getLogger("web").log(Level.INFO, "");
        ArrayList<String[]> tops = new ArrayList<>();
        String sql = "select * from cupcaketops";

        try (Connection connection = connectionPool.getConnection()){

            try (PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    String name = rs.getString("cupcaketop_name");
                    String topPrice = String.valueOf(rs.getInt("cupcaketop_price"));
                    tops.add(new String[]{name, topPrice});
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        topping.put("topping", tops);

        return topping;
    }

    public Map<String, ArrayList<String[]>> getBot(){
        Map<String, ArrayList<String[]>> bottom = new HashMap<>();
        Logger.getLogger("web").log(Level.INFO, "");
        ArrayList<String[]> bots = new ArrayList<>();
        String sql = "select * from cupcakebottoms";

        try (Connection connection = connectionPool.getConnection()){

            try (PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    String name = rs.getString("cupcakebottom_name");
                    String botPrice = String.valueOf(rs.getInt("cupcakebottom_price"));
                    bots.add(new String[]{name, botPrice});
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        bottom.put("topping", bots);
        return bottom;
    }
}
