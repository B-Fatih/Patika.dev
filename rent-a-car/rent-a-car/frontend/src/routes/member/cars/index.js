import MainLayout from "../../../layout/main";
import Page from "../../../layout/page";
import { faPlus, faEdit, faTrash } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

import styles from "./MyCars.module.css";
import { Fragment, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const MyCarsPage = () => {
  const navigate = useNavigate();

  const [query, setQuery] = useState("");
  const [result, setResult] = useState({ total: 0, data: [] });

  function onDeleteCar(id) {
    fetch(process.env.REACT_APP_API_URL + "/member/cars", {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
        Authorization: localStorage.getItem("token"),
      },
      body: JSON.stringify({ id }),
    }).then(async (response) => {
      if (response.status === 401) {
        localStorage.removeItem("token");
        navigate("/auth/login");
        return;
      }
      response.json().then((data) => {
        if (data.error) {
          alert(data.error.message);
        } else {
          setResult({
            data: result.data.filter((c) => c.id !== id),
            total: result.total - 1,
          });
        }
      });
    });
  }

  useEffect(() => {
    let queryParam = "";
    if (query && query.length > 0) {
      queryParam = `?query=${query}`;
    }
    fetch(process.env.REACT_APP_API_URL + "/member/cars" + queryParam, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        Authorization: localStorage.getItem("token"),
      },
    }).then(async (response) => {
      if (response.status === 401) {
        navigate("/auth/login");
        localStorage.removeItem("token");
        return;
      }
      response.json().then((data) => {
        setResult(data);
      });
    });
  }, [query]);

  return (
    <MainLayout>
      <Page>
        <Page.Header>My Cars</Page.Header>
        <Page.Content>
          <div className={styles.header}>
            <div className={styles.searchFilter}>
              <span>Count: {result.total}</span>
            </div>
            <div className={styles.searchInput}>
              <input
                type="text"
                placeholder="Search"
                value={query}
                onChange={(event) => setQuery(event.target.value)}
              />
              <i
                className={styles.searchIcon + ` eye-icon ${"fa fa-search"}`}
              />
            </div>
          </div>
          <div className={styles.divider}></div>
          <button
            className={styles.addNewCarButton}
            onClick={() => navigate("/member/cars/new")}
          >
            <FontAwesomeIcon icon={faPlus}></FontAwesomeIcon>
            Add New Car
          </button>
          <table className={styles.table}>
            <thead>
              <tr>
                <th width="30%">Car Name</th>
                <th>Brand</th>
                <th>Model</th>
                <th>Year</th>
                <th>Plaka</th>
                <th width="5%" style={{ textAlign: "right" }}></th>
              </tr>
            </thead>
            <tbody>
              {result.data.map((car, index) => (
                <Fragment key={index}>
                  <tr>
                    <td>
                      <div className={styles.tableProfileContainer}>
                        <div className={styles.tableProfile}>
                          <img src="https://picsum.photos/150/150" alt="" />
                        </div>
                        <span className={styles.tableProfileContent}>
                          {car.name}
                        </span>
                      </div>
                    </td>
                    <td>{car.brand}</td>
                    <td>{car.model}</td>
                    <td>{car.year}</td>
                    <td>{car.plaka}</td>
                    <td style={{ backgroundColor: "#f2f2f2" }}>
                      <button
                        className={styles.tableButton}
                        onClick={() => navigate(`/member/cars/${car.id}`)}
                      >
                        <FontAwesomeIcon icon={faEdit}></FontAwesomeIcon>
                      </button>
                      <button
                        className={styles.tableButton}
                        onClick={() => onDeleteCar(car.id)}
                      >
                        <FontAwesomeIcon icon={faTrash}></FontAwesomeIcon>
                      </button>
                    </td>
                  </tr>
                </Fragment>
              ))}
            </tbody>
          </table>
          <div className={styles.pagination} style={{ display: "none" }}>
            <span className={styles.paginationText}>Previous</span>
            <ul>
              <li>
                <a href="">1</a>
              </li>
              <li>
                <a className={styles.paginationActive} href="">
                  2
                </a>
              </li>
              <li>
                <a href="">3</a>
              </li>
              <li>
                <a href="">...</a>
              </li>
              <li>
                <a href="">11</a>
              </li>
            </ul>
            <span className={styles.paginationText}>Next</span>
          </div>
        </Page.Content>
      </Page>
    </MainLayout>
  );
};

export default MyCarsPage;
