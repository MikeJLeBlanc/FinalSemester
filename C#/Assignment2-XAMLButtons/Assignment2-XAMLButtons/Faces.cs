using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Media.Imaging;
using System.Windows;
using System.Reflection;
using System.Xml.Linq;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Documents;


namespace Assignment2_XAMLButtons
{

    public class Faces(List<BitmapImage> imageList, Grid MainGrid, string element)
    {

        // initiation of needed variables.
        private List<BitmapImage> images = imageList;
        private Grid mainGrid = MainGrid;
        private string element = element;
        
        private int index = 0;

        private List<UIElement> itemsToRemove = new List<UIElement>();

        public void RandomFace()
        {
            Random random = new Random();
            try
            {
                index = random.Next(images.Count - 1);
                addImage(index);
            }
            catch (IndexOutOfRangeException)
            {
                index = 0;
                addImage(index);
            }
        }

        public void NextImage()
        {
            try
            {
                index++;
                addImage(index);
            } 
            catch (IndexOutOfRangeException)
            {
                index = 0;
                addImage(index);
            }
            
        }

        private void RemoveElement(String element)
        {

            // targeted removal by UID. We manually set these within the methods via a string.
            foreach (UIElement ui in mainGrid.Children)
            {
                if (ui.Uid.StartsWith(element))
                {
                    itemsToRemove.Add(ui);
                }
            }
            foreach (UIElement ui in itemsToRemove)
            {
                MainGrid.Children.Remove(ui);
            }
        }

        private void addImage(int listIndex)
        {
            if (listIndex < images.Count)
            {
                try
                {
                    Image img = new Image();
                    img.Source = images[listIndex];
                    img.Uid = element;
                    img.Height = 434; // could really set these 2 as constants if we wanted.
                    img.Width = 441;

                    RemoveElement(element);

                    MainGrid.Children.Add(img);
                }
                catch (Exception e)
                {
                    Console.WriteLine("Houston, we have an error here! " + e);
                }
            } 
            else
            {
                index = 0;
                addImage(index);
            }
        }
    }
}
