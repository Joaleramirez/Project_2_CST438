import React from "react";
import "../styles/WelcomePage.css"; // Import the CSS file
import {Link} from 'react-router-dom';

const WelcomePage = () => {
    const handleGoogleLogin = () => {
        window.location.href = "http://localhost:8080/oauth2/authorization/google";
    };

    return (
        <div className="page">
            <div className="login-container">
                {/*make it link to new login page*/}
                <Link to="/Login" className="login-button">
                    <strong>
                        Log In
                    </strong>
                </Link>
            </div>
            <div className="welcome-container">
                <h1 className="welcome-title">Welcome to MatchMyTier</h1>
                <p className="welcome-subtitle">
                    Rank, Compare, and Connect with People Who Think Like You!
                </p>
                <button onClick={handleGoogleLogin} className="welcome-button">
                    Sign in With Google
                </button>
            </div>
        </div>
    );
};

export default WelcomePage;
