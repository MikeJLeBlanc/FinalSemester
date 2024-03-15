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
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                string sql = "INSERT INTO Person(firstName, lastName, address)  VALUES('" + firstName + "', '" + lastName + "', '" + address + "');";
                try
                {
                    connection.Open();
                    SqlCommand command = new SqlCommand(sql, connection);

                    command.ExecuteNonQuery();
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

        public void DeletePerson(int id) 
        {
            using (SqlConnection connection = new SqlConnection(connectionString)) 
            {
                string sql = "DELETE FROM Person WHERE Id = " + id + ";";
                try
                {
                    connection.Open();
                    SqlCommand command = new SqlCommand(sql, connection);
                    command.ExecuteNonQuery();
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

        public void UpdatePerson(int id, string firstName, string lastName, string address) 
        {
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                string sql = "UPDATE Person SET firstName = '" + firstName + 
                    "', lastName = '" + lastName + 
                    "', address = '" + address + 
                    "' where Id = " + id + ";";
                try
                {
                    connection.Open();
                    SqlCommand command = new SqlCommand(sql, connection);
                    command.ExecuteNonQuery();
                }
                catch (Exception ex) 
                {
                    Console.WriteLine (ex.ToString());
                }
                finally
                {
                    connection.Close();
                }
            }
        }

        public void ReadPerson(DataGrid grid)
        {
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                string sql = "SELECT * FROM Person";
                try
                {
                    connection.Open();
                    SqlCommand command = new SqlCommand(sql, connection);
                    SqlDataAdapter adapter = new SqlDataAdapter(command);
                    table = new DataTable(grid.Name);
                    adapter.Fill(table);
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
