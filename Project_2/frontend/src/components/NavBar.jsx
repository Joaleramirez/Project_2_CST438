import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import "../styles/NavBar.css"; // ✅ Correct relative path to styles

import WelcomePage from "../pages/WelcomePage";
import TierListPage from "../pages/TierListPage";
import LoginPage from "../pages/LoginPage";
import Dashboard from "../pages/Dashboard";
import Onboarding from "../pages/Onboarding";
import Explore from "../pages/Explore";
import AccountPage from "../pages/AccountPage";
import AdminPage from "../pages/AdminPage";

const NavBar = () => {
    const [user, setUser] = useState(null);

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
            .catch(() => setUser(null)); // Hide NavBar if not authenticated
    }, []);

    if (!user) return null; // Don't show the NavBar if not logged in

    return (
        <nav className="navbar">
            <ul className="nav-links">
                <li><Link to="/dashboard">Dashboard</Link></li>
                <li><Link to="/explore">Explore</Link></li>
                <li><Link to="/TierList">Tier List</Link></li>
                {user.role === "ADMIN" && <li><Link to="/admin">Admin</Link></li>}
                <li><Link to="/account">Account</Link></li>
            </ul>
        </nav>
    );
};

export default NavBar;
