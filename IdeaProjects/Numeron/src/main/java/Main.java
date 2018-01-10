import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        System.out.println ("   　ヌメロン    ");// タイトル
        System.out.println("プレイヤーが指定した3つの数字をあてます。" +
                "\n数字は0から9の間で決めています。\n3つの数字は同じ数字でははありません。" +
                "\n入力した数字と位置があっていたら1つ当たってたら1イート、" +
                "\n数字はあっているが位置が違う場合は1バイトとカウントします。" +
                "\n全ての数字の位置と値が当たっていれば終了です\n\n" +
                "プレイヤー人数を下記から選び、数字をご記入下さい。\n1：お一人様\n2：リア充");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("記入：");
            int num = scanner.nextInt();
            if (num == 1) {
                Numeron Nume = new Numeron();
                Nume.Numeron();
                break;
            } else if (num == 2) {
                Numeron2 Name = new Numeron2();
                Name.Numeron2();
                break;
            } else {
                continue;
            }
        }
    }
}
