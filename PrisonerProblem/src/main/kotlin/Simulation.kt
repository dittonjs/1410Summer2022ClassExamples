class Simulation(private val dim: Int) {
    private val boxes: List<Int>
    private val numPrisoners = dim * dim
    init {
        boxes = (1..numPrisoners).shuffled().toMutableList()
    }

    fun runSimulation(): Boolean {
        return (1..100).all { prisonerNum ->
            var boxesChecked = 1;
            var currentValue = boxes[prisonerNum - 1]
            while (boxesChecked < 50 && currentValue != prisonerNum) {
                currentValue = boxes[currentValue - 1]
                boxesChecked ++
            }
            currentValue == prisonerNum
        }
    }
}