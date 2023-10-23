import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faHome,
  faFolder,
  faEnvelope,
  faArrowRightFromBracket,
} from "@fortawesome/free-solid-svg-icons";

import styles from "./Main.module.css";

const MainLayout = ({ children }) => {
  const navigate = useNavigate();
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const token = localStorage.getItem("token");

  function onLogout() {
    localStorage.removeItem("token");
    navigate("/auth/login");
  }

  useEffect(() => {
    if (!token) {
      navigate("/auth/login");
    } else {
      setIsLoggedIn(true);
    }
  }, [token]);

  if (!isLoggedIn) {
    return null;
  }

  return (
    <div className={styles.container}>
      <aside className={styles.sidebar}>
        <h1 className={styles.logo}>
          <FontAwesomeIcon icon={faEnvelope} /> XYZ-Cars
        </h1>
        <nav>
          <ul className={styles.menu}>
            <li
              className={styles.menuItem}
              onClick={() => navigate("/member/cars")}
            >
              <FontAwesomeIcon icon={faHome} /> Home
            </li>
            <li
              className={styles.menuItem}
              onClick={() => navigate("/member/change-password")}
            >
              <FontAwesomeIcon icon={faFolder} /> Change Password
            </li>
            <li className={styles.menuItem} onClick={onLogout}>
              <FontAwesomeIcon icon={faArrowRightFromBracket} /> Logout
            </li>
          </ul>
        </nav>
      </aside>

      <main className={styles.content}>{children}</main>
    </div>
  );
};

export default MainLayout;
