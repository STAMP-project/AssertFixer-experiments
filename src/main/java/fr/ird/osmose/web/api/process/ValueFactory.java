package fr.ird.osmose.web.api.process;

import fr.ird.osmose.web.api.model.Group;

public interface ValueFactory {
    String groupValueFor(String name, Group group);
}
