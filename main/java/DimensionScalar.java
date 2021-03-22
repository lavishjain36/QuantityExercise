public abstract class DimensionScalar<T extends DimensionScalar> extends Dimension {
    public DimensionScalar(double dimension, Unit unit) {
        super(dimension, unit);
    }

    public abstract T createMeasurement(double dimension);

    public T add(T measurement) {
        double sum = this.unit.dimensionInSIunits(dimension) + measurement.unit.dimensionInSIunits(measurement.dimension);
        return (T) createMeasurement(sum);
    }

    public T subtract(T measurement) {
        double difference = this.unit.dimensionInSIunits(dimension) - measurement.unit.dimensionInSIunits(measurement.dimension);

        try {
            return (T) createMeasurement(difference);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("can't subtract larger unit from smaller one");
        }

    }


}