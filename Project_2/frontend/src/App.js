import { DndProvider } from "react-dnd";
import { HTML5Backend } from "react-dnd-html5-backend";

import NavBar from "./components/NavBar"; // ✅ Import directly from src/components
import WelcomePage from "./pages/WelcomePage";
import TierListPage from "./pages/TierListPage";
import LoginPage from "./pages/LoginPage";
import Dashboard from "./pages/Dashboard";
import Onboarding from "./pages/Onboarding";
import Explore from "./pages/Explore";
import AccountPage from "./pages/AccountPage";
import AdminPage from "./pages/AdminPage";

function App() {
    return (
        <DndProvider backend={HTML5Backend}>
            <Router>
                <NavBar />
                <Routes>
                    <Route path="/" element={<WelcomePage />} />
                    <Route path="/TierList" element={<TierListPage />} />
                    <Route path="/Login" element={<LoginPage />} />
                    <Route path="/dashboard" element={<Dashboard />} />
                    <Route path="/onboarding" element={<Onboarding />} />
                    <Route path="/explore" element={<Explore />} />
                    <Route path="/account" element={<AccountPage />} />
                    <Route path="/admin" element={<AdminPage />} />
                </Routes>
            </Router>
        </DndProvider>
    );
}

export default App;
