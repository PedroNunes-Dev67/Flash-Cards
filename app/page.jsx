import Link from 'next/link'
import styles from './page.module.css'
import Image from 'next/image'

export default function Home(){
  return (
    <main className={styles.container}>
      <Image src= "/flash-brain1.0.jpg" width={200} height={120} className={styles.Image} alt='logo'></Image>
      <div className={styles.form}>
        <h1>Já possui uma conta?</h1>
        <h2>Faça seu login e <span>bons estudos!</span></h2>
        <form>
          <input type="text" required  placeholder='Email'className={styles.inputs} />
          <input type="password" placeholder='Senha' required className={styles.inputs} />
          <input type="submit" value={"Entrar"} className={styles.botao} />
        </form>
        <span className={styles.span}>Esqueceu sua senha?</span>
        <span className={styles.span}>Não possui uma conta? <Link href={"/cadastro"}>Cadastre-se</Link></span>
      </div>
    </main>
  )  
}