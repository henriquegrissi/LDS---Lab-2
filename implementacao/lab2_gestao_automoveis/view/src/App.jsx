import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'

import { Login } from './components/login';
import { CadastroDeUsuario } from './components/cadastroUsuario';
import  {Home}  from './components/home/index';


function App() {
  const [count, setCount] = useState(0)

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/home" element={<Home/>}/>
        <Route path="/usuario/login" element={<Login/>}/>
        <Route path="/usuario/cadastro" element={<CadastroDeUsuario/>}/>
      </Routes>
    </BrowserRouter>

  )
}

export default App