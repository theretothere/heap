package 牛客初学者练习;

/**
 * @Version 1.0
 * @Author: Hu
 * @DATE: 2020/11/11 14:46
 * Content:
 */
public class Main{
    public static void main(String[]args){
        int[] a = {73, 32, 99, 97, 110, 32, 100, 111, 32, 105, 116 , 33};
        toCharge(a);
    }
    public static void toCharge(int[] array){
        char[] ch = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            ch[i] = (char) array[i];
        }
        for(char c:ch){
            System.out.print(c);
        }
    }
}
