package generics;

/*
 Type parameters have naming convention, it is commonly used
 don't try to use different naming convention
 T: Type  (for classes)
 E: Element (for methods)
 K: Key
 V: Values
 N:Number
 */




public class Generics02 {
    public static void main(String[] args) {

  Generic03 <String,Integer> obj1 = new Generic03<>("Ali",33);
      //  obj1.display(true, 'C');
      //  obj1.display(12, "Aliye");
        obj1.display('X', 55);
        obj1.print('A');
    }
}

class Generic03 <K,V>{
    private K key;
    private  V value;
   //
    public Generic03(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Generic03{" +
                "key=" + key +
                ", Value=" + value +
                '}';
    }
    //after N extends you can use just one class/abstract class and it should be the first
    //If you use interface you can use multiple interfaces
    //If you use interface together with a class, class should be the first interfaces
    // should be after the class
    public <E,N extends Number> void display(E element, N number){
        System.out.println("Element: "+element+", Number: "+number);
    }
    public <E> void print (E element){
        System.out.println("Element:"+element);
    }

}