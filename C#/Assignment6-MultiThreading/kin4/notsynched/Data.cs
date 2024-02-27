using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace kin4.notsynched
{
    internal class Data
    {
        private String name = "";
        private String favoriteCharacter = "";
        private String colour = "";

        public Data(String name, String favoriteCharacter, String colour)
        {
            this.name = name;
            this.favoriteCharacter = favoriteCharacter;
            this.colour = colour;
        }

        public void setThreadPerson(String name, String favoriteCharacter, String colour)
        {
            // lock during read/writes
            // lock (read_write_data)
            {
                // update the data
                this.name = name;
                Thread.Sleep(1);
                this.favoriteCharacter = favoriteCharacter;
                Thread.Sleep(1);
                this.colour = colour;
            }

        }

        public String getThreadperson()
        {
            String r = "";

            // lock during read/writes
            //lock (read_write_data)
            {
                // update the data
                r = r + this.name;
                Thread.Sleep(1);
                r = r + this.favoriteCharacter;
                Thread.Sleep(1);
                r = r + this.colour;

            }

            return r;
        }
    }
}
