using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Json;
using System.IO;
using System.Net;
using System.Collections.Specialized;

namespace EBondTrader
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private static string IP = "10.87.231.58:8080";
        public MainWindow()
        {
            InitializeComponent();
            var wc = new WebClient();
            wc.Proxy = null;
            string host = " http://" + IP + "/ElectronicBondTraderWeb/rest/bond";
            var hello = wc.DownloadString(host);
            byte[] byteArray = Encoding.UTF8.GetBytes(hello);
            MemoryStream stream = new MemoryStream(byteArray);
            DataContractJsonSerializer arraySerializer = new DataContractJsonSerializer(typeof(List<Bond>));
            List<Bond> products = (List<Bond>)arraySerializer.ReadObject(stream);
            dataGrid.ItemsSource = products;
            //dataGrid.Style.Resources.Source.
            
            

        }


        private void UpdateBonds(object sender, RoutedEventArgs e)
        {
            
        }

        private void Refresh(object sender, RoutedEventArgs e)
        {
            //using (var client = new WebClient())
            //{

            //    var values = new NameValueCollection();
            //    //values[""] = ";
            //    values["contact"] = "455";

            //    var response = client.UploadValues("http://" + IP + "/ElectronicBondTraderWeb/rest/bond?", values);

            //    var responseString = Encoding.Default.GetString(response);

            //}




            var wc = new WebClient();


            string host = ReturnFilterString();
            var hello = wc.DownloadString(host);
            byte[] byteArray = Encoding.UTF8.GetBytes(hello);
            MemoryStream stream = new MemoryStream(byteArray);
            DataContractJsonSerializer arraySerializer = new DataContractJsonSerializer(typeof(List<Bond>));
            List<Bond> products = (List<Bond>)arraySerializer.ReadObject(stream);
            dataGrid.ItemsSource = products;

            
            



       }

      

        private string ReturnFilterString()
        {
            if (bondRating.SelectedIndex == -1 && currency.SelectedIndex == -1 && bondType.SelectedIndex==-1)
            {
                return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond?";
            }

            else if (bondRating.SelectedIndex==-1 && currency.SelectedIndex == -1)
            {
                return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond?type=" + bondType.SelectedItem;
            }

            else if (currency.SelectedIndex == -1)
            {
                return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond?type="+bondType.SelectedItem+"&rating="+bondRating.SelectedItem;
            }

            else if (bondType.SelectedIndex == -1)
            {
                return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond?rating="+bondRating.SelectedItem+"&currency="+currency.SelectedItem;
            }
            else if (bondRating.SelectedIndex == -1  && bondType.SelectedIndex == -1)
            {
                return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond?currency="+currency.SelectedItem;
            }
            
            else  return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond?type="+bondType.SelectedItem+"&rating="+bondRating.SelectedItem+"&currency="+currency.SelectedItem;
            

            //if (bondType.SelectedIndex==-1)
            //{
            //    return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond?" + bondRating.SelectedItem;
            //}

            //if ((string)bondType.SelectedItem == "Corporate" && (string)bondRating.SelectedItem == "AAA")
            //{
            //    return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond/query/Corporate/AAA ";
            //}
            //else if ((string)bondType.SelectedItem == "Corporate" && (string)bondRating.SelectedItem == "A")
            //{
            //    return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond/query/Corporate/A ";
            //}
            //else if ((string)bondType.SelectedItem == "Corporate" && (string)bondRating.SelectedItem == "BBB+")
            //{
            //    return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond/query/Corporate/BBB+ ";
            //}
            //else if ((string)bondType.SelectedItem == "Corporate" && (string)bondRating.SelectedItem == "BBB")
            //{
            //    return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond/query/Corporate/BBB ";
            //}
            //else if ((string)bondType.SelectedItem == "Corporate" && (string)bondRating.SelectedItem == "BB+")
            //{
            //    return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond/query/Corporate/BB+ ";
            //}
            //else if ((string)bondType.SelectedItem == "Corporate" && (string)bondRating.SelectedItem == "CCC")
            //{
            //    return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond/query/Corporate/CCC ";
            //}
            //else if ((string)bondType.SelectedItem == "Corporate" && (string)bondRating.SelectedItem == "D")
            //{
            //    return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond/query/Corporate/D ";
            //}
            //if ((string)bondType.SelectedItem == "Treasury" && (string)bondRating.SelectedItem == "AAA")
            //{
            //    return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond/query/Treasury/AAA ";
            //}
            //else if ((string)bondType.SelectedItem == "Treasury" && (string)bondRating.SelectedItem == "A")
            //{
            //    return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond/query/Treasury/A ";
            //}
            //else if ((string)bondType.SelectedItem == "Treasury" && (string)bondRating.SelectedItem == "BBB+")
            //{
            //    return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond/query/Treasury/BBB+ ";
            //}
            //else if ((string)bondType.SelectedItem == "Treasury" && (string)bondRating.SelectedItem == "BBB")
            //{
            //    return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond/query/Treasury/BBB ";
            //}
            //else if ((string)bondType.SelectedItem == "Treasury" && (string)bondRating.SelectedItem == "BB+")
            //{
            //    return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond/query/Treasury/BB+ ";
            //}
            //else if ((string)bondType.SelectedItem == "Treasury" && (string)bondRating.SelectedItem == "CCC")
            //{
            //    return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond/query/Treasury/CCC ";
            //}
            //else if ((string)bondType.SelectedItem == "Treasury" && (string)bondRating.SelectedItem == "D")
            //{
            //    return "http://" + IP + "/ElectronicBondTraderWeb/rest/bond/query/Treasury/D ";
            //}


            return null;    
        }


        private void BondType(object sender, RoutedEventArgs e)
        {
            bondType.Items.Add("Corporate");
            bondType.Items.Add("Treasury");
        }

        private void BondRating(object sender, RoutedEventArgs e)
        {
            bondRating.Items.Add("AAA");
            bondRating.Items.Add("A");
            bondRating.Items.Add("BBB+");
            bondRating.Items.Add("BBB");
            bondRating.Items.Add("BB+");
            bondRating.Items.Add("CCC");
            bondRating.Items.Add("D");

        }

        private void ShowBookTrade(object sender, RoutedEventArgs e)
        {

            string isinValue = ((Bond)dataGrid.SelectedItem).bond_ID.ToString();
            BookTrade bookTrade = new BookTrade(isinValue);
            bookTrade.Show();
        }

        private void Test(object sender, RoutedEventArgs e)
        {
            using (var client = new WebClient())
            {
                
                var values = new NameValueCollection();
                values["name"] = "hello";
                values["contact"] = "455";

                var response = client.UploadValues("http://"+IP+"/ElectronicBondTraderWeb/rest/bond/post_test", values);

                var responseString = Encoding.Default.GetString(response);

            }
        }

        private void ShowBond(object sender, MouseButtonEventArgs e)
        {
            Bond b = (Bond)dataGrid.SelectedItem;
            if (b.change > 0)
            {
                Green.Visibility = Visibility.Visible;
                Red.Visibility = Visibility.Hidden;
                
            }
            else
            {
                Red.Visibility = Visibility.Visible;
                Green.Visibility = Visibility.Hidden;
            }
            issuer.Text = b.issuer_Name.ToString();
            txtchange.Text = b.change.ToString();
        }

        private void ShowTop5(object sender, RoutedEventArgs e)
        {
            var wc = new WebClient();
            string host = "http://" + IP +"/ElectronicBondTraderWeb/rest/bond/top5";
            var hello = wc.DownloadString(host);
            byte[] byteArray = Encoding.UTF8.GetBytes(hello);

            MemoryStream stream = new MemoryStream(byteArray);
            DataContractJsonSerializer arraySerializer = new DataContractJsonSerializer(typeof(List<Bond>));
            List<Bond> top5Bonds = (List<Bond>)arraySerializer.ReadObject(stream);

            Top5 top5 = new Top5(top5Bonds);
            top5.Show();
        }

        private void PopulateCurrency(object sender, RoutedEventArgs e)
        {
            currency.Items.Add("INR");
            currency.Items.Add("USD");
            currency.Items.Add("GBP");
            currency.Items.Add("GPB");
            currency.Items.Add("JPY");
            currency.Items.Add("JPB");
        }

        //private void ShowBond(object sender, SelectionChangedEventArgs e)
        //{
        //   if((Bond))
        //}
    }
}
