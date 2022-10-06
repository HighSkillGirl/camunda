package model;

import org.springframework.stereotype.Component;

@Component
public class Info {

    private String message;
    private String password = "1234";

    public String getMessage() {
        return message;
    }

    public void setMessage(String new_message) {
        this.message = new_message;
    }

    public boolean isMessageEmpty() {
        return this.message.isEmpty();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String new_password) {
        this.password = new_password;
    }

    public boolean equals(String pass) {
        return password.equals(pass);
    }
}
