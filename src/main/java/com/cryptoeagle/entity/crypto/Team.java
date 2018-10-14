package com.cryptoeagle.entity.crypto;

import com.cryptoeagle.entity.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;


@Embeddable
@Data
public class Team  {

    private String name;
    private String title;
    private String links;
    private String url;
    private String photo;

}
