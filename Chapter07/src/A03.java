public class A03 {
    String[] str;
    public void copyArr(String[] str){
        this.str = str;
        String[] newArr = new String[str.length];
        for(int i=0;i < str.length; i++){
            newArr[i] = str[i];
        }
        System.out.println("this is the array you copied: ");
        for(int i=0;i < newArr.length; i++){
            System.out.print(newArr[i] + " ");
        }
    }
}
