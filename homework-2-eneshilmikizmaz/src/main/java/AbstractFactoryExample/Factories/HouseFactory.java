package AbstractFactoryExample.Factories;

import AbstractFactoryExample.Rooms.Room;
import AbstractFactoryExample.Windows.Window;

public interface HouseFactory {
    Room createRoom();
    Window buildWindow();
}
