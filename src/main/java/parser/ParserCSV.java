package parser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import model.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParserCSV extends Parser {

    public ParserCSV(String filename) {
        super(filename);
    }

    @Override
    protected List<String[]> parse(BufferedReader input) throws CsvValidationException, IOException {
        List<String[]> list = new ArrayList<>();
        String str = "";
        CSVReader reader = new CSVReader(input);
        String[] line;
        while ((line = reader.readNext()) != null) {
            list.add(line);
        }
    return list;
    }
}
