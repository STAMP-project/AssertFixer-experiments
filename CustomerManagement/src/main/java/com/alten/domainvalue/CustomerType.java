package com.alten.domainvalue;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.alten.util.Helper;
public enum CustomerType {
	INDIVIDUAL, COMPANY;
	
    @JsonCreator
    public static CustomerType fromValue(String value)
    {
        return Helper.BuildEnumFromString(CustomerType.class, value);
    }


    @JsonValue
    public String toJson()
    {
        return name().toLowerCase();
    }
}
