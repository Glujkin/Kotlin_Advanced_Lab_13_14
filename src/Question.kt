class Question<T>(
    val quetionText: String,
    val answer: T,
    val difficulty: Difficulty,
)
enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
}