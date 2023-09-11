public class Homework12 {
    public static void main(String[] args) {
        Employee employee = new Employee("jane",'F',30,"pm",20000);
        Employee employee1 = new Employee("bob",'M',22);
        Employee employee2 = new Employee("SDE",14000);
        System.out.println(employee.name +"\t"+ employee.sex+"\t" + employee.age+"\t" + employee.position+"\t" + employee.salary);
        System.out.println(employee1.name+"\t" + employee1.sex +"\t"+ employee2.age);
        System.out.println(employee2.position +"\t"+ employee2.salary);

    }
}
