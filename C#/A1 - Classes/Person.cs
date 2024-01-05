public abstract class Person
{
    private string FirstName;
    private string LastName;
    private string Address;

    public Person(string firstName, string lastName, string address)
    {
        FirstName = firstName;
        LastName = lastName;
        Address = address;
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

    public override string ToString()
    {
        return $"First Name: {FirstName}\nLast Name: {LastName}\nAddress: {Address}\nSalary: {Salary}\nPerformance Rating: {PerformanceRating}";
    }
}