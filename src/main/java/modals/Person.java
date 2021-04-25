package modals;

/**
 * Person Entity
 */
public class Person {
    private int id;
    private String name;
    private String gender;
    private Department department;
    private String birthday;
    private int salary;

    public Person() {
    }


    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Department getDepartment(){ return department; }

    public String getBirthday() {
        return birthday;
    }

    public int getSalary() {
        return salary;
    }


    //setters
    public void setId(String id) { this.id = Integer.parseInt(id); }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setSalary(String salary) { this.salary = Integer.parseInt(salary); }
}