public class Book {

    private Long book_id;
    private String isbn;
    private String[] authors;
    private Integer original_publication_year;
    private String original_title;
    private String title;
    private String language_code;
    private String image_url;

    public Book(long book_id, String isbn, String[] authors, int original_publication_year, String original_title, String title, String language_code, String image_url) {
        this.book_id = book_id;
        this.isbn = isbn;
        this.authors = authors;
        this.original_publication_year = original_publication_year;
        this.original_title = original_title;
        this.title = title;
        this.language_code = language_code;
        this.image_url = image_url;
    }

    public Book (String[] args){
        if (args.length == 8){
            this.book_id = Long.parseLong(args[0]);
            this.isbn = args[1];
            this.authors[0] = args[2];
            this.original_publication_year = Integer.parseInt(args[3]);
            this.original_title = args[4];
            this.title = args[5];
            this.language_code = args[6];
            this.image_url = args[7];
        }
    }


    @Override
    public String toString() {
        return  "book_id: " + book_id + "\n" +
                "isbn: " + isbn + "\n" +
                "authors: " + authors + "\n" +
                "original_publication_year: " + original_publication_year+ "\n" +
                "original_title: " + original_title + "\n" +
                "title: " + title + "\n" +
                "language_code: " + language_code + "\n" +
                "image_url: " + image_url + "\n" +
                "\n\n";
    }
}
