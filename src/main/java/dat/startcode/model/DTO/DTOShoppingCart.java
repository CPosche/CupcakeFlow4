package dat.startcode.model.DTO;

import lombok.Getter;

import java.util.ArrayList;

public class DTOShoppingCart{

    @Getter private ArrayList<DTOOrderLine> orderLines = new ArrayList<>();
    @Getter private int total = 0;

    public void sum() {
        for (DTOOrderLine i : orderLines) {
            this.total += i.lineTotal;
        }
    }

}
