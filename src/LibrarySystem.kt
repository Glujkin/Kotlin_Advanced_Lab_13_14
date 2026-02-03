data class Book(val title: String, val author: String, val year: Int, val isbn: String)
data class Magazine(val title: String, val issue: Int, val month: String)
data class DVD(val title: String, val director: String, val duration: Int)

sealed class LibraryItem {
    data class BookItem(val book: Book) : LibraryItem()
    data class MagazineItem(val magazine: Magazine) : LibraryItem()
    data class DVDItem(val dvd: DVD) : LibraryItem()
}

class Library<T> {
    private val items = mutableListOf<T>()

    fun addItem(item: T) = items.add(item)
    fun getAllItems(): List<T> = items.toList()
    fun getItemCount(): Int = items.size

    fun filterByYear(year: Int): List<Book> {
        return items.filterIsInstance<LibraryItem.BookItem>()
            .map { it.book }
            .filter { it.year == year }
    }

    fun sortByTitle(): List<LibraryItem> {
        return items.filterIsInstance<LibraryItem>()
            .sortedBy {
                when (it) {
                    is LibraryItem.BookItem -> it.book.title
                    is LibraryItem.MagazineItem -> it.magazine.title
                    is LibraryItem.DVDItem -> it.dvd.title
                }
            }
    }

    fun groupByAuthor(): Map<String, List<Book>> {
        return items.filterIsInstance<LibraryItem.BookItem>()
            .map { it.book }
            .groupBy { it.author }
    }

    fun calculateTotalDuration(): Int {
        return items.filterIsInstance<LibraryItem.DVDItem>()
            .sumOf { it.dvd.duration }
    }

    fun getBooks(): List<Book> {
        return items.filterIsInstance<LibraryItem.BookItem>()
            .map { it.book }
    }

    fun getMagazines(): List<Magazine> {
        return items.filterIsInstance<LibraryItem.MagazineItem>()
            .map { it.magazine }
    }

    fun getDVDs(): List<DVD> {
        return items.filterIsInstance<LibraryItem.DVDItem>()
            .map { it.dvd }
    }
}