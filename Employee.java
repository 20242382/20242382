public class Employee {
    private int    id;
    private String name;
    private String email;

    public Employee(int id, String name, String email) {
        this.id    = id;
        this.name  = name;
        this.email = email;
    }

    public void setName (String n) { name  = n; }
    public void setEmail(String e) { email = e; }
    public void setId   (int    i) { id    = i; }

    public String getName ()  { return name;  }
    public String getEmail()  { return email; }
    public int    getId   ()  { return id;    }
}
