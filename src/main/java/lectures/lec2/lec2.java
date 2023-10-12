package lectures.lec2;

public class lec2 {

    public static void main(String[] args) {
        Car car1 = new Car();

        car1.setAge(258);

        String info = car1.shortInfo();


        System.out.println(info);

        Car car3 = new Car("Lada",13,21.4);
        System.out.println(car3.shortInfo());


        WheelType wt = new WheelType("Nokian", 18, true);

        car3.setWheelType(wt);
        System.out.println(car3);

        Student st1 = new Student("Ivanov", 21);

        /*toString, Equals, HashCode, getClass*/

    }
}


