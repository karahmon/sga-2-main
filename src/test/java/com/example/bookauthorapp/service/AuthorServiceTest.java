package com.example.bookauthorapp.service;

import com.example.bookauthorapp.model.Author;
import com.example.bookauthorapp.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllAuthors() {
        // Given
        Author author1 = new Author();
        author1.setName("Author 1");
        Author author2 = new Author();
        author2.setName("Author 2");
        List<Author> authors = Arrays.asList(author1, author2);

        when(authorRepository.findAllWithBooks()).thenReturn(authors);

        // When
        List<Author> result = authorService.getAllAuthors();

        // Then
        assertEquals(2, result.size());
        verify(authorRepository, times(1)).findAllWithBooks();
    }

    @Test
    public void testGetAuthorById() {
        // Given
        Author author = new Author();
        author.setId(1L);
        author.setName("Test Author");

        when(authorRepository.findById(1L)).thenReturn(Optional.of(author));

        // When
        Author result = authorService.getAuthorById(1L);

        // Then
        assertEquals("Test Author", result.getName());
        verify(authorRepository, times(1)).findById(1L);
    }

    @Test
    public void testSaveAuthor() {
        // Given
        Author author = new Author();
        author.setName("New Author");

        when(authorRepository.save(any(Author.class))).thenReturn(author);

        // When
        Author result = authorService.saveAuthor(author);

        // Then
        assertEquals("New Author", result.getName());
        verify(authorRepository, times(1)).save(author);
    }
}