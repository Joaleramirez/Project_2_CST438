import React, { useState, useEffect } from "react"; // Ensure useEffect is imported

const AdminPage = () => {
    const [users, setUsers] = useState([]); // Fix: Define users state
    const [error, setError] = useState(null); // Fix: Define error state

    useEffect(() => {
        fetch("http://localhost:8080/users", { credentials: "include" })
            .then(response => {
                if (!response.ok) {
                    throw new Error("Failed to fetch users");
                }
                return response.json();
            })
            .then(data => setUsers(data)) // Fix: Use setUsers to update state
            .catch(error => setError(error.message)); // Fix: Use setError to store errors
    }, []);

    return (
        <div>
            <h1>Admin Page</h1>
            {error && <p style={{ color: "red" }}>{error}</p>}
            <ul>
                {users.map(user => (
                    <li key={user.id}>{user.username} - {user.email}</li>
                ))}
            </ul>
        </div>
    );
};

export default AdminPage;
