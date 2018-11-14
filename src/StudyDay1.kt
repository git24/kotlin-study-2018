import java.util.function.Predicate

fun euler1(number: Int) : Int =
        (1..(number -1))
                .filter{ it.rem(3) == 0 || it.rem(5) == 0 }
                .sum()

fun euler2(max: Int, predicate: (Int) -> Boolean = { true }) : Int {
    // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/generate-sequence.html

    var sum = 0
    var pair = Pair(0, 1)

    while (pair.second <= max) {
        if (predicate(pair.second)) {
            sum += pair.second;
        }
        pair = Pair(pair.second, pair.first + pair.second)
    }
    return sum
}

fun euler22(max: Int) : Int =
        generateSequence(Pair(0, 1)) { Pair(it.second, it.first + it.second) }
                .map { it.first }
                .filter { it <= max }
                .filter { it % 2 == 0 }
                .take(max)
                .sum()

fun main(args : Array<String>) {
    println("euler1 = ${ euler1(1000) }")
    println("euler2 = ${ euler2(4000000) { it % 2 == 0 } }")
    println("euler2 = ${ euler22(4000000) }")
}