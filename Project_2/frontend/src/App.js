import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import WelcomePage from "./pages/WelcomePage";
import TierListPage from "./pages/TierListPage";
import LoginPage from "./pages/LoginPage"

function App() {
  return (
      <Router>
        <Routes>
          <Route path="/" element={<WelcomePage />} />
            <Route path="/TierList" element={<TierListPage />} />
            <Route path="/Login" element={<LoginPage />} />
        </Routes>
      </Router>
  );
}

import Dashboard from "./pages/Dashboard";
export default App;
function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<WelcomePage/>}/>
                <Route path="/TierList" element={<TierListPage/>}/>
                <Route path="/dashboard" element={<Dashboard/>}/>
            </Routes>
        </Router>
    );
}