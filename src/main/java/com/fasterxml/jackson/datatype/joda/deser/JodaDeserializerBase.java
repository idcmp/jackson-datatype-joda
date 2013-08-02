package com.fasterxml.jackson.datatype.joda.deser;

import java.io.IOException;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;

abstract class JodaDeserializerBase<T> extends StdScalarDeserializer<T> {

    protected final DateTimeFormatter dateTimeFormatter;

    protected JodaDeserializerBase(Class<T> cls) {
        this(cls, ISODateTimeFormat.dateTimeParser());
    }

    protected JodaDeserializerBase(Class<T> cls, DateTimeFormatter dateTimeFormatter) {
        super(cls);
        this.dateTimeFormatter = dateTimeFormatter;
    }

    @Override
    public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException {
        return typeDeserializer.deserializeTypedFromAny(jp, ctxt);
    }
}
