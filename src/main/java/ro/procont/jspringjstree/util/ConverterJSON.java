package ro.procont.jspringjstree.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverterJSON {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> String toJsonToString(List<T> list) throws JsonProcessingException {
    	String str = mapper.writeValueAsString(list);
    	System.out.println("--> ConverterJSON toJsonToString(List<T>: " + str);
        return str;
    }
}
