public class WeightUtilities extends DimensionScalar {

    public WeightUtilities(double dimension, UnitOfWeight unit) throws IllegalArgumentException {
        super(dimension, unit);
    }

    @Override
    public DimensionScalar createMeasurement(double dimension) {
        return new WeightUtilities(dimension, UnitOfWeight.Kilogram);
    }
}