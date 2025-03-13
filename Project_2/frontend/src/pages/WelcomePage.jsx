import React from "react";
import "../styles/WelcomePage.css"; // Import the CSS file
import { useNavigate } from 'react-router-dom';

const WelcomePage = () => {
    const handleGoogleLogin = () => {
        window.location.href = "http://localhost:8080/oauth2/authorization/google";
    };

    const navigate = useNavigate();

    const handleClick = () => {
        navigate('/CreateAccountPage');
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
            <button onClick={handleClick} className="welcome-button">
                Create Account
            </button>
        </div>
    );
};

export default WelcomePage;
