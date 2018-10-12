package io.sphere.sdk.projects;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.sphere.sdk.models.Base;

final class MessagesConfigurationImpl extends Base implements MessagesConfiguration {
    private Boolean enabled;
    private Long deleteDaysAfterCreation;

    @JsonCreator
    public MessagesConfigurationImpl(final Boolean enabled, final Long deleteDaysAfterCreation) {
        this.enabled = enabled;
        this.deleteDaysAfterCreation = deleteDaysAfterCreation;
    }

    @Override
    public Boolean isEnabled() {
        return enabled;
    }

    @Override
    public Long getDeleteDaysAfterCreation() {
        return deleteDaysAfterCreation;
    }
}
