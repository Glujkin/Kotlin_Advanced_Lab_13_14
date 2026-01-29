interface ProgressPrintable{
    val progressText: String
    fun printProgressBar()
}
class Quiz: ProgressPrintable{
    override val progressText: String
        get() = "${answered} of ${total} andwered"

    override fun printProgressBar() {
        repeat(answered) { print("▓") }
        repeat(Quiz.total) {print("▒")}
        println()
        println(progressText)
    }
    fun printQuiz(){
        question1.let {
            println(it.quetionText)
            println(it.answer)
            println(it.difficulty)
        }
        question2.let {
            println(it.quetionText)
            println(it.answer)
            println(it.difficulty)
        }
        question3.let {
            println(it.quetionText)
            println(it.answer)
            println(it.difficulty)
        }
    }
    val question1 = Question<String>("Речка спятила с ума  - По домам пошла сама. ___",
        "Водопровод",
        Difficulty.MEDIUM
    )
    val question2 = Question<Boolean>("Небо зелёное. Правда или ложь",
        false,
        Difficulty.EASY
    )
    val question3 = Question<Int>("Сколько дней между полнолуниями ?",
        28,
        Difficulty.HARD
    )
    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}


fun main(){
   val quiz = Quiz().apply { printQuiz() }


}