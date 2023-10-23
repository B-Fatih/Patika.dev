import { useNavigate } from "react-router-dom";
import { faFloppyDisk } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

import Page from "../../../layout/page";
import MainLayout from "../../../layout/main";

import styles from "../car-form/CarForm.module.css";
import { useForm } from "react-hook-form";

const CarForm = () => {
  const navigate = useNavigate();

  const {
    register,
    setValue,
    watch,
    formState: { errors },
    handleSubmit,
  } = useForm({
    mode: "onBlur",
    criteriaMode: "firstError",
    shouldFocusError: true,
  });

  const password = watch("password", "");

  function onSubmitForm(data) {
    fetch(process.env.REACT_APP_API_URL + "/member/change-password", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: localStorage.getItem("token"),
      },
      body: JSON.stringify(data),
    }).then(async (response) => {
      response.json().then((data) => {
        if (!response.ok) {
          alert(data.message);
        } else {
          navigate("/member/cars");
        }
      });
    });
  }

  return (
    <MainLayout>
      <Page>
        <Page.Header>Change Password</Page.Header>
        <Page.Content>
          <div className={styles.content}>
            <div className={styles.formGroup}>
              <label>Old Password</label>
              <input
                type="text"
                placeholder="Placeholder"
                className={errors.oldPassword ? styles.inputError : ""}
                {...register("oldPassword", { required: true })}
              />
              {errors.oldPassword && (
                <span className={styles.inputErrorMessage}>
                  This field is required
                </span>
              )}
            </div>

            <div className={styles.formGroup}>
              <label>New Password</label>
              <input
                type="text"
                placeholder="Placeholder"
                className={errors.password ? styles.inputError : ""}
                {...register("password", { required: true })}
              />
              {errors.password && (
                <span className={styles.inputErrorMessage}>
                  This field is required
                </span>
              )}
            </div>

            <div className={styles.formGroup}>
              <label>New Password Repeat</label>
              <input
                type="text"
                placeholder="Placeholder"
                className={errors.passwordRepeat ? styles.inputError : ""}
                {...register("passwordRepeat", {
                  required: true,
                  validate: (value) => value === password,
                })}
              />
              {errors.passwordRepeat && (
                <span className={styles.inputErrorMessage}>
                  Password should match
                </span>
              )}
            </div>

            <div className={styles.buttons}>
              <button
                className={styles.cancelButton}
                onClick={() => navigate("/member/cars")}
              >
                Cancel
              </button>
              <button
                className={styles.submitButton}
                onClick={handleSubmit(onSubmitForm)}
              >
                Save
                <FontAwesomeIcon icon={faFloppyDisk}></FontAwesomeIcon>
              </button>
            </div>
          </div>
        </Page.Content>
      </Page>
    </MainLayout>
  );
};

export default CarForm;
