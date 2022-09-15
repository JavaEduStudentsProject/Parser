package com.example.parser.parser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Slf4j
public class ParserCSV extends Parser {

    public ParserCSV(String filename) {
        super(filename);
    }

    private static Map<String, String> headers = new HashMap<>() {{
        put("Имя", "title");
        put("name", "title");
        put("Цена", "price");
        put("Стоимость", "price");
    }};


    @Override
    protected String parse(FileReader input) throws IOException {
        List<String> result = new ArrayList<>();
        try (CSVReader reader = new CSVReader(input)) {
            List<String[]> r = reader.readAll();
            log.info("Read CSV file");
            String[] header = r.get(0);
            header = replaceHeader(header);
            for (int i = 1; i < r.size(); i++) {
                result.add(csvToJson(header, r.get(i)));
            }
            log.info("File parse");
        } catch (IOException | CsvException e) {
            log.error("Exception" + e);
            throw new RuntimeException(e);

        }
        if (result.size() > 0) {
            String oldLastString = result.get(result.size() - 1);
            String newLastString = oldLastString.substring(0, oldLastString.length() - 2);
            result.remove(result.size() - 1);
            result.add(newLastString);
        }
        return conversionString(result);
    }


    private void changeOrder(int i, int number, String[] header, String[] values) {
        String tmpH, tmpV;
        tmpH = header[number];
        header[number] = header[i];
        header[i] = tmpH;
        tmpV = values[number];
        values[number] = values[i];
        values[i] = tmpV;
    }

    private String csvToJson(String[] header, String[] values) {
        for (int i = 0; i < header.length; i++) {
            if (header[i].equals("title")) {
                changeOrder(i, 1, header, values);
            } else if
            (header[i].equals("id")) {
                changeOrder(i, 0, header, values);
            } else if
            (header[i].equals("price")) {
                changeOrder(i, 3, header, values);
            } else if (header[i].equals("category")) {
                changeOrder(i, 2, header, values);
            } else if (header[i].equals("description")) {
                changeOrder(i, 4, header, values);
            } else if (header[i].equals("image")) {
                changeOrder(i, 5, header, values);
            }
        }
        String result = "{\n";
        String props = "\"" + "filter_features" + "\"" + " : " + "[" + "\n";
        String result2 = "{\n";
        for (int i = 0; i < 6; i++) {
            result += "\"" + header[i] + "\"" + " : " + "\"" + values[i] + "\"" + ",\n";
        }
        for (int i = 6; i < header.length; i++) {
            if (header[i] == header[header.length - 1]) {
                result2 += "\"" + header[i] + "\"" + " : " + "\"" + values[i] + "\"" + "\n";
            } else {
                result2 += "\"" + header[i] + "\"" + " : " + "\"" + values[i] + "\"" + ",\n";
            }
        }
        result2 += "}]\n";
        result += props + result2;
        result += "},\n";
        return result;

    }

    private String[] replaceHeader(String[] header) {
        for (int i = 0; i < header.length; i++) {
            if (headers.containsKey(header[i]))
                header[i] = headers.get(header[i]);
        }
        log.info("Replace name's header from map of headers");
        return header;

    }

    public String conversionString(List<String> list) throws IOException {
        StringBuilder result = new StringBuilder();
        for (String s : list) {
            result.append(s);
        }
        log.info("Create String from Arraylist");
        return result.toString();
    }
}
