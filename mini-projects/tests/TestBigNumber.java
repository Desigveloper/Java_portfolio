class TestBigNumber {

    public static void main(String[] args) {
        // Test cases for BigNumber class

        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (j == i) break;

                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}