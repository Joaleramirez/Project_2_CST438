import React from "react";

const WelcomePage = () => {
    const handleGoogleLogin = () => {
        // Redirect to Spring Boot OAuth endpoint
        window.location.href = "http://localhost:8080/oauth2/authorization/google";
    };

    return (
        <div className="flex flex-col items-center justify-center h-screen bg-gray-100">
            <h1 className="text-4xl font-bold mb-6">Welcome to MatchMyTier</h1>
            <button
                onClick={handleGoogleLogin}
                className="bg-blue-500 text-white px-6 py-3 rounded-lg text-lg hover:bg-blue-600"
            >
                Sign in With Google
            </button>
        </div>
    );
};

export default WelcomePage;
