package homework.v3;

import homework.v3.common.JsonParameterReaderHm;
import homework.v3.common.JsonParameterSerializeReaderHm;
import homework.v3.common.JsonParameterSerializeWriterHm;
import homework.v3.entity.JsonFileClass;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FileWork {
    public void WriteToFileJson(JsonFileClass jc, String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Записываем данные в файл " + fileName);
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), jc);
        System.out.println("Данные записаны на диск в файл " + fileName);
        System.out.println("\n");
    }

    public JsonFileClass ReadObject(String fileName) throws IOException {
        JsonParameterReaderHm service = new JsonParameterReaderHm();
        JsonFileClass business = null;
        System.out.println("Значение business: " + business);
        System.out.println("Считываем данные из файла " + fileName);
        business = service.read(fileName);
        System.out.println("Данные считаны:");
        System.out.println(business);
        System.out.println("\n");
        return business;
    }

    public void WriteObjectToSer(JsonFileClass business, String fileName) throws IOException {
        JsonParameterSerializeWriterHm mySerializer = new JsonParameterSerializeWriterHm();
        System.out.println("Записываем данные в файла " + fileName);
        mySerializer.customSerializeWriter(business, fileName);
        System.out.println("Данные записаны на диск в файл " + fileName);
        System.out.println("\n");
    }

    public JsonFileClass ReadObjectFromSer(String fileName) throws IOException, ClassNotFoundException {
        JsonFileClass business = null;
        System.out.println("Значение business: " + business);
        JsonParameterSerializeReaderHm myReader = new JsonParameterSerializeReaderHm();
        System.out.println("Считываем данные из файла " + fileName);
        business = myReader.customSerializeReader(fileName);
        System.out.println("Данные считаны с диска из файл " + fileName);
        System.out.println("Значение business: " + business);
        System.out.println("\n");
        return business;
    }
}
