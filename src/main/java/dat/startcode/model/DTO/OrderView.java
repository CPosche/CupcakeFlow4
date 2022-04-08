package dat.startcode.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderView {

    private int id;
    private String user_email;

    public OrderView(int id, String user_email) {
        this.id = id;
        this.user_email = user_email;
    }
}
