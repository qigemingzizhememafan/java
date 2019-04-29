package www.bittech;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    // 判断一个数是否是快乐数---方法一
//    public boolean isHappy(int n){
//       Set<Integer> set = new HashSet<>();
//       while(n != 1){
//           int flag = getNext(n);
//           if(set.contains(flag)){
//               return false;
//           }else{
//               set.add(flag);
//               n = flag;
//           }
//       }
//        return true;
//    }
    // 判断一个数是否是快乐数 --- 方法二
    public boolean isHappy(int num){
        while(true){
            int flag = getNext(num);
            if(flag == 1){
                return true;
            }else{
                num = flag;
                if( num == 89){  // 非快乐数一定会在经历89
                    return  false;
                }
            }
        }
    }
    // 求一个数各位平方和
    public int getNext(int num){
        int result = 0;
        result = result+(num%10)*(num%10);
        num = num/10;
        if(num == 0){
            return result;
        }else{
            return  result+getNext(num);
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isHappy(19));
    }
}
