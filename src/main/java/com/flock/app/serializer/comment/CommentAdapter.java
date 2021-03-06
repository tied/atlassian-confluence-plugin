package com.flock.app.serializer.comment;

import com.atlassian.confluence.pages.Comment;
import com.atlassian.confluence.spaces.Space;
import com.flock.app.serializer.CommonSerializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class CommentAdapter implements JsonSerializer<Comment> {

    @Override
    public JsonElement serialize(Comment comment, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("space", jsonSerializationContext.serialize(comment.getSpace(), Space.class));
        jsonObject.addProperty("displayTitle", comment.getDisplayTitle());
        jsonObject.addProperty("urlPath", comment.getUrlPath());
        jsonObject.addProperty("type", comment.getType());
        jsonObject.addProperty("descendantsCount", comment.getDescendantsCount());
        jsonObject.addProperty("depth", comment.getDepth());
        jsonObject.addProperty("threadChangeDate", comment.getThreadChangedDate().getTime());
        jsonObject.addProperty("linkWikiMarkup", comment.getLinkWikiMarkup());
        jsonObject.addProperty("isInlineComment", comment.isInlineComment());
        jsonObject.addProperty("lastModifier", comment.getStatus().getLastModifier());
        jsonObject.addProperty("commentStatus", comment.getStatus().getValue().getStringValue());
        CommonSerializer.serialize(jsonObject, comment, jsonSerializationContext);
        return jsonObject;
    }
}
