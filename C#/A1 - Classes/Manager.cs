public class Manager : Employee
{
    private string Department;

    public Manager(string firstName, string lastName, string address, double salary, int performanceRating, string department) 
    : base(firstName, lastName, address, salary, performanceRating)
    {
        Department = department;
    }

    public string GetDepartment()
    {
        return Department;
    }

    public void SetDepartment(string department)
    {
        Department = department;
    }

    public override string ToString()
    {
        return $"First Name: {GetFirstName()}\nLast Name: {GetLastName()}\nAddress: {GetAddress()}\nSalary: {GetSalary()}\nPerformance Rating: {GetPerformanceRating()}\nDepartment: {Department}\nEmployees: {Employees}";
    }
}