package com.example.bookauthorapp.repository;

import com.example.bookauthorapp.model.Author;
import com.example.bookauthorapp.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testFindAllWithAuthors() {
        // Given
        Author author = new Author();
        author.setName("Test Author");
        author.setEmail("test@example.com");
        authorRepository.save(author);

        Book book = new Book();
        book.setTitle("Test Book");
        book.setIsbn("1234567890");
        book.setAuthor(author);
        bookRepository.save(book);

        // When
        List<Book> books = bookRepository.findAllWithAuthors();

        // Then
        assertNotNull(books);
        assertEquals(1, books.size());
        assertEquals("Test Book", books.get(0).getTitle());
        assertEquals("Test Author", books.get(0).getAuthor().getName());
    }
}