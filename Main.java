import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Spring constant
        System.out.print("Enter spring constant (N/m): ");
        double springConstant = scanner.nextDouble();
        // Viscosity
        System.out.print("Enter viscosity (Ns/m): ");
        double viscosity = scanner.nextDouble();
        // Instance of KelvinVoigtModel
        KelvinVoigtModel model = new KelvinVoigtModel(springConstant, viscosity);
        
        // Simulation with advanced strain input
        System.out.println("Enter number of time steps: ");
        int numTimeSteps = scanner.nextInt();

        double[] strainInput = new double[numTimeSteps];
        for (int i = 0; i < numTimeSteps; i++) {
            System.out.print("Enter strain for time step " + (i + 1) + ": ");
            strainInput[i] = scanner.nextDouble();
        }
        System.out.println("Simulation started...");
        for (int i = 0; i < numTimeSteps; i++) {
            double strain = strainInput[i];

            // Apply strain to the model
            model.applyStrain(strain);

            // Compute and print stress
            double stress = model.computeStress();
            System.out.println("Time step " + (i + 1) + ": Strain = " + strain + ", Stress = " + stress + " N/m²");
        }
        scanner.close();
    }
}
