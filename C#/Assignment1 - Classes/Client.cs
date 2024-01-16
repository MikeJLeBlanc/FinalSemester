public class Client : Person
{
    private string CompanyName;

    public Client(string firstName, string lastName, string address, string companyName) : base(firstName, lastName, address)
    {
        CompanyName = companyName;
    }

   
    public string GetCompanyName()
    {
        return CompanyName;
    }

    public void SetCompanyName(string companyName)
    {
        CompanyName = companyName;
    }

    public override string ToString()
    {
        return $"First Name: {GetFirstName()}\nLast Name: {GetLastName()}\nAddress: {GetAddress()}\nCompany Name: {CompanyName}";
    }
}