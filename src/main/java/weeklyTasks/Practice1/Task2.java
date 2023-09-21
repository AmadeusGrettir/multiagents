package weeklyTasks.Practice1;

public class Task2 {
    public static void main(String[] args) {
        //int (-2_147_483_648 # 2_147_483_647)

        /*int inputInt = 2_147_483_000;
        long answer = 0;
        System.out.println(inputInt);

        answer += (inputInt/1_000_000_000);

        int zeroCount = 0;
        if (answer == 0) zeroCount ++;

        for (int i = 9; i > 1; i--) {
            answer += (long) ((inputInt % (Math.pow(10,i)) - inputInt % (Math.pow(10,i-1))) / (Math.pow(10,i-2)) * (Math.pow(10,9-i)));
            if (answer == 0) zeroCount ++;
        }
        answer += ((inputInt%10) * 1_000_000_000L);

        long finalAnswer = (long) (answer / Math.pow(10, zeroCount));

        System.out.println(finalAnswer);*/


        //////////////////////////////////

        int inputInt = 2_147_483_000;
        int answer = 0;
        int count = 0;

        while (inputInt != 0) {
            answer += inputInt % 10;
            inputInt /= 10;
            if (answer==0) count++;

            if (inputInt != 0) {
                answer *= 10;
            }
        }

        for (int i = 0; i < count; i++) {
            System.out.print("0");
        }
        System.out.printf("%d %n",answer);
    }
}
