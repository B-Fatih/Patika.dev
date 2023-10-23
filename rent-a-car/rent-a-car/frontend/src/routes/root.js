import { Link } from "react-router-dom";

const RootPage = () => {
  return (
    <div>
      home
      <Link to="/login">login page</Link>
      <Link to="/register">register page</Link>
    </div>
  );
};

export default RootPage;
