"use client";

import { useState } from "react";

export default function Flashcard({ pergunta, resposta }) {
  const [flip, setFlip] = useState(false);

  return (
    <div className={`flashcard ${flip ? "flip" : ""}`} onClick={() => setFlip(!flip)}>
      <div className="inner">
        <div className="front">{pergunta}</div>
        <div className="back">{resposta}</div>
      </div>
    </div>
  );
}
