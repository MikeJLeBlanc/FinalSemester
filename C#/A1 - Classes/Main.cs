using System;
using System.Collections;
 
public class Main
{
    ArrayList<Employee> employees = new ArrayList<Employee>();

    public static void Main(string[] args)
    {
        // add employees to the ArrayList
        employees.add(new Programmer("John", "Doe", "123 Fake Street", 50000, 5, "C#", "Java"));
        employees.add(new Manager("Jane", "Doe", "123 Fake Street", 100000, 5, "IT"));

        Client clientMS = new Client("Bill", "Gates", "123 Fake Street", "Microsoft");

        // print out pay cheques of employees
        printPayCheques();

        // increase pay of employees
        increasePay();

        // print out pay cheques of employees to see increase
        printPayCheques();
    }

    public static void printPayCheques()
    {
        foreach (Employee employee in employees)
        {
            employee.CalculatePayCheque();
            Console.WriteLine(employee);
        }
    }

    public static void increasePay()
    {
        foreach (Employee employee in employees)
        {
            employee.CalculatePayRaise();
        }
    }
}