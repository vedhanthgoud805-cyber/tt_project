package com.prescripto.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonConverters {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Converter
    public static class MapConverter implements AttributeConverter<Map<String, Object>, String> {
        @Override
        public String convertToDatabaseColumn(Map<String, Object> attribute) {
            if (attribute == null) {
                return "{}";
            }
            try {
                return objectMapper.writeValueAsString(attribute);
            } catch (Exception e) {
                return "{}";
            }
        }

        @Override
        public Map<String, Object> convertToEntityAttribute(String dbData) {
            if (dbData == null || dbData.trim().isEmpty()) {
                return new HashMap<>();
            }
            try {
                return objectMapper.readValue(dbData, new TypeReference<Map<String, Object>>() {});
            } catch (Exception e) {
                return new HashMap<>();
            }
        }
    }

    @Converter
    public static class AddressConverter implements AttributeConverter<Map<String, String>, String> {
        @Override
        public String convertToDatabaseColumn(Map<String, String> attribute) {
            if (attribute == null) {
                Map<String, String> defaultAddress = new HashMap<>();
                defaultAddress.put("line1", "");
                defaultAddress.put("line2", "");
                try {
                    return objectMapper.writeValueAsString(defaultAddress);
                } catch (Exception e) {
                    return "{\"line1\":\"\",\"line2\":\"\"}";
                }
            }
            try {
                return objectMapper.writeValueAsString(attribute);
            } catch (Exception e) {
                return "{\"line1\":\"\",\"line2\":\"\"}";
            }
        }

        @Override
        public Map<String, String> convertToEntityAttribute(String dbData) {
            Map<String, String> defaultAddress = new HashMap<>();
            defaultAddress.put("line1", "");
            defaultAddress.put("line2", "");
            if (dbData == null || dbData.trim().isEmpty()) {
                return defaultAddress;
            }
            try {
                Map<String, String> result = objectMapper.readValue(dbData, new TypeReference<Map<String, String>>() {});
                if (!result.containsKey("line1")) result.put("line1", "");
                if (!result.containsKey("line2")) result.put("line2", "");
                return result;
            } catch (Exception e) {
                return defaultAddress;
            }
        }
    }

    @Converter
    public static class SlotsBookedConverter implements AttributeConverter<Map<String, List<String>>, String> {
        @Override
        public String convertToDatabaseColumn(Map<String, List<String>> attribute) {
            if (attribute == null) {
                return "{}";
            }
            try {
                return objectMapper.writeValueAsString(attribute);
            } catch (Exception e) {
                return "{}";
            }
        }

        @Override
        public Map<String, List<String>> convertToEntityAttribute(String dbData) {
            if (dbData == null || dbData.trim().isEmpty()) {
                return new HashMap<>();
            }
            try {
                return objectMapper.readValue(dbData, new TypeReference<Map<String, List<String>>>() {});
            } catch (Exception e) {
                return new HashMap<>();
            }
        }
    }
}
