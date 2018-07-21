package tech.spring.structure.scaffold.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class Scaffold {

    private String name;

    @JsonIgnore
    private String authorization;

    private int numberOfColumns;

    private boolean allowCreate;

    private boolean allowBatch;

    private boolean allowDelete;

    private boolean readOnly;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String image;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String title;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String subTitle;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String noticeHeader;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String notice;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String note;

    private List<Property> properties;

    public Scaffold() {
        properties = new ArrayList<Property>();
    }

    public Scaffold(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public boolean isAllowCreate() {
        return allowCreate;
    }

    public void setAllowCreate(boolean allowCreate) {
        this.allowCreate = allowCreate;
    }

    public boolean isAllowBatch() {
        return allowBatch;
    }

    public void setAllowBatch(boolean allowBatch) {
        this.allowBatch = allowBatch;
    }

    public boolean isAllowDelete() {
        return allowDelete;
    }

    public void setAllowDelete(boolean allowDelete) {
        this.allowDelete = allowDelete;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getNoticeHeader() {
        return noticeHeader;
    }

    public void setNoticeHeader(String noticeHeader) {
        this.noticeHeader = noticeHeader;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public static Scaffold of(String name) {
        return new Scaffold(name);
    }

}
