package com.example.bookauthorapp.service;

import com.example.bookauthorapp.model.Book;
import com.example.bookauthorapp.repository.BookRepository;
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

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllBooks() {
        // Given
        Book book1 = new Book();
        book1.setTitle("Book 1");
        Book book2 = new Book();
        book2.setTitle("Book 2");
        List<Book> books = Arrays.asList(book1, book2);

        when(bookRepository.findAllWithAuthors()).thenReturn(books);

        // When
        List<Book> result = bookService.getAllBooks();

        // Then
        assertEquals(2, result.size());
        verify(bookRepository, times(1)).findAllWithAuthors();
    }

    @Test
    public void testGetBookById() {
        // Given
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        // When
        Book result = bookService.getBookById(1L);

        // Then
        assertEquals("Test Book", result.getTitle());
        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    public void testSaveBook() {
        // Given
        Book book = new Book();
        book.setTitle("New Book");

        when(bookRepository.save(any(Book.class))).thenReturn(book);

        // When
        Book result = bookService.saveBook(book);

        // Then
        assertEquals("New Book", result.getTitle());
        verify(bookRepository, times(1)).save(book);
    }
}