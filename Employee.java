package com.project1;

public class Employee {
    private String name;
    private double salary;
    private int age;
    private int empId;

    public Employee(String name, double salary,int age, int id) {
        this.name = name;
        this.salary = salary;
        this.age=age;
        this.empId = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void displayInformation(){
        System.out.println( (this.name+","+this.salary+","+this.age+","+this.empId));
    }

    public void update(String name,double salary,int age){
        this.name = name;
        this.salary = salary;
        this.age=age;
    }
}
