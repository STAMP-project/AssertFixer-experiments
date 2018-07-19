package nl.stil4m.mollie.mocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DummyMethod {

    private final String id;

    @JsonCreator
    public DummyMethod(@JsonProperty("id") String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
