using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task2
{
     internal class Product
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string UPC { get; set; }
        public string Manufacturer { get; set; }
        public double Price { get; set; }
        public DateTime ExpiryDate { get; set; }
        public int Quantity { get; set; }
    }

    internal class Store
    {
        private List<Product> products = new List<Product>();
        public Store()
        {
            products = new List<Product>();
            
        }
        public void AddProduct(Product product)
        {
            products.Add(product);
        }
        public void GenerateProductsFromDataFile(string filename)
        {
            StreamReader file = new StreamReader(filename);
            string line;
            while ((line = file.ReadLine()) != null)
            {
                string[] data = line.Split(";");
                Product product = new Product
                {
                    Id = Convert.ToInt32(data[0]),
                    Name = data[1],
                    UPC = data[2],
                    Manufacturer = data[3],
                    Price = Convert.ToDouble(data[4]),
                    ExpiryDate = Convert.ToDateTime(data[5]),
                    Quantity = Convert.ToInt32(data[6])
                };
                products.Add(product);
            }
            file.Close();
           
        }

        public List<Product> GetProductsByName(string name)
        {
            Console.WriteLine($"Products with name {name}");
                        return products.Where(p => p.Name == name).ToList();
        }
        public void PrintProducts(List<Product> productList)
        {
            foreach (var item in productList)
            {
                Console.WriteLine($"Product Data:{item.Id} {item.UPC} {item.Name} {item.Manufacturer} {item.Price} {item.Quantity} {item.ExpiryDate}");

            }


        }

        public List<Product> GetProductsByNameAndPrice(string name, double maxPrice)
        {
            Console.WriteLine($"Products with name {name} and price<{maxPrice}");
            return products.Where(p => p.Name == name && p.Price <= maxPrice).ToList();
        }

        public List<Product> GetExpiredProducts()
        {
            Console.WriteLine("Expired Products");
            return products.Where(p => p.ExpiryDate < DateTime.Today).ToList();
        }

       
    }
}

