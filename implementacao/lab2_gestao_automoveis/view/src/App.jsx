import { BrowserRouter, Route, Routes } from 'react-router-dom';
import  {CadastroCliente}  from './components/cadastroUsuarioC';
import { CadastroAgente } from './components/cadastroUsuarioA';
import { Login } from './components/login';
import { CadastroVeiculo } from './components/cadastrarVeiculo';
import { HomeCliente } from './components/homeC';


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" element={<Login/>}/>
        <Route path="/cliente/cadastro" element={<CadastroCliente/>}/>
        <Route path="/agente/cadastro" element={<CadastroAgente/>}/>
        <Route path="/veiculo/cadastro" element={<CadastroVeiculo/>}/>
        <Route path="/home" element={<HomeCliente/>}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App