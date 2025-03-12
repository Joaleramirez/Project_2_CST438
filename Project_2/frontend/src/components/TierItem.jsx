import React from "react";
import TierRow from "./TierRow";
import "../styles/TierList.css"; // Import TierList styles

const tiers = ["S", "A", "B", "C", "D", "E", "F"]; // Tier levels

const TierList = ({ items, setItems }) => {
    return (
        <div className="tier-list">
            {tiers.map((tier) => (
                <TierRow key={tier} tier={tier} items={items} setItems={setItems} />
            ))}
        </div>
    );
};

export default TierList;
