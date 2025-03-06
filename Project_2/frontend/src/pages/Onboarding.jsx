import React, { useState } from "react";
import "../styles/Onboarding.css";

const categories = ["Gaming", "Movies", "Music", "Sports", "Anime"];

const Onboarding = () => {
    const [selectedCategories, setSelectedCategories] = useState([]);

    const handleCategoryClick = (category) => {
        setSelectedCategories((prev) =>
            prev.includes(category) ? prev.filter((c) => c !== category) : [...prev, category]
        );
    };

    const handleSubmit = () => {
        console.log("Selected Categories:", selectedCategories);
        window.location.href = "/explore"; // Mock navigation to Explore Page
    };

    return (
        <div className="onboarding-container">
            <h1>Select Your Interests</h1>
            <div className="categories">
                {categories.map((category) => (
                    <button
                        key={category}
                        className={`category-btn ${selectedCategories.includes(category) ? "selected" : ""}`}
                        onClick={() => handleCategoryClick(category)}
                    >
                        {category}
                    </button>
                ))}
            </div>
            <button className="submit-btn" onClick={handleSubmit}>
                Continue
            </button>
        </div>
    );
};

export default Onboarding;
