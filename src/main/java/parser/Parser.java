package parser;

import com.opencsv.exceptions.CsvValidationException;
import model.Product;
import org.yaml.snakeyaml.parser.ParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class Parser {

    public static final String FILE_NOT_FOUND = "Файл не найден";
    public static final String FILE_IS_EMPTY = "Файл пуст";

    protected final String filename;

    public Parser(String filename) {
        this.filename = filename;
    }

    public List<String[]> execute() {
        try (BufferedReader input = Files.newBufferedReader(Paths.get(filename))) {
            return parse(input);
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(FILE_NOT_FOUND);
        }
    }

    protected abstract List<String[]> parse(BufferedReader input) throws IOException, CsvValidationException;

}
