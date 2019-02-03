package homework.v3.common;

import homework.v3.entityext.JsonFileClassExt;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonParameterReaderHmExt {

    public JsonFileClassExt read(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonFileClassExt jfc = mapper.readValue(new File(url), JsonFileClassExt.class);
        return jfc;
    }

}