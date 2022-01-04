package com.example.firstjavafx.util;

public class Client {
    private User current_user;

    public Client(User current_user) {
        this.current_user = current_user;
    }

    public User getCurrent_user() {
        return current_user;
    }

    public void setCurrent_user(User current_user) {
        this.current_user = current_user;
    }

//    @Override
//    public String toString() {
//
//    }
}
