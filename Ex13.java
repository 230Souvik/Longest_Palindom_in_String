
package ex13;


public class Ex13 {
public int lps(String str, int start, int end,Integer[][] arr){
    if(start > end) {
      return 0;
    }
    
    if(start == end) {
      return 1;
    }
    
    if(arr[start][end] == null) {
      if(str.charAt(start) == str.charAt(end)) {
        arr[start][end] = 2 + lps(str, start + 1, end - 1, arr);
      } else {
        arr[start][end] = Math.max(lps(str, start + 1, end, arr), lps(str, start, end - 1, arr));  
      }  
    }

    return arr[start][end];
}
public static int lpsBottomUp(String str, int n) {
    int[][] arr = new int[n][n];
    
    for (int i = 0; i < str.length(); i++) {
      arr[i][i] = 1;
    }
      
    for(int i = n - 2; i >= 0; i--) {
      for(int j = i + 1; j < n; j++) {
        
        if(str.charAt(i) == str.charAt(j)) {
          arr[i][j] = 2 + arr[i + 1][j - 1];
        } else {
          arr[i][j] = Math.max(arr[i + 1][j], arr[i][j - 1]);
        }
      }
    }
    
    return arr[0][n - 1];
  }
 
    public static void main(String[] args) {
        // TODO code application logic here
        String str="abcabba";
        Ex13 e=new Ex13();
        System.out.println("using top down approch");
        Integer[][] arr = new Integer[str.length()][str.length()];
    System.out.println(e.lps(str, 0, str.length() - 1, arr));
        System.out.println("buttom up approch");
        System.out.println(lpsBottomUp(str, str.length()));
    }
    
}
