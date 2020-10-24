public class Employee implements Comparable<Employee> {

    private String name;
    private double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public boolean equals(Employee employee) {
        return Math.abs(this.salary - employee.getSalary()) < .01 && this.name.equals(employee.getName());
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(this.salary, o.salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}