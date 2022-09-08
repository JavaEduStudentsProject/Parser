package parser;

import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.List;

public abstract class Parser {

    public static final String FILE_NOT_FOUND = "Файл не найден";
    public static final String FILE_IS_EMPTY = "Файл пуст";

    protected final String filename;

    public Parser(String filename) {
        this.filename = filename;
    }

    public String execute() throws IOException, CsvValidationException {
//        try (BufferedReader input = Files.newBufferedReader(Paths.get(filename))) {
//            return parse(input);
//        } catch (IOException | CsvValidationException e) {
//            throw new RuntimeException(FILE_NOT_FOUND);
//        }
        FileReader reader = new FileReader(filename);
        return parse(reader);
    }

    protected abstract String parse(FileReader reader) throws IOException, CsvValidationException;

}
