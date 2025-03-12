import React from "react";
import TierRow from "./TierRow";
import "../styles/TierList.css"; // Ensure this file exists

const TierList = ({ tiers, items, setItems }) => {
    return (
        <div className="tier-list">
            {tiers.map((tier) => (
                <TierRow
                    key={tier}
                    tier={tier}
                    items={items.filter((item) => item.tier === tier)}
                    setItems={setItems}
                />
            ))}
        </div>
    );
};

export default TierList;
