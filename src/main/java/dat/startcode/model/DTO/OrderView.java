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
    private Timestamp timeCreated;
    private boolean isPayed;
    private int totalorderlines;

    public OrderView(int id, String userEmail, Timestamp timeCreated, boolean isPayed, ArrayList<DTOOrderLine> orderLines) {
        this.id = id;
        this.userEmail = userEmail;
        this.timeCreated = timeCreated;
        this.isPayed = isPayed;
        this.orderLines = orderLines;
        this.totalorderlines = orderLines.size();
    }
}
