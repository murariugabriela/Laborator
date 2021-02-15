public class Laborator1 {
    public static void main(String[] args) {
        System.out.print("Hello World!\n");
        String[] languages={"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        System.out.print(languages[3]);
        System.out.print("\n");
        int n = (int) (Math.random() * 1_000_000);
        System.out.print(n);
        System.out.print("\n");
        n=n*3;
//        System.out.print(n);
//        System.out.print("\n");
        int x=10101,nr=0,p=1;
//        add the binary number 10101 to the result;
        while(x!=0)
        {
            nr=nr+(x%10)*p;
//            System.out.print(nr);
//            System.out.print("\n");
            p=p*2;
            x=x/10;
        }
        n=n+nr;
        System.out.print(n);
        System.out.print("\n");
//        add the hexadecimal number FF to the result;
        String y="FF";
        nr=0;p=1;
        for(int i=y.length()-1;i>=0;i--)
        {
            int c=(int)y.charAt(i)-55;
            nr=c*p+nr;
            System.out.print(nr);
            System.out.print("\n");
            p=p*16;
        }
        n=n+nr;
        System.out.print(n);
        System.out.print("\n");
//        multiply the result by 6;
        n=n*6;
        System.out.print(n);
        System.out.print("\n");
    }
}
