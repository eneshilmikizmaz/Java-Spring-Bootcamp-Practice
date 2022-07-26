package AbstractFactoryExample.Factories;

import AbstractFactoryExample.Rooms.Room;
import AbstractFactoryExample.Rooms.VillaRoom;
import AbstractFactoryExample.Windows.VillaWindow;
import AbstractFactoryExample.Windows.Window;

public class VillaFactory implements HouseFactory {
    @Override
    public Room createRoom() {
        return new VillaRoom();
    }

    @Override
    public Window buildWindow() {
        return new VillaWindow();
    }
}
