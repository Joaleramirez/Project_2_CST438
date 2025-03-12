package com.example.Project_2.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tier_items")
public class TierItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tierName;

    @Column(nullable = false)
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "tier_list_id", nullable = false)
    private TierList tierList;

    public TierItem() {}

    public TierItem(String tierName, String itemName, TierList tierList) {
        this.tierName = tierName;
        this.itemName = itemName;
        this.tierList = tierList;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTierName() {
        return tierName;
    }

    public void setTierName(String tierName) {
        this.tierName = tierName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
