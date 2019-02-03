package homework.v3;

import homework.v3.common.JsonParameterReaderHmExt;
import homework.v3.common.JsonParameterSerializeReaderHmExt;
import homework.v3.common.JsonParameterSerializeWriterHmExt;
import homework.v3.entityext.JsonFileClassExt;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FileWorkExt {
    public void WriteToFileJson(JsonFileClassExt jc, String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Записываем данные в файл " + fileName);
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), jc);
        System.out.println("Данные записаны на диск в файл " + fileName);
        System.out.println("\n");
    }

    public JsonFileClassExt ReadObject(String fileName) throws IOException {
        JsonParameterReaderHmExt service = new JsonParameterReaderHmExt();
        JsonFileClassExt business = null;
        System.out.println("Значение business: " + business);
        System.out.println("Считываем данные из файла " + fileName);
        business = service.read(fileName);
        System.out.println("Данные считаны:");
        System.out.println(business);
        System.out.println("\n");
        return business;
    }

    public void WriteObjectToSer(JsonFileClassExt business, String fileName) throws IOException {
        JsonParameterSerializeWriterHmExt mySerializer = new JsonParameterSerializeWriterHmExt();
        System.out.println("Записываем данные в файла " + fileName);
        mySerializer.customSerializeWriter(business, fileName);
        System.out.println("Данные записаны на диск в файл " + fileName);
        System.out.println("\n");
    }

    public JsonFileClassExt ReadObjectFromSer(String fileName) throws IOException, ClassNotFoundException {
        JsonFileClassExt business = null;
        System.out.println("Значение business: " + business);
        JsonParameterSerializeReaderHmExt myReader = new JsonParameterSerializeReaderHmExt();
        System.out.println("Считываем данные из файла " + fileName);
        business = myReader.customSerializeReader(fileName);
        System.out.println("Данные считаны с диска из файл " + fileName);
        System.out.println("Значение business: " + business);
        System.out.println("\n");
        return business;
    }
}
