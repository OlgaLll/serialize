package homework.v3.common;

import homework.v3.entityext.JsonFileClassExt;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class JsonParameterSerializeWriterHmExt {

    public void customSerializeWriter(JsonFileClassExt parameters, String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(fos);) {
                oos.writeObject(parameters);
            }
        }
    }
}
