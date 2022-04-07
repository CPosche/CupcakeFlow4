package dat.startcode.model.entities;

import lombok.Getter;

@Getter
public class CupcakeBot implements ICupcakePart{

    private int id;
    private String name;
    private float price;

    public CupcakeBot(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
