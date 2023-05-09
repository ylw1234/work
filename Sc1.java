package text;
import java.util.*;
public class Sc1 {
    public static void main(String[] args) {
        System.out.println("<------第一题------->");
        Monkey monkey = new Monkey("king");
        System.out.println("monkey's name:"+monkey.name);
        monkey.speak();
        People people = new People("Jesus");
        System.out.println("people's name:"+people.name);
        people.speak();
        people.think();
        
        
        System.out.println("<-------第二题------->");
        Car car = new Car(4,1150,3);
        System.out.println(car);
        System.out.println("----------------------------");
        Truck truck = new Truck(6,15000,1,3000);
        System.out.println(truck);
        
        
        System.out.println("<-------第三题------->");
        System.out.println(getSum("46529156841298344697257","764916438246319842695173"));

        
        System.out.println("<-------第五题------->");
        System.out.println("输入不存在公共前缀。"+longestCommonPrefix(new String[]{"f1ower","f1ow","f1ight"}));
    }
    //第三题
    public static String getSum(String a,String b){
        List<Integer> la = new ArrayList<Integer>();
        List<Integer> lb = new ArrayList<Integer>();
        String c="";
        for(int i=a.length()-1;i>=0;--i){
            la.add(a.charAt(i)-'0');
        }
        for(int i=b.length()-1;i>=0;--i){
            lb.add(b.charAt(i)-'0');
        }
        List<Integer> lc = new ArrayList<Integer>();
        int temp=0;
        int maxsize = Math.max(la.size(),lb.size());
        for (int i = 0; i < maxsize; i++) {
            if(i<la.size()){
                temp+= la.get(i);
            }
            if(i<lb.size()){
                temp+= lb.get(i);
            }
            lc.add(temp%10);
            temp/= 10;
        }
        if(temp>0)
            lc.add(temp%10);
        for(int i = lc.size()-1;i>=0;i--){
            c += lc.get(i);
        }
        return c;
    }
    //第三题

    //第五题
    public static String longestCommonPrefix(String[] strs) {
        if (strs==null||strs.length==0) {
            return "";
        }
        int length=strs[0].length();
        int count=strs.length;
        for (int i=0;i<length;i++) {
            char txt = strs[0].charAt(i);
            for (int j=1;j<count;j++) {
                if (i==strs[j].length()||strs[j].charAt(i)!=txt) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
    //第五题
}
//第一题
class Monkey{
    String name;
    public Monkey(String s){
        this.name = s;
    }
    public void speak(){
        System.out.println("咿咿呀呀 ......");
    }
}
class People extends Monkey{
    public People(String s){
        super(s);
    }
    public void speak(){
        System.out.println("小样儿，不错嘛！会说话了！");
    }
    public void think(){
        System.out.println("别说话！认真 思考！ ");
    }
}
//第一题

//第二题
class Vehicle{
    int wheels;
    double weight;
    public Vehicle(){
    }
    public Vehicle(int wheels,double weight){
        this.wheels = wheels;
        this.weight = weight;
    }
}
class Car extends Vehicle{
    int loader;
    public Car(){
    }
    public Car(int wheels,double weight,int loader){
        super(wheels,weight);
        this.loader = loader;
    }
    public String toString(){
        return "车轮的个数是"+wheels+" 车重" + weight
                +"\n这是一辆小车，能载6人，实载"+loader+"人"+(loader>6? ",你超员了!":"");
    }
}
class Truck extends Vehicle{
    int loader;
    double payload;
    public Truck(int wheels,double weight,int loader,double payload){
        super(wheels,weight);
        this.loader = loader;
        this.payload = payload;
    }
    public String toString(){
        return "车轮的个数是"+wheels+" 车重" + weight
                +"\n这是一辆卡车，能载3人，实载"+loader+"人"+(loader>3? ",你超员了!":"")
                +"\n这是一辆卡车，核载5000kg，你已装载"+payload+"kg"+(payload>5000? ",你超载了!":"");
    }
}
//第二题
