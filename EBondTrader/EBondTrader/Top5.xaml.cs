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
    /// Interaction logic for Top5.xaml
    /// </summary>
    public partial class Top5 : Window
    {
        List<Bond> top5Bonds;
        public Top5(List<Bond> top5Bonds)
        {
            InitializeComponent();
            this.top5Bonds = top5Bonds;
        }

        private void LoadTop5(object sender, RoutedEventArgs e)
        {
            dataGrid.ItemsSource = top5Bonds;
        }
    }
}
