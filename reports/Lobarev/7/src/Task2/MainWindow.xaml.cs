using System.Windows;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Shapes;

namespace Task2
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private readonly double sqrt2 = Math.Sqrt(2);

        public MainWindow()
        {
            InitializeComponent();
        }


        private void canvas_MouseDown(object sender, MouseButtonEventArgs e)
        {
            var point = e.GetPosition(canvas);

            var modal = new ModalWindow();
            if (modal.ShowDialog() == true)
            {
                var depth = (int)modal.Slider;

                
                DrawHilbertFractal(depth, point);
            }
        }

        private async void DrawHilbertFractal(int depth, Point point)
        {
            double length = 200;


            var start = new Point(point.X - length / 2, point.Y);
            var end = new Point(point.X + length / 2, point.Y);


            Line line = new()
            {
                X1 = start.X,
                X2 = end.X,
                Y1 = start.Y,
                Y2 = end.Y,

                Stroke = Brushes.Black,
                StrokeThickness = 1,
            };

            DrawHorizontal(line, depth);
        }

        private void DrawVertical(Line line, int depth)
        {
            if (depth == 0)
            {
                return;
            }

            canvas.Children.Add(line);

            var length = (line.Y2 - line.Y1) / sqrt2;
            var line1 = new Line()
            {
                X1 = line.X1 - length / 2,
                X2 = line.X1 + length / 2,

                Y1 = line.Y1,
                Y2 = line.Y1,

                Stroke = Brushes.Black,
                StrokeThickness = 1,
            };

            var line2 = new Line()
            {
                X1 = line.X2 - length / 2,
                X2 = line.X2 + length / 2,

                Y1 = line.Y2,
                Y2 = line.Y2,

                Stroke = Brushes.Black,
                StrokeThickness = 1,
            };





            DrawHorizontal(line1, depth - 1);
            DrawHorizontal(line2, depth - 1);
        }

        private void DrawHorizontal(Line line, int depth)
        {
            if (depth == 0)
            {
                return;
            }

            canvas.Children.Add(line);

            var length = (line.X2 - line.X1) / sqrt2;

            var line1 = new Line()
            {
                X1 = line.X1,
                X2 = line.X1,

                Y1 = line.Y1 - length / 2,
                Y2 = line.Y1 + length / 2,

                Stroke = Brushes.Black,
                StrokeThickness = 1,
            };

            var line2 = new Line()
            {
                X1 = line.X2,
                X2 = line.X2,

                Y1 = line.Y2 - length / 2,
                Y2 = line.Y2 + length / 2,

                Stroke = Brushes.Black,
                StrokeThickness = 1,
            };



            DrawVertical(line1, depth - 1);
            DrawVertical(line2, depth - 1);
        }
    }
}