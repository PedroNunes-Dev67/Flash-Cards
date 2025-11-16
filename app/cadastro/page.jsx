import styles from './page.module.css'
import Image from 'next/image'

export default function Home(){
  return (
    <main className={styles.container}>
      <Image src= "/flash-brain1.0.png" width={200} height={120} className={styles.Image} alt='logo'></Image>
      <div className={styles.form}>
        <h1>Cadastre sua conta?</h1>
        <h2>Simples, rápido e fácil!</h2>
        <form> 
          <input type="text" required placeholder='Digite seu nome' className={styles.inputs}/>
          <input type="email" required  placeholder='Digite Seu Email'className={styles.inputs} />
           <input type="password" required  placeholder='Digite Sua Senha'className={styles.inputs} />
          <input type="submit" value={"Enviar"} className={styles.botao} />
        </form>        
      </div>
    </main>
  )  
}
