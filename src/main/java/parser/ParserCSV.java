package parser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.BufferedReader;
import java.io.FileReader;
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
       } catch (IOException e) {
           throw new RuntimeException(e);
       } catch (CsvException e) {
           throw new RuntimeException(e);
       }

       if(result.size() > 0) {
           String oldLastString = result.get(result.size()-1);
           String newLastString = oldLastString.substring(0,oldLastString.length()-2);
           result.remove(result.size()-1);
           result.add(newLastString);
       }
        return result;
    }

    private String csvToJson(String[] header, String[] values) {
        String result = "{\n";
        for (int i = 0; i < header.length; i++) {
            result += "\"" + header[i] + "\"" + " : " + "\"" + values[i] + "\"" + ",\n";
        }
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
}
