import React from "react";
import "../styles/Explore.css";

const mockTierLists = {
    Gaming: ["Top 5 RPGs", "Best FPS Games", "Favorite Indie Games"],
    Movies: ["Best Sci-Fi Films", "Top 10 Horror Movies", "Best Animated Movies"],
    Music: ["Greatest Rock Albums", "Top Hip-Hop Tracks", "Best Classical Composers"],
};

const Explore = () => {
    return (
        <div className="explore-container">
            <h1>Explore Tier Lists</h1>
            {Object.entries(mockTierLists).map(([category, lists]) => (
                <div key={category} className="category-section">
                    <h2>{category}</h2>
                    <ul>
                        {lists.map((list) => (
                            <li key={list}>
                                <a href={`/tierlist/${list.replace(/\s+/g, "-").toLowerCase()}`}>
                                    {list}
                                </a>
                            </li>
                        ))}
                    </ul>
                </div>
            ))}
        </div>
    );
};

export default Explore;
