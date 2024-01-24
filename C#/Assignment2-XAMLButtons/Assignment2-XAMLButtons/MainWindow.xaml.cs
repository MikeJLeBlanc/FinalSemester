using System;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Xml.Linq;

namespace Assignment2_XAMLButtons
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        // initiation of needed variables.
        private int hairIndex, eyesIndex, mouthIndex, noseIndex;

        private List<BitmapImage> hairList = new List<BitmapImage>();
        private List<BitmapImage> eyeList = new List<BitmapImage>();
        private List<BitmapImage> noseList = new List<BitmapImage>();
        private List<BitmapImage> mouthList = new List<BitmapImage>();

        //used for targeted removal of elements in the Grid.
        private List<UIElement> itemsToRemove = new List<UIElement>();

        public MainWindow()
        {
            InitializeComponent();

            /// <summary
            /// add images to images lists
            /// </summary>
            
            hairList.Add(new BitmapImage(new Uri("Images/hair1.png", UriKind.Relative)));
            hairList.Add(new BitmapImage(new Uri("Images/hair2.png", UriKind.Relative)));
            hairList.Add(new BitmapImage(new Uri("Images/hair3.png", UriKind.Relative)));

            eyeList.Add(new BitmapImage(new Uri("Images/eyes1.png", UriKind.Relative)));
            eyeList.Add(new BitmapImage(new Uri("Images/eyes2.png", UriKind.Relative)));
            eyeList.Add(new BitmapImage(new Uri("Images/eyes3.png", UriKind.Relative)));

            noseList.Add(new BitmapImage(new Uri("Images/nose1.png", UriKind.Relative)));
            noseList.Add(new BitmapImage(new Uri("Images/nose2.png", UriKind.Relative)));
            noseList.Add(new BitmapImage(new Uri("Images/nose3.png", UriKind.Relative)));

            mouthList.Add(new BitmapImage(new Uri("Images/mouth1.png", UriKind.Relative)));
            mouthList.Add(new BitmapImage(new Uri("Images/mouth2.png", UriKind.Relative)));
            mouthList.Add(new BitmapImage(new Uri("Images/mouth3.png", UriKind.Relative)));
        }

        // indexs to help control the clicks through the different list items in each list.
        public int HairIndex { get; set; }
        public int EyesIndex { get; set; }
        public int NoseIndex { get; set; }
        public int MouthIndex { get; set; }

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

        private void RandomFace_Click(object sender, RoutedEventArgs e)
        {
            Random random = new Random();

            HairIndex = random.Next(hairList.Count - 1);
            EyesIndex = random.Next(hairList.Count - 1);
            NoseIndex = random.Next(hairList.Count - 1);
            MouthIndex = random.Next(hairList.Count - 1);

            Image hairImg = new Image();
            Image eyeImg = new Image();
            Image noseImg = new Image();
            Image mouthImg = new Image();

            // Prepare images before plastering on the grid

            hairImg.Source = hairList[HairIndex];
            hairImg.Uid = "hair";
            hairImg.Width = 441;
            hairImg.Height = 434;

            eyeImg.Source = eyeList[EyesIndex];
            eyeImg.Uid = "eyes";
            eyeImg.Width = 441;
            eyeImg.Height = 434;

            noseImg.Source = noseList[NoseIndex];
            noseImg.Uid = "nose";
            noseImg.Width = 441;
            noseImg.Height = 434;

            mouthImg.Source = mouthList[MouthIndex];
            mouthImg.Uid = "mouth";
            mouthImg.Width = 441;
            mouthImg.Height = 434;

            // Remove elements right before setting them back so theres less of a time gap where there is no images.
            // Should be quick enough to where only a debugger sees an empty space.

            RemoveElement("hair");
            RemoveElement("eyes");
            RemoveElement("nose");
            RemoveElement("mouth");

            MainGrid.Children.Add(hairImg);
            MainGrid.Children.Add(eyeImg);
            MainGrid.Children.Add(noseImg);
            MainGrid.Children.Add(mouthImg);
        }

        private void NextImg(List<BitmapImage> currlist, int index, String element)
        {
            /// take the current list and move to the next image, append UID element for clean erasing
            
            Image img = new Image();

            img.Source = currlist[index];
            img.Uid = element;
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
    }
}