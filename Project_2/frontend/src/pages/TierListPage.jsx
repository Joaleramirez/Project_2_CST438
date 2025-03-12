import React, { useState } from "react";
import { DndProvider } from "react-dnd";
import { HTML5Backend } from "react-dnd-html5-backend";
import TierList from "../components/TierList"; // Import TierList component
import "../styles/TierListPage.css"; // Import the CSS file

const TierListPage = () => {
    // Define tier levels
    const tiers = ["S", "A", "B", "C", "D", "E", "F"];

    // Placeholder items (Now assigned to tiers)
    const initialItems = [
        { id: 1, name: "Item 1", tier: "S" },
        { id: 2, name: "Item 2", tier: "B" },
        { id: 3, name: "Item 3", tier: "D" },
        { id: 4, name: "Item 4", tier: "F" },
    ];

    const [items, setItems] = useState(initialItems);

    return (
        <DndProvider backend={HTML5Backend}>
            <div className="tierlist-container">
                <h1 className="tierlist-title">Tier List</h1>
                <TierList tiers={tiers} items={items} setItems={setItems} />
            </div>
        </DndProvider>
    );
};

export default TierListPage;
