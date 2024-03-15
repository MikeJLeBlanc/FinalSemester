using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace Assignment5_HelpMenu
{
    internal class SqlConnection
    {
        public MySqlConnection GetConnection() 
        {
            string connectionString = "server=localhost;user=root;database=csharpcrud;";
            MySqlConnection connection = new MySqlConnection(connectionString);

            return connection;

        }
    }
}
