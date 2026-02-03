fun main() {
    val library = Library<LibraryItem>()

    val books = listOf(
        Book("Война и мир", "Лев Толстой", 1869, "978-5-699-12014-7"),
        Book("Преступление и наказание", "Федор Достоевский", 1866, "978-5-17-090324-2"),
        Book("Мастер и Маргарита", "Михаил Булгаков", 1967, "978-5-17-090325-9"),
        Book("1984", "Джордж Оруэлл", 1949, "978-5-17-090326-6"),
        Book("Анна Каренина", "Лев Толстой", 1877, "978-5-699-12015-4")
    )

    val magazines = listOf(
        Magazine("Наука и жизнь", 3, "Март"),
        Magazine("Компьютерра", 12, "Декабрь")
    )

    val dvds = listOf(
        DVD("Крестный отец", "Фрэнсис Форд Коппола", 175),
        DVD("Побег из Шоушенка", "Фрэнк Дарабонт", 142),
        DVD("Форрест Гамп", "Роберт Земекис", 142)
    )

    books.forEach { library.addItem(it.toLibraryItem()) }
    magazines.forEach { library.addItem(it.toLibraryItem()) }
    dvds.forEach { library.addItem(it.toLibraryItem()) }

    println("Всего элементов: ${library.getItemCount()}")

    println("\n1. Книги 1869 года:")
    library.filterByYear(1869).forEach { println("- ${it.title}") }

    println("\n2. Сортировка по названию:")
    library.sortByTitle().take(3).forEach { println("- ${it.title}") }

    println("\n3. Книги по авторам:")
    library.groupByAuthor().forEach { (author, books) ->
        println("$author: ${books.size} книг")
    }

    println("\n4. Общая продолжительность DVD:")
    println("${library.calculateTotalDuration()} минут")

    println("\n5. Поиск 'мир':")
    library.searchByTitle("мир").forEach { println("- ${it.title}") }

    println("\n6. Статистика:")
    println("Книги: ${library.getBooks().size}")
    println("Журналы: ${library.getMagazines().size}")
    println("DVD: ${library.getDVDs().size}")

    library.getOldestBook()?.let {
        println("\nСамая старая книга: ${it.title} (${it.year})")
    }
}