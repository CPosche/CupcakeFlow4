package dat.startcode.model.persistence;

import dat.startcode.model.DTO.DTOShoppingCart;
import dat.startcode.model.entities.ICupcakePart;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public interface ICupcakeMapper {
    Map<String, ArrayList<ICupcakePart>> getTopBot();
    DTOShoppingCart makeOrder(DTOShoppingCart cart, User user) throws DatabaseException;
}
