package com.fasterxml.jackson.datatype.joda.ser;

import java.io.IOException;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

abstract class JodaSerializerBase<T> extends StdSerializer<T>
{
    protected final DateTimeFormatter dateTimeFormatter;

    protected JodaSerializerBase(Class<T> cls) { this(cls, ISODateTimeFormat.dateTimeParser()); }

    protected JodaSerializerBase(Class<T> cls, DateTimeFormatter dateTimeFormatter) {
        super(cls);
        this.dateTimeFormatter = dateTimeFormatter;
    }

    @Override
    public void serializeWithType(T value, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer) throws IOException, JsonProcessingException {
        typeSer.writeTypePrefixForScalar(value, jgen);
        serialize(value, jgen, provider);
        typeSer.writeTypeSuffixForScalar(value, jgen);
    }




}
