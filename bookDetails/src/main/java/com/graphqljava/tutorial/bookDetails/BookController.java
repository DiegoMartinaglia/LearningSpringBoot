package com.graphqljava.tutorial.bookDetails;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class BookController {
    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @QueryMapping
    public List<Book> allBooks() {
        return Book.books;
    }

    @QueryMapping
    public List<Author> allAuthors() {
        return Author.authors;
    }


    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.getAuthorId());
    }
}

