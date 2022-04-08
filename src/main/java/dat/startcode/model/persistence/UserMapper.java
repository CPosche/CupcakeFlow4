package dat.startcode.model.persistence;

import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserMapper implements IUserMapper
{

    ConnectionPool connectionPool;

    public UserMapper(ConnectionPool connectionPool)
    {
        this.connectionPool = connectionPool;
    }

    @Override
    public User login(String username, String password) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;

        String sql = "SELECT * FROM user u inner join role r on u.FK_user_role = r.role_id WHERE u.user_email = ? AND u.user_password = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    int id = rs.getInt("user_id");
                    String role = rs.getString("role_name");
                    int balance = rs.getInt("user_balance");
                    user = new User(id, username, password, balance, role);
                } else
                {
                    throw new DatabaseException("Wrong username or password");
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }

    @Override
    public User createUser(String username, String password, String role) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        User user;
        int convRole = Integer.parseInt(role);
        String sql = "insert into user (user_email, user_password, FK_user_role, user_balance) values (?,?,?, 200)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setInt(3, convRole);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
//                    user = new User(username, password, role);
                    user = null;
                } else
                {
                    throw new DatabaseException("The user with username = " + username + " could not be inserted into the database");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return user;
    }

    @Override
    public Void pay(int orderID, User user) throws DatabaseException {


        String sql = "UPDATE cupcake.order SET order_isPayed = 1 WHERE order_id = ?";

        try (Connection connection = connectionPool.getConnection()){

            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderID);
                ps.executeUpdate();
            }

        } catch ( SQLException e) {
            throw new DatabaseException(Arrays.toString(e.getStackTrace()));
        }


        return null;
    }


}
