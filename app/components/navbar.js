import Link from 'next/link';
import Image from 'next/image';


export default function Navbar() {
    return (
        <nav className="navbar1">
            <Link href="/" className='logonav'>
                <Image src="/flash-brain1.0.png"
                alt="logofbrain"
                width={95}
                height={55}>                         
                </Image>
            </Link>
            <ul className="navbar2">
                <li>
                    <Link href="/pages/home">Home</Link>
                </li>
                <li>
                    <Link href="/pages/contato">Contato</Link>
                </li>
                <li>
                    <Link href="/pages/suporte">Suporte</Link>
                </li>
                <li>
                    <Link href="/pages/game-flash">Flash cards</Link>
                </li>
            </ul>
        </nav>
    );
}