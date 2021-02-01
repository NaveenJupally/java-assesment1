package com.project1;

import java.util.*;

public class Platform {

    private static Scanner scanner=new Scanner(System.in);
    private static ArrayList<Employee> employees=new ArrayList();
    private static int index=0;
    public static void main(String[] args)
    {
        while (true){
            int usersChoice=askUsersChoice();
            processUserChoice(usersChoice);
        }

    }

    private static void processUserChoice(int userChoice){
        switch (userChoice){
            case 1:
                final Employee employee=createEmployee();
                employees.add(employee);
                break;
            case 2:
                System.out.println("Which Employe Needs to Update? Give me the ID:");
                updateEmployee(scanner.nextInt());
                break;
            case 3:
                System.out.println("Enter Employee to delete! Give the Id");
                deleteEmployee(scanner.nextInt());
                break;
            case 4:
                listEmployees();
                break;
        }
    }

    private static int askUsersChoice(){
        showUsersChoice();
        System.out.println("Choose Your Choice");
        return scanner.nextInt();
    }

    public static void showUsersChoice(){
        System.out.println("1.Create Emloyee");
        System.out.println("2.Update Employee");
        System.out.println("3.Delete Employee ");
        System.out.println("4.List Employee");
    }

    private static Employee createEmployee(){

        System.out.println("Provide Employee details!");
        final String name=takeName();
        final double salary=takeSalary();
        final int age=takeAge();
        Employee employee=creatingEmployeeObject(name,salary,age);

        employee.displayInformation();

        return employee;
    }

    private static int identifier=1;
    private static Employee creatingEmployeeObject(String name, double salary, int age) {

        return new Employee(name,salary,age,identifier++);
    }

    public static String takeName(){
        System.out.print("Name: ");
        final String name=scanner.next();
        if (!isNameValid(name)) {
            return takeName();
        }
        else {
            return name;
        }
    }

    private static boolean isNameValid(String name){
        final boolean matches=name.matches("[a-zA-Z]*$");
        if(!matches) {
            System.out.println("Looks like Invalid");
        }
        return matches;
    }


   /* private static void addEmployeeToStorage(Employee employee){
        employees.set(index, employee);
        index++;
    }
    private static boolean storageFull(){
        return employees.le;
    }*/


    private static void updateEmployee(int empId) {


        boolean isEmployeeFound=false;
        for (int i=0;i<employees.size();i++)
        {
            isEmployeeFound= employees.get(i).getEmpId()==(empId);

                if(isEmployeeFound){
                    System.out.println("Enter updated info with id: "+empId);
                    final String name=takeName();
                    final double salary=takeSalary();
                    final int age=takeAge();
                    employees.get(i).update(name,salary,age);
                   // processUpdate(empId,employees.get(i));
                    break;
                }

            if (!isEmployeeFound)
                System.out.println("Employee Not Exist to Update!");

        }
    }

   // private static void processUpdate(int empId, Employee employee) {
    //}
   private static void deleteEmployee(int employeeId) {
       for (int i=0;i<employees.size();i++){
           if(employees.get(i).getEmpId()==employeeId){
               employees.remove(i);
               System.out.println("Employee with id: "+employeeId+" is deleted");
           }
       }
   }
    private static void listEmployees() {
        for (Employee e:employees) {
            e.displayInformation();
        }
         /*for (int i=0;i<employees.size();i++){
                    employees.get(i).displayInformation();
                }*/

         /* Iterator<Employee> employeeIterator=employees.iterator();
                while (employeeIterator.hasNext()){
                    employeeIterator.next().displayInformation();
                }*/
    }


    public static double takeSalary(){
        System.out.print("Salary: ");
        return scanner.nextDouble();
    }

    public static int takeAge(){
        System.out.print("Age: ");
        return scanner.nextInt();
    }

}
