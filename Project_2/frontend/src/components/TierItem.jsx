import React from "react";
import { useDrag } from "react-dnd";
import "../styles/TierItem.css"; // Ensure CSS exists

const TierItem = ({ item }) => {
    const [{ isDragging }, drag] = useDrag({
        type: "ITEM",
        item: { id: item.id },
        collect: (monitor) => ({
            isDragging: !!monitor.isDragging(),
        }),
    });

    return (
        <div ref={drag} className={`tier-item ${isDragging ? "dragging" : ""}`}>
            {item.name}
        </div>
    );
};

export default TierItem;
