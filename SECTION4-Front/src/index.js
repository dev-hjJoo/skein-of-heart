import React from "react";
import ReactDOM from "react-dom";
import App from "./App";
import Main from "./js/screens/main";
import SkeinOfHeart from "./js/components/SkeinOfHeart";
import DiaryWrite from "./js/screens/diaryWrite";
import DiaryList from "./js/screens/diaryList";

ReactDOM.render(
  <React.StrictMode>
    <SkeinOfHeart />
  </React.StrictMode>,
  document.getElementById("root")
);
