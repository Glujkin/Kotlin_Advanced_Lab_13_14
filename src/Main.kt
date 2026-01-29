fun main(){
    val question1 = Question<String>(
        "Речка спятила с ума  - По домам пошла сама. ___",
        "Водопровод",
        Difficulty.MEDIUM
    )
    val question2 = Question<Boolean>(
        "Небо зелёное. Правда или ложь",
        false,
        Difficulty.EASY


    )
    val question3 = Question<Int>(
        "Сколько дней между полнолуниями ?",
        28,
        Difficulty.HARD

    )
    println(question1.toString())
    println(question2.toString())
    println(question3.toString())
}