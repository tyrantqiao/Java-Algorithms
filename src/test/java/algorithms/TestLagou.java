package algorithms;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author tyrantqiao
 * date: 2019/5/6
 * blog: tyrantqiao.com
 * contact: tyrantqiao@icloud.com
 */
public class TestLagou {
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        String input=in.next();
        if(input.length()<1||input.length()>50){
            return ;
        }
        int result=0;
        Stack<Character> stack=new Stack<>();
        int i=0;
        do{
            if(stack.size()!=0&&input.charAt(i)!=stack.peek()){
                stack.push(input.charAt(i));
                i++;
                continue;
            }else if(stack.size()!=0&&input.charAt(i)==stack.peek()){
                stack.pop();
                result++;
                i++;
                continue;
            }
            stack.push(input.charAt(i));
            i++;
        }while (i<input.length());
        System.out.println(result);
    }
}
