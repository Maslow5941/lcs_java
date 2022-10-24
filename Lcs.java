import java.util.Scanner;

public class Lcs {
  static Integer dp[][];
  static int cache[][];

  // metodo recursivo top down
  // O(3^(m+n))
  public static int LCS1(char[] x, char[] y, int i, int j) {

    if (i <= 0 || j <= 0) {
      return 0;
    }
    if (x[i - 1] == y[j - 1]) {
      return 1 + LCS1(x, y, i - 1, j - 1);
    } else {
      return Math.max(LCS1(x, y, i, j - 1), LCS1(x, y, i - 1, j));
    }
  }

  // recursico com memorização
  public static int LCS2(char[] x, char[] y, int i, int j, Integer[][] dp) {
    if (i <= 0 || j <= 0) {

      return 0;

    }
    if (dp[i][j] != null) {

      return dp[i][j];

    }
    if (x[i - 1] == y[j - 1]) {
      return 1 + LCS2(x, y, i - 1, j - 1, dp);
    } else {
      return dp[i][j] = Math.max(LCS2(x, y, i, j - 1, dp), LCS2(x, y, i - 1, j, dp));
    }

  }

  public static int LCS3(char[] x, char[] y, int m, int n) {
    int memori[][] = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) {
          memori[i][j] = 0;

        } else if (x[i - 1] == y[j - 1]) {
          memori[i][j] = memori[i - 1][j - 1] + 1;
        } else {
          memori[i][j] = Math.max(memori[i - 1][j], memori[i][j - 1]);
        }

      } // i

    } // j
    cache = memori;
    return memori[m][n];
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String x = sc.next();
    String y = sc.next();

    long m1Execution = metodo1(x.toCharArray(), y.toCharArray(), x.length(), y.length());
    long m2Execution = metodo2(x.toCharArray(), y.toCharArray(), x.length(), y.length());
    long m3Execution = metodo3(x.toCharArray(), y.toCharArray(), x.length(), y.length());
    

    System.out.println("tempo execução dos algoritimos");
    System.out.println("----------------------------------------------------------------");
    System.out.println("Recursivo" + m1Execution + "ns");
    System.out.println("top-down" + m2Execution + "ns");
    System.out.println("DP btt-up" + m3Execution + "ns");
    

    // displayMemori(cache);
    sc.close();

  }



  public static long metodo1(char[] x, char[] y, int m, int n) {
    long timeStart = 0, timeEnd = 0;
    timeStart = System.nanoTime();
    System.out.println("Recursivo LCS1");
    System.out.println("saida" + LCS1(x, y, m, n));
    timeEnd = System.nanoTime();
    return timeEnd - timeStart;

  }

  public static long metodo2(char[] x, char[] y, int m, int n) {
    long timeStart = 0, timeEnd = 0;
    timeStart = System.nanoTime();
    dp = new Integer[m + 1][n + 1];
    System.out.println("top-down lcs2");
    System.out.println("saida" + LCS2(x, y, m, n, dp));
    timeEnd = System.nanoTime();
    return timeEnd - timeStart;
  }

  public static long metodo3(char[] x, char[] y, int m, int n) {
    long timeStart = 0, timeEnd = 0;
    timeStart = System.nanoTime();
    dp = new Integer[m + 1][n + 1];
    System.out.println("top-down lcs3");
    System.out.println("saida lcs3" + LCS3(x, y, m, n));
    timeEnd = System.nanoTime();
    return timeEnd - timeStart;

  }



}
