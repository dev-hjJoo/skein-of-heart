import React from "react";
import DiaryListPresenter from "./DiaryListPresenter";
const DiaryListContainer = () => {
  const diary = [
    {
      title: "오늘의 일기",
      content: "일기다 이자식아",
      wordCloud: "image/wordCloud1.png",
    },
    {
      title: "집가고싶다",
      content: "고양이가 최고양",
      wordCloud: "image/wordCloud2.png",
    },
    {
      title: "오늘의 일기",
      content: "일기다 이자식아",
      wordCloud: "image/wordCloud1.png",
    },
    {
      title: "집가고싶다",
      content: "고양이가 최고양",
      wordCloud: "image/wordCloud2.png",
    },
  ];
  return <DiaryListPresenter diary={diary} />;
};

export default DiaryListContainer;
