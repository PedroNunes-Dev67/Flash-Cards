import styles from './page.module.css'
import Image from 'next/image'

export default function Home(){
  return (
    <main className={styles.container}>
      <Image src= "/flash-brain1.0.png" width={200} height={120} className={styles.Image} alt='logo'></Image>
      <div className={styles.form}>
        <h1>Esqueceu sua senha?</h1>
        <h2>Não se desespere!</h2>
        <form> 
          <input type="email" required  placeholder='Digite Seu Melhor Email'className={styles.inputs} />
          <input type="submit" value={"Enviar"} className={styles.botao} />
        </form>        
      </div>
    </main>
  )  
}
