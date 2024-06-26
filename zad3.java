import java.util.ArrayList;
class Employee {
    protected String name;
    protected String surname;
    protected String address;
    protected String email;
    protected String PESEL;
    protected int yearOfEmployment;

    public Employee(String name, String surname, String address, String email, String PESEL, int yearOfEmployment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.PESEL = PESEL;
        this.yearOfEmployment = yearOfEmployment;
    }

    public int calculateBaseSalary() {
        return 3000 + (1000 * (2024 - yearOfEmployment));
    }

    public int calculateSalary() {
        return calculateBaseSalary();
    }
}

// Deweloper
class Developer extends Employee {
    private ArrayList<Technology> knownTechnologies = new ArrayList<>();

    public Developer(String name, String surname, String address, String email, String PESEL, int yearOfEmployment) {
        super(name, surname, address, email, PESEL, yearOfEmployment);
    }

    public void addTechnology(Technology technology) {
        knownTechnologies.add(technology);
    }

    @Override
    public int calculateSalary() {
        int salary = super.calculateBaseSalary();
        for (Technology tech : knownTechnologies) {
            salary += tech.getBonus();
        }
        return salary;
    }
}

class Technology {
    private String name;
    private int bonus;

    public Technology(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}
class Tester extends Employee {
    private ArrayList<String> testTypes = new ArrayList<>();

    public Tester(String name, String surname, String address, String email, String PESEL, int yearOfEmployment) {
        super(name, surname, address, email, PESEL, yearOfEmployment);
    }

    public void addTestType(String testType) {
        testTypes.add(testType);
    }
    @Override
    public int calculateSalary() {
        return super.calculateBaseSalary() + (300 * testTypes.size());
    }
}


class Manager extends Employee {
    private ArrayList<Goal> goals = new ArrayList<>();

    public Manager(String name, String surname, String address, String email, String PESEL, int yearOfEmployment) {
        super(name, surname, address, email, PESEL, yearOfEmployment);
    }

    public void addGoal(Goal goal) {
        goals.add(goal);
    }

    @Override
    public int calculateSalary() {
        int salary = super.calculateBaseSalary();
        for (Goal goal : goals) {
            if (goal.isAchieved()) {
                salary += goal.getBonusAmount();
            }
        }
        return salary;
    }
}
class Goal {
    private int year;
    private int month;
    private int day;
    private String name;
    private int bonusAmount;

    public Goal(int year, int month, int day, String name, int bonusAmount) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.name = name;
        this.bonusAmount = bonusAmount;


    }

    public boolean isAchieved() {
        return year <= 2024 && month <= 5;
    }

    public int getBonusAmount() {
        return bonusAmount;
    }
}

public class Program {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        Developer dev = new Developer("John", "Doe", "New York", "john@doe.com", "123456789", 2020);
        Technology t = new Technology("Java", 800);
        dev.addTechnology(t);
        employees.add(dev);


        Tester tester = new Tester("Jane", "Smith", "Los Angeles", "jane@smith.com", "987654321", 2021);
        tester.addTestType("UI/UX");
        employees.add(tester);


        Manager manager = new Manager("Bob", "Johnson", "Chicago", "bob@johnson.com", "1122334455", 2019);
        Goal g = new Goal(2010, 10, 15, "Implementing FB login", 1000);
        manager.addGoal(g);
        employees.add(manager);

        // wypłata
        int totalAmount = 0;
        for (Employee employee : employees) {
            totalAmount += employee.calculateSalary();
        }
        System.out.println("Total amount to be paid this month: " + totalAmount + " USD");
    }
}