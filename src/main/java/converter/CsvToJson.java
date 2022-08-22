//package converter;
//
//import com.fasterxml.classmate.GenericType;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.csv.CsvMapper;
//import com.fasterxml.jackson.dataformat.csv.CsvParser;
//import com.fasterxml.jackson.dataformat.csv.CsvSchema;
//import com.google.gson.Gson;
//import com.mongodb.client.model.geojson.Point;
//import model.Product;
//
//import java.io.File;
//import java.util.List;
//import java.util.Map;
//
//    public class CsvToJson {
//
//        public static void main(String[] args) throws Exception {
//
//
//            File input = new File("file3.csv");
//            CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
//            CsvMapper csvMapper = new CsvMapper();
//
//            // Reading the data from CSV file
//            List<Object> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(input).readAll();
//
//            ObjectMapper mapper = new ObjectMapper();
//
//            // Writing the JSON formated data to mydata.json file
//            File output = new File("mydata.json");
//            mapper.writerWithDefaultPrettyPrinter().writeValue(output, readAll);
//
//            // Writing the JSON formated data to output console
//            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(readAll));
//
//        }
//    }
