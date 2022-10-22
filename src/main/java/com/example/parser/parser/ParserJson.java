package com.example.parser.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserJson extends Parser {

    public ParserJson(String filename) {
        super(filename);
    }

    @Override
    protected String parse(FileReader input) throws IOException {
        BufferedReader bReader = new BufferedReader(input);
        String json;
        ArrayList<String> listProducts = new ArrayList<>();
        while ((json = bReader.readLine()) != null) {
            listProducts.add(json);
        }
        bReader.close();

        return conversionString(listProducts);
    }

    public String conversionString(List<String> list) throws IOException {
        StringBuilder result = new StringBuilder();
        for (String s : list) {
            result.append(s);
        }

        return result.toString();
    }
}

