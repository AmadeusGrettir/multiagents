package weeklyTasks.converter;

public class Main {
    public static void main(String[] args) {
        /*Разработать систему конвертации валюты в различные формы: доллар, юань, йена, рубль.
    - разработать интерфейс Converter с тремя методами:
    double convertToRub(double ue);
    double convertToCurency(double rub);
    Type getType(); где Type - это тип валюты.
    - разработать три реализации для конвретации валюты
    - Создать класс обменник, который содержит массив всех конверторов и метод конвертации:
    convert(double value, Type input, Type output);*/

        Converter.convert(50, "EUR", "RUR");

    }
}