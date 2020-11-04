import React from "react";
import "../../../css/main.css";
import { Button } from "react-bootstrap";

const MainPresenter = () => {
  return (
    <>
      <div id="main">
        <div className="title">
          <font className="logo">마음 실타래</font>
          <br />
          <button type="button" class="btn btn-warning">
            글쓰러가기
          </button>
        </div>
      </div>
    </>
  );
};

export default MainPresenter;
