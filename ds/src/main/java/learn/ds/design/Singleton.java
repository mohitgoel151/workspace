package learn.ds.design;

public final class Singleton {
    
//    private static Singleton singleton = new Singleton();

//    Approach 1
//    The inner class is referenced no earlier (and therefore loaded no earlier by the class loader) 
//    than the moment that getInstance() is called. Thus, this solution is thread-safe without requiring 
//    special language constructs (i.e. volatile or synchronized).
    
    private Singleton() {
        System.out.println("as");
    }
    
    private static final class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        //return singleton;
        return SingletonHolder.INSTANCE;
    }
    
    //Approach 2 which is commented
//    When the initialized object is a static field of a class with no other methods or fields, 
//    the JVM effectively performs lazy initialization automatically. In the following example, 
//    the Resource will not be constructed until the field resource is first referenced by another class, 
//    and any memory writes that result from resource's initialization are automatically visible to all threads:
    
//    The initialization will be performed when the JVM initializes the class. Since MySingleton has no other fields or methods, 
//    class initialization occurs when the resource field is first referenced.

    
    //Issue with double locking:
    //http://www.javaworld.com/article/2074979/java-concurrency/double-checked-locking--clever--but-broken.html
}
