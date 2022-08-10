package parser;

import model.People;
import model.Root;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class JsonSimpleParser {
    private static final String TAG_NAME_MAIN = "name";
    private static final String TAG_PEOPLE = "people";
    private static final String TAG_NAME = "name";
    private static final String TAG_AGE = "age";

    public Root parse() {
        Root root = new Root();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("test.json")) {

            JSONObject rootJsonObject = (JSONObject) parser.parse(reader);

            //String name = (String) rootJsonObject.get("name"); это хардкод
            String name = (String) rootJsonObject.get(TAG_NAME_MAIN);
// мы всегда будем знать структуру джейсон, поэтому понимаем где эррей
            JSONArray peopleJsonArray = (JSONArray) rootJsonObject.get(TAG_PEOPLE);


            //  for (JSONObject peopleObject: peopleJsonArray){ требуется приведение типов поэтому
            List<People> peopleList = new ArrayList<>();
            for (Object item : peopleJsonArray) {
                JSONObject peopleJsonObject = (JSONObject) item;
                String namePeople = (String) peopleJsonObject.get(TAG_NAME);
                long age = (Long) peopleJsonObject.get(TAG_AGE);
                People people = new People(namePeople, (int) age);
                peopleList.add(people);
            }
            root.setPeopleList(peopleList);
            root.setName(name);
            return root;
        } catch (Exception e) {
            System.out.println("Parsing error  " + e.toString());
        }
        // parser.parse()
        return null;
    }
}
