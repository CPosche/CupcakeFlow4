package dat.startcode.model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;

@Getter
@Setter
public class OrderView implements Views{

    private ArrayList<DTOOrderLine> orderLines;
    private int id;
    private String userEmail;
    private int balance;
    private Timestamp timeCreated;
    private boolean isPayed;

    public OrderView(int id, String userEmail, int balance, Timestamp timeCreated, boolean isPayed, ArrayList<DTOOrderLine> orderLines) {
        this.id = id;
        this.userEmail = userEmail;
        this.balance = balance;
        this.timeCreated = timeCreated;
        this.isPayed = isPayed;
        this.orderLines = orderLines;
    }
}
