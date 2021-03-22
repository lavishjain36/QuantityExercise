public enum UnitOfWeight implements Unit {
    Gram("gram", 0.001),
    Kilogram("kilogram", 1);

    private final String name;
    private final double conversionFactorForSIUnit;

    UnitOfWeight(String name, double conversionFactorForSIUnit) {
        this.name = name;
        this.conversionFactorForSIUnit = conversionFactorForSIUnit;
    }

    public double getconversionFactorForSIUnit() {
        return conversionFactorForSIUnit;
    }

    @Override
    public double dimensionInSIunits(double dimension) {
        return dimension * this.getconversionFactorForSIUnit();
    }

}