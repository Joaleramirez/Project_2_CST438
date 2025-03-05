import React from "react";
import "../styles/LoginPage.css"; // Import the CSS file

const LoginPage = () => {
    return (
        <div className="login-page">
            <h1>Login Page</h1>
            <form method="" action="/" className="login-form"> {/*make method POST. action will go to home*/}
                <label className="input-label">
                    <h3>Username</h3>
                    <input type="text" name="username" className="input-text"/> <br/>
                </label>
                <label className="input-label">
                    <h3>Password</h3>
                    <input type="password" name="password" className="input-text"/> <br/>
                </label>

                <input type="submit" value="Submit" className="input-submit"/>
            </form>
        </div>
    );
};

export default LoginPage;
