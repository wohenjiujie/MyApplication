package com.organization.myapplication.Bean;

import androidx.annotation.NonNull;

/**
 * Created by INvo
 * on 2020-01-26.
 */
public class RegistrationBean<T> {

    private T account;
    private T password;

    @NonNull
    @Override
    public String toString() {
        return (String) account + password;
    }

    public T getPassword() {
        return password;
    }

    public void setPassword(T password) {
        this.password = password;
    }

    public T getAccount() {
        return account;
    }

    public void setAccount(T account) {
        this.account = account;
    }
}
