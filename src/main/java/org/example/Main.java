package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static List<Employee> employees = new LinkedList<>();

    public static void main(String[] args) {

        employees.add(new Employee(1, "John", "Doe"));
        employees.add(new Employee(2, "Jane", "Smith"));
        employees.add(new Employee(1, "John", "Doe"));
        employees.add(new Employee(3, "Alice", "Brown"));
        employees.add(new Employee(4, "Bob", "White"));
        employees.add(new Employee(2, "Jane", "Smith"));

        List<Employee> duplicates = findDuplicates(employees);
        System.out.println("Duplicates:");
        for (Employee e : duplicates) {
            System.out.println(e);
        }
        Map<Integer, Employee> uniques = findUniques(employees);
        System.out.println("\nUniques:");
        for (Map.Entry<Integer, Employee> entry : uniques.entrySet()) {
            System.out.println(entry.getValue());
        }
        List<Employee> noDuplicates = removeDuplicates(employees);
        System.out.println("\nList without duplicates:");
        for (Employee e : noDuplicates) {
            System.out.println(e);
        }
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Employee> seen = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();

        for (Employee employee : list) {
            if (employee != null) {
                if (!seen.add(employee)) {
                    duplicates.add(employee);
                }
            }
        }
        return duplicates;
    }


    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> uniqueMap = new HashMap<>();

        for (Employee employee : list) {
            if (employee != null && !uniqueMap.containsKey(employee.getId())) {
                uniqueMap.put(employee.getId(), employee);
            }
        }

        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Employee employee : list) {
            if (employee != null) {
                countMap.put(employee.getId(), countMap.getOrDefault(employee.getId(), 0) + 1);
            }
        }

        List<Employee> result = new LinkedList<>();
        Set<Integer> added = new HashSet<>();

        for (Employee employee : list) {
            if (employee != null && countMap.get(employee.getId()) == 1 && !added.contains(employee.getId())) {
                result.add(employee);
                added.add(employee.getId());
            }
        }

        return result;
    }
}