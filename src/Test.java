private long fib(int n){
    if(n <= 1) return  n;
    long a = 0 , b =1 ;
    for(int i = 2 ; i<=n ; i++){
        long temp = a+b;
        a = b ;
        b= temp;
    }
    return (long)b;
}
private int appFib(int n){
    int[] arr = new int[60];
    arr[0] = 0;
    arr[1] = 1;
    for(int i = 2 ; i < 60 ; i++){
        arr[i] = (arr[i-1] +arr[i-2])%10;
    }
    return arr[n%60];
}
private int sumofprime(int n){
    List<Boolean> arr  = new ArrayList<>(Collections.nCopies(n+1 ,Boolean.TRUE));
    for(int i = 2; i*i <= n;i++){
        if(arr.get(i)) {
            for(int j = i ; i *j <= n; j ++){
               arr.set(j*i,Boolean.FALSE) ;
            }
        }
    }
    int sum = 0;
    for(int i = 2; i < arr.size();i++){
        if(arr.get(i)) sum+=i;
    }
    return sum;

}
int sumofarr(int[] arr){
    int currentmax , Maxmax ;
    currentmax = arr[0];
    Maxmax = arr[0];
    for(int i = 1; i < arr.length;i++){
        currentmax = Math.max(arr[i],currentmax +arr[i]);
        Maxmax  = Math.max(currentmax,Maxmax);
    }
    return Maxmax;
}
int maximumNonAdj(int[] arr) {
    int n = arr.length;
    if (n == 0) return 0;
    if (n == 1) return arr[0];

    int prev2 = arr[0];
    int prev1 = Math.max(arr[0], arr[1]);

    for (int i = 2; i < n; i++) {
        int current = Math.max(prev1, prev2 + arr[i]);
        prev2 = prev1;
        prev1 = current;
    }
    return prev1;
}


void main() {
    System.out.println(fib(9));
    System.out.println(fib(3));
    System.out.println(fib(62));
    System.out.println(appFib(62));
    System.out.println(sumofprime(11));
    int[] arr = {-2,4,-6,5,3};
    System.out.println(sumofarr(arr));
    System.out.println(maximumNonAdj(arr));
}