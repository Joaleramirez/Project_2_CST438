import React, { useState } from "react";
import { DndProvider } from "react-dnd";
import { HTML5Backend } from "react-dnd-html5-backend";
import TierList from "../components/TierList"; // Import TierList component
import "../styles/TierListPage.css"; // Import the CSS file

const TierListPage = () => {
    // Placeholder items
    const initialItems = [
        { id: 1, name: "Item 1" },
        { id: 2, name: "Item 2" },
        { id: 3, name: "Item 3" },
        { id: 4, name: "Item 4" },
    ];

    const [items, setItems] = useState(initialItems);

    return (
        <DndProvider backend={HTML5Backend}>
            <div className="tierlist-container">
                <h1 className="tierlist-title">Tier List</h1>
                <TierList items={items} setItems={setItems} />
            </div>
        </DndProvider>
    );
};

export default TierListPage;
