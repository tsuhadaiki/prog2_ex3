import java.util.Scanner;
public class Main {
    //　3桁の数当てゲーム「ヌメロン」
    //　一人でプレイする場合は、ランダムに設定された数を探し出す
    //　二人でプレイする場合は、設定画面や回答画面が交互に現れる
    public static void main(String[] args){
        // タイトル
        System.out.println ("   　ヌメロン    ");
        //　説明文
        System.out.println("指定した3つの数字をあてます。" +
                "\n数字は0から9の間で決めています。" +
                "\n3つの数字は同じ数字でははありません。" +
                "\n入力した数字と位置があっていたら1つ当たってたら1イート、" +
                "\n数字はあっているが位置が違う場合は1バイトとカウントします。" +
                "\n全ての数字の位置と値が当たっていれば終了です\n\n" +
                //　プレイ人数選択肢
                "\nプレイヤー人数を下記から選び、数字をご記入下さい。" +
                "\n1：お一人様" +
                "\n2：二人用");
        //　選択肢記入場面
        //　記入画面をループ文で設定し、必ず記入することを許容する
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("記入：");
            int num = scanner.nextInt();
            //　一人用の場合
            if (num == 1) {
                System.out.println("「一人用ヌメロン」\n" +
                        "〜隠された3桁の数字を探し出そう！〜\n" +
                        "一桁ずつ数字を記入してください");
                Numeron Nume = new Numeron();
                Nume.Numeron();
                break;
                //　二人用の場合
            } else if (num == 2) {
                System.out.println("「二人用ヌメロン」\n" +
                        "〜対戦相手より先に隠された数字を暴き出せ！〜\n" +
                        "一桁ずつ数字を記入してください");
                Numeron2 Name = new Numeron2();
                Name.Numeron2();
                break;
                //　それ以外の記入の場合、ループの最初に戻る
            } else {
                continue;
            }
        }
    }
}
