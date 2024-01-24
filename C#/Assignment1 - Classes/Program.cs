using System;
using System.Collections;

namespace CompanyPayments
{
    internal class Program 
    {
        private static ArrayList employees = new ArrayList();

        static void Main(string[] args)
        {
            

            // add employees to the ArrayList
            employees.Add(new Programmer("John", "Doe", "123 Fake Street", 50000, 5, "C#", "Java"));
            employees.Add(new Manager("Jane", "Doe", "123 Fake Street", 100000, 5, "IT"));

            Client clientMS = new Client("Bill", "Gates", "123 Fake Street", "Microsoft");
            
            // print out pay cheques of employees
            PrintPayCheques();

            // increase pay of employees
            IncreasePay();

            // print out pay cheques of employees to see increase
            PrintPayCheques();

            clientMS.ToString();
        }

        public static void PrintPayCheques()
        {
            foreach (Employee employee in employees)
            {
                Console.WriteLine($"{employee.GetFirstName()} {employee.GetLastName()} - {employee.GetSalary()}");
            }
        }
    
        public static void IncreasePay()
        {
            foreach (Employee employee in employees)
            {
                employee.CalculatePayRaise();
            }
        }
    }
}
