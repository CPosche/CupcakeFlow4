package dat.startcode.model.DTO;

import dat.startcode.model.entities.CupcakeBot;
import dat.startcode.model.entities.CupcakeTop;
import lombok.Getter;
import lombok.Setter;

public class DTOOrderLine {

    @Getter @Setter
    CupcakeTop topping;
    @Getter @Setter
    CupcakeBot bottom;
    @Getter @Setter
    float topPrice;
    @Getter @Setter
    float botPrice;
    @Getter @Setter
    int amount;
    @Getter @Setter
    float lineTotal;
    @Getter @Setter
    String assembledCupcake;

    public DTOOrderLine(CupcakeTop topping, CupcakeBot bottom, float topPrice, float botPrice, int amount) {
        this.topping = topping;
        this.bottom = bottom;
        this.topPrice = topPrice;
        this.botPrice = botPrice;
        this.amount = amount;
        this.lineTotal = (topPrice+botPrice)*amount;
        this.assembledCupcake = bottom.getName() + " cupcake with " + topping.getName() + " topping.";
    }
}
