package AbstractFactoryExample;

import AbstractFactoryExample.Factories.ApartmentFactory;
import AbstractFactoryExample.Factories.HouseFactory;
import AbstractFactoryExample.Factories.VillaFactory;
import AbstractFactoryExample.Enums.HouseType;

public class Main {

    private static House configureHouse(HouseType houseType) {
        HouseFactory houseFactory;
        House house = null;
        if (houseType == HouseType.APARTMENT) {
            houseFactory = new ApartmentFactory();
            house = new House(houseFactory);
        } else if (houseType == HouseType.VILLA) {
            houseFactory = new VillaFactory();
            house = new House(houseFactory);
        }
        return house;
    }

    public static void main(String[] args) {
        House house = configureHouse(HouseType.VILLA);
        house.buildHouse();
        System.out.println("-----------------------------------------");
        House house1 = configureHouse(HouseType.APARTMENT);
        house1.buildHouse();
    }
}
