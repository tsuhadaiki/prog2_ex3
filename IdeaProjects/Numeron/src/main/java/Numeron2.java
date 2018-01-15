import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Numeron2 {
    public static void Numeron2() {
        /*このNumeron2メソッドでは後述してあるメソッドを呼び出し、ゲームの形にするためのものである。*/
        int[] answer1 = new int[3];// 一人目の設定した答え（数字３桁）が入る
        int[] input1 = new int[3];// 一人目の入力した答え（二人目への回答）が入る
        int[] answer2 = new int[3];// 二人目の設定した答え（数字３桁）が入る
        int[] input2 = new int[3];// 二人目の入力した答え（一人目への回答）が入る
        int countturn1 = 0, countturn2 = 0;//一人目と二人目の解答回数をカウントするための変数
        int exit =0;//ループ処理から抜ける時に用いる変数
        System.out.println("一人目の３桁の数字を１個ずつ入力してください");
        settingnumber1(answer1);
        System.out.println("二人目の３桁の数字を１個ずつ入力してください");
        settingnumber2(answer2);
        //下部のwhile文では最初に二人目が回答するようにし、次に一人目が回答するようになっている。
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
        /*Numeron1anメソッドではイート、バイトの判定、また回答の結果を出力するための機能を実装した。また、try,catch構文で数字以外、
        同じ数字、2桁の数字、readLineで何らかの入出力エラーが起きた場合に対処できるようにしてある。*/
        int eat = 0, bit = 0, exit = 0;
        //
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("一人目の回答" + countturn2 + "回目");
        System.out.println("    " + countturn2 + "回目");
        for (int i = 0; i < answer2.length; i++) {
            System.out.print((i + 1) + "個目 : ");
            int dig = 0;
            try {
                //ここで全角英数字でも入力できるように対応
                input2[i] = Integer.parseInt(br.readLine());
                dig = input2[i];
            } catch (NumberFormatException e) {
                System.err.println("数値を入力してください");
                i--;
            } catch (IOException e) {
                System.err.println("もう一度入力してください");
                i--;
            } finally {
                if(dig >= 10){
                    System.err.println("数字は0~9の範囲で入力してください");
                    i--;
                }
                for (int j = i - 1; j >= 0; j--) {
                    if (input2[i] == input2[j]) {
                        System.err.println("同じ数字を入力しないでください");
                        i--;
                    }
                }
            }
        }
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
            System.out.println("   一人目の勝ち\n終了");
            exit++;
        } else if(eat < 3){
            System.out.println("   次は二人目   ");
        }
        return exit;
    }

    public static int Numeron2an(int[] answer1,int[] input1,int countturn1){
        /*Numeron2anメソッドでも同様にイート、バイトの判定、また回答の結果を出力するための機能を実装した。また、try,catch構文で数字以外、
        同じ数字、2桁の数字、readLineで何らかの入出力エラーが起きた場合に対処できるようにしてある。*/
        int eat = 0, bit = 0, exit =0;//イート、バイトの数を入れる変数
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("二人目の回答" + countturn1 + "回目");
        System.out.println("    " + countturn1 + "回目");
        for (int i = 0; i < answer1.length; i++) {
            System.out.print((i + 1) + "個目 : ");
            int dig = 0;
            try {
                //ここで全角英数字でも入力できるように対応
                input1[i] = Integer.parseInt(br.readLine());
                dig = input1[i];
            } catch (NumberFormatException e) {
                System.err.println("数値を入力してください");
                i--;
            } catch (IOException e) {
                System.err.println("もう一度入力してください");
                i--;
            } finally {
                if(dig >= 10){
                    System.err.println("数字は0~9の範囲で入力してください");
                    i--;
                }
                for (int j = i - 1; j >= 0; j--) {
                    if (input1[i] == input1[j]) {
                        System.err.println("同じ数字を入力しないでください");
                        i--;
                    }
                }
            }
        }
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
            System.out.println("   二人目の勝ち\n終了");
            exit++;
        } else if (eat < 3) {
            System.out.println("   次は一人目   ");
        }
        return exit;
    }

    public static void settingnumber1(int[] answer1){
        /*judgnumber1メソッドでは一人目の設定した答えを配列のanswer1に入れるための機能を実装した。try,catch構文で数字以外、
        同じ数字、2桁の数字、readLineで何らかの入出力エラーが起きた場合に対処できるようにしてある。*/
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < answer1.length; i++) {
            System.out.print((i + 1) + "個目 : ");
            int dig = 0;
            try {
                //ここで全角英数字でも入力できるように対応
                answer1[i] = Integer.parseInt(br.readLine());
                dig = answer1[i];
            } catch (NumberFormatException e) {
                System.err.println("数値を入力してください");
                i--;
            } catch (IOException e) {
                System.err.println("もう一度入力してください");
                i--;
            } finally {
                if(dig >= 10) {
                    System.err.println("数字は0~9の範囲で入力してください");
                    i--;
                }
                for (int j = i - 1; j >= 0; j--) {
                    if (answer1[i] == answer1[j]) {
                        System.err.println("同じ数字を入力しないでください");
                        i--;
                    }
                }
            }
        }
        //改行で入力した数字を見えないようにしたが、上スクロールすると見えてしまうので効果は薄い。
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

    public static void settingnumber2(int[] answer2){
        /*judgnumber2メソッドでも二人目の設定した答えを配列のanswer2に入れるための機能を実装した。try,catch構文で数字以外、
        同じ数字、2桁の数字、readLineで何らかの入出力エラーが起きた場合に対処できるようにしてある。*/
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < answer2.length; i++) {
            System.out.print((i + 1) + "個目 : ");
            int dig = 0;
            try {
                //ここで全角英数字でも入力できるように対応
                answer2[i] = Integer.parseInt(br.readLine());
                dig = answer2[i];
            } catch (NumberFormatException e) {
                System.err.println("数値を入力してください");
                i--;
            } catch (IOException e) {
                System.err.println("もう一度入力してください");
                i--;
            } finally {
                if(dig >= 10) {
                    System.err.println("数字は0~9の範囲で入力してください");
                    i--;
                }
                for (int j = i - 1; j >= 0; j--) {
                    if (answer2[i] == answer2[j]) {
                        System.err.println("同じ数字を入力しないでください");
                        i--;
                    }
                }
            }
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }
}