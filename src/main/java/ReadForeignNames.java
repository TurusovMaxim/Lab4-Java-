import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import modals.Department;
import modals.Person;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for working with the foreign_names.csv file
 */
public class ReadForeignNames {

    public ReadForeignNames() {
    }

    /**
     * @param pathToFile - the path to foreign_names.csv file.
     * @return - the filled list with employee data.
     * @throws FileNotFoundException - a file opening error.
     *
     * the opencsv library is used to read the file.
     */
    public List<Person> openForeignNames(String pathToFile) throws FileNotFoundException {
        List<Person> employees = new ArrayList<>();
        List<Department> departments = new ArrayList<>();

        FileReader fileReader = new FileReader(pathToFile);

        char separator = ';';

        CSVParser csvParser = new CSVParserBuilder().withSeparator(separator).build(); // custom CSV parser

        try(CSVReader csvReader = new CSVReaderBuilder(fileReader)
            .withCSVParser(csvParser)
            .build()
        ) {
            String[] nextLine;
            nextLine = csvReader.readNext();
            while ((nextLine = csvReader.readNext()) != null) {
                employees.add(setEmployee(departments, nextLine));
            }

        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }

        return employees;

    }

    /**
     * @param departments - a list of departments.
     * @param nextLine - a string we are currently working with.
     * @return - an entity of an employee.
     *
     * Create the employee entity.
     */
    private Person setEmployee(List<Department> departments, String[] nextLine) {
        Person person = new Person();
        person.setId(nextLine[0]);
        person.setName(nextLine[1]);
        person.setGender(nextLine[2]);
        person.setBirthday(nextLine[3]);
        person.setDepartment(setDepartment(departments, nextLine[4]));
        person.setSalary(nextLine[5]);

        return person;
    }

    /**
     * @param departments - a list of departments.
     * @param name - a department name.
     * @return - the entity of a department.
     *
     * Create the department entity.
     */
    private Department setDepartment(List<Department> departments, String name) {
        int id = 1;

        for (Department pointer: departments) {
            if (pointer.getName().equals(name)) {
                return pointer;
            }
        }

        Department createDepartment = new Department();
        createDepartment.setId(id);
        createDepartment.setName(name);
        departments.add(createDepartment);

        id += 1;

        return createDepartment;
    }

}
