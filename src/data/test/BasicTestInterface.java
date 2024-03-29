/**
 * This interface and the TestObject exist here for unit testing, as integration testing
 * in this package would add a dependency on the gameengine module.
 */
public interface BasicTestInterface {

    public void changeString(String string);

    public void storeArgs(String... args);

    public String getString();

    public String[] getArgs();

    public void storeObjects(Object... objects);

    public Object[] getObjects();
}
