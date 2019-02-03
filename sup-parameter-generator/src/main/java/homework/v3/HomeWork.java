package homework.v3;


import homework.v3.entity.JsonFileClass;
import homework.v3.entityext.JsonFileClassExt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Задание
 * 1) Составить файл с JSON-объектом, который "разложен" в пакете homework.v3.entity.
 * Определить какой элемент является корневым
 * Дать имя файлу homework.parameters.json
 * 2) Заполнить его значениями (как пример "parameters.v1.json")
 * 3) Считать получившийся homework.parameters.json в память
 * 4) Сериализовать его с помощью встроенного механиза сериализации в файл с именем homework.parameters.ser
 * 5) Сериализовать его с использованием интерфейса Externalizable в файл с именем homework.parameters.exter
 * 6) Считать данные из файла homework.parameters.ser в память и сохранить в формате JSON в файл с именем homework.result.ser.parameters.json
 * 7) Считать данные из файла homework.parameters.exter в память и сохранить в формате JSON в файл с именем homework.result.exter.parameters.json
 * 8) Убедиться, что файлы homework.result.ser.parameters.json и  homework.result.exter.parameters.json
 * совпадают с homework.parameters.json
 * */

public class HomeWork {
    public static final String FILE_INPUT_HM_JSON = "homework.parameters.json";
    public static final String FILE_OUTPUT_HM_JSON = "homework.result.ser.parameters.json";
    public static final String TEMP_HM_OUT = "homework.parameters.ser";

    public static final String FILE_INPUT_HM_JSON_EXT = "homework.parameters.exter.json";
    public static final String FILE_OUTPUT_HM_JSON_EXT = "homework.result.exter.parameters.json";
    public static final String TEMP_HM_OUT_EXT = "homework.parameters.exter";

    public static void main (String[] args) throws IOException, ClassNotFoundException {
        //Serializable--------------------------------------------------------------------------------------------------
        JsonFileClass jc = new MakeObject().makeObject(5);
        //1) Составить файл с JSON-объектом, который "разложен" в пакете homework.v3.entity.
        //* Определить какой элемент является корневым
        //* Дать имя файлу homework.parameters.json
        //2) Заполнить его значениями (как пример "parameters.v1.json")
        FileWork fw = new FileWork();
        fw.WriteToFileJson(jc, FILE_INPUT_HM_JSON);
        //3) Считать получившийся homework.parameters.json в память
        JsonFileClass jfcRead = fw.ReadObject(FILE_INPUT_HM_JSON);
        //4) Сериализовать его с помощью встроенного механиза сериализации в файл с именем homework.parameters.ser
        fw.WriteObjectToSer(jfcRead, TEMP_HM_OUT);
        //6) Считать данные из файла homework.parameters.ser в память и сохранить в формате JSON в файл с именем homework.result.ser.parameters.json
        JsonFileClass jfcReadSer = fw.ReadObjectFromSer(TEMP_HM_OUT);
        fw.WriteToFileJson(jfcReadSer, FILE_OUTPUT_HM_JSON);

        //Externalizable---------------------------------------------------------------------
        JsonFileClassExt jcExt = new MakeObjectExt().makeObject(5);
        FileWorkExt fwExt = new FileWorkExt();
        fwExt.WriteToFileJson(jcExt, FILE_INPUT_HM_JSON_EXT);
        JsonFileClassExt jfcReadExt = fwExt.ReadObject(FILE_INPUT_HM_JSON_EXT);
        //5) Сериализовать его с использованием интерфейса Externalizable в файл с именем homework.parameters.exte
        fwExt.WriteObjectToSer(jfcReadExt, TEMP_HM_OUT_EXT);
        //7) Считать данные из файла homework.parameters.exter в память и сохранить в формате JSON в файл с именем homework.result.exter.parameters.json
        JsonFileClassExt jfcReadSerExt = fwExt.ReadObjectFromSer(TEMP_HM_OUT_EXT);
        fwExt.WriteToFileJson(jfcReadSerExt, FILE_OUTPUT_HM_JSON_EXT);

        //-----------------------------------------------------------------------------------
        //8) Убедиться, что файлы homework.result.ser.parameters.json и  homework.result.exter.parameters.json
        //совпадают с homework.parameters.json
        ArrayList<String> jsonFileSer = getArrayListFromFile(FILE_INPUT_HM_JSON);
        ArrayList<String> jsonFileExt = getArrayListFromFile(FILE_INPUT_HM_JSON_EXT);
        ArrayList<String> jsonFileOutputSer = getArrayListFromFile(FILE_OUTPUT_HM_JSON);
        ArrayList<String> jsonFileOutputExt = getArrayListFromFile(FILE_OUTPUT_HM_JSON_EXT);
        if (jsonFileSer.equals(jsonFileExt)&jsonFileSer.equals(jsonFileOutputSer)&jsonFileSer.equals(jsonFileOutputExt)) {
            System.out.println("Файлы совпадают");
        }
        else {
            System.out.println("Файлы не совпадают");
        }
    }

    private static ArrayList<String> getArrayListFromFile(String fileName) throws IOException {
        ArrayList<String> arrayList = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String sCurrentLine;
        while ((sCurrentLine = bufferedReader.readLine()) != null) {
            arrayList.add(sCurrentLine);
        }
        bufferedReader.close();
        return arrayList;
    }
}
