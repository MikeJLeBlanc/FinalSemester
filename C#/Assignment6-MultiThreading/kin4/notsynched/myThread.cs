using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace kin4.notsynched
{
    internal class myThread
    {

        notsynched.Data dd;

        private String name = "";
        private String favoriteCharacter = "";
        private String colour = "";

        public myThread(notsynched.Data dd, string name, string favoriteCharacter, string colour)
        {
            // the object reference to update, each thread gets the same
            this.dd = dd;

            // the data that this thread will update with
            this.name = name;
            this.favoriteCharacter = favoriteCharacter;
            this.colour = colour;
        }

        public void ThreadProc()
        {
            for (int i = 0; i < 180; i++)
            {
                dd.setThreadPerson(this.name, this.favoriteCharacter, this.colour);
                Console.WriteLine("ThreadProc: " + this.name);
                // Yield the rest of the time slice.
                Thread.Sleep(1);
            }
        }
    }   
}
