public class Programmer : Employee
{
    private string MainLanguage;
    private string SecondLanguage;
    
    public Programmer(string firstName, string lastName, string address, double salary, int performanceRating, string mainLanguage, string secondLanguage) 
    : base(firstName, lastName, address, salary, performanceRating)
    {
        MainLanguage = mainLanguage;
        SecondLanguage = secondLanguage;
    }

    public string GetMainLanguage()
    {
        return MainLanguage;
    }

    public string GetSecondLanguage()
    {
        return SecondLanguage;
    }

    public void SetMainLanguage(string mainLanguage)
    {
        MainLanguage = mainLanguage;
    }

    public void SetSecondLanguage(string secondLanguage)
    {
        SecondLanguage = secondLanguage;
    }

    public override string ToString()
    {
        return $"First Name: {GetFirstName()}\nLast Name: {GetLastName()}\nAddress: {GetAddress()}\nSalary: {GetSalary()}\nPerformance Rating: {GetPerformanceRating()}\nMain Language: {MainLanguage}\nSecond Language: {SecondLanguage}";
    }
}