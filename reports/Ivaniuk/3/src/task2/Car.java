package Lab3;

class Car{
    private int carId;
    private String carBrand;
    private String carModel;
    private int year;
    private String carColor;
    private double carPrice;
    private String regNumber;
    private String carNumber;
    private String renterFIO;
    private String renterPassportNumber;

    public Car(int carId, String carBrand, String carModel, int year, String carColor, double carPrice, String regNumber, String carNumber, String renterFIO, String renterPassportNumber) {
        this.carId = carId;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.year = year;
        this.carColor = carColor;
        this.carPrice = carPrice;
        this.regNumber = regNumber;
        this.carNumber = carNumber;
        this.renterFIO = renterFIO;
        this.renterPassportNumber = renterPassportNumber;
    }

    public Car(){
        this.carId = 0;
        this.carBrand = "Undefined";
        this.carModel = "Undefined";
        this.year = 0;
        this.carColor = "Undefined";
        this.carPrice = 0.0;
        this.regNumber = "Undefined";
        this.carNumber = "Undefined";
        this.renterFIO = "Undefined";
        this.renterPassportNumber = "Undefined";
    }

    public void setCarId(int carId){
        this.carId = carId;
    }
    public void setCarBrand(String carBrand){
        this.carBrand=carBrand;
    }
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }
    public void setRegNum(String regNumber) {
        this.regNumber = regNumber;
    }
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
    public void setRenterFIO(String renterFIO) {
        this.renterFIO = renterFIO;
    }
    public void setRenterPassportNumber(String renterPassportNumber) {
        this.renterPassportNumber = renterPassportNumber;
    }
    public int getCarId() {
        return carId;
    }
    public String getCarBrand() {
        return carBrand;
    }
    public String getCarModel() {
        return carModel;
    }
    public int getYear() {
        return year;
    }
    public String getCarColor() {
        return carColor;
    }
    public double getCarPrice() {
        return carPrice;
    }
    public String getRegNumber() {
        return regNumber;
    }
    public String getCarNumber() {
        return carNumber;
    }
    public String getRenterFullName() {
        return renterFIO;
    }
    public String getRenterPassportNumber() {
        return renterPassportNumber;
    }
    public void printCarInfo(){
        System.out.println("id: "+ this.carId);
        System.out.println("brand: "+ this.carBrand);
        System.out.println("model: "+ this.carModel);
        System.out.println("year: "+ this.year);
        System.out.println("color: "+ this.carColor);
        System.out.println("price: "+ this.carPrice + "$");
        System.out.println("registration number: "+ this.regNumber);
        System.out.println("number: "+ this.carNumber);
        System.out.println("Renter FullName: "+ this.renterFIO);
        System.out.println("Renter passport number: "+ this.renterPassportNumber + "\n");
    }
}
