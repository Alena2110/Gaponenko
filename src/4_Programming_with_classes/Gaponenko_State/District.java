import java.util.ArrayList;

public class District {
    private String nameDistrict;//название района
    private ArrayList<City> district = new ArrayList<>();//список городов района

    public District(String nameDistrict) {
        this.nameDistrict = nameDistrict;
    }

    public void cityAdd(City city) {//добавление города к району
        district.add(city);
    }//добавление города к району

    public String getNameDistrict() {
        return nameDistrict;
    }

    public void setNameDistrict(String nameDistrict) {
        this.nameDistrict = nameDistrict;
    }

    @Override
    public String toString() {
        StringBuilder cities = new StringBuilder();
        for (City city : district) {
            cities.append(city).append("; ");
        }
        return "Район " + nameDistrict + " включает города: " + cities;
    }
}
