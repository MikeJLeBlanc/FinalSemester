public abstract class Employee : Person
{
    private double Salary;
    
    // Performance rating is a number between 1 and 5. 1 is the worst, 5 is the best.
    private int PerformanceRating;

    // Constructor chaining will allow us to create a Person object and an Employee object at the same time. 
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

    public void CalculatePayRaise()
    {
        switch (PerformanceRating)
        {
            case 1:
                Salary *= 1.05;
                break;
            case 2:
                Salary *= 1.1;
                break;
            case 3:
                Salary *= 1.15;
                break;
            case 4:
                Salary *= 1.2;
                break;
            case 5:
                Salary *= 1.25;
                break;
            default:
                break;
        }
    }

    public void CalculatePayCheque()
    {
        Salary /= 26;
    }

    public override string ToString()
    {
        return $"First Name: {GetFirstName()}\nLast Name: {GetLastName()}\nAddress: {GetAddress()}\nSalary: {Salary}\nPerformance Rating: {PerformanceRating}";
    }
}