package dat.startcode.model.persistence;

import dat.startcode.model.DTO.Views;

import java.util.ArrayList;
import java.util.Map;

public interface IDashMapper {
    Map<String, ArrayList<Views>> getDashViews();
    ArrayList<Views> getDashOrders();
    ArrayList<Views> getDashCustomers();
}
