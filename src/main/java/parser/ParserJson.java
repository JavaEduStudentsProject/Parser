//package parser;
//
package parser;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileReader;
import java.util.List;

public class ParserJson extends Parser {

    private ObjectMapper jsonMapper;

    public ParserJson(String filename) {
        super(filename);
    }

    @Override
    protected String parse(FileReader input) {
        System.out.println("json, проверка фабрики");
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.FileReader;
//import java.util.List;
//
//public class ParserJson extends Parser {
//
//    private ObjectMapper jsonMapper;
//
//    public ParserJson(String filename) {
//        super(filename);
//    }
//
//    @Override
//    protected List<String> parse(FileReader input) {
//        System.out.println("json, проверка фабрики");
////
////        String data = input.lines().collect(Collectors.joining());
////
////        System.out.println(data);
////
////        Gson g = new Gson();
////        Product product = g.fromJson(data, Product.class);
////
////        System.out.println(product.getName());
////        System.out.println(product.getPrice());
//
//
////        Object json;
////
////        json = new JSONTokener(data).nextValue();
////        if (json instanceof JSONObject) { //json with single object-order
////            return null;
////        } else if (json instanceof JSONArray) { //json with array of orders
////            List<String[]> array;
////            try {
////               return array = jsonMapper.readValue(data, new TypeReference<List<String[]>>(){});
////            } catch (Exception e) {
////                System.out.println("exc");
////            }
////        } else { //strange content
////            System.out.println(JSON_IS_INVALID);
////        }
////        return null;
//        return null;
//    }
//}
