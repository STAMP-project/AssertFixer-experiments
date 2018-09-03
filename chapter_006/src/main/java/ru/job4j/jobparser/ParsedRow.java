package ru.job4j.jobparser;

public class ParsedRow implements Comparable {
    private String title;
    private String url;
    private long date;

    public ParsedRow(String title, String url, long date) {
        this.title = title;
        this.url = url;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public int compareTo(Object o) {
        return Long.compare(this.date, (Long) o);
    }
}
