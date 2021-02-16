import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.awt.*;
//Student: Murariu Gabriela
public class Arbore {
    public static void main(String[] args){
        List noduri= new List(10,false);
        noduri.add("Nod0");
        System.out.println("Nod0");
        int numar_noduri=0,nivel_curent=1;
        int nivel_maxim=(int)(Math.random()*4);
        int n=(int)(Math.random()*4);
        int m=n;
        int i=0;
        String t="\t";
        for(i=0;i<m&&nivel_curent<=nivel_maxim;i++) {
            m=n;
            while (n > 0) {
                int c=(int)(Math.random()*4);
                while(c>0) {
                    numar_noduri++;
                    noduri.add(t + "Nod" + String.valueOf(numar_noduri));
                    System.out.println(t + "Nod" + String.valueOf(numar_noduri));
                    c--;
                }
                n--;
                t=t.concat("\t");
            }
            t=String.valueOf(t.subSequence(0,t.length()-m));
            nivel_curent++;

            n=(int)(Math.random()*4);
        }
    }
}
