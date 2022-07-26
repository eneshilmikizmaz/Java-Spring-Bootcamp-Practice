package AbstractFactoryExample;

import AbstractFactoryExample.Factories.HouseFactory;
import AbstractFactoryExample.Rooms.Room;
import AbstractFactoryExample.Windows.Window;

public class House {
    private Room room;
    private Window window;

    public House(HouseFactory factory) {
        this.room = factory.createRoom();
        this.window = factory.buildWindow();
    }

    public void buildHouse() {
        room.create();
        window.build();
    }


}
