using Task2;

Store store = new Store();
store.GenerateProductsFromDataFile("products.txt");
store.PrintProducts(store.GetProductsByName("Apple"));
store.PrintProducts(store.GetProductsByNameAndPrice("Apple",2.40));
store.PrintProducts(store.GetExpiredProducts());

