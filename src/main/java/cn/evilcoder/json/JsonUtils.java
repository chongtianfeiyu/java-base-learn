package cn.evilcoder.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

/**
 * Created by huangshanqi on 2016/6/20.
 * 利用jackson的序列化以及反序列
 */
public class JsonUtils {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        JsonUtils.objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        JsonUtils.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonUtils.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private static final ObjectWriter writer = JsonUtils.objectMapper.writer();
    private static final ObjectWriter prettyWriter = JsonUtils.objectMapper.writerWithDefaultPrettyPrinter();

    public static String toJsonPrettyString(Object value) throws JsonProcessingException {
        return JsonUtils.prettyWriter.writeValueAsString(value);
    }

    public static String toJsonString(Object value) {
        try {
            return JsonUtils.writer.writeValueAsString(value);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Returns the deserialized object from the given json string and target class; or null if the given json string is
     * null.
     */
    public static <T> T fromJsonString(String json, Class<T> clazz) {
        if (json == null) {
            return null;
        }
        try {
            return JsonUtils.objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            logger.info("Unable to parse Json String", e);
            return null;
        }
    }

    public static JsonNode jsonNodeOf(String json) {
        return JsonUtils.fromJsonString(json, JsonNode.class);
    }

    public static JsonGenerator jsonGeneratorOf(Writer writer) throws IOException {
        return new JsonFactory().createGenerator(writer);
    }

    public static <T> T loadFrom(File file, Class<T> clazz) throws IOException {
        try {
            return JsonUtils.objectMapper.readValue(file, clazz);
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static void load(InputStream input, Object obj) throws IOException, JsonProcessingException {
        objectMapper.readerForUpdating(obj).readValue(input);
    }

    public static <T> T loadFrom(InputStream input, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {
        return JsonUtils.objectMapper.readValue(input, clazz);
    }

    public static ObjectMapper getObjectMapper() {
        return JsonUtils.objectMapper;
    }

    public static ObjectWriter getWriter() {
        return JsonUtils.writer;
    }

    public static ObjectWriter getPrettywriter() {
        return JsonUtils.prettyWriter;
    }
}
