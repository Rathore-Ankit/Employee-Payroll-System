

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Employee Payroll System Project");
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee fullTimeEmployee1 = new FullTimeEmployee("Manoj",101 , 20000.0);
        payrollSystem.addEmployee(fullTimeEmployee1);
        payrollSystem.displayEmployee();
//        payrollSystem.removeEmployee(101);
        FullTimeEmployee fullTimeEmployee2= new FullTimeEmployee("manish" ,102,25000.0);
        payrollSystem.addEmployee(fullTimeEmployee2);
        payrollSystem.displayEmployee();
    }
}
abstract class Employee{
    private int id ;
    private String name ;
    public  Employee(int id , String name){
        this.id=id;
        this.name= name;
    }
    public int getId(){
        return  id;
    }
    public  String getName(){
        return name;
    }
    public abstract double calculateSalary();
    @Override
    public String toString(){
        return  "Employee Details:\n Employee_name : "+ name+ "\nEmployee_id : "+ id + "\nEmployee_salary : "+ calculateSalary()+"]";
    }
}
class FullTimeEmployee extends Employee {
    private  double  monthlysalary;
    public  FullTimeEmployee(String name , int id , double monthlysalary) {
        super(id, name);
        this.monthlysalary = monthlysalary;
    }@Override
    public double calculateSalary(){
        return  monthlysalary;
    }
}
class PartTimeEmployee extends Employee {
    private  int hourWorked ;
    private  double hourrate;
    public  PartTimeEmployee( String name,int id , int hourWorked, double hourrate){
        super(id,name);
        this.hourrate=hourrate;
        this.hourWorked=hourWorked;
    }
    @Override
    public double calculateSalary() {
        return  hourrate*hourWorked;
    }


}

class PayrollSystem{
    //here we will create a linked list
    //this is collection farmework datatype
    private  ArrayList <Employee>employeeArrayList;
    //        //how to create a array list
//        /*public ArrayList<String> employee = new ArrayList<>();
//        //this is a way to create array list and intilized it*/
    public PayrollSystem(){
        employeeArrayList = new ArrayList<>();
    }

    public  void addEmployee(Employee employee){
        employeeArrayList.add(employee);
        System.out.println( "Employee Mr. " +employee.getName()+ " added succesfully ");
    }

    public void removeEmployee(int id){
        Employee removeToEmployee= null;
        for(Employee employee: employeeArrayList){
            if(employee.getId()==id){
                removeToEmployee =employee;
                break;
            }
        }
        if(removeToEmployee!=null){
            employeeArrayList.remove(removeToEmployee);
            System.out.println("employee removed successfully");
        }

    }
    public void displayEmployee(){
        for(Employee employee : employeeArrayList){
            System.out.println(employee);
            
        }
    }


}

