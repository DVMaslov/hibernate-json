package ru.codeseeker.util;

import com.fasterxml.jackson.databind.JsonNode;
import org.h2.api.JavaObjectSerializer;

public class JsonH2Serializer implements JavaObjectSerializer {

    @Override
    public byte[] serialize(Object obj) throws Exception {
        if (obj instanceof JsonNode) {
            return obj.toString().getBytes();
        }
        return null;
    }

    @Override
    public Object deserialize(byte[] bytes) throws Exception {
        return new String(bytes);
    }
}
