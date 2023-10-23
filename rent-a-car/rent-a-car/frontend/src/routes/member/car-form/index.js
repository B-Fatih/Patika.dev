import { useNavigate, useParams } from "react-router-dom";
import { faFloppyDisk } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

import Page from "../../../layout/page";
import MainLayout from "../../../layout/main";

import styles from "./CarForm.module.css";
import { useForm } from "react-hook-form";
import { useEffect } from "react";

const carBrands = [
  { id: 1, name: "Audi" },
  { id: 2, name: "BMW" },
  { id: 3, name: "Mercedes" },
  { id: 4, name: "Volkswagen" },
  { id: 5, name: "Renault" },
  { id: 6, name: "Fiat" },
  { id: 7, name: "Opel" },
  { id: 8, name: "Peugeot" },
  { id: 9, name: "Citroen" },
  { id: 10, name: "Ford" },
  { id: 11, name: "Toyota" },
  { id: 12, name: "Honda" },
  { id: 13, name: "Hyundai" },
  { id: 14, name: "Kia" },
  { id: 15, name: "Volvo" },
];

const carModels = [
  { id: 1, name: "A1" },
  { id: 2, name: "A2" },
  { id: 3, name: "A3" },
  { id: 4, name: "A4" },
  { id: 5, name: "A5" },
  { id: 6, name: "A6" },
  { id: 7, name: "A7" },
];

const CarForm = () => {
  const { id } = useParams();

  const navigate = useNavigate();

  const {
    register,
    setValue,
    formState: { errors },
    handleSubmit,
  } = useForm({
    mode: "onBlur",
    criteriaMode: "firstError",
    shouldFocusError: true,
  });

  function onSubmitForm(data) {
    if (id !== "new") {
      data.id = id;
    }
    fetch(process.env.REACT_APP_API_URL + "/member/cars", {
      method: id === "new" ? "POST" : "PUT",
      headers: {
        "Content-Type": "application/json",
        Authorization: localStorage.getItem("token"),
      },
      body: JSON.stringify(data),
    }).then(async (response) => {
      response.json().then((data) => {
        if (data.error) {
          alert(data.error.message);
        } else {
          navigate("/member/cars");
        }
      });
    });
  }

  useEffect(() => {
    if (id !== "new") {
      fetch(`${process.env.REACT_APP_API_URL}/member/cars/${id}`, {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
          Authorization: localStorage.getItem("token"),
        },
      }).then(async (response) => {
        response.json().then((data) => {
          if (response.ok) {
            setValue("name", data.name);
            setValue("plaka", data.plaka);
            setValue("brand", data.brand);
            setValue("model", data.model);
            setValue("year", data.year);
          }
        });
      });
    }
  }, []);

  return (
    <MainLayout>
      <Page>
        <Page.Header>{id === "new" ? "Add New Car" : "Edit Car"}</Page.Header>
        <Page.Content>
          <div className={styles.content}>
            <div className={styles.formGroup}>
              <label>Car Name</label>
              <input
                type="text"
                placeholder="Placeholder"
                className={errors.name ? styles.inputError : ""}
                {...register("name", { required: true })}
              />
              {errors.name && (
                <span className={styles.inputErrorMessage}>
                  This field is required
                </span>
              )}
            </div>

            <div className={styles.formGroup}>
              <label>Plaka</label>
              <input
                type="text"
                placeholder="Placeholder"
                className={errors.plaka ? styles.inputError : ""}
                {...register("plaka", { required: true })}
              />
              {errors.plaka && (
                <span className={styles.inputErrorMessage}>
                  This field is required
                </span>
              )}
            </div>

            <div className={styles.formGroup}>
              <label>Marka</label>
              <select
                name=""
                id=""
                placeholder="Placeholder"
                className={errors.plaka ? styles.inputError : ""}
                {...register("brand", { required: true })}
              >
                <option value="">Placeholder</option>
                {carBrands.map((brand) => (
                  <option key={brand.id} value={brand.id}>
                    {brand.name}
                  </option>
                ))}
              </select>
              {errors.brand && (
                <span className={styles.inputErrorMessage}>
                  This field is required
                </span>
              )}
            </div>

            <div className={styles.formGroup}>
              <label>Model</label>
              <select
                name=""
                id=""
                className={errors.model ? styles.inputError : ""}
                {...register("model", { required: true })}
              >
                <option value="">Placeholder</option>
                {carModels.map((model) => (
                  <option key={model.id} value={model.id}>
                    {model.name}
                  </option>
                ))}
              </select>
              {errors.model && (
                <span className={styles.inputErrorMessage}>
                  This field is required
                </span>
              )}
            </div>

            <div className={styles.formGroup}>
              <label>Year</label>
              <input
                type="text"
                className={errors.year ? styles.inputError : ""}
                {...register("year", { required: true })}
              />
              {errors.year && (
                <span className={styles.inputErrorMessage}>
                  This field is required
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
