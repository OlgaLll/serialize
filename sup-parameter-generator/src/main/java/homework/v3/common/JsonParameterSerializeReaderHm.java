package homework.v3.common;

import homework.v3.entity.JsonFileClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class JsonParameterSerializeReaderHm {

    public JsonFileClass customSerializeReader(String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fos = new FileInputStream(filename)){
            try (ObjectInputStream oos = new ObjectInputStream(fos)){
                return (JsonFileClass)oos.readObject();
            }
        }

    }

}
