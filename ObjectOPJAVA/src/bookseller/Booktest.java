package bookseller;

public class Booktest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookSelect book = new BookSelect("harper's book", "1123-23", 123.5, 6);
		BookSelectBiz bookbiz = new BookSelectBiz();

		bookbiz.sellbook(book);
		System.out.println(book.getCount());
	}

}
