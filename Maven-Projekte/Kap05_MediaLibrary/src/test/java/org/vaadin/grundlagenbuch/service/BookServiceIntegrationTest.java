package org.vaadin.grundlagenbuch.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.vaadin.grundlagenbuch.MedialibraryApplication;
import org.vaadin.grundlagenbuch.model.Book;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MedialibraryApplication.class)
public class BookServiceIntegrationTest {

  @Autowired
  private BookService service;

  @Before
  public void createAndSaveBooks() {
    service.save(new Book("King Lear", "William Shakespeare"));
    service.save(new Book("It", "Stephen King", "Viking Press"));
    service.save(new Book("Book Design", "Andrew Haslam", "Laurence King Publishing"));
  }

  @After
  public void deleteAllBooks() {
    service.deleteAllBooks();
  }

  @Test
  public void testSavingAndLoadingBooks() {
    Book tlotr = new Book("The Lord of the Rings", "J. R. R. Tolkien", "George Allen & Unwin");
    Book tlotrSaved = service.save(tlotr);

    Book tlotrLoaded = service.findById(tlotrSaved.getId());
    assertThat(tlotrLoaded.getTitle(), equalTo(tlotrSaved.getTitle()));
  }

  @Test
  public void testFullTextSearchForBooks() {
    List<Book> books = service.searchBooks("king");
    assertThat(books, hasSize(3));
  }
}
