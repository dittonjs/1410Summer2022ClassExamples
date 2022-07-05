fun main(args: Array<String>) {
    val dim = 10
    val numTests = 1000
    var successes = 0
    (0 until numTests).forEach {
        successes += if (Simulation(dim).runSimulation()) 1 else 0
    }

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println(successes.toDouble() / numTests.toDouble())
}