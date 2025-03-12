package com.example.Project_2.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tier_lists")
public class TierList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "tierList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TierItem> tierItems;

    public TierList() {}

    public TierList(String title, User user) {
        this.title = title;
        this.user = user;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
