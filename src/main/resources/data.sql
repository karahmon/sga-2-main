-- Insert sample authors
INSERT INTO authors (name, email) VALUES
('J.K. Rowling', 'jk@example.com'),
('George Orwell', 'george@example.com'),
('Jane Austen', 'jane@example.com'),
('Mark Twain', 'mark@example.com'),
('Leo Tolstoy', 'leo@example.com'),
('Virginia Woolf', 'virginia@example.com'),
('Charles Dickens', 'charles@example.com'),
('William Shakespeare', 'william@example.com'),
('Agatha Christie', 'agatha@example.com'),
('F. Scott Fitzgerald', 'scott@example.com');

-- Insert sample books
INSERT INTO books (title, isbn, author_id) VALUES
('Harry Potter and the Philosopher''s Stone', '9780747532699', 1),
('1984', '9780451524935', 2),
('Pride and Prejudice', '9780141439518', 3),
('The Adventures of Huckleberry Finn', '9780142437179', 4),
('War and Peace', '9781400079988', 5),
('Mrs. Dalloway', '9780156628709', 6),
('Great Expectations', '9780141439563', 7),
('Hamlet', '9780743477123', 8),
('Murder on the Orient Express', '9780062693662', 9),
('The Great Gatsby', '9780743273565', 10);