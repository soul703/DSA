import java.sql.SQLOutput;

private  int getFibonacciLastDigitNaive(int n) {
    if (n <= 1)
        return n;

    int previous = 0;
    int current  = 1;

    for (int i = 0; i < n - 1; ++i) {
        int tmp_previous = previous;
        previous = current;
        current = tmp_previous + current;
    }

    return current % 10;
}
private int getLastDigit(int n) {
    if (n <= 1) return n;

    int prev = 0;
    int curr = 1;
    for (int i = 2; i <= n; i++) {
        int temp = (prev + curr) % 10;
        prev = curr;
        curr = temp;
    }
    return curr;
}
public static int getFibonacciLastDigitFastest(int n) {
    int[] pisanoMod10 = new int[60];
    pisanoMod10[0] = 0;
    pisanoMod10[1] = 1;
    for (int i = 2; i < 60; i++) {
        pisanoMod10[i] = (pisanoMod10[i - 1] + pisanoMod10[i - 2]) % 10;
    }
    return pisanoMod10[n % 60];
}

void main(){
//    Main.measure(() -> {
//        System.out.println(getFibonacciLastDigitNaive(327305));
//    });
//    Main.measure(() -> {
//        System.out.println(getLastDigit(327305));
//    });
   Main.measure(() -> {
        System.out.println(getFibonacciLastDigitFastest(327305));
    });
    Thread thread1 = new Thread(() -> {
        Main.measure(() -> {
            int result = getFibonacciLastDigitNaive(327305);
            System.out.println("Kết quả: " + result);
        });
    });
    thread1.start(); // Đừng quên chạy thread
}
