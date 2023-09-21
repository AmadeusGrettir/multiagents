package weeklyTasks.converter;

public class Euro implements Converse{
    @Override
    public double convertToRub(double ue) {
        return ue*101.5646;
    }

    @Override
    public double convertToCurency(double rub) {
        return rub*0.0098;
    }

    @Override
    public Type getType() {
        return Type.EUR;
    }
}
