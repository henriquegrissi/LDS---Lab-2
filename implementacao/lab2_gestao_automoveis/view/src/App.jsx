import { BrowserRouter, Route, Routes } from 'react-router-dom';
import  {CadastroDeUsuario}  from './components/home/index';


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/home" element={<CadastroDeUsuario/>}/>
        <Route path="/usuario/cadastro" element={<CadastroDeUsuario/>}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App