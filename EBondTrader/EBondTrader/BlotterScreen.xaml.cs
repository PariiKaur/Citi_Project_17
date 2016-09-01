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
    /// Interaction logic for BlotterScreen.xaml
    /// </summary>
    public partial class BlotterScreen : Window
    {
        List<Trade> trade;

        public BlotterScreen(List<Trade> trade)
        {
            InitializeComponent();
            this.trade = trade;
        }

        private void LoadTrade(object sender, RoutedEventArgs e)
        {
            
                dataGridTrade.ItemsSource = trade;
            
        }
    }
}
