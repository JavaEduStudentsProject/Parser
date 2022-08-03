package src.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class Parser {
    public static final String FILE_NOT_FOUND = "Файл не найден";
    public static final String FILE_IS_EMPTY = "Файл пуст";

    protected final String filename;

    public Parser(String filename) {
        this.filename = filename;
    }

//    public List<Product> execute() {
//        try (BufferedReader input = Files.newBufferedReader(Paths.get(filename))) {
//            return parse(input);
//        } catch (IOException e) {
//            throw new ParserException(FILE_NOT_FOUND);
//        }
//    }

//    protected abstract List<Product> parse(BufferedReader input);

}
