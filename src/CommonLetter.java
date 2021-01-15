import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class CommonLetter {

    public static char commonLetter(String input) {
        int[] counts = new int[26];

        for(int i = 0;i < counts.length;i++) {
            counts[i] = 0;
        }
        for(int i = 0;i < input.length();i++) {
            counts[input.toLowerCase().charAt(i) - 'a']++;
        }
        int maxSoFar = 0;
        char c = 'a';
        for(int i = 0;i < counts.length;i++) {
            if (maxSoFar < counts[i]) {
                maxSoFar = counts[i];
                c = (char) (i + 'a');
            }
        }
        return c;
    }
    public static char commonLetter2(String input) {
        List<Character> list = new ArrayList<Character>();

        for(int i = 0; i<input.length(); i++) {
            list.add(input.toLowerCase().charAt(i));
        }
        int max = 0;
        char c = 'a';
        for(int i = 0;i < 26;i++ ) {
            final int j = i;
            int count = (int) list.parallelStream().filter((d)->d==((char) (j + 'a'))).count();
            if (max < count) { 
                max = (int) count;
                c = (char) (i + 'a');
            }
        }
        return c;
    }

    public static void main(String[] args) {
        String test = "asdfghjukilopmnbvcxzeaweqdfgha";
        Date start = new Date();
        char c = 'a';
        for(int i =0; i<10000;i++) {
            c= commonLetter(test);
        }
        Date stop = new Date();
        System.out.println("commonLetter="+c+" took="+(stop.getTime()-start.getTime())+"ms");
        start = new Date();
        c = 'a';
        for(int i =0; i<10000;i++) {
            c= commonLetter2(test);
        }
        stop = new Date();
        System.out.println("commonLetter2="+c+" took="+(stop.getTime()-start.getTime())+"ms");
    }

}
