import React from "react";
import "../../../css/diaryWrite.css";
import { useForm } from "react-hook-form";

const DiaryWritePresenter = () => {
  const { register, handleSubmit, watch, errors, reset } = useForm();

  const writeDiary = (contents) => {
    console.log(contents.content);
    reset();
  };
  return (
    <>
      <div id="diaryWrite">
        <h1>다이어리 작성</h1>
        <div className="writeArea">
          <form onSubmit={handleSubmit(writeDiary)}>
            <textarea
              type="textarea"
              id="inContent"
              name="content"
              ref={register}
            />
            <input type="submit" value="글쓰기" />
          </form>
        </div>
      </div>
    </>
  );
};

export default DiaryWritePresenter;
