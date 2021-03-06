package com.flock.app.serializer.space;

import com.atlassian.confluence.spaces.Space;
import com.flock.app.serializer.CommonSerializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class SpaceAdapter implements JsonSerializer<Space> {
    @Override
    public JsonElement serialize(Space space, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", space.getName());
        jsonObject.addProperty("key", space.getKey());
        jsonObject.addProperty("lowerKey", space.getLowerKey());
        jsonObject.addProperty("spaceType", space.getSpaceType().toString());
        jsonObject.addProperty("spaceStatus", space.getSpaceStatus().name());
        jsonObject.addProperty("description", space.getDescription().getDisplayTitle());
        CommonSerializer.serialize(jsonObject, space, jsonSerializationContext);
        return jsonObject;
    }
}
