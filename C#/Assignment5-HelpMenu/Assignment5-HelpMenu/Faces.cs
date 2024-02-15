using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media.Imaging;

namespace Assignment5_HelpMenu
{
    public class Faces
    {
        private List<BitmapImage> images;
        private Grid mainGrid;
        private string element;
        public Faces(List<BitmapImage> imageList, Grid MainGrid, string element)
        {

            images = imageList;
            mainGrid = MainGrid;
            this.element = element;

        }
        
            // initiation of needed variables.
            
            
            private int index;

            private List<UIElement> itemsToRemove = new List<UIElement>();
        
            public void RandomFace()
            {
                Random random = new Random();
                try
                {
                    index = random.Next(images.Count);
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

            private void RemoveElement(string element)
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
                    mainGrid.Children.Remove(ui);
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

                        mainGrid.Children.Add(img);
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