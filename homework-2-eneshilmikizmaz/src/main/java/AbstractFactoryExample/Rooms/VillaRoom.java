package AbstractFactoryExample.Rooms;

public class VillaRoom implements Room{
    @Override
    public void create() {
        System.out.println("Created Villa Room");
    }
}
