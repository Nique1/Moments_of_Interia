package mypack;

public class Cone extends Sphere{
    public Cone(int Mass, int R) {
        super(Mass, R);
    }

    @Override
    double momentOfInteria() {
        return 3*Mass*R*R/10;
    }

}
