package com.example.Project_2.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.List;

@Entity
@Table(name = "tiers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tier_list_id", nullable = false)
    private TierList tierList;

    @Column(nullable = false)
    private String tierName;

    @Column(nullable = false)
    private Integer tierRank;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TierList getTierList() {
        return tierList;
    }

    public void setTierList(TierList tierList) {
        this.tierList = tierList;
    }

    public String getTierName() {
        return tierName;
    }

    public void setTierName(String tierName) {
        this.tierName = tierName;
    }

    public Integer getTierRank() {
        return tierRank;
    }

    public void setTierRank(Integer tierRank) {
        this.tierRank = tierRank;
    }
}