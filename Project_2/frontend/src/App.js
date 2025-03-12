import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { DndProvider } from "react-dnd";
import { HTML5Backend } from "react-dnd-html5-backend";

import WelcomePage from "./pages/WelcomePage";
import TierListPage from "./pages/TierListPage";
import LoginPage from "./pages/LoginPage";
import Dashboard from "./pages/Dashboard";
import Onboarding from "./pages/Onboarding";
import Explore from "./pages/Explore";

function App() {
    return (
        <DndProvider backend={HTML5Backend}>
            <Router>
                <Routes>
                    <Route path="/" element={<WelcomePage />} />
                    <Route path="/TierList" element={<TierListPage />} />
                    <Route path="/Login" element={<LoginPage />} />
                    <Route path="/dashboard" element={<Dashboard />} />
                    <Route path="/onboarding" element={<Onboarding />} />
                    <Route path="/explore" element={<Explore />} />
                </Routes>
            </Router>
        </DndProvider>
    );
}

export default App;
