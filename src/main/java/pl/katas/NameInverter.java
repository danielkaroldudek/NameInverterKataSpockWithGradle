package pl.katas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NameInverter {
    public String invert(String name) {
        if (name.isBlank()) {
            return "";
        }

        return createInvertedName(splitName(name));
    }

    private ArrayList<String> splitName(String name) {
        var splitName = name.split(" ");
        return new ArrayList<>(List.of(splitName));
    }

    private String createInvertedName(ArrayList<String> splitName) {
        splitName.removeIf(n -> List.of("Pan", "Pani").contains(n));

        Collections.reverse(splitName);

        return String.join(", ", splitName);
    }
}
