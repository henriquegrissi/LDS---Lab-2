import { BrowserRouter, Route, Routes } from 'react-router-dom';
import  {CadastroCliente}  from './components/cadastroUsuarioC';
import { CadastroAgente } from './components/cadastroUsuarioA';
import { Login } from './components/login';
import { CadastroVeiculo } from './components/cadastrarVeiculo';
import { HomeCliente } from './components/Alugar';
import { HomeAgente } from './components/AnalisarPedido';
import{ PedidosCliente } from './components/pedidoC';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" element={<Login/>}/>
        <Route path="/cliente/cadastro" element={<CadastroCliente/>}/>
        <Route path="/agente/cadastro" element={<CadastroAgente/>}/>
        <Route path="/veiculo/cadastro" element={<CadastroVeiculo/>}/>
        <Route path="/alugar" element={<HomeCliente/>}/>
        <Route path="/analisar" element={<HomeAgente/>}/>
        <Route path="/pedidos" element={<PedidosCliente/>}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App