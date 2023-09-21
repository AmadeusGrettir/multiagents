package weeklyTasks.converter;

public class Yen implements Converse{
    @Override
    public double convertToRub(double ue) {
        return ue*0.6459;
    }

    @Override
    public double convertToCurency(double rub) {
        return rub*1.5483;
    }

    @Override
    public Type getType() {
        return Type.JPY;
    }
}
