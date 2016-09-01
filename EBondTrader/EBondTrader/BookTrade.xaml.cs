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
using System.Windows.Shapes;
using System.Net;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Json;
using System.IO;
using System.Collections.Specialized;
namespace EBondTrader
{
    /// <summary>
    /// Interaction logic for BookTrade.xaml
    /// </summary>
    public partial class BookTrade : Window
    {
        string isinValue;
        private static string IP = "10.87.231.58";
        public BookTrade(string isinValue)
        {
            InitializeComponent();
            this.isinValue = isinValue;

        }

        
       

        private void LoadISIN(object sender, RoutedEventArgs e)
        {
            isin.Text = isinValue;
        }

        private void AddToSettleDate(object sender, SelectionChangedEventArgs e)
        {
            DateTime date = DateTime.Parse(tradeDate.ToString());
            DateTime s = date.AddDays(2);
            settleDate.Text = s.ToString();
        }

        private void LoadClientID(object sender, RoutedEventArgs e)
        {


            clientID.Items.Add("1");
         }

        private void PrintToListClient(object sender, SelectionChangedEventArgs e)
        {
            using (var client = new WebClient())
            {

                var values = new NameValueCollection();
                values["id"] = clientID.Text.ToString();


                var response = client.UploadValues("http://"+IP+":8080/ElectronicBondTraderWeb/rest/bond/client_retrieval_success", values);

                var responseString = Encoding.Default.GetString(response);
                
                if (responseString.CompareTo("Success")==0)
                {
                    var wc = new WebClient();
                    string host = "http://" + IP + ":8080/ElectronicBondTraderWeb/rest/bond/client_retrieval/"+clientID.SelectedItem.ToString();
                    var hello = wc.DownloadString(host);
                    byte[] byteArray = Encoding.UTF8.GetBytes(hello);
                    MemoryStream stream = new MemoryStream(byteArray);
                    DataContractJsonSerializer arraySerializer = new DataContractJsonSerializer(typeof(List<Client>));
                    List<Client> clients = (List<Client>)arraySerializer.ReadObject(stream);
                    foreach(Client item in clients)
                    {
                       
                        ClientDetails clientDetails = new ClientDetails(item);
                        clientDetails.Show();
                    }
                    
                    
                }
            }
            

           
        }

        private void Compute(object sender, RoutedEventArgs e)
        {
            using (var client = new WebClient())
            {

                var values = new NameValueCollection();
                values["isin"] = isin.Text.ToString();
                values["quantity"] = quantity.Text.ToString();
                values["trade_date"] = tradeDate.Text.ToString();
                values["yield"] = yield.Text.ToString();
                values["client_id"] = clientID.SelectedItem.ToString();


                var response = client.UploadValues("http://" + IP + ":8080/ElectronicBondTraderWeb/rest/order/compute_trade", values);

                //var responseString = Encoding.Default.GetString(response);
                //MessageBox.Show(responseString);

                var wc = new WebClient();
                string host = "http://" + IP + ":8080/ElectronicBondTraderWeb/rest/order/compute_trade";
                var hello = wc.DownloadString(host);
                byte[] byteArray = Encoding.UTF8.GetBytes(hello);
                
                MemoryStream stream = new MemoryStream(byteArray);
                DataContractJsonSerializer arraySerializer = new DataContractJsonSerializer(typeof(Result));
                Result item = (Result)arraySerializer.ReadObject(stream);
                MessageBox.Show(item.ToString());
                clean_Price.Text = item.cleanPrice.ToString();
                dirty_Price.Text = item.dirtyPrice.ToString();
                accrued_Interest.Text = item.accruedInterest.ToString();
                settled_Amount.Text = item.settledAmount.ToString();



            }
        }

        private void Clear(object sender, RoutedEventArgs e)
        {
            clean_Price.Text = "";
            dirty_Price.Text = "";
            yield.Text = "";
            accrued_Interest.Text = "";
            settled_Amount.Text = "";
        }

        private void Recompute(object sender, RoutedEventArgs e)
        {
            using (var client = new WebClient())
            {

                var values = new NameValueCollection();
                values["isin"] = isin.Text.ToString();
                values["quantity"] = quantity.Text.ToString();
                values["trade_date"] = tradeDate.Text.ToString();
                values["clean_price"] = clean_Price.Text.ToString();
                values["client_id"] = clientID.SelectedItem.ToString();


                var response = client.UploadValues("http://" + IP + ":8080/ElectronicBondTraderWeb/rest/order/recompute_trade", values);

                //var responseString = Encoding.Default.GetString(response);
                //MessageBox.Show(responseString);

                var wc = new WebClient();
                string host = "http://" + IP + ":8080/ElectronicBondTraderWeb/rest/order/recompute_trade";
                var hello = wc.DownloadString(host);
                byte[] byteArray = Encoding.UTF8.GetBytes(hello);

                MemoryStream stream = new MemoryStream(byteArray);
                DataContractJsonSerializer arraySerializer = new DataContractJsonSerializer(typeof(ResultRecompute));
                ResultRecompute item = (ResultRecompute)arraySerializer.ReadObject(stream);
                MessageBox.Show(item.ToString());
                yield.Text = item.yield.ToString();
                dirty_Price.Text = item.dirtyPrice.ToString();
                accrued_Interest.Text = item.accruedInterest.ToString();
                settled_Amount.Text = item.settledAmount.ToString();



            }
        }

        private void Buy(object sender, RoutedEventArgs e)
        {
            using (var client = new WebClient())
            {

                var values = new NameValueCollection();
                values["isin"] = isin.Text.ToString();
                values["quantity"] = quantity.Text.ToString();
                values["trade_date"] = tradeDate.Text.ToString();
                values["dirty_price"] = dirty_Price.Text.ToString();
                values["client_id"] = clientID.SelectedItem.ToString();
                

                var response = client.UploadValues("http://" + IP + ":8080/ElectronicBondTraderWeb/rest/order/buy", values);

                var responseString = Encoding.Default.GetString(response);
                //MessageBox.Show(responseString);

                MessageBox.Show(responseString);

                



            }
        }

        private void ShowTrade(object sender, RoutedEventArgs e)
        {

            var wc = new WebClient();
            string host = "http://" + IP + ":8080/ElectronicBondTraderWeb/rest/order/show_trades";
            var hello = wc.DownloadString(host);
            byte[] byteArray = Encoding.UTF8.GetBytes(hello);

            MemoryStream stream = new MemoryStream(byteArray);
            DataContractJsonSerializer arraySerializer = new DataContractJsonSerializer(typeof(List<Trade>));
            List<Trade> trades = (List<Trade>)arraySerializer.ReadObject(stream);
            
            BlotterScreen blotterScreen = new BlotterScreen(trades);
            blotterScreen.Show();
            
           
        }
    }
}
