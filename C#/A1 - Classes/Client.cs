public class Client : Person
{
    private string CompanyName;

    public Client(string firstName, string lastName, string address, string address, string companyName) : base(firstName, lastName, address)
    {
        CompanyName = companyName;
    }

    public string GetName()
    {
        return Name;
    }

    public string GetAddress()
    {
        return Address;
    }

    public string GetCompanyName()
    {
        return CompanyName;
    }

    public void SetName(string name)
    {
        Name = name;
    }

    public void SetAddress(string address)
    {
        Address = address;
    }

    public void SetCompanyName(string companyName)
    {
        CompanyName = companyName;
    }

    public override string ToString()
    {
        return $"Name: {Name}\nAddress: {Address}\nCompany Name: {CompanyName}";
    }
}