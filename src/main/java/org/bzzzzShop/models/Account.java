package org.bzzzzShop.models;

import java.util.Objects;

public class Account {
    private String login;
    private String password;
    public Account(String login, String password){
        this.login=login;
        this.password=password;
    }
    public String getLogin() { return login; }
    public String getPassword() { return password; }
    public void setLogin(String login) { this.login = login; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return login.equals(account.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(String.format("  Логин: %s\n" +
                        "   Пароль: %s\n",
                login, password));
        return str.toString();
    }
}
