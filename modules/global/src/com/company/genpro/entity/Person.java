package com.company.genpro.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "JSONB_PERSON")
@Entity(name = "jsonb_Person")
@NamePattern("%s|name")
@Data
public class Person extends StandardEntity {
    private static final long serialVersionUID = -497620453639855904L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @Convert(converter = JsonConverter.class)
    @Column(name = "ADDRESS", columnDefinition = "jsonb")
    private Address address;

    public void setAddress(Address address){
        this.address = address;
    }
}