"use client";

import "./style.css";
import { useState } from "react";
import Flashcard from "./Flashcard";

export default function Page() {
  const [pergunta, setPergunta] = useState("");
  const [resposta, setResposta] = useState("");

  const [flashcards, setFlashcards] = useState([
    { pergunta: "O que é HTML?", resposta: "Linguagem de marcação usada para estruturar páginas web." },
    { pergunta: "O que é CSS?", resposta: "Linguagem usada para estilizar páginas web." },
    { pergunta: "O que é JavaScript?", resposta: "Linguagem usada para adicionar interatividade à página." },
    { pergunta: "O que é DOM?", resposta: "É a representação da estrutura de um documento HTML." }
  ]);

  function adicionarFlashcard(e) {
    e.preventDefault();

    if (!pergunta.trim() || !resposta.trim()) return;

    setFlashcards([...flashcards, { pergunta, resposta }]);
    setPergunta("");
    setResposta("");
  }

  return (
    <div className="container">
      <h1>FlashBrain</h1>

      <div className="flashcards-container">
        {flashcards.map((card, index) => (
          <Flashcard
            key={index}
            pergunta={card.pergunta}
            resposta={card.resposta}
          />
        ))}
      </div>

      <h2>➕ Criar novo flashcard</h2>

      <form onSubmit={adicionarFlashcard}>
        <input
          type="text"
          placeholder="Digite a pergunta"
          value={pergunta}
          onChange={(e) => setPergunta(e.target.value)}
          required
        />

        <input
          type="text"
          placeholder="Digite a resposta"
          value={resposta}
          onChange={(e) => setResposta(e.target.value)}
          required
        />

        <button type="submit">Adicionar</button>
      </form>
    </div>
  );
}
