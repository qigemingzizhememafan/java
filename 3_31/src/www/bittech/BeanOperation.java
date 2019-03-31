package www.bittech;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanOperation {
    private BeanOperation(){}
        // 传入 emp.name:zhangsan|emp.job:Linux
        public static void setBeanValue(Object actionobj,String value){
            //1. 进行字符串拆分
            String[] temp = value.split("\\|");
            // emp.name:zhangsan
            // emp.job:Linux
            for(int i = 0;i < temp.length;i++){
                String[] result = temp[i].split(":");
                // emp.name
                // zhangsan
                //取得真实要设置的内容
                String realValue = result[1];
                //取得要设置的真实类名称emp
                String realClassName = result[0].split("\\.")[0];
                // 取得要设置的属性名称
                String attrName = result[0].split("\\.")[1];
                // 通过反射取得xxAction中的真实对象
                // 取得了emp对象
                Object realObj = getRealObject(actionobj,realClassName);
            }
        }
        private static Object getRealObject(Object actionObj,String realClassName){
              // 取得action对象的class对象
              Class<?> cls = actionObj.getClass();
              // 拼装getEmp方法名
              String methodName = "get" + realClassName;
              Object realObj = null;
              // 取得Method对象
            try {
                Method method = cls.getDeclaredMethod(methodName);
                //相当于调用empaction.getEmp();
                try {
                    realObj = method.invoke(actionObj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            return realObj;
        }
            //首字母大写
            private static String initCap(String str){
                return str.substring(0,1).toUpperCase()+str.substring(1);
            }

    }


