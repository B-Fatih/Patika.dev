import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

import styles from "./Register.module.css";

const RegisterPage = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [passwordRepeat, setPasswordRepeat] = useState("");

  const [passwordVisible, setPasswordVisible] = useState(false);
  const [passwordRepeatVisible, setPasswordRepeatVisible] = useState(false);

  const [error, setError] = useState("");

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

  const togglePasswordRepeatVisibility = () => {
    setPasswordRepeatVisible(!passwordRepeatVisible);
  };

  function onClickSubmit() {
    fetch(process.env.REACT_APP_API_URL + "/auth/register", {
      method: "post",
      body: JSON.stringify({
        username: username,
        password: password,
        passwordRepeat: passwordRepeat,
      }),
      headers: {
        "content-type": "application/json",
      },
    })
      .then(async (response) => {
        const data = await response.json();
        if (!response.ok) {
          setError("Server error");
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
        <h2>Sign Up</h2>
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

        <div className={`${styles.formGroup} ${styles.passwordInput}`}>
          <label htmlFor="password">Password Repeat</label>
          <div className={styles.passwordInputContainer}>
            <input
              type={passwordVisible ? "text" : "password"}
              id="password"
              name="password"
              placeholder="Enter your password"
              value={passwordRepeat}
              onChange={(e) => setPasswordRepeat(e.target.value)}
              required
            />
            <i
              className={`eye-icon ${
                passwordRepeatVisible ? "fa fa-eye-slash" : "fa fa-eye"
              }`}
              onClick={togglePasswordRepeatVisibility}
            />
          </div>
        </div>

        <button
          className={styles.registerButton}
          type="submit"
          onClick={onClickSubmit}
        >
          Sign Up
        </button>
        <div className={styles.divider}></div>
        <p>
          Have na account?{" "}
          <a
            href="#"
            className={styles.signInLink}
            onClick={(event) => {
              event.preventDefault();
              navigate("/auth/login");
            }}
          >
            Sign In
          </a>
        </p>
      </div>
    </div>
  );
};

export default RegisterPage;
