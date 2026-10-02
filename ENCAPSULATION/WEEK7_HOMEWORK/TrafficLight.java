public class TrafficLight {

    private String color;
    private final String id;

    public TrafficLight(String id) {
        this.id = id;
        color = "RED";
    }

    public void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
    }

    public String getColor() {
        return color;
    }
}