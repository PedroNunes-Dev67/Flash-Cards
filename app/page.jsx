'use client'

import axios from 'axios'
import Link from 'next/link'
import styles from './page.module.css'
import Image from 'next/image'
import { useState } from 'react'

export default function Home(){
  
  const [email,setEmail] = useState("");
  const [senha,setSenha] = useState("");

  async function handlerLogin(e){
    e.preventDefault();

    try{
      const response = await axios.get("http://localhost:8080/usuario/"+email);
      console.log(response)
      if(response.data.email === email && response.data.senha === senha){
        window.location.href = "/pages/home";
      }
      else{
        alert("Email ou senha incorretos!")
      }
    }
    catch(error){
      alert("Usário não cadastrado")
      window.location.reload();
    }
    
  }

  return (
    <main className={styles.container}>
      <Image src= "/flash-brain1.0.png" width={200} height={120} className={styles.Image} alt='logo'></Image>
      <div className={styles.form}>
        <h1>Bem-vindo de volta </h1>
        <h2>
  Entre para continuar sua <span className={styles.highlightGradient}>jornada!</span></h2>
        <form onSubmit={handlerLogin}> 
          <input type="email" required  placeholder='Seu Email'className={styles.inputs} value={email} onChange={(e) => setEmail(e.target.value)} />
          <input type="password" placeholder='Sua Senha' required className={styles.inputs} value={senha} onChange={(e) => setSenha(e.target.value)} />
          <input type="submit" value={"Entrar"} className={styles.botao} />
        </form>
        <span className={styles.span}>Esqueceu sua senha? <Link href={"/redefinirSenha"}>Clique aqui!</Link></span>
        <span className={styles.span}>Não possui uma conta? <Link href={"/cadastro"}>Cadastre-se</Link></span>
      </div>
    </main>
  )  
}