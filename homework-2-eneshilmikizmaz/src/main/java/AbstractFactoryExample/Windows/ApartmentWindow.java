package AbstractFactoryExample.Windows;

public class ApartmentWindow implements Window{
    @Override
    public void build() {
        System.out.println("Built Apartment Window");
    }
}
