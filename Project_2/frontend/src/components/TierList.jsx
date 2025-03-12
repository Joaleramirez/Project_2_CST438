import React, { useState } from "react";
import { useDrop } from "react-dnd";
import TierRow from "./TierRow";

const initialTiers = {
    S: [],
    A: [],
    B: [],
    C: [],
    D: [],
    E: [],
    F: [],
};

const TierList = () => {
    const [tiers, setTiers] = useState(initialTiers);

    const moveItem = (itemId, targetTier) => {
        setTiers((prevTiers) => {
            // Remove item from previous tier
            const updatedTiers = { ...prevTiers };
            for (const tier in updatedTiers) {
                updatedTiers[tier] = updatedTiers[tier].filter((item) => item.id !== itemId);
            }

            // Add item to new tier
            updatedTiers[targetTier].push({ id: itemId, name: `Item ${itemId}` });

            return updatedTiers;
        });
    };

    return (
        <div className="tier-list">
            {Object.keys(tiers).map((tier) => (
                <DroppableTier key={tier} tier={tier} items={tiers[tier]} moveItem={moveItem} />
            ))}
        </div>
    );
};

const DroppableTier = ({ tier, items, moveItem }) => {
    const [, drop] = useDrop({
        accept: "ITEM",
        drop: (item) => moveItem(item.id, tier),
    });

    return (
        <div ref={drop}>
            <TierRow tier={tier} items={items} moveItem={moveItem} />
        </div>
    );
};

export default TierList;
