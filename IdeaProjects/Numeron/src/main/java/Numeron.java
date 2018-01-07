import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Numeron {
    public static void Numeron() {
        int[] answer = new int[3];// 答えが入る
        int[] input = new int[3];// 入力した答えが入る
        int hit = 0, blow = 0, count = 0;
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < answer.length; i++) {
            boolean flag = false;
            answer[i] = (int) (Math.random() * 9 + 1);
            do {
                flag = false;
                for (int j = i - 1; j >= 0; j--) {
                    if (answer[i] == answer[j]) {
                        flag = true;
                        answer[i] = (int) (Math.random() * 9 + 1);
                    }
                }
            } while (flag == true);
        }
        while (true) {
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
                }
            }
            judg(answer,input);
            if (hit == 3){
                break;
            }
        }
    }
    public static int judg(int[] answer, int[] input) {
        int hit = 0;
        int blow = 0;
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                if (i == j && input[i] == answer[j]) {
                    hit++;
                } else if (input[i] == answer[j]) {
                    blow++;
                }
            }
        }
        System.out.println("ヒット" + hit + " ブロー" + blow);
        if (hit == 3) {
            System.out.println("おめでとー");
            return hit;
        } else {
            System.out.println();
        }
        return hit;
    }
}