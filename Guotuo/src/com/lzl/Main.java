package com.lzl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final String[] hanzi = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾"};
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double money = sc.nextDouble();
            StringBuffer buffer = new StringBuffer();
            int yi = (int) (money / 100000000);
            int wan = (int) ((money - yi * 100000000) / 10000);
            int ge = (int) (money - yi * 100000000 - wan * 10000);

            System.out.print("人民币");
            if (yi != 0) {
                buffer.append(change(yi) + "亿");
            }
            if (wan != 0) {
                buffer.append(change(wan) + "万");
            }
            if (ge != 0) {
                buffer.append(change(ge) + "元");

            }

            int xiaoshu = (int) ((money - yi * 100000000 - wan * 10000 - ge + 0.001) * 100);
            int jiao = xiaoshu / 10;
            int fen = xiaoshu % 10;
            if (jiao != 0 && fen != 0) {
                buffer.append(hanzi[jiao] + "角" + hanzi[fen] + "分");
            } else if (jiao != 0 && fen == 0) {
                buffer.append(hanzi[jiao] + "角");

            } else if (jiao == 0 && fen != 0) {
                buffer.append("零" + hanzi[fen] + "分");

            } else if (jiao == 0 && fen == 0) {
                buffer.append("整");
            }
            String string = buffer.toString();
            System.out.println(string);
        }
        sc.close();
    }

    /**
     * 4位的汉语转换
     *
     * @param a
     */
    public static String change(int a) {

        final String[] hanzi = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾"};
        int qian = a / 1000;
        int bai = (a - qian * 1000) / 100;
        int shi = (a - qian * 1000 - bai * 100) / 10;
        int ge = a - qian * 1000 - bai * 100 - shi * 10;
        StringBuffer br = new StringBuffer();
        if (qian != 0) {
            br.append(hanzi[qian] + "仟");
        }
        if (bai != 0) {
            br.append(hanzi[bai] + "佰");
        } else if (qian != 0 && bai == 0 && (shi != 0 || ge != 0)) {
            br.append("零");
        }
        if (shi != 0 && shi != 1) {
            br.append(hanzi[shi] + "拾");
        } else if (bai != 0 && ge != 0) {
            br.append("零");
        }
        if (shi == 1 && qian == 0 && bai == 0) {
            br.append("拾");
        }
        if (ge != 0) {
            br.append(hanzi[ge]);
        }
        String s = br.toString();
        return s;
    }

        public static void main1(String[] args){
            Scanner in=new Scanner(System.in);
            int n=in.nextInt();
            int gradePoint[]=new int[n];//每门课学分
            int coursePoint[]=new int[n];//每门课分数

            for(int i=0;i<n;i++){
                gradePoint[i]=in.nextInt();
            }
            for(int i=0;i<n;i++){
                coursePoint[i]=in.nextInt();
            }
            in.close();
            System.out.printf("%.2f",gradePointAverage(gradePoint,coursePoint));//格式输出

        }
        public static double pointOfEachCourse(int grade){ //根据实际成绩判断学分方法
            double point = 0.0;
            if(grade>=90&&grade<=100)
                point=4.0;

            if(grade>=85&&grade<=89)
                point=3.7;

            if(grade>=82&&grade<=84)
                point=3.3;

            if(grade>=78&&grade<=81)
                point=3.0;

            if(grade>=75&&grade<=77)
                point=2.7;

            if(grade>=72&&grade<=74)
                point=2.3;

            if(grade>=68&&grade<=71)
                point=2.0;

            if(grade>=64&&grade<=67)
                point=1.5;

            if(grade>=60&&grade<=63)
                point=1.0;

            if(grade<60)
                point=0.0;

            return (double)point;
        }
        //计算平均绩点的方法
        public static double gradePointAverage(int[] gradePoint,int[] coursePoint){
            double gradePointTotal=0;
            double gradeOfEachCourseTotal=0;
            for(int i=0;i<gradePoint.length;i++){
                gradePointTotal+=pointOfEachCourse(coursePoint[i])*gradePoint[i];
                gradeOfEachCourseTotal+=gradePoint[i];
            }
            return (double)gradePointTotal/gradeOfEachCourseTotal;
        }

    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int n2 = n*n;
            int sum = 0;
            while(n>=1){
                sum+=n%10;
                n=n/10;
            }
            System.out.print(sum+" ");
            sum=0;
            while(n2>=1){
                sum+=n2%10;
                n2=n2/10;
            }
            System.out.println(sum);
        }
    }
}
