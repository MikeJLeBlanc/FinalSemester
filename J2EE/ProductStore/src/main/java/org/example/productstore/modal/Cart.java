package org.example.productstore.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cart {
    @Id
    private Long id;
    private int userId;
    private int itemId;
    private int itemQuantity;
    private int submitted;
    private int shipped;
    private int received;

    public Cart() {}

    public Cart(Long id, int userId, int itemId, int itemQuantity, int submitted, int shipped, int received) {
        this.id = id;
        this.userId = userId;
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
        this.submitted = submitted;
        this.shipped = shipped;
        this.received = received;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public int getUserId() {return userId;}

    public void setUserId(int userId) {this.userId = userId;}

    public int getItemId() {return itemId;}

    public void setItemId(int itemId) {this.itemId = itemId;}

    public int getItemQuantity() {return itemQuantity;}

    public void setItemQuantity(int itemQuantity) {this.itemQuantity = itemQuantity;}

    public int getSubmitted() {return submitted;}

    public void setSubmitted(int submitted) {this.submitted = submitted;}

    public int getShipped() {return shipped;}

    public void setShipped(int shipped) {this.shipped = shipped;}

    public int getReceived() {return received;}

    public void setReceived(int received) {this.received = received;}
}
