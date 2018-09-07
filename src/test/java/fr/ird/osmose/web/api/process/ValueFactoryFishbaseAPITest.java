package fr.ird.osmose.web.api.process;

import fr.ird.osmose.web.api.model.Group;

import java.util.List;

public class ValueFactoryFishbaseAPITest extends ValueFactoryFishbaseTestBase {

    @Override
    ValueFactory createValueFactory(List<Group> groups) {
        return new ValueFactoryFishbaseAPI();
    }
}
