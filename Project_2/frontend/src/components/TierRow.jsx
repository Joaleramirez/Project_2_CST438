import React from "react";
import { useDrop } from "react-dnd";
import TierItem from "./TierItem";
import "../styles/TierRow.css"; // Import TierRow styles

const TierRow = ({ tier, items, setItems }) => {
    const [{ isOver }, drop] = useDrop({
        accept: "ITEM",
        drop: (item) => moveItem(item, tier),
        collect: (monitor) => ({
            isOver: !!monitor.isOver(),
        }),
    });

    const moveItem = (item, newTier) => {
        setItems((prevItems) =>
            prevItems.map((i) =>
                i.id === item.id ? { ...i, tier: newTier } : i
            )
        );
    };

    return (
        <div ref={drop} className={`tier-row ${isOver ? "hovered" : ""}`}>
            <div className="tier-label">{tier}</div>
            <div className="tier-content">
                {items
                    .filter((item) => item.tier === tier)
                    .map((item) => (
                        <TierItem key={item.id} item={item} />
                    ))}
            </div>
        </div>
    );
};

export default TierRow;
