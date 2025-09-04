class Employee {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age must be positive!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        employee1.setName("Michael");
        employee1.setAge(21);

        employee2.setName("Rian");
        employee2.setAge(22);

        System.out.println("Name : " + employee1.getName());
        System.out.println("Age: " + employee1.getAge());

        System.out.println("Name : " + employee2.getName());
        System.out.println("Age: " + employee2.getAge());

    }
}
