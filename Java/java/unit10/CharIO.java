package unit10;
//例10-1 从键盘接收字符输入。
import java.io.*;
public class CharIO{
    public static void main(String args[]){
        int i = 0;
        System.out.println("请输入字符: ");
        try{
            i = System.in.read();
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
        System.out.print("您输入了字符:");
        System.out.print((char)i);
    }
}