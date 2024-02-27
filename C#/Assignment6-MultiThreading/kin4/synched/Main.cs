using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Reflection.Emit;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Controls;
using System.Windows.Threading;
using System.Xml.Linq;

namespace kin4.synched
{
    internal class Main
    {
        private Dispatcher dis;

        public Main(Dispatcher dis)
        {
            this.dis = dis;
        }

        public void Main1(TextBox outBox)
        {

            // invoke GUI update using GUI thread...to output on textbox
            this.dis.Invoke(new Action(() =>
            {
                outBox.AppendText("\r\rSynched interleave started");
            }));

            // Data is shared, this causes the interleave
            synched.Data dd = new Data("Data1", "Data2", "Data3");

            for (int i = 0; i < 1; i++)
            {
                myThread tinMan = new myThread(dd, "Dorothy ", "Tin man ", "Silver");
                myThread scarecrow = new myThread(dd, "Dorothy ", "Scarecrow ", "Brown");
                myThread cowardlyLion = new myThread(dd, "Dorothy ", "Cowardly Lion ", "Yellow");

                Action MethodToRun_a = tinMan.ThreadProc;
                Action MethodToRun_b = scarecrow.ThreadProc;
                Action MethodToRun_c = cowardlyLion.ThreadProc;

                Thread t1 = new Thread(new ThreadStart(MethodToRun_a));
                Thread t2 = new Thread(new ThreadStart(MethodToRun_b));
                Thread t3 = new Thread(new ThreadStart(MethodToRun_c));

                t1.Start();
                t2.Start();
                t3.Start();
            }

            for (int i = 0; i < 200; i++)
            {
                Thread.Sleep(2);
                Console.WriteLine("MAIN=>" + dd.getThreadperson());

                // invoke GUI update using GUI thread...to output on textbox
                this.dis.Invoke(new Action(() =>
                {
                    outBox.AppendText("\rMAIN=>" + dd.getThreadperson());
                }));
            }

            // Finished...tell user
            this.dis.Invoke(new Action(() =>
            {
                outBox.AppendText("\rMAIN=> Finished Synched Run");
            }));

        }
    }
}
