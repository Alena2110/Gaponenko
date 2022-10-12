import java.util.ArrayList;

public class State {
    private String nameState;//название государства
    private String capital;//столица государства
    private String square;//площадь
    private ArrayList<Region> state = new ArrayList<>();//список областей государства

    public State(String nameState, String capital, String square) {
        this.nameState = nameState;
        this.capital = capital;
        this.square = square;
    }

    public String getSquare() {
        return square;
    }

    public String getNameState() {
        return nameState;
    }

    public void setNameState(String nameState) {
        this.nameState = nameState;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setSquare(String square) {
        this.square = square;
    }

    public void regionAdd(Region region) {//добавление области к государству
        state.add(region);
    }

    public int numberOfRegions() {//определение количества областей
        return state.size();
    }

    @Override
    public String toString() {
        StringBuilder regions = new StringBuilder();
        for (Region region : state) {
            regions.append("\n").append(region.getNameRegion()).append(" область").append(", областной центр: ").append(region.getRegionalCenter());
        }
        return "Государство " + nameState + "; площадь: " + square + "; количество областей: " + numberOfRegions() + ".\n"
                + regions.toString();

    }
}
