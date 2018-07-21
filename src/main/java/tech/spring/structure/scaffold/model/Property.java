package tech.spring.structure.scaffold.model;

import static tech.spring.structure.utility.StringUtility.formalize;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import tech.spring.structure.auth.model.Role;
import tech.spring.structure.scaffold.ScaffoldProperty.JoinSelectFilter;
import tech.spring.structure.scaffold.ScaffoldProperty.ScaffoldConditional;

public class Property {

    private String name;

    private String clazz;

    private String gloss;

    private String type;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String help;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String path;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String proxy;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String template;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String autocomplete;

    private boolean autofocus;

    private boolean hidden;

    private boolean disabled;

    private boolean collection;

    private boolean join;

    private boolean column;

    private boolean facet;

    private boolean validate;

    private boolean batch;

    private int length;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Header header;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Object> options;

    private List<Filter> filters;

    private List<Conditional> conditionals;

    private List<Validation> validations;

    private List<Role> whitelist;

    private List<Role> blacklist;

    public Property() {
        options = new ArrayList<Object>();
        filters = new ArrayList<Filter>();
        conditionals = new ArrayList<Conditional>();
        validations = new ArrayList<Validation>();
        whitelist = new ArrayList<Role>();
        blacklist = new ArrayList<Role>();
    }

    public Property(String name, String clazz) {
        this();
        this.name = name;
        this.clazz = clazz;
        this.gloss = formalize(name);
        this.type = "text";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getGloss() {
        return gloss;
    }

    public void setGloss(String gloss) {
        this.gloss = gloss;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getAutocomplete() {
        return autocomplete;
    }

    public void setAutocomplete(String autocomplete) {
        this.autocomplete = autocomplete;
    }

    public boolean isAutofocus() {
        return autofocus;
    }

    public void setAutofocus(boolean autofocus) {
        this.autofocus = autofocus;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isCollection() {
        return collection;
    }

    public void setCollection(boolean collection) {
        this.collection = collection;
    }

    public boolean isJoin() {
        return join;
    }

    public void setJoin(boolean join) {
        this.join = join;
    }

    public boolean isColumn() {
        return column;
    }

    public void setColumn(boolean column) {
        this.column = column;
    }

    public boolean isFacet() {
        return facet;
    }

    public void setFacet(boolean facet) {
        this.facet = facet;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public boolean isBatch() {
        return batch;
    }

    public void setBatch(boolean batch) {
        this.batch = batch;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public List<Object> getOptions() {
        return options;
    }

    public void setOptions(List<Object> options) {
        this.options = options;
    }

    public List<Validation> getValidations() {
        return validations;
    }

    public void setValidations(List<Validation> validations) {
        this.validations = validations;
    }

    public void addValidation(Validation validation) {
        this.validations.add(validation);
    }

    public void addValidations(List<Validation> validations) {
        this.validations.addAll(validations);
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public void addFilters(JoinSelectFilter[] joinSelectFilters) {
        for (JoinSelectFilter joinSelectFilter : joinSelectFilters) {
            addFilter(new Filter(joinSelectFilter));
        }
    }

    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }

    public List<Conditional> getConditionals() {
        return conditionals;
    }

    public void setConditionals(List<Conditional> conditionals) {
        this.conditionals = conditionals;
    }

    public void addConditionals(ScaffoldConditional[] conditionals) {
        for (ScaffoldConditional conditional : conditionals) {
            addConditional(new Conditional(conditional));
        }
    }

    public void addConditional(Conditional conditional) {
        this.conditionals.add(conditional);
    }

    public List<Role> getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(List<Role> whitelist) {
        this.whitelist = whitelist;
    }

    public void whitelistRoles(Role[] whitelist) {
        for (Role role : whitelist) {
            whitelistRole(role);
        }
    }

    public void whitelistRole(Role role) {
        this.whitelist.add(role);
    }

    public List<Role> getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(List<Role> blacklist) {
        this.blacklist = blacklist;
    }

    public void blacklistRoles(Role[] blacklist) {
        for (Role role : blacklist) {
            blacklistRole(role);
        }
    }

    public void blacklistRole(Role role) {
        this.blacklist.add(role);
    }

    public static Property of(String name, String clazz) {
        return new Property(name, clazz);
    }

}
