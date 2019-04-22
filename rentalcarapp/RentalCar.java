//package [your package name here];

public class RentalCar {
    private int id;
    private String name;
    private String brand;
    private double costPerDay;
    private String url;
    private int image;


    public RentalCar() {
    }

    public RentalCar(int id, String name, String brand, double costPerDay, String url, int image) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.costPerDay = costPerDay;
        this.url = url;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
