public class A02 {
    public int find(String str, String[] arr) {
        if (arr != null && arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                if (str == arr[i]) {
                    return i;
                }
            }
            return -1;
        }
        else {
            return -2;
        }
    }
}
