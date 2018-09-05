package org.hesperides.application.workshopproperties;

import org.hesperides.domain.security.User;
import org.hesperides.domain.workshopproperties.commands.WorkshopPropertyCommands;
import org.hesperides.domain.workshopproperties.entities.WorkshopProperty;
import org.hesperides.domain.workshopproperties.queries.WorkshopPropertyQueries;
import org.hesperides.domain.workshopproperties.queries.views.WorkshopPropertyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkshopPropertyUseCases {

    private final WorkshopPropertyCommands commands;
    private final WorkshopPropertyQueries queries;

    @Autowired
    public WorkshopPropertyUseCases(WorkshopPropertyCommands commands, WorkshopPropertyQueries queries) {
        this.commands = commands;
        this.queries = queries;
    }

    public String createWorkshopProperty(WorkshopProperty workshopProperty, User user) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public WorkshopPropertyView getWorkshopProperty(String workshopPropertyKey) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public void updateWorkshopProperty(WorkshopProperty workshopProperty, User user) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
