import * as React from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import "font-awesome/css/font-awesome.min.css";

import Root from "./routes/root";

import AuthLogin from "./routes/auth/login";
import AuthRegister from "./routes/auth/register";
import MemberMyCars from "./routes/member/cars";
import MemberCarForm from "./routes/member/car-form";
import MemberChangePassword from "./routes/member/change-password";

const root = createRoot(document.getElementById("root"));

root.render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Root />}></Route>
      <Route path="/auth/login" element={<AuthLogin />}></Route>
      <Route path="/auth/register" element={<AuthRegister />}></Route>
      <Route path="/member/cars" element={<MemberMyCars />}></Route>
      <Route path="/member/cars/:id" element={<MemberCarForm />}></Route>
        <Route path="/member/change-password" element={<MemberChangePassword />}></Route>
    </Routes>
  </BrowserRouter>,
);
