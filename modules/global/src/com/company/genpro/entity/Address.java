package com.company.genpro.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.entity.StandardEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@MetaClass(name = "jsonb_Address")
@NamePattern("%s %s %s|country,city,address")
@Data
public class Address extends BaseIntegerIdEntity {
    private static final long serialVersionUID = -8853088682232651783L;

    @MetaProperty
    private String country;

    @MetaProperty
    private String city;

    @MetaProperty
    private String address;

    public Address() {
    }

    public Address(String country, String city, String address) {
        this.country = country;
        this.city = city;
        this.address = address;
    }

}