package dat.startcode.model.persistence;

import dat.startcode.model.entities.ICupcakePart;

import java.util.ArrayList;
import java.util.Map;

public interface ICupcakeMapper {
    Map<String, ArrayList<ICupcakePart>> getTopBot();
}
