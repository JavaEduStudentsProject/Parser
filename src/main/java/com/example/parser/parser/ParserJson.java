package com.example.parser.parser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserJson extends Parser {

    private ObjectMapper jsonMapper;

    public ParserJson(String filename) {
        super(filename);
    }

    @Override
    protected String parse(FileReader input) throws IOException {
        System.out.println("json, проверка фабрики");



        BufferedReader bReader = new BufferedReader(input);
        ObjectMapper oMapper = new ObjectMapper();
        String json;
        ArrayList<String> listProducts = new ArrayList<>();
        while ((json = bReader.readLine()) != null) {
            System.out.println(json);
            listProducts.add(json);
            //listProducts.add(oMapper.readValue(json, String.class));
        }
        bReader.close();
        System.out.println("прочитано из файла");
        System.out.println("*************************");
        System.out.println(conversionString(listProducts));
        System.out.println("*************************");
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

//
//        String data = input.lines().collect(Collectors.joining());
//
//        System.out.println(data);
//
//        Gson g = new Gson();
//        Product product = g.fromJson(data, Product.class);
//
//        System.out.println(product.getName());
//        System.out.println(product.getPrice());


//        Object json;
//
//        json = new JSONTokener(data).nextValue();
//        if (json instanceof JSONObject) { //json with single object-order
//            return null;
//        } else if (json instanceof JSONArray) { //json with array of orders
//            List<String[]> array;
//            try {
//               return array = jsonMapper.readValue(data, new TypeReference<List<String[]>>(){});
//            } catch (Exception e) {
//                System.out.println("exc");
//            }
//        } else { //strange content
//            System.out.println(JSON_IS_INVALID);
//        }
//        return null;
// return null;
// }

