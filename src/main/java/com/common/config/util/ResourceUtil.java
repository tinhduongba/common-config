package com.common.config.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class ResourceUtil {
    public static ObjectMapper mapper = new ObjectMapper();
    public static Map<String, Map<String, String>> dataMaps = new HashMap<>();

    public static Map<String, String> getDataMap(String dataType, String language) {
        if (dataMaps.containsKey(dataType + "." + language)) {
            return dataMaps.get(language);
        }

        ClassLoader classLoader = ResourceUtil.class.getClassLoader();
        InputStream inputStream =
                classLoader.getResourceAsStream("language/" + dataType + "." + language + ".json");
        if (inputStream == null) {
            return dataMaps.getOrDefault(dataType + ".en", new HashMap<>());
        }

        Map<String, String> data;
        try {
            data = mapper.readValue(new InputStreamReader(inputStream), new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        dataMaps.put(language, data);
        return data;
    }

    public static String getMessage(String language, String key, Object ...arg) {
        Map<String, String> dataMap = getDataMap("message", language);

        return MessageFormat.format(dataMap.getOrDefault(key, key), arg);
    }
}
