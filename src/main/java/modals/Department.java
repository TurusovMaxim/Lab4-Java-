package modals;

/**
 * Department entity
 */
public class Department {
    private int id;
    private String name;

    public Department() {
    }


    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
