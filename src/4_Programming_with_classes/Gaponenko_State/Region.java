import java.util.ArrayList;

public class Region {
    private String nameRegion;//название области
    private ArrayList<District> region = new ArrayList<>();//список районов в области
    private String regionalCenter;//областной центр

    public Region(String nameRegion, String regionalCenter) {
        this.nameRegion = nameRegion;
        this.regionalCenter = regionalCenter;
    }

    public String getNameRegion() {
        return nameRegion;
    }

    public void setNameRegion(String nameRegion) {
        this.nameRegion = nameRegion;
    }

    public void setRegionalCenter(String regionalCenter) {
        this.regionalCenter = regionalCenter;
    }

    public String getRegionalCenter() {
        return regionalCenter;
    }

    public void districtAdd(District district) {//добавление района к области
        region.add(district);
    }

    public String toString() {
        StringBuilder districts = new StringBuilder();
        for (District district : region) {
            districts.append(district.getNameDistrict()).append("; ");
        }
        return "Область " + nameRegion + " включает районы: " + districts;
    }
}
