import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Numeron2 {

    /*これは二人用に直す。具体的には入力部の追加と判定とか*/
    public static void main(String[] args) {
        //変数の初期化。
        /*必要な変数
         * タイトル、ルール文、答えの格納される配列、
         * 入力された数字の格納される配列。
         */
        String title = "   　ヌメロン    ";// タイトル
        String rule = "プレイヤーが指定した3つの数字をあてます。\n"
                + "数字は0から9の間で決めています。\n"
                + "3つの数字は同じ数字でははありません。\n"
                + "入力した数字と位置があっていたら1つ当たってたら1イート、\n"
                + "数字はあっているが位置が違う場合は1バイトとカウントします。\n"
                + "全ての数字の位置と値が当たっていれば終了です\n\n";
        int[] answer1 = new int[3];// 答えが入る
        int[] input1 = new int[3];// 入力した答えが入る
        int[] answer2 = new int[3];// 答えが入る
        int[] input2 = new int[3];// 入力した答えが入る
        int countturn1 = 0, countturn2 = 0;
        int eat = 0, bit = 0;
        //タイトルとルールの表示
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(title);
        System.out.println(rule);
            /*ここに入力部と入力に同じ数字が使われていないかの判定部、ついでにゲームの判定を突っ込んだら１つにはなる。
            * そのあとどうにかして３人でやるためにmainメソッド+３つのメソッドに分ける必要がある（mainメソッドが７０行を超えるようであれば２つでいい）*/
        System.out.println("一人目の３桁の数字を１個ずつ入力してください");
        for (int i = 0; i < answer1.length; i++) {
                //自分より前の要素にかぶるやつがないか確かめる。
                //あったらもう1回入力作業
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
        System.out.println("二人目の３桁の数字を１個ずつ入力してください");
        for (int i = 0; i < answer2.length; i++) {
            //自分より前の要素にかぶるやつがないか確かめる。
            //あったらもう1回入力作業
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
        while(true){
            if (countturn1 == countturn2) {
                while (countturn1 == countturn2) {
                    countturn1++;
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
                    //終了判断　イートが3つになったら終了
                    System.out.println("イート" + eat + "バイト" + bit);
                    if (eat == 3) {
                        System.out.println("終了");
                        break;
                    } else if(eat < 3){
                        System.out.println();
                    }
                }
            }else{
                while (countturn1 > countturn2) {
                    countturn2++;
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
                    //終了判断　イートが3つになったら終了
                    //終了判断　イートが3つになったら終了
                    System.out.println("イート" + eat + "バイト" + bit);
                    if (eat == 3) {
                        System.out.println("終了");
                        break;
                    } else if(eat < 3){
                        System.out.println();
                    }
                }
            }
        }
    }
}