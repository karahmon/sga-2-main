package com.example.bookauthorapp.repository;

import com.example.bookauthorapp.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("test")
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testFindAllWithBooks() {
        // Given
        Author author = new Author();
        author.setName("Test Author");
        author.setEmail("test@example.com");
        authorRepository.save(author);

        // When
        List<Author> authors = authorRepository.findAllWithBooks();

        // Then
        assertNotNull(authors);
        assertEquals(1, authors.size());
        assertEquals("Test Author", authors.get(0).getName());
    }
}