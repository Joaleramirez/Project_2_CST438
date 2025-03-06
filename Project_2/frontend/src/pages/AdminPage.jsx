useEffect(() => {
    fetch("http://localhost:8080/admin/users", { credentials: "include" })
        .then((response) => {
            if (!response.ok) {
                throw new Error("Failed to fetch users");
            }
            return response.json();
        })
        .then((data) => setUsers(data))
        .catch((error) => {
            console.error("Error fetching users:", error);
            setError(error.message);
        });
}, []);
