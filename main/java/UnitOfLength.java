public enum UnitOfLength implements Unit {
    Centimeter("centimeter", 0.01),
    Meter("meter", 1),
    Kilometer("kilometer", 1000);

    private final String name;
    private final double conversionFactorForSIUnit;

    UnitOfLength(String name, double conversionFactorForSIUnit) {
        this.name = name;
        this.conversionFactorForSIUnit = conversionFactorForSIUnit;
    }

    public double getConversionFactorForSIUnit() {
        return conversionFactorForSIUnit;
    }


    @Override
    public double dimensionInSIunits(double dimension) {
        return dimension * this.getConversionFactorForSIUnit();
    }

}