import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import WelcomePage from "./pages/WelcomePage";
import TierListPage from "./pages/TierListPage";
import Dashboard from "./pages/Dashboard";
import Onboarding from "./pages/Onboarding";
import Explore from "./pages/Explore";

export default App;
function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<WelcomePage/>}/>
                <Route path="/TierList" element={<TierListPage/>}/>
                <Route path="/dashboard" element={<Dashboard/>}/>
                <Route path="/onboarding" element={<Onboarding />} />
                <Route path="/explore" element={<Explore />} />
            </Routes>
        </Router>
    );
}