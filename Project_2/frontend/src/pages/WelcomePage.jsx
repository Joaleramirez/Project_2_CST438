import React from "react";
import "../styles/WelcomePage.css"; // Import the CSS file

const WelcomePage = () => {
    const handleGoogleLogin = () => {
        window.location.href = "http://localhost:8080/oauth2/authorization/google";
    };

    return (
        <div className="welcome-container">
            <h1 className="welcome-title">Welcome to MatchMyTier</h1>
            <p className="welcome-subtitle">
                Rank, Compare, and Connect with People Who Think Like You!
            </p>
            <button onClick={handleGoogleLogin} className="welcome-button">
                Sign in With Google
            </button>
        </div>
    );
};

export default WelcomePage;
