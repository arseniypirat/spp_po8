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

namespace Task2
{
    /// <summary>
    /// Логика взаимодействия для ModalWindow.xaml
    /// </summary>
    public partial class ModalWindow : Window
    {
        public ModalWindow()
        {
            InitializeComponent();

            slider.Minimum = 1;
            slider.Maximum = 12;
        }

        public double Slider => slider.Value;

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            this.DialogResult = true;
        }
    }
}
