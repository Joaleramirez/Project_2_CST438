import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "../styles/NavBar.css"; // Import CSS file

const NavBar = () => {
    const [user, setUser] = useState(null);
    const [showLogoutConfirm, setShowLogoutConfirm] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        fetch("http://localhost:8080/user/auth", { credentials: "include" })
            .then((response) => {
                if (!response.ok) throw new Error("User not authenticated");
                return response.json();
            })
            .then((data) => {
                data.role = data.email === "albergarcia@csumb.edu" ? "ADMIN" : "USER"; // Temporary role check
                setUser(data);
            })
            .catch(() => setUser(null)); // Hide NavBar if not logged in
    }, []);

    const handleLogout = async () => {
        try {
            const response = await fetch("http://localhost:8080/logout", {
                credentials: "include",
                redirect: "manual" // Don't auto-follow redirects
            });

            // Clear local state and stored data
            setUser(null);
            localStorage.clear();
            sessionStorage.clear();

            // Get the redirect URL from the response headers
            const redirectUrl = response.headers.get("Location");
            if (redirectUrl) {
                window.location.href = redirectUrl;
            } else {
                navigate("/");
            }
        } catch (error) {
            console.error("Logout failed:", error);
        }
    };


    if (!user) return null; // Don't show the NavBar if not logged in

    return (
        <nav className="navbar">
            <ul className="nav-links">
                <li><Link to="/dashboard">Dashboard</Link></li>
                <li><Link to="/explore">Explore</Link></li>
                <li><Link to="/TierList">Tier List</Link></li>
                {user.role === "ADMIN" && <li><Link to="/admin">Admin</Link></li>}
                <li><Link to="/account">Account</Link></li>
                <li>
                    <button className="logout-button" onClick={() => setShowLogoutConfirm(true)}>
                        Sign Out
                    </button>
                </li>
            </ul>

            {showLogoutConfirm && (
                <div className="logout-popup">
                    <p>Are you sure you want to log out?</p>
                    <button className="logout-button-yes" onClick={handleLogout}>Yes</button>
                    <button className="logout-button-no" onClick={() => setShowLogoutConfirm(false)}>No</button>
                </div>
            )}
        </nav>
    );
};

export default NavBar;
