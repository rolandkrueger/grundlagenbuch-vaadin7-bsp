package org.vaadin.grundlagenbuch.service;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.collection.IsIterableWithSize;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.vaadin.grundlagenbuch.MedialibraryApplication;
import org.vaadin.grundlagenbuch.model.Genre;
import org.vaadin.grundlagenbuch.model.MediaType;
import org.vaadin.grundlagenbuch.repository.GenreRepository;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MedialibraryApplication.class)
public class GenreServiceIntegrationTest {

  @Autowired
  private GenreService service;

  @Autowired
  private GenreRepository genreRepository;

  private Genre horrorBooks;
  private Genre rockMusic;

  @Before
  public void createGenres() {
    horrorBooks = new Genre("Horror", MediaType.BOOK);
    rockMusic = new Genre("Rock", MediaType.MUSIC);
  }

  @After
  public void deleteAll() {
    genreRepository.deleteAll();
  }

  @Test
  public void testSave() throws Exception {
    Genre savedRockMusic = service.save(rockMusic);

    assertThat(savedRockMusic, is(not(nullValue())));
    Iterable<Genre> all = service.findAll();
    assertThat(all, IsIterableContainingInAnyOrder.containsInAnyOrder(rockMusic));
  }

  @Test
  public void testFindAll() throws Exception {
    saveAllGenres();

    Iterable<Genre> all = service.findAll();
    assertThat(all, IsIterableWithSize.iterableWithSize(2));
    assertThat(all, IsIterableContainingInAnyOrder.containsInAnyOrder(horrorBooks, rockMusic));
  }

  @Test
  public void testFindByMediaType() throws Exception {
    saveAllGenres();

    List<Genre> musicGenres = service.findByMediaType(MediaType.MUSIC);
    List<Genre> bookGenres = service.findByMediaType(MediaType.BOOK);
    List<Genre> gameGenres = service.findByMediaType(MediaType.GAME);

    assertThat(musicGenres, IsIterableWithSize.iterableWithSize(1));
    assertThat(musicGenres, IsIterableContainingInAnyOrder.containsInAnyOrder(rockMusic));

    assertThat(bookGenres, IsIterableWithSize.iterableWithSize(1));
    assertThat(bookGenres, IsIterableContainingInAnyOrder.containsInAnyOrder(horrorBooks));

    assertThat(gameGenres, IsIterableWithSize.iterableWithSize(0));
  }

  private void saveAllGenres() {
    service.save(rockMusic);
    service.save(horrorBooks);
  }

}