import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom"; // Import navigation hook
import "../styles/Dashboard.css"; // Import CSS file

const Dashboard = () => {
    const [user, setUser] = useState(null);
    const [error, setError] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        fetch("http://localhost:8080/user", { credentials: "include" })
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Failed to fetch user details");
                }
                return response.json();
            })
            .then((data) => {
                // Simulate role-based access (Temporary until DB is ready)
                data.role = data.email === "albergarcia@csumb.edu" ? "ADMIN" : "USER";

                if (data.isNewUser) {
                    navigate("/onboarding"); // Redirect new users to onboarding
                } else {
                    setUser(data);
                }
            })
            .catch((error) => {
                console.error("Error fetching user:", error);
                setError(error.message);
            });
    }, [navigate]);

    const handleLogout = () => {
        fetch("http://localhost:8080/logout", { credentials: "include" })
            .then(() => {
                setUser(null);
                navigate("/"); // Redirect to Sign-In Page after Logout
            })
            .catch((error) => console.error("Logout failed:", error));
    };

    return (
        <div className="dashboard-container">
            <h1 className="dashboard-title">Welcome to MatchMyTier</h1>

            {error ? (
                <p className="error-message">Error: {error}</p>
            ) : user ? (
                <div className="dashboard-user-info">
                    <h2>Hello, {user.name}!</h2>
                    <img src={user.picture} alt="Profile" className="user-profile-pic" />
                    <p>Email: {user.email}</p>

                    {/* Admin Panel Button (only visible for Admins) */}
                    {user.role === "ADMIN" && (
                        <button onClick={() => navigate("/admin")} className="admin-button">
                            Admin Panel
                        </button>
                    )}

                    <button onClick={handleLogout} className="dashboard-button">
                        Logout
                    </button>
                </div>
            ) : (
                <p className="loading-message">Loading user details...</p>
            )}
        </div>
    );
};

export default Dashboard;
