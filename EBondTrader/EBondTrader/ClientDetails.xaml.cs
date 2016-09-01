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

namespace EBondTrader
{
    /// <summary>
    /// Interaction logic for ClientDetails.xaml
    /// </summary>
    public partial class ClientDetails : Window
    {
        Client client;
        public ClientDetails(Client client)
        {
            InitializeComponent();
            this.client = client;
        }

        private void LoadDetails(object sender, RoutedEventArgs e)
        {
            clientID.Text = client.client_Id.ToString();
            firstName.Text = client.first_Name.ToString();
            lastName.Text = client.last_Name.ToString();
            email.Text = client.email.ToString();
            contact.Text = client.phone.ToString();
        }
    }
}
