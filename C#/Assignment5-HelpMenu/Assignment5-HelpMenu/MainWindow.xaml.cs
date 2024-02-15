using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Forms;
using System.Windows.Input;
using System.Windows.Media.Imaging;
using CheckBox = System.Windows.Controls.CheckBox;
using ComboBox = System.Windows.Controls.ComboBox;
using RadioButton = System.Windows.Controls.RadioButton;


namespace Assignment5_HelpMenu
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        // initiation of needed variables.
        // not so needed anymore
        private int hairIndex, eyesIndex, mouthIndex, noseIndex;

        private List<BitmapImage> hairList = new List<BitmapImage>();
        private List<BitmapImage> eyeList = new List<BitmapImage>();
        private List<BitmapImage> noseList = new List<BitmapImage>();
        private List<BitmapImage> mouthList = new List<BitmapImage>();

        // used for targeted removal of elements in the Grid.
        private List<UIElement> itemsToRemove = new List<UIElement>();

        public Faces hair;
        public Faces eyes;
        public Faces nose;
        public Faces mouth;

        public MainWindow()
        {
            InitializeComponent();

            // Interaction logic for MainWindow.xaml

            hairList.Add(new BitmapImage(new Uri("/Images/hair1.png", UriKind.Relative)));
            hairList.Add(new BitmapImage(new Uri("/Images/hair2.png", UriKind.Relative)));
            hairList.Add(new BitmapImage(new Uri("/Images/hair3.png", UriKind.Relative)));

            eyeList.Add(new BitmapImage(new Uri("/Images/eyes1.png", UriKind.Relative)));
            eyeList.Add(new BitmapImage(new Uri("/Images/eyes2.png", UriKind.Relative)));
            eyeList.Add(new BitmapImage(new Uri("/Images/eyes3.png", UriKind.Relative)));

            noseList.Add(new BitmapImage(new Uri("/Images/nose1.png", UriKind.Relative)));
            noseList.Add(new BitmapImage(new Uri("/Images/nose2.png", UriKind.Relative)));
            noseList.Add(new BitmapImage(new Uri("/Images/nose3.png", UriKind.Relative)));

            mouthList.Add(new BitmapImage(new Uri("/Images/mouth1.png", UriKind.Relative)));
            mouthList.Add(new BitmapImage(new Uri("/Images/mouth2.png", UriKind.Relative)));
            mouthList.Add(new BitmapImage(new Uri("/Images/mouth3.png", UriKind.Relative)));

            EyeComboBox.ItemsSource = LoadComboBoxData();
            
            hair = new Faces(hairList, MainGrid, "hair");
            eyes = new Faces(eyeList, MainGrid, "eyes");
            nose = new Faces(noseList, MainGrid, "nose");
            mouth = new Faces(mouthList, MainGrid, "mouth");

            CommandHandler cmdNewHair = new CommandHandler(hair.NextImage, true);
            CommandHandler cmdNewNose = new CommandHandler(nose.NextImage, true);
            CommandHandler cmdNewMouth = new CommandHandler(mouth.NextImage, true);
            CommandHandler cmdNewEye = new CommandHandler(eyes.NextImage, true);

            CommandHandler cmdRandomFace = new CommandHandler(RandomFace, true);

            DataContext = new
            {
                newHair = cmdNewHair,
                newEye = cmdNewEye,
                newNose = cmdNewNose,
                newMouth = cmdNewMouth,
                randomFace = cmdRandomFace
            };

            // keybindings.
            InputBindings.Add(new KeyBinding(cmdNewHair, new KeyGesture(Key.D1, ModifierKeys.Control)));
            InputBindings.Add(new KeyBinding(cmdNewEye, new KeyGesture(Key.D2, ModifierKeys.Control)));
            InputBindings.Add(new KeyBinding(cmdNewNose, new KeyGesture(Key.D3, ModifierKeys.Control)));
            InputBindings.Add(new KeyBinding(cmdNewMouth, new KeyGesture(Key.D4, ModifierKeys.Control)));

            InputBindings.Add(new KeyBinding(cmdRandomFace, new KeyGesture(Key.R, ModifierKeys.Control)));
        }

        // call from keybinding and menu option
        public void RandomFace()
        {
            hair.RandomFace();
            eyes.RandomFace();
            nose.RandomFace();
            mouth.RandomFace();
        }
        public void MenuHairSelection(object sender, RoutedEventArgs e)
        {
            hair.NextImage();
        }

        public void MenuEyeSelection(object sender, RoutedEventArgs e)
        {
            eyes.NextImage();
        }

        public void MenuNoseSelection(object sender, RoutedEventArgs e)
        {
            nose.NextImage();
        }

        public void MenuMouthSelection(object sender, RoutedEventArgs e)
        {
            mouth.NextImage();
        }

        private void RandomFace_Click(object sender, RoutedEventArgs e)
        {

            hair.RandomFace();
            eyes.RandomFace();
            nose.RandomFace();
            mouth.RandomFace();
        }

        // helpNav
        private HelpNavigator helpNav = new HelpNavigator();

        private void Help_Click(object sender, RoutedEventArgs e)
        {
            HelpNavigator helpNav = HelpNavigator.Topic;
            Help.ShowHelp(null, "Project5-HelpDocs.chm", helpNav);

        }

        // from here down seems to be all old code.
        // we'll keep the code here so that we can see our progression.
        // This is an update from Assignment2-XAML and Assignment3-controls AND Assignment4-hotkeys and menus

        // indexs to help control the clicks through the different list items in each list.
        public int HairIndex { get; set; }
        public int EyesIndex { get; set; }
        public int NoseIndex { get; set; }
        public int MouthIndex { get; set; }

        // this is where we'd call all the data from the database if we had one to pull from
        private string[] LoadComboBoxData()
        {
            string[] strArray = {
            "Gray",
            "Brown",
            "Blue"
            };
            
            return strArray;
        }
        
        // element = hair, eyes, nose, or mouth
        private void AddImage(String element, int index, List<BitmapImage> list)
        {
            Image img = new Image();
            img.Source = list[index];
            img.Uid = element;
            img.Height = 434; // could really set these 2 as constants if we wanted.
            img.Width = 441;

            RemoveElement(element);

            MainGrid.Children.Add(img);
        }
        
        

        // start of code for project 3.
        private void Slider_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            Slider slider = sender as Slider;
            if (slider != null)
            {
                AddImage("hair", (int)slider.Value, hairList);
            }
        }

        private void Nose_CheckedChanged(object sender, RoutedEventArgs e)
        {
            CheckBox checkBox = sender as CheckBox;
            AddImage("nose", (int)checkBox.MinWidth, noseList);
        }

        private void EyeComboBox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            ComboBox eyeComboBox = sender as ComboBox;
            if (eyeComboBox != null) 
            {
                AddImage("eyes", eyeComboBox.SelectedIndex, eyeList);
            }
        }

        private void RB_Checked(object sender, RoutedEventArgs e)
        {
            RadioButton rb = sender as RadioButton;
            AddImage("mouth", (int)rb.MinWidth, mouthList);
        }

        private void NextImg(List<BitmapImage> currlist, int index, String element)
        {
            /// take the current list and move to the next image, append UID element for clean erasing
                        
            Image img = new Image();

            img.Source = currlist[index];
            img.Width = 441;
            img.Height = 434;
            
            MainGrid.Children.Add(img);
        }

        private void PrevImg(List<BitmapImage> currlist, int index, String element)
        {
            Image img = new Image();

            img.Source = currlist[index];
            img.Uid = element;
            img.Width = 441;
            img.Height = 434;

            MainGrid.Children.Add(img);
        }

        private void RemoveElement(String element)
        {

            // targeted removal by UID. We programmatically set these within the methods.
            foreach (UIElement ui in MainGrid.Children)
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

        private void HairPrev_Click(object sender, RoutedEventArgs e)
        {
            // these are essentially all the same. remove the targeted previous image, reduce the associated index,
            // pass that index along to the prevImage method. could use pointers here, would save memory.

            RemoveElement("hair");

            --HairIndex;

            if (HairIndex < 0)
            {
                HairIndex = hairList.Count - 1;
            }

            PrevImg(hairList, HairIndex, "hair");
        }

        private void HairNext_Click(object sender, RoutedEventArgs e)
        {

            // again, all the same, except incrementing. if we get to the end of the list, we just reset the counter.
            // "Reset the clock!" - Pacific Rim
            RemoveElement("hair");

            ++HairIndex;

            if (HairIndex > hairList.Count - 1)
            {
                HairIndex = 0;
            }

            NextImg(hairList, HairIndex, "hair");
        }

        private void EyesPrev_Click(object sender, RoutedEventArgs e)
        {
            RemoveElement("eyes");

            --EyesIndex;

            if (EyesIndex < 0)
            {
                EyesIndex = eyeList.Count - 1;
            }

            PrevImg(eyeList, EyesIndex, "eyes");
        }

        private void EyesNext_Click(object sender, RoutedEventArgs e)
        {
            RemoveElement("eyes");

            ++EyesIndex;

            if (EyesIndex > eyeList.Count - 1)
            {
                EyesIndex = 0;
            }

            NextImg(eyeList, EyesIndex, "eyes");
        }

        private void NosePrev_Click(object sender, RoutedEventArgs e)
        {
            RemoveElement("nose");

            --NoseIndex;

            if (NoseIndex < 0)
            {
                NoseIndex = noseList.Count - 1;
            }

            PrevImg(noseList, NoseIndex, "nose");
        }
                
        private void NoseNext_Click(object sender, RoutedEventArgs e)
        {
            RemoveElement("nose");

            ++NoseIndex;

            if (NoseIndex > noseList.Count - 1)
            {
                NoseIndex = 0;
            }

            NextImg(noseList, NoseIndex, "nose");
        }

        private void MouthPrev_Click(object sender, RoutedEventArgs e)
        {
            RemoveElement("mouth");

            --MouthIndex;

            if (MouthIndex < 0)
            {
                MouthIndex = mouthList.Count - 1;
            }

            PrevImg(mouthList, MouthIndex, "mouth");
        }

        private void MouthNext_Click(object sender, RoutedEventArgs e)
        {
            RemoveElement("mouth");

            ++MouthIndex;

            if (MouthIndex > mouthList.Count - 1)
            {
                MouthIndex = 0;
            }

            NextImg(mouthList, MouthIndex, "mouth");
        }
    }
}