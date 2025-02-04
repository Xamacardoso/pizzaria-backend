package dev.xamanicolas.pizzaria_backend.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PizzaOrder> orders;

    private BigDecimal total;

    protected CustomerOrder() {}

    public CustomerOrder(Customer customer, List<PizzaOrder> orders) {
        this.customer = customer;
        this.orders = orders;
        calculateTotal();
    }

    public CustomerOrder(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<PizzaOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<PizzaOrder> orders) {
        this.orders = orders;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void calculateTotal(){
        setTotal(this.orders.stream()
                .map(x -> x.subTotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOrder customerOrder = (CustomerOrder) o;
        return Objects.equals(id, customerOrder.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
