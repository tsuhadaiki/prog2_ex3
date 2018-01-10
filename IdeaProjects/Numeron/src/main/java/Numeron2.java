import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Numeron2 {
    public static void Numeron2() {
        int[] answer1 = new int[3];// 答えが入る
        int[] input1 = new int[3];// 入力した答えが入る
        int[] answer2 = new int[3];// 答えが入る
        int[] input2 = new int[3];// 入力した答えが入る
        int countturn1 = 0, countturn2 = 0;
        int exit =0;
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("一人目の３桁の数字を１個ずつ入力してください");
        judgnumber1(answer1);
        System.out.println("二人目の３桁の数字を１個ずつ入力してください");
        judgnumber2(answer2);
        while(exit == 0) {
            if (countturn1 == countturn2) {
                countturn1++;
                exit = Numeron2an(answer1, input1, countturn1);
            } else {
                countturn2++;
                exit = Numeron1an(answer2, input2, countturn2);
            }
        }
    }

    public static int Numeron1an(int[] answer2,int[] input2,int countturn2) {
        int eat = 0, bit = 0, exit = 0;
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("一人目の回答" + countturn2 + "回目");
        System.out.println("    " + countturn2 + "回目");
        for (int i = 0; i < answer2.length; i++) {
            System.out.print((i + 1) + "個目 : ");
            try {
                input2[i] = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.err.println("数値を入力してください");
                i--;
            } catch (IOException e) {
                System.err.println("もう一度入力してください");
                i--;
            }
        }
        eat = 0;
        bit = 0;
        for (int i = 0; i < answer2.length; i++) {
            for (int j = 0; j < answer2.length; j++) {
                if (i == j && input2[i] == answer2[j]) {
                    eat++;
                } else if (input2[i] == answer2[j]) {
                    bit++;
                }
            }
        }
        System.out.println(eat +"イート" + bit + "バイト" );
        if (eat == 3) {
            System.out.println("終了");
            exit++;
        } else if(eat < 3){
            System.out.println();
        }
        return exit;
    }

    public static int Numeron2an(int[] answer1,int[] input1,int countturn1){
        int eat = 0, bit = 0, exit =0;
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("二人目の回答" + countturn1 + "回目");
        System.out.println("    " + countturn1 + "回目");
        //インプット
        for (int i = 0; i < answer1.length; i++) {
            System.out.print((i + 1) + "個目 : ");
            try {
                input1[i] = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.err.println("数値を入力してください");
                i--;
            } catch (IOException e) {
                System.err.println("もう一度入力してください");
                i--;
            }
        }
        eat = 0;
        bit = 0;
        for (int i = 0; i < answer1.length; i++) {
            for (int j = 0; j < answer1.length; j++) {
                if (i == j && input1[i] == answer1[j]) {
                    eat++;
                } else if (input1[i] == answer1[j]) {
                    bit++;
                }
            }
        }
        System.out.println(eat +"イート" + bit + "バイト" );
        if (eat == 3) {
            System.out.println("二人目の勝ち\n終了");
            exit++;
        } else if (eat < 3) {
            System.out.println("次");
        }
        return exit;
    }

    public static void judgnumber1(int[] answer1){
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < answer1.length; i++) {
            System.out.print((i + 1) + "個目 : ");
            try {
                answer1[i] = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.err.println("数値を入力してください");
                i--;
            } catch (IOException e) {
                System.err.println("もう一度入力してください");
                i--;
            } finally {
                for (int j = i - 1; j >= 0; j--) {
                    if (answer1[i] == answer1[j]) {
                        System.err.println("同じ数字を入力しないでください");
                        i--;
                    }
                }
            }
        }
    }

    public static void judgnumber2(int[] answer2){
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < answer2.length; i++) {
            System.out.print((i + 1) + "個目 : ");
            try {
                answer2[i] = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.err.println("数値を入力してください");
                i--;
            } catch (IOException e) {
                System.err.println("もう一度入力してください");
                i--;
            } finally {
                for (int j = i - 1; j >= 0; j--) {
                    if (answer2[i] == answer2[j]) {
                        System.err.println("同じ数字を入力しないでください");
                        i--;
                    }
                }
            }
        }
    }
}