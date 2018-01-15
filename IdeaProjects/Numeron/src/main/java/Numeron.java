import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Numeron {
    public static void Numeron() {
        int[] answer = new int[3];// 答えが入る
        int[] input = new int[3];// 入力した答えが入る
        int eat = 0, count = 0;
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < answer.length; i++) {
            boolean flag = false;
            answer[i] = (int) (Math.random() * 10);
            do {
                flag = false;
                for (int j = i - 1; j >= 0; j--) {
                    if (answer[i] == answer[j]) {
                        flag = true;
                        answer[i] = (int) (Math.random() * 10);
                    }
                }
            } while (flag == true);
        }
        while (eat < 3) {
            count++;
            System.out.println("*** " + count + "回目 ***");
            for (int i = 0; i < answer.length; i++) {
                System.out.print((i + 1) + "個目 : ");
                try {
                    input[i] = Integer.parseInt(br.readLine());
                } catch (NumberFormatException e) {
                    System.err.println("数値を入力してください");
                    i--;
                } catch (IOException e) {
                    System.err.println("もう一度入力してください");
                    i--;
                } finally {
                    if(input[i] > 10) {
                        System.err.println("数字は0~9の範囲で入力してください");
                        i--;
                    }
                    for (int j = i - 1; j >= 0; j--) {
                        if (input[i] == input[j]) {
                            System.err.println("同じ数字を入力しないでください");
                            i--;
                        }
                    }
                }
            }
            eat = judg(answer,input);
        }
    }
    public static int judg(int[] answer, int[] input) {
        int eat = 0;
        int bit = 0;
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                if (i == j && input[i] == answer[j]) {
                    eat++;
                } else if (input[i] == answer[j]) {
                    bit++;
                }
            }
        }
        System.out.println(eat +"イート" + bit + "バイト" );
        if (eat == 3) {
            System.out.println("おめでとー");
        } else {
            System.out.println();
        }
        return eat;
    }
}