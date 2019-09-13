//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int n = sc.nextInt();
//            List<Integer> list = new ArrayList();
//            for(int i = 0; i < n; i++){
//                list.add(sc.nextInt());
//            }
//            int[] dp = new int[n];
//            int max = list.get(0);
//            for(int i = 1; i < n; i++){
//                dp[i] = Math.max(dp[i-1] + list.get(i), list.get(i));
//                max = Math.max(max, dp[i]);
//            }
//            System.out.println(max);
//        }
//    }
//}
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int n = sc.nextInt();
//            List<Integer> list = new ArrayList();
//            for(int i = 0; i < n; i++){
//                list.add(sc.nextInt());
//            }
//            int[] dp = new int[n];
//            int max = list.get(0);
//            for(int i = 1; i < n; i++){
//                dp[i] = Math.max(dp[i-1] + list.get(i), list.get(i));
//                max = Math.max(max, dp[i]);
//            }
//            System.out.println(max);
//        }
//    }
//}

//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String ss =  scanner.next();
//        count(ss);
//    }
//
//    public static void count(String ss){
//        String[] data = ss.split(",");
//        Map<String,Integer> map = new HashMap();
//        for(int i = 0; i < data.length; i++){
//            if(data[i].endsWith("d") || data[i].endsWith("e")){
//                if(map.containsKey(data[i])){
//                    map.put(data[i],map.get(data[i])+1);
//                }else{
//                    map.put(data[i],1);
//                }
//            }
//        }
//        System.out.print("{");
//        int count = 0;
//        for(Map.Entry<String,Integer> set : map.entrySet()){
//            count++;
//            if(count < map.size()-1){
//                System.out.print(set.getKey()+"=");
//                System.out.print(set.getValue()+", ");
//            }else{
//                System.out.print(set.getKey()+"=");
//                System.out.print(set.getValue());
//            }
//        }
//        System.out.print("}");
//    }
//}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        statisticSubStr(input);
    }
    public static void statisticSubStr(String s){
        char[] a = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < a.length - 1 ; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            }else{
                map.put(a[i],1 );
            }
        }
        for(Map.Entry<Character,Integer> set : map.entrySet()){
            if(set.getValue() > 1) {
                System.out.print(set.getKey() + ":");
                System.out.println(set.getValue());
            }
        }
    }
}

//import java.util.*;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int n = sc.nextInt();
//            int[][] data = new int[n][n];
//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < n; j++){
//                    data[i][j] = sc.nextInt();
//                }
//            }
//            int sum1 = 0;
//            int sum2 = 0;
//            int res1 = 0;
//            int res2 = 0;
//            int[] row = new int[n+2];
//            int rowindex = 0;
//            int[] col = new int[n+2];
//            int colindex = 0;
//            for(int i = 0; i < n; i++){
//                sum1 = 0;
//                res1 = 0;
//                for(int j = 0; j < n; j++){
//                    sum1 = Math.max(sum1 + data[i][j], data[i][j]);
//                    res1 = Math.max(sum1, res1);
//                    row[rowindex++] = res1;
//                    sum2 = Math.max(sum2 + data[j][i], data[j][i]);
//                    res2 = Math.max(sum2, res2);
//                    col[colindex++] = res2;
//                }
//            }
//            int max1 = 0;
//            int max2 = 0;
//            for(int i = 0; i < row.length; i++){
//                if(row[i] > max1){
//                    max1 = row[i];
//                }
//            }
//            for(int i = 0; i < row.length; i++){
//                if(row[i] > max2){
//                    max2 = col[i];
//                }
//            }
//            System.out.println(Math.max(max1, max2));
//        }
//    }
//}
//import java.util.*;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int n = sc.nextInt();
//            List<Integer> list = new ArrayList();
//            for(int i = 0; i < n; i++){
//                list.add(sc.nextInt());
//            }
//            int[] dp = new int[n];
//            int max = list.get(0);
//            for(int i = 1; i < n; i++){
//                dp[i] = Math.max(dp[i-1] + list.get(i), list.get(i));
//                max = Math.max(max, dp[i]);
//            }
//            System.out.println(max);
//        }
//    }
//}
//import java.util.*;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int n = sc.nextInt();
//            int sum = 0;
//            int i = 0;
//            for( i = 1; i <= 100 && sum < n; i++){
//                sum += i;
//            }
//            if(sum == n){
//                System.out.println(i);
//            }else{
//                System.out.println("No");
//            }
//        }
//    }
//}
//import java.util.*;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String s1 = sc.next();
//            String s2 = sc.next();
//            StringBuffer sb = new StringBuffer();
//            for(int i = 0; i < s2.length(); i++){
//                if(s1.contains(String.valueOf(s2.charAt(i)))){
//
//                }else{
//                    sb.append(s2.charAt(i));
//                }
//            }
//            System.out.println(sb.toString());
//        }
//    }
//}

//public class Main{
//    public static String change(long b){
//        if(b==1)
//            return "壹";
//        if(b==2)
//            return"贰";
//        if(b==3)
//            return"叁";
//        if(b==4)
//            return"肆";
//        if(b==5)
//            return"伍";
//        if(b==6)
//            return"陆";
//        if(b==7)
//            return"柒";
//        if(b==8)
//            return"捌";
//        if(b==9)
//            return"玖";
//        return  null;
//    }
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            StringBuffer sb = new StringBuffer();
//            sb.append("[");
//            double a = in.nextDouble();
//            String s = in.nextLine();
//            s = s.substring(1,s.length());
//            String[] data = s.split(",");
//            double[] money = new double[data.length];
//            for(int i = 0; i < data.length; i++){
//                money[i] = Double.parseDouble(data[1]);
//                sb.append(change(money[i]));
//                if(i != data.length-1) {
//                    sb.append(",");
//                }
//            }
//            sb.append("]");
//            System.out.println(sb.toString());
//        }
//    }
//    public static String change(double a){
//        int b = (int)a%10000;//元
//        int c = (int)a/10000%10000;//万
//        int d =  (int)a/100000000%10000;//亿
//        int count = 0;
//        StringBuilder str = new StringBuilder();
//        System.out.print("人民币");
//        if(d>0){
//            int qian = d/1000;
//            int bai = d%1000/100;
//            int shi = d%100/10;
//            int ge = d%10;
//            if(qian>0){
//                str.append(change(qian)+"仟");
//            }else {
//                if (!str.toString().isEmpty()&&str.toString().charAt(str.length()-1)!='零'){
//                    str.append("零");
//                }
//            }
//            if(bai>0){
//                str.append(change(bai)+"佰");
//            }else {
//                if (!str.toString().isEmpty()&&str.toString().charAt(str.length()-1)!='零'){
//                    str.append("零");
//                }
//            }
//            if(shi>0){
//                if(shi==1&&qian==0&&bai==0){
//                    str.append("拾");
//                }else{
//                    str.append(change(shi)+"拾");
//                }
//            }else {
//                if (!str.toString().isEmpty()&&str.toString().charAt(str.length()-1)!='零'){
//                    str.append("零");
//                }
//            }
//            if(ge>0){
//                str.append(change(ge));
//            }
//            str.append("亿");
//        }
//        if(c>0){
//            int qian = c/1000;
//            int bai = c%1000/100;
//            int shi = c%100/10;
//            int ge = c%10;
//            if(qian>0){
//                str.append(change(qian)+"仟");
//            }else {
//                if (!str.toString().isEmpty()&&str.toString().charAt(str.length()-1)!='零'){
//                    str.append("零");
//                }
//            }
//            if(bai>0){
//                str.append(change(bai)+"佰");
//            }else {
//                if (!str.toString().isEmpty()&&str.toString().charAt(str.length()-1)!='零'){
//                    str.append("零");
//                }
//            }
//            if(shi>0){
//                if(shi==1&&qian==0&&bai==0){
//                    str.append("拾");
//                }else{
//                    str.append(change(shi)+"拾");
//                }
//            }else {
//                if (!str.toString().isEmpty()&&str.toString().charAt(str.length()-1)!='零'){
//                    str.append("零");
//                }
//            }
//            if(ge>0){
//                str.append(change(ge));
//            }
//            str.append("万");
//        }
//        if(b>0){
//            int qian = b/1000;
//            int bai = b%1000/100;
//            int shi = b%100/10;
//            int ge = b%10;
//            if(qian>0){
//                str.append(change(qian)+"仟");
//            }else {
//                if (!str.toString().isEmpty()&&str.toString().charAt(str.length()-1)!='零'){
//                    str.append("零");
//                }
//            }
//            if(bai>0){
//                str.append(change(bai)+"佰");
//            }else {
//                if (!str.toString().isEmpty()&&str.toString().charAt(str.length()-1)!='零'){
//                    str.append("零");
//                }
//            }
//            if(shi>0){
//                if(shi==1&&qian==0&&bai==0){
//                    str.append("拾");
//                }else{
//                    str.append(change(shi)+"拾");
//                }
//            }else {
//                if (!str.toString().isEmpty()&&str.toString().charAt(str.length()-1)!='零'){
//                    str.append("零");
//                }
//            }
//            if(ge>0){
//                str.append(change(ge));
//            }
//            str.append("元");
//        }
//        double x = a*1000/10;
//        long t = (int)(a*1000/10);
//        long m = (int)a;
//        long xiao = t - m*100;
//        if (xiao==0){
//            str.append("整");
//        }
//        if(xiao>0){
//            long jiao = xiao/10;
//            long fen = xiao%10;
//            if(jiao>0){
//                str.append(change(jiao)+"角");
//            }
//            if(fen>0){
//                str.append(change(fen)+"分");
//            }
//        }
//        return str.toString();
//    }
//}

//import java.text.DecimalFormat;
//import java.util.*;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            double x1 = sc.nextInt();
//            double y1 = sc.nextInt();
//            double x2 = sc.nextInt();
//            double y2 = sc.nextInt();
//            double x3 = sc.nextInt();
//            double y3 = sc.nextInt();
//            double a = Math.abs(x1-y1);
//            double b = Math.abs(x2-y2);
//            double c = Math.abs(x3-y3);
//            if(a+b > c && a+c > b && b+c > a){
//                double p = (a+b+c)/2;
//                DecimalFormat df = new DecimalFormat("0.00");
//                String f = df.format(p*2);
//                System.out.println(f);
//                double area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
//                System.out.println(df.format(area));
//            }else{
//                System.out.println("Impossible");
//            }
//        }
//    }
//}

//import java.util.*;
//public class Main{
//    public static void main(String []args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()) {
//            String s = sc.nextLine();
//            System.out.println(maxLength(s));
//        }
//    }
//    public static int maxLength(String s){
//        if(s.length() == 0){
//            return 0;
//        }
//        int res = 0;
//        int head = 0;
//        for(int i = 0; i < s.length(); i++){
//            for(int j = head; j < i; j++){
//                if(s.charAt(i) == s.charAt(j)){
//                    head = j+1;
//                }
//            }
//            if(i+1-head > res){
//                res = i+1-head;
//            }
//        }
//        return res;
//    }
//}

//import java.util.*;
//public class Main{
//    public static void main(String[] args){
//        int a = 65;
//        String[] data = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q"
//                ,"R","S","T","U","V","W","X","Y","Z"};
//        Scanner sc = new Scanner(System.in);
//        Set<Integer> set = new TreeSet();
//        Set<Integer> set1 = new TreeSet<>();
//        while(sc.hasNext()) {
//            int len = 0;
//            String s = sc.nextLine();
//            for (int i = 0; i < s.length(); i++) {
//                char c = s.charAt(i);
//                set.add(Integer.valueOf(String.valueOf(c)));
//            }
//            Iterator iterator = set.iterator();
//            int[] te = new int[set.size()];
//            for (int i = 0; i < set.size(); i++) {
//                te[i] = (Integer) iterator.next();
//            }
//            for (int i = 0; i < set.size(); i++) {
////                System.out.println((char) te[i]+'');
//                if(te[i]-1 >=0 && te[i]-1 <= 26) {
//                    System.out.print(data[te[i] - 1]);
//                }
//
//            }
//            System.out.println();
//            for (int i = 0; i <= s.length() - 2; i = i + 2) {
//                String temp = s.substring(i, i + 2);
//                    set1.add(Integer.valueOf(temp));
//                }
//            Iterator iterator1 = set1.iterator();
//            int[] mp = new int[set1.size()];
//            for (int i = 0; i < set1.size(); i++) {
//                if(mp[i] <= 26) {
//                    mp[i] = (Integer) iterator1.next();
//                }else{
//                    String q = String.valueOf(mp[i]);
//                    for (int k = 0; k < q.length(); k++) {
//                        char c = q.charAt(i);
//                        set.add(Integer.valueOf(String.valueOf(c)));
//                    }
//                    Iterator iterator2 = set.iterator();
//                    int[] tee = new int[set.size()];
//                    for (int p = 0; p < set.size(); p++) {
//                        tee[i] = (Integer) iterator.next();
//                    }
//                    for (int l = 0; l < set.size(); l++) {
////                System.out.println((char) te[i]+'');
//                        if(tee[l]-1 >=0 && tee[l]-1 <= 26) {
//                            System.out.print(data[tee[l] - 1]);
//                        }
//
//                    }
//                }
//            }
//            for(int i = 0 ; i < set1.size(); i++){
//                if(mp[i]-1 <= 26 && mp[i]-1 >= 0) {
//                    System.out.print(data[mp[i] - 1]);
//                }
//            }
//            }
//        }
//        }





//        import java.util.*;
//public class Main{
//    public static void main(String[] args){
//        int a = 65;
//        String[] data = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q"
//                ,"R","S","T","U","V","W","X","Y","Z"};
//        Scanner sc = new Scanner(System.in);
//        Set<Integer> set = new TreeSet();
//        while(sc.hasNext()) {
//            int len = 0;
//            String s = sc.nextLine();
//            for (int i = 0; i < s.length(); i++) {
//                char c = s.charAt(i);
//                set.add(c - 65 + 1);
//                len = set.size();
//            }
//            Iterator iterator = set.iterator();
//            int[] te = new int[set.size()];
//            for (int i = 0; i < set.size(); i++) {
//                te[i] = (Integer) iterator.next();
//            }
//            for (int i = 0; i < set.size(); i++) {
//                System.out.print(data[te[i]-65-1]);
//            }
//            for (int i = 0; i < s.length() - 2; i = i + 2) {
//                String temp = s.substring(i, i + 2);
//                int t = Integer.valueOf(temp);
//                if (t >= 0 && t <= 26) {
//                    set.add(t);
//                }
//            }
//            Iterator iterator1 = set.iterator();
//            int[] mp = new int[set.size()];
//            for (int i = 0; i < set.size(); i++) {
//                mp[i] = (Integer) iterator1.next();
//            }
//            for(int i = set.size() - te.length-1; i < set.size(); i++){
//                System.out.print(data[mp[i]-65-1]);
//            }
//        }
//    }
//}





//import java.util.*;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        List<Integer> list = new ArrayList();
//        Map<Integer,Integer> map = new HashMap();
//        int max = Integer.MIN_VALUE;
//        int maxIndex = Integer.MIN_VALUE;
//        while(sc.hasNext()){
//            int n = sc.nextInt();
//            for(int i = 0; i < n; i++){
//                list.add(sc.nextInt());
//            }
//            for(int i = list.size()-1; i > 0; i--){
//                int temp = list.get(i);
//                for(int j = i-1; j > 0; j--){
//                    int t = list.get(j);
//                    if(temp <= t){
//                        if(map.containsKey(t)){
//                            map.put(t, map.get(t)+1);
//                            if(max < map.get(t)){
//                                max = map.get(t);
//                                maxIndex = t;
//                            }
//                        }else{
//                            map.put(t,1);
//                            if(max < map.get(t)){
//                                max = map.get(t);
//                                maxIndex = t;
//                            }
//                        }
//                        break;
//                    }
//                }
//            }
//            System.out.println(maxIndex);
//        }
//    }
//}











//import java.util.*;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String s;
//
//            s = sc.nextLine();
//            String[] temp = s.split(",");
//            int n = temp.length;
//            int[] data = new int[n];
//            for(int i = 0; i < temp.length; i++){
//                data[i] = Integer.valueOf(temp[i]);
//            }
//            Arrays.sort(data);
//            int i = 0;
//            int j = 0;
//            int count = 0;
//            for(i = 0,j = n-1; i < j ; ){
//                if(data[i] + data[j] == 0){
//                    count++;
//                }else if(data[i] + data[j] < 0){
//                    i++;
//                }else{
//                    j--;
//                }
//            }
//            System.out.println(count);
//        }
//
//}

//import java.util.*;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        List<Integer> list = new ArrayList();
//        while(sc.hasNextInt()){
//            list.add(sc.nextInt());
//        }
//        int n = list.size();
//        int[] data = new int[n+1];
//        long[][] dp = new long[n+1][0];
//        for(int i = 0; i < n; i++){
//            data[i] = list.get(i);
//        }
//        for(int i = 0; i <= n; i++){
//            dp[i][0] = 1;
//        }
//        dp[0][0] = 0;
//        for(int i = 0; i <= n; i++){
//            for(int j = 0; j <= 0; j++){
//                if(data[i] <= j){
//                    dp[i][j] = dp[i-1][j] + dp[i-1][j-data[i]];
//                }else{
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//        System.out.println(dp[n][0]);
//    }
//}
//import java.util.*;
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            Map<Integer,Boolean> map1 = new HashMap();
//            Map<Integer,Boolean> map2 = new HashMap();
//            int b1 = 0; // 宝箱为奇数的个数
//            int b2 = 0; // 宝箱为偶数的个数
//            int k1 = 0; // 钥匙为奇数的个数
//            int k2 = 0; // 钥匙为偶数的个数
//            for(int i = 0; i < n; i++){
//                map1.put(sc.nextInt(),false);
//            }
//            for(int j = 0; j < m; j++){
//                map2.put(sc.nextInt(),false);
//            }
//            int count = 0;
//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < m; j++){
//                    Set<Integer> set = map1.keySet();
//                    Iterator iterator = set.iterator();
//                    int key =  (Integer) iterator.next();
//
//                    Set<Integer> set1 = map2.keySet();
//                    Iterator iterator1 = set1.iterator();
//                    int key2 =  (Integer) iterator1.next();
//                    if((key + key2) % 2 == 1 && map1.get(key) == false && map2.get(key2) == false){
//                        count++;
//                        map1.put(key,true);
//                        map2.put(key2,true);
//                    }
//                }
//            }
//            System.out.println(count);
//        }
//    }
//}
//
//
//
//
//
////import java.util.*;
////public class Main{
////    public static void main(String[] args){
////        Scanner sc = new Scanner(System.in);
////        while(sc.hasNext()){
////            int n = sc.nextInt();
////            int m = sc.nextInt();
////            Map<Integer,Boolean> map1 = new HashMap();
////            Map<Integer,Boolean> map2 = new HashMap();
////            int b1 = 0; // 宝箱为奇数的个数
////            int b2 = 0; // 宝箱为偶数的个数
////            int k1 = 0; // 钥匙为奇数的个数
////            int k2 = 0; // 钥匙为偶数的个数
////            for(int i = 0; i < n; i++){
////                map1.put(sc.nextInt(),false);
////            }
////            for(int j = 0; j < m; j++){
////                map2.put(sc.nextInt(),false);
////            }
////            int count = 0;
////            for(int i = 0; i < n; i++){
////                for(int j = 0; j < m; j++){
////                    Set<Integer> set = map1.keySet();
////                    Iterator iterator = set.iterator();
////                    int key =  (Integer) iterator.next();
////
////                    Set<Integer> set1 = map2.keySet();
////                    Iterator iterator1 = set1.iterator();
////                    int key2 =  (Integer) iterator1.next();
////                    if((key + key2) % 2 != 0 && map1.get(key) == false && map2.get(key2) == false){
////                        count++;
////                        map1.put(key,true);
////                        map2.put(key2,true);
////                    }
////                }
////            }
////            System.out.println(count);
////        }
////    }
////}
