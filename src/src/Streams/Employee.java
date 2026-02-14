package Streams;

public class Employee {

    // Attributes (fields)
    private String name;
    private String gender;
    private double salary;
    private int yearOfJoining;
    private String department;
    private int age;

    // No-argument constructor
    public Employee() {
    }

    // Parameterized constructor
    public Employee(String name, String gender, int age,double salary,
                    int yearOfJoining, String department) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
        this.yearOfJoining = yearOfJoining;
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for gender
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Getter and Setter for salary
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Getter and Setter for yearOfJoining
    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    // Getter and Setter for department
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
