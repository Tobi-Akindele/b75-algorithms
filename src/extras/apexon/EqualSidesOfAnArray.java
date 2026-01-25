package extras.apexon;

public class EqualSidesOfAnArray {

    public static int findV1(int[] arr) {
        int totalSum = 0;
        for (int i: arr) {
            totalSum += i;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int rightSum = totalSum - leftSum - arr[i];
            if (leftSum == rightSum){
                return i;
            }

            leftSum += arr[i];
        }

        return -1;
    }

    // O(n^2)
    public static int find(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            int leftIdx = i - 1;
            int rightIdx = arr.length - 1;

            // Calculate left side sum
            while (leftIdx >= 0) {
                leftSum += arr[leftIdx];

                leftIdx--;
            }

            // Calculate right side sum
            while (rightIdx > i) {
                rightSum += arr[rightIdx];

                rightIdx--;
            }

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[] {1,2,3,4,3,2,1}));
        System.out.println(find(new int[] {1,100,50,-51,1,1}));
        System.out.println(find(new int[] {20,10,-80,10,10,15,35}));
        System.out.println(find(new int[] {}));
        System.out.println("=".repeat(10));

        System.out.println(findV1(new int[] {1,2,3,4,3,2,1}));
        System.out.println(findV1(new int[] {1,100,50,-51,1,1}));
        System.out.println(findV1(new int[] {20,10,-80,10,10,15,35}));
        System.out.println(findV1(new int[] {}));
    }
}
