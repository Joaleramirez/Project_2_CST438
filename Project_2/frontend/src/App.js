import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import WelcomePage from "./pages/WelcomePage";
import TierListPage from "./pages/TierListPage";
import CreateAccountPage from "./pages/CreateAccountPage";

function App() {
  return (
      <Router>
        <Routes>
          <Route path="/" element={<WelcomePage />} />
            <Route path="/TierList" element={<TierListPage />} />
            <Route path="/CreateAccountPage" element={<CreateAccountPage />} />
        </Routes>
      </Router>
  );
}

export default App;
