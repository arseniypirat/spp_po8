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

namespace Task1
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private readonly List<MyRect> rectangles = [];
        private readonly List<Point> points = [];

        public MainWindow()
        {
            InitializeComponent();
        }

        private void Canvas_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {
            Point mousePosition = e.GetPosition(canvas);

            Rectangle rectangle = new()
            {
                Width = 50,
                Height = 30,
                Fill = Brushes.White,
                Stroke = Brushes.Black,
                StrokeThickness = 1,
            };

            double left = mousePosition.X - rectangle.Width / 2;
            double top = mousePosition.Y - rectangle.Height / 2;

            Canvas.SetLeft(rectangle, left);
            Canvas.SetTop(rectangle, top);

            rectangles.Add(new MyRect(new Point(left, top), rectangle.Width, rectangle.Height));
            canvas.Children.Add(rectangle);
        }

        private void Canvas_MouseRightButtonDown(object sender, MouseButtonEventArgs e)
        {
            Point mousePosition = e.GetPosition(canvas);

            Ellipse point = new()
            {
                Width = 5,
                Height = 5,
                Fill = Brushes.Red,
            };

            if (rectangles.Any(rect => rect.Contains(mousePosition)))
            {
                point.Fill = Brushes.Green;
            }
            
            Canvas.SetLeft(point, mousePosition.X - point.Width / 2);
            Canvas.SetTop(point, mousePosition.Y - point.Height / 2);

            points.Add(mousePosition);
            canvas.Children.Add(point);
        }
    }
}