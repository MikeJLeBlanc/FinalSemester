using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;

namespace Assignment5_HelpMenu
{
    internal class DatabaseAccess
    {
        private readonly string connectionString = "Data Source=(LocalDB)\\MSSQLLocalDB;AttachDbFilename=E:\\school-work\\Year2\\Semester2\\C#\\Assignment5-HelpMenu\\Assignment5-HelpMenu\\userData.mdf;Integrated Security=True";
        DataTable table;
       
        public void InsertPerson(string firstName, string lastName, string address)
        {
            string sql = "INSERT INTO Person(firstName, lastName, address)  VALUES ('" + firstName + "', '" + lastName + "', '" + address + "');";

            using (SqlConnection connection = new SqlConnection(connectionString))
            using (SqlCommand command = new SqlCommand(sql, connection))
            {
                
                try
                {
                    connection.Open();
                    command.ExecuteNonQuery();
                }   
                catch (Exception ex) 
                { 
                Console.WriteLine(ex.ToString());
                }
            }
        }

        public void DeletePerson(int id) 
        {
            string sql = "DELETE FROM Person WHERE Id = " + id + ";";

            using (SqlConnection connection = new SqlConnection(connectionString))
            using (SqlCommand command = new SqlCommand(sql, connection))
            {
                try
                {
                    connection.Open();
                    command.ExecuteNonQuery();
                } 
                catch (Exception ex)
                {
                    Console.WriteLine(ex.ToString());
                }
            }
        }

        public void UpdatePerson(int id, string firstName, string lastName, string address) 
        {
            string sql = "UPDATE Person SET firstName = '" + firstName +
                    "', lastName = '" + lastName +
                    "', address = '" + address +
                    "' where Id = " + id + ";";

            using (SqlConnection connection = new SqlConnection(connectionString))
            using (SqlCommand command = new SqlCommand(sql, connection))
            {
                try
                {
                    connection.Open();
                    command.ExecuteNonQuery();
                }
                catch (Exception ex) 
                {
                    Console.WriteLine (ex.ToString());
                }
            }
        }

        public void ReadPerson(DataGrid grid)
        {
            string sql = "SELECT * FROM Person";
            using (SqlConnection connection = new SqlConnection(connectionString))
            using (SqlCommand command = new SqlCommand(sql, connection))
            {
                
                try
                {
                    connection.Open();
                    using (SqlDataAdapter adapter = new SqlDataAdapter(command))
                    {
                        table = new DataTable(grid.Name);
                        adapter.Fill(table);
                    }                   
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.ToString());
                }
                finally
                {
                    connection.Close();
                }
            }
        }
    }
}
