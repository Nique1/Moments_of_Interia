package mypack;

public class Cylinder extends Cone {
    public Cylinder(int Mass, int R) {
        super(Mass, R);
    }

    @Override
    double momentOfInteria() {
        return Mass*R*R/2;
    }
}
