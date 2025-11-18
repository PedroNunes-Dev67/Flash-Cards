import Link from "next/link"
import style from "./page.module.css"
import Image from "next/image"

export default function Home(){
    return(
        <> 
        <div className={style.bloco}>
            <main className={style.main}> 
                <h1>Quer turbinar seus estudos e memorizar mais? <i className="fi fi-br-brain-circuit"></i></h1>
                <h2>O FlashCards é a ferramenta perfeita para você!</h2>
                <h3>Crie seus próprios cartões ou use a IA para revisar e aprender <br />
                    qualquer matéria de forma rápida, eficiente e interativa.</h3>
                <Link href="/pages/game-flash">
                <button className={style.botao}>Comece agora!</button>
                </Link>
            </main>  
        </div>    
        </> 
    )           
}