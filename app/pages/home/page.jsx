import Link from "next/link"
import style from "./page.module.css"
import Image from "next/image"

export default function Home(){
    return(
        <> 
        <div className={style.bloco}>
            <main className={style.main}> 
                <h1>Quer turbinar seus estudos e memorizar mais?</h1>
                <h3>Este site de flashcards é a ferramenta perfeita para você!</h3>
                <h3>Crie seus próprios cartões ou use a IA para revisar e aprender</h3>
                <h3>qualquer matéria de forma rápida, eficiente e interativa.</h3>
                <Link href="/pages/game-flash">
                <button className={style.botao}>Comece agora!</button>
                </Link>
            </main>  
        </div>    
            <div className={style.right}>
                <Image src="/flash-brain1.0.png" 
                alt="Flashcard" 
                width={400} 
                height={400}>
                </Image>

            </div>
                 
        </> 
    )           
}