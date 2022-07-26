package AbstractFactoryExample.Factories;

import AbstractFactoryExample.Rooms.ApartmentRoom;
import AbstractFactoryExample.Rooms.Room;
import AbstractFactoryExample.Windows.ApartmentWindow;
import AbstractFactoryExample.Windows.Window;

public class ApartmentFactory implements HouseFactory {
    @Override
    public Room createRoom() {
        return new ApartmentRoom();
    }

    @Override
    public Window buildWindow() {
        return new ApartmentWindow();
    }
}
