package com.example.User.dto;

import com.example.User.entity.User;

import java.util.List;

public class UserWithBooksResponse {
    private User user;
    private List<BookDto> books;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }

    public UserWithBooksResponse(User user, List<BookDto> books) {
        this.user = user;
        this.books = books;
    }
    @Override
    public String toString() {
        return "UserWithBooksResponse{" +
                "user=" + user +
                ", books=" + books +
                '}';
    }
}
