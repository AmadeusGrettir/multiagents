package weeklyTasks.converter;

public class Dollar implements Converse{
    @Override
    public double convertToRub(double ue) {
        return ue*94.7035;
    }

    @Override
    public double convertToCurency(double rub) {
        return rub*0.0106;
    }

    @Override
    public Type getType() {
        return Type.USD;
    }
}
