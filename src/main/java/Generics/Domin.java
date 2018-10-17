package Generics;

/**
 * @author JYH
 * 2018/10/15 16:05
 */
public class Domin implements Comparable<Domin> {
    private String str;

    public Domin(String str){
        this.str = str;
    }

    @Override
    public int compareTo(Domin domin) {
        if(this.str.compareTo(domin.str) > 0){
            return 1;
        }else if (this.str.compareTo(domin.str) == 0){
            return 0;
        }else {
            return -1;
        }
    }

    public String getStr(){
        return str;
    }

    public static void main(String[] args) {
        Domin d1 = new Domin("c");
        Domin d2 = new Domin("c");
        Domin d3 = new Domin("b");
        Domin d4 = new Domin("d");
        System.out.println(d1.compareTo(d2));
        System.out.println(d1.compareTo(d3));
        System.out.println(d1.compareTo(d4));
    }
}
