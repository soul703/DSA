public class lab12_1 {
    private static int getChange(int m) {
        int[] coins = {10, 5, 1};  // mảng mệnh giá, giảm dần
        int count = 0;

        for (int coin : coins) {
            if (m >= coin) {
                int num = m / coin;     // dùng được bao nhiêu tờ mệnh giá này
                count += num;
                m -= num * coin;
            }

            if (m == 0) break; // không cần xét nữa
        }

        return count;
    }

    void main(){
        System.out.println(getChange(18));
    }

}
