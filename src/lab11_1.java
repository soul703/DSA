/*
lab 11.1 Fibonacci
 */
private int Fibonacci(int a){
    if(a <=1) return a ;
    int b = 0 , c =1 , fib = 0;
    for(int i = 2 ; i <= a ; i++){
        fib = c + b;
        b = c;
        c = fib;
    }
    return fib;
}
void main(){
    Main.measure(() -> {
        System.out.println("Testcase 1: " );
        System.out.println("Input = 3 - Output = :" + Fibonacci(3));
    });
    Main.measure(() -> {
        System.out.println("Testcase 2: " );
        System.out.println("Input = 10 - Output = :" + Fibonacci(10));
    });

}
