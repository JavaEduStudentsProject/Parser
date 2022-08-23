package parser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ParserCSV extends Parser {

    public ParserCSV(String filename) {
        super(filename);
    }

    private static Map<String, String> headers = new HashMap<>() {{
        put("Имя", "name");
        put("Цена", "price");
        put("Стоимость", "price");
    }};


    @Override
    protected List<String> parse(FileReader input) throws IOException {
        List<String> result = new ArrayList<>();
       try(CSVReader reader = new CSVReader(input)) {
           List<String[]> r = reader.readAll();
           String[] header = r.get(0);
           header = replaceHeader(header);
           for (int i = 1; i < r.size(); i++) {
               result.add(csvToJson(header, r.get(i)));
           }
       } catch (IOException | CsvException e) {
           throw new RuntimeException(e);
       }
        if(result.size() > 0) {
           String oldLastString = result.get(result.size()-1);
           String newLastString = oldLastString.substring(0,oldLastString.length()-2);
           result.remove(result.size()-1);
           result.add(newLastString);
       }
        saveToJson(result);
        return result;
    }

    private String csvToJson(String[] header, String[] values) {
        String tmpH = null;
        String tmpV = null;
        String tmpH2 = null;
        String tmpV2 = null;
        for (int i = 0; i < header.length; i++) {
            if(header[i].equals("name")) {
                tmpH = header[0];
                header[0] = header[i];
                header[i] = tmpH;
                tmpV = values[0];
                values[0] = values[i];
                values[i] = tmpV;
            } else if
            (header[i].equals("price")) {
                tmpH2 = header[1];
                header[1] = header[i];
                header[i] = tmpH2;
                tmpV2 = values[1];
                values[1] = values[i];
                values[i] = tmpV2;
            }
        }
        String result = "{\n";
        String props = "\"" + "properties" + "\"" + " : " + "[" + "\n";
        String result2 = "{\n";
        for (int i = 0; i < 2; i++) {
            result += "\"" + header[i] + "\"" + " : " + "\"" + values[i] + "\"" + ",\n";
        }
        for (int i = 2; i < header.length; i++) {
            if (header[i] == header[header.length-1]) {
                result2 += "\"" + header[i] + "\"" + " : " + "\"" + values[i] + "\"" + "\n";
            } else {
                result2 += "\"" + header[i] + "\"" + " : " + "\"" + values[i] + "\"" + ",\n";
            }
        }
        result2+= "}]\n";
        result +=props + result2;
        result+= "},\n";
        return result;
    }

    private String[] replaceHeader(String[] header) {
        for (int i = 0; i < header.length; i++) {
            if(headers.containsKey(header[i]))
                header[i] = headers.get(header[i]);
        }
        return header;
    }

    public void saveToJson(List<String> list) throws IOException {
        FileWriter writer = new FileWriter("mydata.json");
        for (int i = 0; i < list.size(); i++) {
            writer.write(list.get(i));
        }
        writer.close();
    }
}
