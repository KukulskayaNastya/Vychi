import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        double[] X={0.0,0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9};
        double[] F = {1.623250, 1.664792, 1.701977, 1.734832, 1.763404, 1.787764, 1.808002, 1.824230, 1.836580, 1.845201};
        double[] d1 = new double[9];
        double[] d2 = new double[8];
        double[] d3 = new double[7];
        double[] d4 = new double[6];
        for (int i = 0; i <= 8; i++) {
            d1[i]=(double) ((int) Math.round((F[i+1]-F[i])*1000000))/1000000;
        }
        for (int i = 0; i <= 7; i++) {
            d2[i]=(double) ((int) Math.round((d1[i+1]-d1[i])*1000000))/1000000;
        }
        for (int i = 0; i <= 6; i++) {
            d3[i]=(double) ((int) Math.round((d2[i+1]-d2[i])*1000000))/1000000;
        }
        for (int i = 0; i <= 5; i++) {
            d4[i]=(double) ((int) Math.round((d3[i+1]-d3[i])*1000000))/1000000;
        }
        String p="                 ";
        System.out.println("X      F          Delta1       Delta2      Delta3      Delta4   ");
        System.out.println(X[0]+"  "+F[0]);
        System.out.println("                 "+d1[0]);
        System.out.println(X[1]+"  "+F[1]+p+d2[0]);
        System.out.println("                 "+d1[1]+p+d3[0]);
        System.out.println(X[2]+"  "+F[2]+p+d2[1]+p+d4[0]);
        System.out.println("                 "+d1[2]+p+d3[1]);
        System.out.println(X[3]+"  "+F[3]+p+d2[2]+p+d4[1]);
        System.out.println("                 "+d1[3]+p+d3[2]);
        System.out.println(X[4]+"  "+F[4]+p+d2[3]+p+d4[2]);
        System.out.println("                 "+d1[4]+p+d3[3]);
        System.out.println(X[5]+"  "+F[5]+p+d2[4]+p+d4[3]);
        System.out.println("                 "+d1[5]+p+d3[4]);
        System.out.println(X[6]+"  "+F[6]+p+d2[5]+p+d4[4]);
        System.out.println("                 "+d1[6]+p+d3[5]);
        System.out.println(X[7]+"  "+F[7]+p+d2[6]+p+d4[5]);
        System.out.println("                 "+d1[7]+p+d3[6]);
        System.out.println(X[8]+"  "+F[8]+p+d2[7]);
        System.out.println("                 "+d1[8]);
        System.out.println(X[9]+"  "+F[9]);
    }

}
