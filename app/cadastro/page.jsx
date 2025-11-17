'use client'

import { useState } from 'react';
import axios from 'axios';
import styles from './page.module.css'
import Image from 'next/image'

export default function Home(){

  const [nome,setNome] = useState("");
  const [email,setEmail] = useState("");
  const [senha,setSenha] = useState("");
  const [mensagem,setMensagem] = useState("");

  async function cadastro(e){

    e.preventDefault();

    const novoUsuario = {nome,email,senha}

    try{
      setMensagem("Carregando...")
      const response = await axios.post("http://localhost:8080/usuario/novoUsuario",novoUsuario);
      setMensagem("Usuário cadastrado com sucesso!")
      setNome("");
      setEmail("");
      setSenha("");
    }
    catch(error){
      setMensagem("Erro ao cadastrar usuário!")
    }
  }

  return (
    <main className={styles.container}>
      <Image src= "/flash-brain1.0.png" width={200} height={120} className={styles.Image} alt='logo'></Image>
      <div className={styles.form}>
        <h1>Cadastre sua conta?</h1>
        <h2>Simples, rápido e fácil!</h2>
        <form onSubmit={cadastro}> 
          <input type="text" required placeholder='Digite seu nome' className={styles.inputs} value={nome} onChange={(e) => setNome(e.target.value)} />
          <input type="email" required  placeholder='Digite Seu Email'className={styles.inputs} value={email} onChange={(e) => setEmail(e.target.value)} />
           <input type="password" required  placeholder='Digite Sua Senha'className={styles.inputs} value={senha} onChange={(e) => setSenha(e.target.value)} />
          <input type="submit" value={"Enviar"} className={styles.botao} />
          <h3>{mensagem}</h3>
        </form>        
      </div>
    </main>
  )  
}
