package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeMain {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Harshil", "Male", 29, 75000, 2020, "IT"));
        employees.add(new Employee("Bhakti", "Female", 28, 68000, 2019, "HR"));
        employees.add(new Employee("Kashvi", "Female", 25, 82000, 2021, "Finance"));
        employees.add(new Employee("Amit", "Male", 35, 90000, 2018, "IT"));
        employees.add(new Employee("Neha", "Female", 30, 72000, 2020, "Marketing"));
        employees.add(new Employee("Rohan", "Male", 34, 60000, 2017, "Sales"));
        employees.add(new Employee("Priya", "Female", 38, 88000, 2016, "Finance"));
        employees.add(new Employee("Suresh", "Male", 42, 95000, 2015, "Operations"));
        employees.add(new Employee("Anita", "Female", 26, 70000, 2022, "HR"));
        employees.add(new Employee("Vikas", "Male", 31, 64000, 2021, "Support"));
        employees.add(new Employee("Meena", "Female", 33, 78000, 2019, "IT"));
        employees.add(new Employee("Rahul", "Male", 36, 85000, 2018, "Marketing"));
        employees.add(new Employee("Pooja", "Female", 27, 73000, 2020, "Sales"));
        employees.add(new Employee("Karan", "Male", 39, 92000, 2017, "Finance"));
        employees.add(new Employee("Nisha", "Female", 24, 81000, 2022, "IT"));

        // Print all employees
        /*for (Employee emp : employees) {
            System.out.println(
                    emp.getName() + " | " +
                            emp.getGender() + " | " +
                            emp.getSalary() + " | " +
                            emp.getYearOfJoining() + " | " +
                            emp.getDepartment()
            );
        }*/

        //Given a list of Employee, get names of those in a specific department and age < 30.
        List<String> result = employees.stream()
                .filter(e -> e.getDepartment().equals("IT") && e.getAge() < 30)
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("list of Employee, get names of those in a specific department and age < 30 " + result);

        //Count number of employees in each department.
        Map<String, Long> deptCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        System.out.println("Count number of employees in each department. " + deptCount);

        //Sum of salary using reduce
        double totalSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);

        System.out.println("Sum of Salary " + totalSalary);

        //Get highest-paid employee per department
        Map<String, Optional<Employee>> topEarnerPerDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                        ));

        topEarnerPerDept.forEach((dept, empOpt) -> {
            empOpt.ifPresent(emp ->
                    System.out.println(
                            "Department: " + dept +
                                    ", Name: " + emp.getName() +
                                    ", Salary: " + emp.getSalary()
                    )
            );
        });

        //Partition employees based on whether they earn more than 50K
        Map<Boolean, List<Employee>> partitioned =
                employees.stream()
                        .collect(Collectors.partitioningBy(e -> e.getSalary() > 50000));

        System.out.println("Employees with salary > 50000:");
        partitioned.get(true).forEach(e ->
                System.out.println(e.getName() + " | " + e.getSalary())
        );

        System.out.println("\nEmployees with salary <= 50000:");
        partitioned.get(false).forEach(e ->
                System.out.println(e.getName() + " | " + e.getSalary())
        );

        //Sort by salary descending, then name ascending
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()
                        .thenComparing(Employee::getName))
                .forEach(System.out::println);

        //Aggregation (max/min/count/sum)
        Optional<Employee> topEmp =
                employees.stream()
                        .max(Comparator.comparing(Employee::getSalary));
        System.out.println("Max Salary - Top emp " + topEmp);

        long count = employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .count();

        System.out.println("count of emp having salary greater than 50000 " + count);

        //Youngest employee / highest salary or low salary .. all will follow same concept
        Optional<Employee> youngestEmployee =
                employees.stream()
                        .min(Comparator.comparing(Employee::getAge));

        youngestEmployee.ifPresent(entry ->
                System.out.println("Youngest employee: " + entry.getName()));

        //2nd youngest employee
        Optional<Employee> seoncdYoungestEmployee =
                employees.stream().sorted(Comparator.comparing(Employee::getAge)).skip(1).findFirst();

        seoncdYoungestEmployee.ifPresent(entry ->
        System.out.println("Second Youngest employee: " + entry.getName()));

        //To get Nth ranked employee (generic version)

        int n=2;

        Optional<Employee> nthRankedEmployee =
                employees.stream().sorted(Comparator.comparing(Employee::getAge)).skip(2).findFirst();

        nthRankedEmployee.ifPresent(entry ->
                System.out.println("nthRankedEmployee : " + entry.getName()));

        //Above to similar problem to find nth highest empoyee. Below example is using map
        //Find top rank employee
        // Map of Employee to Rank

        Map<Employee, Integer> employeeRankMap = new HashMap<>();
        employeeRankMap.put(new Employee("Tejas", "Male", 40, 75000, 2020, "Finance"), 3);
        employeeRankMap.put(new Employee("Sanika", "Female", 29, 85000, 2020, "Sales"), 1);
        employeeRankMap.put(new Employee("Akshay", "Male", 39, 50000, 2020, "IT"), 2);

        // Using Stream to find Employee with top (lowest) rank
        Optional<Map.Entry<Employee, Integer>> topEmployee =
                employeeRankMap.entrySet().stream()
                        .min(Map.Entry.comparingByValue()); // min because rank 1 < rank 2

        // Print result
        topEmployee.ifPresent(entry ->
                System.out.println("Top ranked employee: " + entry.getKey() + " with rank " + entry.getValue()));

        //2nd rank employee using streams
        Optional<Map.Entry<Employee, Integer>> secondRank =
                employeeRankMap.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue()) // Sort by rank ascending
                        .skip(1)                              // Skip top (rank 1)
                        .findFirst();                         // Get next one (rank 2)

        secondRank.ifPresent(entry ->
                System.out.println("2nd ranked employee: " + entry.getKey() + " with rank " + entry.getValue()));

        //If you want nth ranked employee (say 2nd, 3rd, etc.), you can do:
        int n1 = 2; // nth rank
        Optional<Map.Entry<Employee, Integer>> nthRank =
                employeeRankMap.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .skip(n1 - 1)
                        .findFirst();

        nthRank.ifPresent(entry ->
                System.out.println("nth ranked employee: " + entry.getKey() + " with rank " + entry.getValue()));


//--------------------

        //Employee with the Highest Salary
        Optional<Employee> highestPaid = employees.stream()
                .max(Comparator.comparingDouble(e -> e.getSalary()));

        highestPaid.ifPresent(System.out::println);

        //Group Employees by Department
        Map<String, List<Employee>> groupedByDept = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.toList()));

        groupedByDept.forEach((dept, empList) -> {
            System.out.println("For dept " + dept);
            empList.forEach(emp -> System.out.println(emp.getName()));
        });


        //Compute Average Salary of Employees
        OptionalDouble avgSalary = employees.stream()
                .mapToDouble(e -> e.getSalary())
                .average();

        /* Other way to calculate average

        Double avgSalary =
        employees.stream()
                 .collect(Collectors.averagingDouble(Employee::getSalary));
         */

        avgSalary.ifPresent(avg -> System.out.println("Average Salary: " + avg));

        //how many male female employee in org
        employees.stream().collect(Collectors.groupingBy(e->e.getGender(), Collectors.counting()))
                .forEach((g,c)->System.out.println("gender count " + g+" "+c));

        //other way is

        Map<String, Long> genderCount =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getGender,
                                Collectors.counting()
                        ));

        System.out.println("Employee count by gender:");
        genderCount.forEach((gender, count1) ->
                System.out.println("Gender = " + gender + ", Count = " + count1)
        );


        //Print name of all the dept in org
        employees.stream().map(Employee::getDepartment).forEach(System.out::println);

        //other way
        List<String> deptname = employees.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
        System.out.println("Dept name using list " + deptname);

        //Another way is

        Set<String> deptname1 = employees.stream().map(Employee::getDepartment).collect(Collectors.toSet());
        System.out.println("Dept name using set " + deptname1);

        //average age of male female
        Map<String, Double> genderAvg = employees.stream().collect(Collectors.groupingBy(
                Employee::getGender,Collectors.averagingDouble(e->e.getAge())));

        System.out.println("Avg age by gender  " + genderAvg);

        //highest paid employee in the org
        Optional<Employee> highestPaidEmp = employees.stream().max(Comparator.comparingDouble(e->e.getSalary()));

        highestPaidEmp.ifPresent(System.out::println);

        //Another way to write is
        String empname = employees.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get().getName();
        System.out.println("Highest paid employee " + empname);


        //Get name of all employees who joined after 2015
        employees.stream().filter(e -> e.getYearOfJoining() > 2015).forEach(System.out::println);

        employees.stream().filter(e -> e.getYearOfJoining() > 2015).collect(Collectors.toList()).forEach(System.out::println);

        employees.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).collect(Collectors.toList()).forEach(System.out::println);

        //count number of employess in each dept
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).forEach((d,c)->System.out.println("D "+ d + "C " + c));

        //Average salary of each dept
        employees.stream().collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.averagingDouble(e->e.getSalary())))
                .forEach((d,c)->System.out.println("Dept "+ d + "Salary " + c));

        //get the details of the youngest employee in IT department
        employees.stream().filter(e -> e.getDepartment().equals("IT")).min(Comparator.comparing(Employee::getAge)).ifPresent(System.out::println);

        //Another way
        employees.stream().filter(e -> e.getDepartment().equals("IT")).collect(Collectors.minBy(Comparator.comparingDouble(Employee::getAge))).ifPresent(System.out::println);

        //Most working exp in org
        employees.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).ifPresent(System.out::println);

        //how many male and female emp in sales and marketing team

        employees.stream().filter(e->e.getDepartment().equals("Finance"))
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()))
                .forEach((g,c)->System.out.println("Gender "+ g + "Count " + c));


        //Average salary of male and female emp
        employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(e->e.getSalary()))).forEach((d,c)->System.out.println("Gender "+ d + " Avg Salary " + c));

        //List down all employess from each dept
        Map<String,List<Employee>> deptWiseEmp = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.toList()));

        for (Map.Entry<String, List<Employee>> entry : deptWiseEmp.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        //Another way to write above for loop is as below

        for (Map.Entry<String, List<Employee>> entry : deptWiseEmp.entrySet()) {

            String department = entry.getKey();
            List<Employee> empList = entry.getValue();

            System.out.println("Department: " + department);

            for (Employee emp : empList) {
                System.out.println(
                        emp.getName() + " | " +
                                emp.getGender() + " | " +
                                emp.getAge() + " | " +
                                emp.getSalary()
                );
            }

            System.out.println(); // blank line between departments
        }

        //Avg salary and total salary of whole org
        double avgSal = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("avg sal of whole org " + avgSal);

        double totalSal = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println("avg sal of whole org " + totalSal);

        //separate employees by age (≤ 25 and > 25)
        Map<Boolean, List<Employee>> agePartition =
                employees.stream()
                        .collect(Collectors.partitioningBy(e -> e.getAge() <= 25));

        for (Map.Entry<Boolean, List<Employee>> entry : agePartition.entrySet()) {

            if (entry.getKey()) {
                System.out.println("Employees aged 25 or below:");
            } else {
                System.out.println("Employees older than 25:");
            }

            for (Employee emp : entry.getValue()) {
                System.out.println(
                        emp.getName() + " | Age: " + emp.getAge() + " | Dept: " + emp.getDepartment()
                );
            }

            System.out.println();
        }

        //Another way to print
        System.out.println("Employees aged 25 or below:");
        agePartition.get(true).forEach(System.out::println);

        System.out.println("\nEmployees older than 25:");
        agePartition.get(false).forEach(System.out::println);

        //oldest empl in the org and its age,dept

        Optional<Employee> oldestEmployee =
                employees.stream()
                        .max(Comparator.comparingInt(Employee::getAge));

        oldestEmployee.ifPresent(e -> {
            System.out.println("Oldest Employee Details");
            System.out.println("Name       : " + e.getName());
            System.out.println("Age        : " + e.getAge());
            System.out.println("Department : " + e.getDepartment());
        });


        //Find salaries of all employees
        List<Double> salary = employees.stream().map(Employee::getSalary).collect(Collectors.toList());

        //Find max salaries from all empl
        Optional<Double> maxsalary = employees.stream().map(Employee::getSalary).max(Comparator.comparingDouble(e->e));
        maxsalary.ifPresent(System.out::println);

        //Find empl that hsa max salary
        Optional<Employee> maxSalaryEmp = employees.stream().max(Comparator.comparingDouble(e->e.getSalary()));

        maxSalaryEmp.ifPresent(System.out::println);

        //Find highest salary from each department
        Map<String, Optional<Employee>> maxByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

        //below are 2 ways of writing for loop
        maxByDept.forEach((dept, empOpt) -> {
            empOpt.ifPresent(emp ->
                    System.out.println(
                            "Department: " + dept +
                                    ", Name: " + emp.getName() +
                                    ", Salary: " + emp.getSalary()
                    )
            );
        });

        for(Map.Entry <String, Optional<Employee>> entry : maxByDept.entrySet())
        {
            String deptName = entry.getKey();
            Optional<Employee> emp = entry.getValue();

            if(emp.isPresent())
            {
                Employee emp1 = emp.get();
                System.out.println(emp1.getDepartment() + " | Name: " + emp1.getName() + " | Salary: " + emp1.getSalary());
            }
        }


        //Sort all empl based on his age
        System.out.println("Sort all empl based on his age");
        employees.stream().sorted((a,b)->Integer.compare(a.getAge(),b.getAge())).forEach(System.out::println);
        employees.stream().sorted((a,b)->Integer.compare(a.getAge(),b.getAge())).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("==================");
        employees.stream().sorted(Comparator.comparingDouble(Employee::getAge)).forEach(System.out::println);

    }

}

