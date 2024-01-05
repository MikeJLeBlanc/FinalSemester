abstract class Person
{
    private string FirstName;
    private string LastName;
    private string Address;
    private int Salary;
    private int PerformanceRating;

    public Person(string firstName, string lastName, string address, int salary, int performanceRating)
    {
        FirstName = firstName;
        LastName = lastName;
        Address = address;
        Salary = salary;
        PerformanceRating = performanceRating;
    }

    public string GetFirstName()
    {
        return FirstName;
    }

    public string GetLastName()
    {
        return LastName;
    }

    public string GetAddress()
    {
        return Address;
    }

    public int GetSalary()
    {
        return Salary;
    }

    public int GetPerformanceRating()
    {
        return PerformanceRating;
    }

    public void SetFirstName(string firstName)
    {
        FirstName = firstName;
    }

    public void SetLastName(string lastName)
    {
        LastName = lastName;
    }

    public void SetAddress(string address)
    {
        Address = address;
    }

    public void SetSalary(int salary)
    {
        Salary = salary;
    }

    public void SetPerformanceRating(int performanceRating)
    {
        PerformanceRating = performanceRating;
    }

    public abstract int CalculatePayCheck();

    public abstract int CalculatePayRaise();

    public override string ToString()
    {
        return $"First Name: {FirstName}\nLast Name: {LastName}\nAddress: {Address}\nSalary: {Salary}\nPerformance Rating: {PerformanceRating}";
    }
}