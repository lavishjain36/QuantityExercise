public enum UnitOfTemperature implements Unit {
    Celsius("celsius", 273.15),
    Fahrenheit("fahrenheit", -32),
    Kelvin("kelvin", 0);

    private final String name;
    private final double conversionFactorForSIUnit;

    UnitOfTemperature(String name, double conversionFactorForSIUnit) {
        this.name = name;
        this.conversionFactorForSIUnit = conversionFactorForSIUnit;
    }

    public double getconversionFactorForSIUnit() {
        return conversionFactorForSIUnit;
    }

    @Override
    public double dimensionInSIunits(double dimension) {
        if (name.equalsIgnoreCase("fahrenheit"))
            return (dimension - 32) * 5 / 9 + 273.15;
        else
            return dimension + this.getconversionFactorForSIUnit();
    }
}