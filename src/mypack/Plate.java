package mypack;

public class Plate extends Sphere{
    public Plate(int Mass, int R) {
        super(Mass, R);
    }

    @Override
    double momentOfInteria() {
        return Mass*R*R/2;
    }
}
