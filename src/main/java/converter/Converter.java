package converter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter {

    private static class SingletonHolder {
        private static final Converter INSTANCE = new Converter();
    }
    private ObjectMapper jsonMapper;
    private Converter() {

        jsonMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
    public static Converter getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
