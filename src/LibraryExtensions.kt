fun Book.toLibraryItem(): LibraryItem = LibraryItem.BookItem(this)
fun Magazine.toLibraryItem(): LibraryItem = LibraryItem.MagazineItem(this)
fun DVD.toLibraryItem(): LibraryItem = LibraryItem.DVDItem(this)

val LibraryItem.title: String
    get() = when (this) {
        is LibraryItem.BookItem -> this.book.title
        is LibraryItem.MagazineItem -> this.magazine.title
        is LibraryItem.DVDItem -> this.dvd.title
    }

fun Library<LibraryItem>.searchByTitle(title: String): List<LibraryItem> {
    return this.getAllItems().filter {
        it.title.contains(title, ignoreCase = true)
    }
}

fun Library<LibraryItem>.getOldestBook(): Book? {
    return this.getBooks().minByOrNull { it.year }
}