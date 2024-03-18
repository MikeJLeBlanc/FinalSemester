package org.example.scriptsavings.model;

public class Statement {
    private int id;
    private String name;
    private double amount;
    private int categoryId;
    private int userId;
    private String date;

    public Statement(int id, String name, double amount, int categoryId, int userId, String date) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.categoryId = categoryId;
        this.userId = userId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
