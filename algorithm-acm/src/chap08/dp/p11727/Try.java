package chap08.dp.p11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11727
 * 
 * @author zaccoding
 * @Date 2017. 9. 14.
 */
public class Try {
    public static int n;
    public static final int mod = 10007;
    public static int[] dp = new int[1001];    
    
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);        
        n = Reader.nextInt();        
        dp[1] = 1;
        dp[2] = 3;
        System.out.println(solve(n));
    }
    
    public static int solve(int n) {
        if(dp[n] != 0) {
            return dp[n];
        }
        
        return dp[n] = (solve(n-1) + (2*solve(n-2))) % mod;
    }
    

    static class Reader {
        static BufferedReader reader;
        static StringTokenizer tokenizer;       
        
        public static void init(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
        }
        
        public static String nextLine() throws IOException {
            return reader.readLine();
        }
        
        public static String next() throws IOException {
            while(tokenizer ==null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();           
        }
        
        public static int nextInt() throws IOException {
            return Integer.parseInt( next() );
        }
        
        public static void close() throws IOException {
            if(reader != null)
                reader.close();
        }
        
    }
}
