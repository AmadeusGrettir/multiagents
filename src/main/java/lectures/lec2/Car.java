package lectures.lec2;

public class Car {
    private String model = "Default";
    private int age;
    private double wheelRadius;

    private WheelType wheelType;



    public Car(){
    }

    public WheelType getWheelType() {
        return wheelType;
    }

    public void setWheelType(WheelType wheelType) {
        this.wheelType = wheelType;
    }

    public Car(String lada, int i, double v){
        this.age = i;
        this.wheelRadius = v;
        this.model=lada;
    }

    public String shortInfo(){
        return model + " " + age + " radius: " + wheelRadius;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWheelRadius() {
        return wheelRadius;
    }

    public void setWheelRadius(double wheelRadius) {
        this.wheelRadius = wheelRadius;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String
    toString() {
        return "lectures.lec2.Car{" +
                "model='" + model + '\'' +
                ", age=" + age +
                ", wheelRadius=" + wheelRadius +
                ", wheelType=" + wheelType.toString() +
                '}';
    }


}
