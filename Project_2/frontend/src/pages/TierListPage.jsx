import React from "react";
import "../styles/TierListPage.css"; // Import the CSS file

const TierListPage = () => {
    return (
        <div className="tierlist-container">
            <h1 className="tierlist-title">Tier List</h1>
            <div className="active-tier-section">
                <h2>Active Tier</h2>
                <p>This section will display the current active tier. Users will be able to add to or adjust the items in this tier.</p>
            </div>
            <div className="past-tiers-section">
                <h2>Past Tiers</h2>
                <p>This section will display the past tiers. Each past tier will be listed with its items.</p>
            </div>
        </div>
    );
};

export default TierListPage;
