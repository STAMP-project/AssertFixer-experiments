package tech.spring.structure.scaffold;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;

import tech.spring.structure.auth.AuthIntegrationHelper;
import tech.spring.structure.auth.model.Role;
import tech.spring.structure.scaffold.model.Conditional;
import tech.spring.structure.scaffold.model.Filter;
import tech.spring.structure.scaffold.model.Header;
import tech.spring.structure.scaffold.model.Property;
import tech.spring.structure.scaffold.model.Scaffold;
import tech.spring.structure.scaffold.model.Validation;

public abstract class ScaffoldIntegrationHelper extends AuthIntegrationHelper {

    @Value("classpath:mock/scaffold.json")
    private Resource scaffoldResource;

    @Value("classpath:mock/scaffold/login-request.json")
    private Resource loginRequestScaffoldResource;

    private Map<String, Scaffold> scaffolding;

    @Before
    public void initializeMockScaffold() throws JsonParseException, JsonMappingException, IOException {
        // @formatter:off
        scaffolding = objectMapper.readValue(scaffoldResource.getFile(), new TypeReference<Map<String , Scaffold>>() {});
        // @formatter:on
    }

    protected Scaffold getMockScaffold(String name) {
        Optional<Scaffold> scaffold = Optional.ofNullable(scaffolding.get(name));
        assertTrue("Unable to find scaffold with name " + name + "!", scaffold.isPresent());
        return scaffold.get();
    }

    protected Map<String, Scaffold> getMockScaffolding() {
        return scaffolding;
    }

    protected void assertScaffold(Scaffold mockScaffold, Scaffold scaffold) {
        assertEquals("Scaffold does not have correct name!", mockScaffold.getName(), scaffold.getName());
        assertEquals("Scaffold does not have correct authorization!", mockScaffold.getAuthorization(), scaffold.getAuthorization());
        assertEquals("Scaffold does not have correct number of columns!", mockScaffold.getNumberOfColumns(), scaffold.getNumberOfColumns());
        assertEquals("Scaffold does not have correct allow to create flag!", mockScaffold.isAllowCreate(), scaffold.isAllowCreate());
        assertEquals("Scaffold does not have correct allow to batch flag!", mockScaffold.isAllowBatch(), scaffold.isAllowBatch());
        assertEquals("Scaffold does not have correct allow to delete flag!", mockScaffold.isAllowDelete(), scaffold.isAllowDelete());
        assertEquals("Scaffold does not have correct read only flag!", mockScaffold.isReadOnly(), scaffold.isReadOnly());
        assertEquals("Scaffold does not have correct image!", mockScaffold.getImage(), scaffold.getImage());
        assertEquals("Scaffold does not have correct title!", mockScaffold.getTitle(), scaffold.getTitle());
        assertEquals("Scaffold does not have correct subtitle!", mockScaffold.getSubTitle(), scaffold.getSubTitle());
        assertEquals("Scaffold does not have correct notice header!", mockScaffold.getNoticeHeader(), scaffold.getNoticeHeader());
        assertEquals("Scaffold does not have correct notice!", mockScaffold.getNotice(), scaffold.getNotice());
        assertEquals("Scaffold does not have correct note!", mockScaffold.getNote(), scaffold.getNote());
        assertProperties(mockScaffold.getProperties(), scaffold.getProperties());
    }

    protected void assertProperties(List<Property> mockProperties, List<Property> properties) {
        assertEquals("Scaffold does not have correct number of properties!", mockProperties.size(), properties.size());
        for (int i = 0; i < mockProperties.size(); i++) {
            Property mockProperty = mockProperties.get(i);
            Property property = properties.get(i);
            assertProperty(mockProperty, property);
        }
    }

    protected void assertProperty(Property mockProperty, Property property) {
        assertEquals("Property does not have correct name!", mockProperty.getName(), property.getName());
        assertEquals("Property does not have correct class!", mockProperty.getClazz(), property.getClazz());
        assertEquals("Property does not have correct gloss!", mockProperty.getGloss(), property.getGloss());
        assertEquals("Property does not have correct help!", mockProperty.getHelp(), property.getHelp());
        assertEquals("Property does not have correct proxy!", mockProperty.getProxy(), property.getProxy());
        assertEquals("Property does not have correct path!", mockProperty.getPath(), property.getPath());
        assertEquals("Property does not have correct template!", mockProperty.getTemplate(), property.getTemplate());
        assertEquals("Property does not have correct autocomplete!", mockProperty.getAutocomplete(), property.getAutocomplete());
        assertEquals("Property does not have correct autofocus flag!", mockProperty.isAutofocus(), property.isAutofocus());
        assertEquals("Property does not have correct hidden flag!", mockProperty.isHidden(), property.isHidden());
        assertEquals("Property does not have correct disable flag!", mockProperty.isDisabled(), property.isDisabled());
        assertEquals("Property does not have correct collection flag!", mockProperty.isCollection(), property.isCollection());
        assertEquals("Property does not have correct join flag!", mockProperty.isJoin(), property.isJoin());
        assertEquals("Property does not have correct column flag!", mockProperty.isColumn(), property.isColumn());
        assertEquals("Property does not have correct validate flag!", mockProperty.isValidate(), property.isValidate());
        assertEquals("Property does not have correct batch flag!", mockProperty.isBatch(), property.isBatch());
        assertEquals("Property does not have correct length!", mockProperty.getLength(), property.getLength());

        if (mockProperty.getHeader() == null) {
            assertNull("Header was not null as expected!", property.getHeader());
        } else {
            assertHeader(mockProperty.getHeader(), property.getHeader());
        }

        assertOptions(mockProperty.getOptions(), property.getOptions());
        assertValidations(mockProperty.getValidations(), property.getValidations());
        assertFilters(mockProperty.getFilters(), property.getFilters());
        assertConditionals(mockProperty.getConditionals(), property.getConditionals());
        assertRoleList(mockProperty.getWhitelist(), property.getWhitelist());
        assertRoleList(mockProperty.getBlacklist(), property.getBlacklist());
    }

    protected void assertHeader(Header mockHeader, Header header) {
        assertEquals("Property does not have correct text!", mockHeader.getText(), header.getText());
        assertEquals("Property does not have correct italicized flag!", mockHeader.isItalicized(), header.isItalicized());
    }

    protected void assertOptions(List<Object> mockOptions, List<Object> options) {
        assertEquals("Property does not have correct number of options!", mockOptions.size(), options.size());
        for (int i = 0; i < mockOptions.size(); i++) {
            Object mockOption = mockOptions.get(i);
            Object option = options.get(i);
            assertEquals("Property does not have same option!", mockOption, option);
        }
    }

    protected void assertValidations(List<Validation> mockValidations, List<Validation> validations) {
        assertEquals("Property does not have correct number of validations!", mockValidations.size(), validations.size());
        for (int i = 0; i < mockValidations.size(); i++) {
            Validation mockValidation = mockValidations.get(i);
            Validation validation = validations.get(i);
            assertValidation(mockValidation, validation);
        }
    }

    protected void assertValidation(Validation mockValidation, Validation validation) {
        assertEquals("Validation does not have same name!", mockValidation.getName(), validation.getName());
        assertEquals("Validation does not have same value!", mockValidation.getValue(), validation.getValue());
        assertEquals("Validation does not have same message!", mockValidation.getMessage(), validation.getMessage());
    }

    protected void assertFilters(List<Filter> mockFilters, List<Filter> filters) {
        assertEquals("Property does not have correct number of filters!", mockFilters.size(), filters.size());
        for (int i = 0; i < mockFilters.size(); i++) {
            Filter mockFilter = mockFilters.get(i);
            Filter filter = filters.get(i);
            assertFilter(mockFilter, filter);
        }
    }

    protected void assertFilter(Filter mockFilter, Filter filter) {
        assertEquals("Filter does not have same property!", mockFilter.getProperty(), filter.getProperty());
        assertEquals("Filter does not have same value!", mockFilter.getValue(), filter.getValue());
    }

    protected void assertConditionals(List<Conditional> mockConditionals, List<Conditional> conditionals) {
        assertEquals("Property does not have correct number of conditionals!", mockConditionals.size(), conditionals.size());
        for (int i = 0; i < mockConditionals.size(); i++) {
            Conditional mockConditional = mockConditionals.get(i);
            Conditional conditional = conditionals.get(i);
            assertConditional(mockConditional, conditional);
        }
    }

    protected void assertConditional(Conditional mockConditional, Conditional conditional) {
        assertEquals("Conditional does not have same type!", mockConditional.getType(), conditional.getType());
        assertEquals("Conditional does not have same path!", mockConditional.getPath(), conditional.getPath());
        assertEquals("Conditional does not have same value!", mockConditional.getValue(), conditional.getValue());
    }

    protected void assertRoleList(List<Role> mockRoleList, List<Role> roleList) {
        assertEquals("Property does not have correct number of roles in list!", mockRoleList.size(), roleList.size());
        for (int i = 0; i < mockRoleList.size(); i++) {
            Role mockRole = mockRoleList.get(i);
            Role role = roleList.get(i);
            assertEquals("Property does not have same role!", mockRole, role);
        }
    }

}
