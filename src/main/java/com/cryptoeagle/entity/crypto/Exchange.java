package com.cryptoeagle.entity.crypto;


import com.cryptoeagle.entity.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Data
@Embeddable
public class Exchange {

    private String price;
    private String name;
    private String logo;
    private String currency;
    private String roi;

}
