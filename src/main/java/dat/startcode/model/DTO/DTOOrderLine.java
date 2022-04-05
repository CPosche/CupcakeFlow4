package dat.startcode.model.DTO;

import lombok.Getter;
import lombok.Setter;

public class DTOOrderLine {

    @Getter @Setter
    String topping;
    @Getter @Setter
    String bottom;
    @Getter @Setter
    int topPrice;
    @Getter @Setter
    int botPrice;
    @Getter @Setter
    int amount;
    @Getter @Setter
    int lineTotal = (topPrice+botPrice)*amount;
    @Getter @Setter
    String assembledCupcake;

    public DTOOrderLine(String topping, String bottom, int topPrice, int botPrice, int amount) {
        this.topping = topping;
        this.bottom = bottom;
        this.topPrice = topPrice;
        this.botPrice = botPrice;
        this.amount = amount;
        this.assembledCupcake = bottom + " cupcake with " + topping + " topping.";
    }
}
