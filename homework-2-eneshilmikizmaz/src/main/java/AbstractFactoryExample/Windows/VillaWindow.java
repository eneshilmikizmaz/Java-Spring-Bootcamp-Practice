package AbstractFactoryExample.Windows;

public class VillaWindow implements Window{
    @Override
    public void build() {
        System.out.println("Built Villa Window");
    }
}
