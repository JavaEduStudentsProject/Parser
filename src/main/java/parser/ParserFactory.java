package parser;

import org.yaml.snakeyaml.parser.ParserException;

import java.io.InputStream;
import java.util.Properties;

public class ParserFactory {

    public static final String PROPERTIES_FILENAME = "parsers.properties";
    public static final String UNABLE_TO_LOAD = "Не возможно загрузить ";
    public static final String PARSER_BY_NAME = "- разбор по названию ";
    public static final String FILES_ARE_NOT_SUPPORTED = "- файлы не поддерживаются";
    public static final String FILE_FORMAT_NOT_SPECIFIED = "Формат файла не указан";
    private Properties parsers;

    private static class SingletonHolder {
        private static final ParserFactory INSTANCE = new ParserFactory();
    }

    public static ParserFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public ParserFactory() {
        try(InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTIES_FILENAME)) {
            parsers = new Properties();
            parsers.load(in);
        } catch (Exception e) {
            System.out.println(UNABLE_TO_LOAD + PROPERTIES_FILENAME);
        }
    }

    public Parser getParserByFileName(String filename) {
        /** проверяем указан ли формат */
        int dotIndex = filename.lastIndexOf('.');
        if ((dotIndex == -1) || (dotIndex == filename.length()-1)) {
            System.out.println(FILE_FORMAT_NOT_SPECIFIED);
        }

        /** проверяем указан ли поддерживаемый формат */
        String format = filename.substring(dotIndex+1).toUpperCase();
        String className = parsers.getProperty(format);
        if (className == null) {
            System.out.println(format + FILES_ARE_NOT_SUPPORTED);
        }

        Parser parser = null;
        try {
            parser = (Parser) Class.forName(className).getDeclaredConstructor(String.class).newInstance(filename);
        } catch (Exception e) {
            System.out.println(UNABLE_TO_LOAD + format + PARSER_BY_NAME + className);
        }
        return parser;
    }
}
