public class PassObject {
    public void printAreas(Circle c,int times){
        System.out.println("Radius" + "\t" + "Area");
        for(int i = 1;i <= times;i++){
            System.out.println((double) i + "\t\t" + c.areaCircle(i));
        }
    }
}
