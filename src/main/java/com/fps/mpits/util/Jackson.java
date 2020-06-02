package com.fps.mpits.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fps.mpits.exception.InternalServerException;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * @author HieuDT28 (Hiếu Boy) - 19/05/2020
 */

public class Jackson {
    private static Jackson instance = new Jackson();

    private Jackson() {

    }

    public static Jackson getInstance() {
        return instance;
    }

    public String object2String(Object objInput) {
        return object2String(objInput, null, null, null);
    }

    public String object2String(Object objInput, String sFilterId, String[] arrFilterOutAllExcept,
                                String[] arrSerializeAllExcept) {
        String sRet = null;
        try {
            if (objInput != null)
                sRet = getObjectWriter(sFilterId, arrFilterOutAllExcept, arrSerializeAllExcept)
                        .writeValueAsString(objInput);
        } catch (JsonProcessingException e) {
            throw new InternalServerException(Common.getStackTrace(e));
        }
        return sRet;
    }

    public <T> T string2Object(String sInput, Class<T> clazz) {
        T objRet = null;
        try {
            if (!StringUtils.isEmpty(sInput)) objRet = getObjectMapper().readValue(sInput, clazz);
        } catch (IOException e) {
            throw new InternalServerException(Common.getStackTrace(e));
        }
        return objRet;
    }

    private ObjectMapper getObjectMapper() {
        ObjectMapper omMap = new ObjectMapper();
        omMap.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        omMap.setAnnotationIntrospector(new JacksonAnnotationIntrospector() {
            private static final long serialVersionUID = 1L;

            @Override
            public Object findFilterId(Annotated a) {
                return null;
            }
        });
        return omMap;
    }

    private ObjectWriter getObjectWriter(String sFilterId, String[] arrFilterOutAllExcept,
                                         String[] arrSerializeAllExcept) {
        ObjectMapper omMap = new ObjectMapper();
        omMap.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        if (!StringUtils.isEmpty(sFilterId)) {
            if (arrFilterOutAllExcept != null && arrFilterOutAllExcept.length > 0) {
                SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter
                        .filterOutAllExcept(arrFilterOutAllExcept);
                FilterProvider filterProvider = new SimpleFilterProvider().addFilter(sFilterId,
                        simpleBeanPropertyFilter);
                return omMap.writer(filterProvider);
            }
            if (arrSerializeAllExcept != null && arrSerializeAllExcept.length > 0) {
                SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter
                        .serializeAllExcept(arrSerializeAllExcept);
                FilterProvider filterProvider = new SimpleFilterProvider().addFilter(sFilterId,
                        simpleBeanPropertyFilter);
                return omMap.writer(filterProvider);
            }
        }
        omMap.setAnnotationIntrospector(new JacksonAnnotationIntrospector() {
            private static final long serialVersionUID = 1L;

            @Override
            public Object findFilterId(Annotated a) {
                return null;
            }
        });
        return omMap.writer(new SimpleFilterProvider());
    }

}
