import React from "react";
import "../styles/AccountPage.css"; // Import the CSS file
import deleteImg from '../images/trashcan.png'

const AccountPage = () => {
    return(
        <div className="account-page">
            <h1>Account Page</h1>

            <div className="main-area">
                {/*button will delete account when clicked. should ask for confirmation*/}
                <label className="delete-label">
                    <input type="image" alt="Delete" src={deleteImg} className="delete-button"/>
                </label>

                <form method="" action="" className="account-form"> {/*make method POST. action stays on same page*/}
                    {/* prepopulate with db values */}
                    <label className="input-label">
                        <h3>Username</h3>
                        <input type="text" name="username" defaultValue="temp" className="input-text"/>
                    </label>
                    <label className="input-label">
                        <h3>Password</h3>
                        <input type="text" name="password" defaultValue="temp" className="input-text"/> <br/>
                    </label>

                    <input type="submit" value="Submit Changes" className="input-submit"/>
                </form>
            </div>

        </div>
    );
};

export default AccountPage;