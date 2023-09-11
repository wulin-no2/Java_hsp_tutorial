public class A01 {
    public Double max(double[] arr) {
        if (arr != null && arr.length > 0) {

            double maxNum = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > maxNum) {
                    maxNum = arr[i];
                }
            }
            return maxNum;
        } else {
            return null;
        }
    }
}
