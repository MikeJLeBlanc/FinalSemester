using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Forms;
using System.Windows.Input;
using System.Windows.Media.Imaging;
using CheckBox = System.Windows.Controls.CheckBox;
using ComboBox = System.Windows.Controls.ComboBox;
using MessageBox = System.Windows.MessageBox;
using RadioButton = System.Windows.Controls.RadioButton;


namespace Assignment5_HelpMenu
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private List<BitmapImage> hairList = new List<BitmapImage>();
        private List<BitmapImage> eyeList = new List<BitmapImage>();
        private List<BitmapImage> noseList = new List<BitmapImage>();
        private List<BitmapImage> mouthList = new List<BitmapImage>();

        // used for targeted removal of elements in the Grid.
        private List<UIElement> itemsToRemove = new List<UIElement>();
        private DatabaseAccess dbAccess;
        private int dbIndex = 0;

        public Faces hair;
        public Faces eyes;
        public Faces nose;
        public Faces mouth;

        string connectionString = "Data Source=(LocalDB)\\MSSQLLocalDB;AttachDbFilename=E:\\school-work\\Year2\\Semester2\\C#\\Assignment5-HelpMenu\\Assignment5-HelpMenu\\userData.mdf;Integrated Security=True";

        public MainWindow()
        {
            InitializeComponent();

            LoadComboBox("Occupation", OccupationComboBox);
            LoadComboBox("Hobbies", HobbyComboBox);
            
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
            
            hair = new Faces(hairList, SecondaryGrid, "hair");
            eyes = new Faces(eyeList, SecondaryGrid, "eyes");
            nose = new Faces(noseList, SecondaryGrid, "nose");
            mouth = new Faces(mouthList, SecondaryGrid, "mouth");

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

            dbAccess = new DatabaseAccess();

            ResetGrid();
        }

        private void ResetGrid()
        {
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                string sql = "select * from Person";

                connection.Open();
                SqlCommand command = new SqlCommand(sql, connection);
                SqlDataAdapter adapter = new SqlDataAdapter(command);
                DataTable table = new DataTable("PersonGrid");
                adapter.Fill(table);
                PersonGrid.ItemsSource = table.DefaultView;
            }
        }

        // Tab 1 code
        private void InsertBtn_Click(object sender, RoutedEventArgs e)
        {
            string firstName = FNameTextBlock.Text;
            string lastName = LNameTextBlock.Text;
            string address = AddressTextBlock.Text;

            if (firstName != "" &&  lastName !="" &&  address != "")
            {
                dbAccess.InsertPerson(firstName, lastName, address);
            }
            else
            {
                MessageBox.Show("Empty field! \nBetter enter some of that there data you got!");
            }
            ResetGrid();
        }

        private void PersonGrid_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            try
            {
                dbIndex = (int)(PersonGrid.SelectedItem as DataRowView).Row.ItemArray[0];
                fNameTextBox.Text = (string)(PersonGrid.SelectedItem as DataRowView).Row.ItemArray[1];
                lNameTextBox.Text = (string)(PersonGrid.SelectedItem as DataRowView).Row.ItemArray[2];
                addressTextBox.Text = (string)(PersonGrid.SelectedItem as DataRowView).Row.ItemArray[3];
            }
            catch (NullReferenceException)
            {
                dbIndex = -1;
                fNameTextBox.Text = "D:";
                lNameTextBox.Text = "D:";
                addressTextBox.Text = "D:";
            }
        }
        private void UpdateBtn_Click(object sender, RoutedEventArgs e)
        {
            string firstName = fNameTextBox.Text;
            string lastName = lNameTextBox.Text;
            string address = addressTextBox.Text;
            if (dbIndex >= 0)
            {
                dbAccess.UpdatePerson(dbIndex, firstName, lastName, address);
            }
            ResetGrid();
        }

        private void DeleteBtn_Click(object sender, RoutedEventArgs e)
        {
            if (PersonGrid.SelectedItem != null)
            {
                int id = (int)(PersonGrid.SelectedItem as DataRowView).Row.ItemArray[0];
                dbAccess.DeletePerson(id);

                ResetGrid();
            }
        }

        private void CancelBtn_Click(object sender, RoutedEventArgs e)
        {
            fNameTextBox.Text = "";
            lNameTextBox.Text = "";
            addressTextBox.Text = "";
        }

        // Tab 2 code
        private void LoadComboBox(String DatabaseName, ComboBox ComboBoxName)
        {
            string sql = "SELECT * FROM " + DatabaseName;
            using (SqlConnection connection = new SqlConnection(connectionString))
            using (SqlCommand command = new SqlCommand(sql, connection))
            {
                connection.Open();
                
                using (SqlDataReader reader = command.ExecuteReader())
                {
                    while (reader.Read()) 
                    {
                        string item = reader.GetString(1);
                        ComboBoxName.Items.Add(item);
                        
                    }
                }
                
            }
        }

        // call from keybinding and menu option
        // Tab 3 code
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
        private void Help_Click(object sender, RoutedEventArgs e)
        {
            HelpNavigator helpNav = HelpNavigator.Topic;
            Help.ShowHelp(null, "Project5-HelpDocs.chm", helpNav);

        }

        // Checks which of the radio buttons is selected.
        private void AnimalLover(object sender, RoutedEventArgs e)
        {
            if (DogRadioBtn.IsChecked == true) 
            { 
                AnimalChoiceTextBlock.Text = "I am a Dog lover!"; 
            } 
            else 
            { 
                AnimalChoiceTextBlock.Text = "I am a Cat lover!"; 
            }
            
        }

        // Outputs to file. Space is needed between first and last names if writing on the same line.
        // tab 4 code
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            string[] lines =
            {
                FNameTextBlock.Text + " " + LNameTextBlock.Text,
                AddressTextBlock.Text,
                AnimalChoiceTextBlock.Text,
                OccupationTextBlock.Text,
                HobbyTextBlock.Text
            };

            string docPath = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);

            using (StreamWriter outputFile = new StreamWriter(Path.Combine(docPath, "Assignment6-TabItems.txt"))) 
            {
                foreach (string line in lines) { outputFile.WriteLine(line); }
            }
        }
    }
}
