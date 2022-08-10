package parser;

import com.google.gson.Gson;
import model.Root;
import java.io.FileReader;


// в чем смысл библиотеки- умеют автоматически взять джейсон и закинуть из него все данные в наши объекты
//gson основана на рефлексии. анализирует объект и сопоставляет
//Если все поля совпадают то он сам создаст объекты, лист и тд
public class GsonParser {
    public Root parse() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("test.json")) {
            Root root = gson.fromJson(reader, Root.class);
            return root;
        } catch (Exception e) {
            System.out.println("Parsing error  " + e.toString());
        }
        return null;
    }
}

