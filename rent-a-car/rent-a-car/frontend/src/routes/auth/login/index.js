import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

import styles from "./Login.module.css";

const RegisterPage = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const [error, setError] = useState(null);
  const [passwordVisible, setPasswordVisible] = useState(false);

  const navigate = useNavigate();

  const token = localStorage.getItem("token");

  useEffect(() => {
    if (token) {
      navigate("/member/cars");
    }
  }, [token]);

  const togglePasswordVisibility = () => {
    setPasswordVisible(!passwordVisible);
  };

  function onClickSubmit() {
    setError("");
    fetch(process.env.REACT_APP_API_URL + "/auth/login", {
      method: "post",
      body: JSON.stringify({
        username: username,
        password: password,
      }),
      headers: {
        "content-type": "application/json",
      },
    })
      .then(async (response) => {
        const data = await response.json();
        if (!response.ok) {
          setError(data.message);
          return;
        }

        localStorage.setItem("token", data.token);
        navigate("/member/cars");
      })

      .catch((error) => {
        setError("Server error");
      });
  }

  return (
    <div className={styles.login}>
      <div className={styles.container}>
        <h1>XYZ Cars</h1>
        <h2>Please login to continue</h2>
        {error && <p className={styles.error}>{error}</p>}
        <div className={styles.formGroup}>
          <label htmlFor="username">Username</label>
          <input
            type="text"
            id="username"
            name="username"
            placeholder="Enter your username"
            required
            value={username}
            onChange={(event) => setUsername(event.target.value)}
          />
        </div>
        <div className={`${styles.formGroup} ${styles.passwordInput}`}>
          <label htmlFor="password">Password</label>
          <div className={styles.passwordInputContainer}>
            <input
              type={passwordVisible ? "text" : "password"}
              id="password"
              name="password"
              placeholder="Enter your password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
            <i
              className={`eye-icon ${
                passwordVisible ? "fa fa-eye-slash" : "fa fa-eye"
              }`}
              onClick={togglePasswordVisibility}
            />
          </div>
        </div>

        <button
          className={styles.loginButton}
          type="submit"
          onClick={onClickSubmit}
        >
          Log in
        </button>
        <div className={styles.divider}></div>
        <p>
          No account yet?{" "}
          <a
            href="#"
            className={styles.signInLink}
            onClick={(event) => {
              event.preventDefault();
              navigate("/auth/register");
            }}
          >
            Sign up
          </a>
        </p>
      </div>
    </div>
  );
};

export default RegisterPage;
