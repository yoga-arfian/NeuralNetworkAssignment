# Neural Network Assignment

A Java-based academic project exploring Single Perceptron and Multilayer Perceptron (MLP) learning algorithms.

## Project Overview

This project studies neural network learning behavior through experiments involving activation functions and learning rates. It supports the analysis of how these configurations influence training performance.

## Implementations

- **Single Perceptron** — A single-layer perceptron implementation for studying basic neural network learning.
- **Multilayer Perceptron (MLP)** — A multilayer neural network implementation for exploring learning behavior in a network with hidden layers.

## Experiments

The assignment investigates:

1. Changing the activation function while keeping the learning rate constant.
2. Changing the learning rate while keeping the activation function constant.
3. Recording and comparing experiment results.
4. Visualizing learning behavior using spreadsheet charts.
5. Analyzing the impact of parameter changes on model performance.

## Technologies

- Java
- Eclipse IDE
- CSV experiment data
- Microsoft Excel or a compatible spreadsheet application

## Project Structure

```text
NeuralNetworkAssignment/
├── src/
│   ├── SinglePerceptron.java
│   └── MultiLayerPerceptron.java
├── mlp_results.csv
├── single_results.csv
├── .classpath
├── .project
├── .gitignore
└── README.md
```

## Experiment Results

- `single_results.csv` — Results from Single Perceptron experiments.
- `mlp_results.csv` — Results from Multilayer Perceptron experiments.

These files can be imported into Excel for comparison, visualization, and further analysis.

## Getting Started

1. Open Eclipse.
2. Import the project using **File → Import → Existing Projects into Workspace**.
3. Select the `NeuralNetworkAssignment` directory.
4. Confirm that the required JDK is configured.
5. Run `SinglePerceptron.java` or `MultiLayerPerceptron.java` as a Java Application, if the class contains a `main` method.

## Limitations

This project is intended for academic experimentation. Conclusions should be drawn from the actual experiment configurations and results; performance may vary depending on the dataset, activation function, learning rate, and other parameters.

## Author

Yoga Arfiansyah Firdaus

Master of Information Systems  
Telkom University

---

For educational purposes only.
