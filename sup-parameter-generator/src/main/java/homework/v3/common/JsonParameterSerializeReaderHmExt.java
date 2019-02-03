package homework.v3.common;


import homework.v3.entityext.JsonFileClassExt;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class JsonParameterSerializeReaderHmExt {

    public JsonFileClassExt customSerializeReader(String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fos = new FileInputStream(filename)){
            try (ObjectInputStream oos = new ObjectInputStream(fos)){
                return (JsonFileClassExt)oos.readObject();
            }
        }

    }

}