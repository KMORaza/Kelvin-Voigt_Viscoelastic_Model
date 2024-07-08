public class KelvinVoigtModel {
    private double springConstant;
    private double viscosity;
    private double currentStrain;
    public KelvinVoigtModel(double springConstant, double viscosity) {
        this.springConstant = springConstant;
        this.viscosity = viscosity;
        this.currentStrain = 0.0; 
    }
    public void applyStrain(double strain) {
        currentStrain += strain;
    }
    public double computeStress() {
        double stressElastic = springConstant * currentStrain;
        double stressViscous = viscosity * getStrainRate();
        return stressElastic + stressViscous;
    }
    private double getStrainRate() {
        return currentStrain;
    }
    public double getCurrentStrain() {
        return currentStrain;
    }
    public double getSpringConstant() {
        return springConstant;
    }
    public void setSpringConstant(double springConstant) {
        this.springConstant = springConstant;
    }
    public double getViscosity() {
        return viscosity;
    }
    public void setViscosity(double viscosity) {
        this.viscosity = viscosity;
    }
}
