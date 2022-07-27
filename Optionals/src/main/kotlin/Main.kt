fun main(args: Array<String>) {
    val dog: Dog? = null;
    val result = dog?.speak() ?: "sdf"

}

class Dog {
    public fun speak(): String {
        return "Woof!"
    }
}