package com.bonjourcs.java.ltjl.cao;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/13
 */
@Getter
@Setter
public class SpecialObject implements Serializable {

    private static final long serialVersionUID = -6439069665096059014L;

    private String version;
    private String user;
    private Content content;

    class Content {

        private String length;
        private String content;

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
