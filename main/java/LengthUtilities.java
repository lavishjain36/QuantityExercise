class LengthUtilities extends DimensionScalar {

    public LengthUtilities(double dimension, UnitOfLength unit) throws IllegalArgumentException {
        super(dimension, unit);
    }

    @Override
    public LengthUtilities createMeasurement(double dimension) {
        return new LengthUtilities(dimension, UnitOfLength.Meter);
    }
}