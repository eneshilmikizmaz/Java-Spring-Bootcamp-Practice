package AbstractFactoryExample.Rooms;

public class ApartmentRoom implements Room{
    @Override
    public void create() {
        System.out.println("Created Apartment Room");
    }
}
