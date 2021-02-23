import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.awt.*;
//Student: Murariu Gabriela
public class Arbore {
    public static void main(String[] args){
        List noduri= new List(10,false);
        noduri.add("Nod0");
        int numar_noduri=0,nivel_curent=1;
        int nivel_maxim=(int)(Math.random()*4);
        int n=(int)(Math.random()*4);
        int m=n,c2;
        int i=0;
        String t="\t";
        for(i=0;i<m&&nivel_curent<=nivel_maxim;i++) {
            m=n;
            c2=0;
            while (n > 0) {
                int c=(int)(Math.random()*4);
                c2=c;
                while(c>0) {
                    numar_noduri++;
                    noduri.add(t + "Nod" + String.valueOf(numar_noduri));
//                    System.out.println(t + "Nod" + String.valueOf(numar_noduri));
                    c--;
                }
                n--;
                t=t.concat("\t");
            }
            if(m!=0)
                t=String.valueOf(t.subSequence(0,t.length()-m));
            else
                t=String.valueOf(t.subSequence(0,t.length()-1));
            nivel_curent++;

            n=(int)(Math.random()*4);
        }
        int j=0;
        while(j<=numar_noduri) {
            System.out.print(noduri.getItem(j) + "\n");
            j++;
        }

    }
}
