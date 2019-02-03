package homework.v3.common;

import homework.v3.entity.JsonFileClass;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonParameterReaderHm {

    public JsonFileClass read(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonFileClass jfc = mapper.readValue(new File(url), JsonFileClass.class);
        return jfc;
    }

}
