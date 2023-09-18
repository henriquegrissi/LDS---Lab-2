import { BrowserRouter, Route, Routes } from 'react-router-dom';
import  {CadastroCliente}  from './components/cadastroUsuarioC';
import { CadastroAgente } from './components/cadastroUsuarioA';
import { Login } from './components/login';


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" element={<Login/>}/>
        <Route path="/cliente/cadastro" element={<CadastroCliente/>}/>
        <Route path="/agente/cadastro" element={<CadastroAgente/>}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App