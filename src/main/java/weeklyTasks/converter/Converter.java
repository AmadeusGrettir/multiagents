package weeklyTasks.converter;

enum Type {
    JPY,
    EUR,
    USD,
    RUR;
}

public class Converter {
    public static void convert(double value, String input, String output) {

        Type[] types = Type.values();
        //for (Type s : types) { System.out.println(s); }

        boolean flagInput = false;
        boolean flagOutput = false;
        int i = 0;
        while ((!flagInput || !flagOutput)){
            if (i>types.length-1){
                System.out.println("Wrong currency type");
                return;
            }
            if (types[i].toString().equals(input.toUpperCase())){
                flagInput = true;
            }
            if (types[i].toString().equals(output.toUpperCase())){
                flagOutput = true;
            }
            i++;
        }

        double outcome = 0;

        if (Type.USD.toString().equals(input.toUpperCase())) {
            Converse wallet = new Dollar();
            outcome = wallet.convertToRub(value);

        } else if (Type.EUR.toString().equals(input.toUpperCase())){
            Converse wallet = new Euro();
            outcome = wallet.convertToRub(value);

        } else if (Type.JPY.toString().equals(input.toUpperCase())){
            Converse wallet = new Yen();
            outcome = wallet.convertToRub(value);
            
        } else if (Type.RUR.toString().equals(input.toUpperCase())){
            outcome = value;
        }

        double result = 0;

        if (Type.USD.toString().equals(output.toUpperCase())) {
            Converse walletNew = new Dollar();
            result = walletNew.convertToCurency(outcome);

        } else if (Type.EUR.toString().equals(output.toUpperCase())) {
            Converse walletNew = new Euro();
            result = walletNew.convertToCurency(outcome);

        } else if (Type.JPY.toString().equals(output.toUpperCase())) {
            Converse walletNew = new Yen();
            result = walletNew.convertToCurency(outcome);

        } else if (Type.RUR.toString().equals(output.toUpperCase())) {
            result = outcome;
        }

        System.out.printf("Converted %5.2f %s to %5.2f %s", value, input, result, output);

    }
}