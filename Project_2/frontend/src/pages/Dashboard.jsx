import React, { useEffect, useState } from "react";
import "../styles/Dashboard.css"; // Import CSS file

const Dashboard = () => {
    const [user, setUser] = useState(null);
    const [error, setError] = useState(null);

    useEffect(() => {
        fetch("http://localhost:8080/user", { credentials: "include" })
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Failed to fetch user details");
                }
                return response.json();
            })
            .then((data) => setUser(data))
            .catch((error) => {
                console.error("Error fetching user:", error);
                setError(error.message);
            });
    }, []);

    // Improved logout function
    const handleLogout = () => {
        setUser(null); // Clear frontend state
        fetch("http://localhost:8080/logout", { credentials: "include" })
            .then(() => {
                window.location.href = "http://localhost:3000/";
            })
            .catch((error) => console.error("Logout failed:", error));
    };

    return (
        <div className="dashboard-container">
            <h1 className="dashboard-title">Welcome to MatchMyTier</h1>
            {error ? (
                <p style={{ color: "red" }}>Error: {error}</p>
            ) : user ? (
                <div className="dashboard-user-info">
                    <h2>Hello, {user.name}!</h2>
                    <img src={user.picture} alt="Profile" />
                    <p>Email: {user.email}</p>
                    <button onClick={handleLogout} className="dashboard-button">
                        Logout
                    </button>
                </div>
            ) : (
                <p>Loading user details...</p>
            )}
        </div>
    );
};

export default Dashboard;
