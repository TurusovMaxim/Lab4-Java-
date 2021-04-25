import modals.Person;

import java.util.List;

public class Main {
    private static final String pathToFile = "./src/main/resources/foreign_names.csv";

    public static void main(String[] args) throws Exception {
        ReadForeignNames foreignNames = new ReadForeignNames();

        List<Person> result = foreignNames.openForeignNames(pathToFile);

        /*for (Person person : result) {
            System.out.println(person.getName());
        }*/
    }
}
