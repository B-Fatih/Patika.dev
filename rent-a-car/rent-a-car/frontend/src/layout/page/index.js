import { Fragment } from "react";

import styles from "./Page.module.css";

const Header = ({ children }) => {
  return (
    <Fragment>
      <header className={styles.header}>{children}</header>
    </Fragment>
  );
};

const Content = ({ children }) => {
  return <Fragment>{children}</Fragment>;
};

const Page = ({ children }) => {
  return <div className={styles.page}>{children}</div>;
};

Page.Header = Header;
Page.Content = Content;

export default Page;
