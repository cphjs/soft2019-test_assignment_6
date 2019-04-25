package cphb;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Container container = new Container();
        container.load();
        OrderDataStore store = container.get(OrderDataStore.class);
        System.out.println("Store:" +  store + " type: " + store.getClass().getSimpleName());
    }
}
