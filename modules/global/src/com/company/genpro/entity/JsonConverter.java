package com.company.genpro.entity;

import com.haulmont.cuba.core.app.serialization.EntitySerializationAPI;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Metadata;
import org.postgresql.util.PGobject;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.SQLException;

@Converter
public class JsonConverter implements AttributeConverter<Address, Object> {

    private EntitySerializationAPI serializationAPI;

    private Metadata metadata;

    private void inject() {
        if (serializationAPI == null) {
            serializationAPI = AppBeans.get(EntitySerializationAPI.class);
        }
        if (metadata == null) {
            metadata = AppBeans.get(Metadata.class);
        }
    }

    @Override
    public Object convertToDatabaseColumn(Address attribute) {
        inject();
        try {
            PGobject out = new PGobject();
            out.setType("json");
            out.setValue(serializationAPI.toJson(attribute));
            return out;
        } catch (SQLException ex) {
            throw new IllegalArgumentException("Cannot convert " + attribute + " to JSON", ex);
        }
    }

    @Override
    public Address convertToEntityAttribute(Object dbData) {
        inject();
        if (dbData != null) {
            return serializationAPI.entityFromJson(dbData.toString(), metadata.getClass(Address.class));
        } else {
            return null;
        }
    }
}
