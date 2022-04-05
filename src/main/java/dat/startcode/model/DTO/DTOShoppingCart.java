package dat.startcode.model.DTO;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;

public class DTOShoppingCart extends HttpServlet {

    ArrayList<DTOOrderLine> orderLines = new ArrayList<>();

    int total = sum();

    public int sum() {
        int sum = 0;
        for (DTOOrderLine i : orderLines) {
            sum += i.lineTotal;
        }
        return sum;
    }

    public void generate() {

        orderLines.add(new DTOOrderLine("Chocolate", "Vanilla",5,5,1));
        orderLines.add(new DTOOrderLine("Chocolate", "Lemon",5,5,2));
        orderLines.add(new DTOOrderLine("Almond", "Vanilla",5,5,3));
        orderLines.add(new DTOOrderLine("Vanilla", "Strawberry",5,5,4));
        orderLines.add(new DTOOrderLine("Chocolate", "Blueberry",5,5,6));

    }

}
