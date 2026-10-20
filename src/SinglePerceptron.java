import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Locale;

/*
 * Single perceptron experiment for the AND dataset.
 * Activation: STEP, SIGMOID, TANH
 * Learning rates can be changed in main().
 *
 * For STEP, use the classic perceptron update.
 * For SIGMOID/TANH, use a differentiable activation and gradient-based update.
 */
public class SinglePerceptron {
    static final double[][] X = {{0,0},{0,1},{1,0},{1,1}};
    static final double[] Y = {0,0,0,1};

    static double activate(double z, String function) {
        switch (function.toUpperCase()) {
            case "STEP": return z > 0 ? 1.0 : 0.0;
            case "SIGMOID": return 1.0 / (1.0 + Math.exp(-z));
            case "TANH": return Math.tanh(z);
            default: throw new IllegalArgumentException("Unknown activation: " + function);
        }
    }

    static double derivativeFromOutput(double a, String function) {
        switch (function.toUpperCase()) {
            case "SIGMOID": return a * (1.0 - a);
            case "TANH": return 1.0 - a * a;
            default: return 1.0;
        }
    }

    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        String[] activations = {"STEP", "SIGMOID", "TANH"};
        double[] rates = {0.01, 0.1, 0.5};
        int maxEpochs = 500;

        try (PrintWriter out = new PrintWriter(new FileWriter("single_results.csv"))) {
            out.println("activation,learning_rate,epoch,mse");
            for (String activation : activations) {
                for (double lr : rates) {
                    double[] w = {0.15, -0.20};
                    double b = -0.10;
                    for (int epoch = 1; epoch <= maxEpochs; epoch++) {
                        double totalSquaredError = 0.0;
                        for (int i = 0; i < X.length; i++) {
                            double z = w[0]*X[i][0] + w[1]*X[i][1] + b;
                            double a = activate(z, activation);
                            double error = Y[i] - a;
                            totalSquaredError += error * error;

                            if (activation.equals("STEP")) {
                                // Classic perceptron learning rule
                                w[0] += lr * error * X[i][0];
                                w[1] += lr * error * X[i][1];
                                b += lr * error;
                            } else {
                                // Gradient update for half squared error
                                double delta = error * derivativeFromOutput(a, activation);
                                w[0] += lr * delta * X[i][0];
                                w[1] += lr * delta * X[i][1];
                                b += lr * delta;
                            }
                        }
                        double mse = totalSquaredError / X.length;
                        out.printf("%s,%.2f,%d,%.8f%n", activation, lr, epoch, mse);
                    }
                }
            }
        }
        System.out.println("Selesai. File dibuat: single_results.csv");
        System.out.println("Catatan: untuk STEP, MSE dihitung dari prediksi sebelum update pada tiap contoh.");
    }
}
