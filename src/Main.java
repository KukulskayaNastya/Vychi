
public class Main {

    static double[] X={0.0,0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9};
    static double[] F = {1.623250, 1.664792, 1.701977, 1.734832, 1.763404, 1.787764, 1.808002, 1.824230, 1.836580, 1.845201};
    static double[] d1 = new double[9];
    static double[] d2 = new double[8];
    static double[] d3 = new double[7];
    static double[] d4 = new double[6];

    public static void main(String[] args) {
        double x1=0.172544;
        double a1=0.1;
        double x2=0.815445;
        double a2=0.9;
        double x3=0.269765;
        double a3=0.2;
        double a4=0.3;
        double y =1.739372;
        double a5=1.734832;

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

        System.out.println(p1(x1, a1));
        System.out.println(p2(x2, a2));

        System.out.println(p1(x3, a3));
        System.out.println(p2(x3, a4));
        System.out.println(p3(x3, a3));

        double t0 = 0.12345678910111213;
        double t1 = fi(y,t0,a5);
        int k = 0;
        System.out.println("k          tk                                   fi(tk)");
        System.out.println(k+"          "+t0+"                "+fi(y,t0,a5));
        k = 1;
        while (Math.abs(t1-t0)>0.00001){
            System.out.println(k+"          "+t1+"                "+fi(y,t1,a5));
            t0=t1;
            t1=fi(y,t1,a5);
            k++;
        }
        System.out.println(k+"          "+t1+"                "+fi(y,t1,a5));


        System.out.println(p(t1,a5));
        double xt = X[3] + t1*0.1;
        System.out.println(xt);
    }

    static double p1(double X1, double X0) {
        double t = (X1 - X0) / 0.1;
        int j=0;
        for (int i=0;i<10;i++){
            if (X0 == X[i]) j=i;
        }
        return F[j] + t * d1[j] + t * (t - 1) *d2[j] / 2 + t * (t - 1) * (t - 2) * d3[j] / 6 + t * (t - 1) * (t - 2) * (t - 3) * d4[j] / 24;
    }
    static double p2(double X1, double X0) {
        double t = (X1 - X0) / 0.1;
        int j=0;
        for (int i=0;i<10;i++){
            if (X0 == X[i]) j=i;
        }
        if (j > 3) {
        return F[j] + t * d1[j-1] + t * (t + 1) *d2[j-2] / 2 + t * (t + 1) * (t + 2) * d3[j-3] / 6 + t * (t + 1) * (t + 2) * (t + 3) * d4[j-4] / 24; }
        else {
            return F[j] + t * d1[j-1] + t * (t + 1) *d2[j-2] / 2 + t * (t + 1) * (t + 2) * d3[j-3] / 6;
        }
    }
    static double p3(double X1, double X0) {
        double t = (X1 - X0) / 0.1;
        int j=0;
        for (int i=0;i<10;i++){
            if (X0 == X[i]) j=i;
        }
        return F[j] + t * d1[j] + t * (t - 1) *d2[j-1] / 2 + t * (t - 1) * (t +1) * d3[j-1] / 6 + t * (t - 1) * (t +1) * (t - 2) * d4[j-2] / 24;
    }

    static double fi(double y,double t,double y0) {
        int j=0;
        for (int i=0;i<10;i++){
            if (y0 == F[i]) j=i;
        }
        return  1/d1[j]*(y-F[j]-t*(t-1)*d2[j-1]/2-t*(t-1)*(t+1)*d3[j-1]/6-t*(t-1)*(t+1)*(t-2)*d4[j-2]/24);
    }

    static double p(double t, double y0) {
        int j=0;
        for (int i=0;i<10;i++){
            if (y0 == F[i]) j=i;
        }
        return F[j] + t * d1[j] + t * (t - 1) *d2[j-1] / 2 + t * (t - 1) * (t +1) * d3[j-1] / 6 + t * (t - 1) * (t +1) * (t - 2) * d4[j-2] / 24;
    }
}
