import Navbar from "../components/navbar"; 

export default function PagesLayout({ children }) {
  return (
    <>
      <Navbar /> 
      <main>
        {children} 
      </main>

    </>
  );
}