import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum test {
    Boy(1,2,3,4),
    Girl(3,5,7),
    DOG(2,8,0);
    Set<Integer> set = new HashSet<>();
    test (int...a){

    }
    public static void main(String[] args) {
//        System.out.println(Boy.name());
        String workDir = System.getProperty("user.home");
        System.out.println(workDir);
    }
}
