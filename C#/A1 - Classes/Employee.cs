abstract class Employee : Person
{
    private double Salary;
    private int PerformanceRating;

    public Employee(string firstName, string lastName, string address, double salary, int performanceRating) : base(firstName, lastName, address)
    {
        Salary = salary;
        PerformanceRating = performanceRating;
    }

    public double GetSalary()
    {
        return Salary;
    }

    public int GetPerformanceRating()
    {
        return PerformanceRating;
    }

    public void SetSalary(double salary)
    {
        Salary = salary;
    }

    public void SetPerformanceRating(int performanceRating)
    {
        PerformanceRating = performanceRating;
    }

    public override string ToString()
    {
        return $"First Name: {GetFirstName()}\nLast Name: {GetLastName()}\nAddress: {GetAddress()}\nSalary: {Salary}\nPerformance Rating: {PerformanceRating}";
    }
}