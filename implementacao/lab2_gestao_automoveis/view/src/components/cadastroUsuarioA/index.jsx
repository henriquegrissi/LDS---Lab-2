import { Box } from "@mui/system"
import { Typography, Button, Grid, TextField, Select, MenuItem } from '@mui/material';
import fotoDeFundo from '../../assets/fundoCarro.png'
import { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { useApi } from '../../hook/userApi';


export const CadastroAgente = () => {
  const navigate = useNavigate();

  const [nome, setNome] = useState('');
  const [cnpj, setCnpj] = useState('');
  const [rua, setRua] = useState('');
  const [bairro, setBairro] = useState('');
  const [numero, setNumero] = useState('');
  const [cidade, setCidade] = useState('');
  const [estado, setEstado] = useState('');
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [tipo, setTipo] = useState('');

  const handleClick = async () => {
    //debugger;
    const endereco = `Rua: ${rua}, Nº ${numero}, Bairro: ${bairro}, Cidade: ${cidade}, Estado: ${estado}`;
    const user ={
      nome, 
      cnpj,
      endereco,
      login: email,
      senha,
      tipoAgente: tipo, // confirmar esse campo
    };
    debugger;
    console.log(user);
    
    try{
      await useApi.post('agente/cadastrar', user);
      alert('Agente cadastrado com sucesso');
      navigate('/login');
    }catch(error){
      console.error('Erro:', error);
    }

  };

  return (
  <Grid container component="main" sx={{ height: '100vh'}}>
    
    <Grid item xs={12} sm={8} md={5} >
      <Box>
        
        <Box component="form"   sx={{my: 8, mx: 4, display: 'flex', flexDirection: 'column', alignItems: 'center',}} >
          <Typography variant="h4" fontWeight="fontWeightMedium" mb={3}>
            Realize seu cadastro
          </Typography>
        
          <Grid container spacing={2}>
            <Grid item xs={12} >
              <TextField
                autoComplete="given-name"
                name="Nome"
                required
                fullWidth
                label="Nome"
                size="small"
                autoFocus
                value={nome}
                onChange={(e) => setNome(e.target.value)}
              />
            </Grid>
            <Grid item xs={12} >
              <TextField
                required
                fullWidth
                name="cnpj"
                label="CNPJ"
                type="text"
                size="small"
                value={cnpj}
                onChange={(e) => setCnpj(e.target.value)}
              />
            </Grid>
            <Grid item xs={12} sm={7}>
              <TextField
                required
                fullWidth
                name="rua"
                label="Rua"
                type="text"
                size="small"
                value={rua}
                onChange={(e) => setRua(e.target.value)}
              />
            </Grid>
            <Grid item xs={12} sm={5}>
              <TextField
                fullWidth
                required
                name="bairro"
                label="Bairro"
                type="text"
                id="bairro"
                size="small"
                value={bairro}
                onChange={(e) => setBairro(e.target.value)}
              />
            </Grid>
            <Grid item xs={12} sm={4}>
              <TextField
                fullWidth
                required
                name="numero"
                label="Nº"
                type="number"
                id="numero"
                size="small"
                value={numero}
                onChange={(e) => setNumero(e.target.value)}
              />
            </Grid>
            <Grid item xs={12} sm={4}>
              <TextField
                required
                fullWidth
                name="cidade"
                label="Cidade"
                type="text"
                id="cidade"
                size="small"
                value={cidade}
                onChange={(e) => setCidade(e.target.value)}
              />
            </Grid>
            <Grid item xs={12} sm={4}>
              <TextField
                required
                fullWidth
                name="estado"
                label="Estado"
                type="text"
                id="estado"
                size="small"
                value={estado}
                onChange={(e) => setEstado(e.target.value)}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                name="email"
                label="E-mail"
                type="text"
                id="email"
                size="small"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
            </Grid>

            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                name="password"
                label="Senha"
                type="password"
                id="password"
                size="small"
                value={senha}
                onChange={(e) => setSenha(e.target.value)}
              />
            </Grid>

            <Grid item xs={12}>
              <Select
                  required
                  fullWidth
                  name="role"
                  label="Tipo de usuário"
                  size="small"
                  id="tipo"
                  value={tipo}
                  onChange={(e) => setTipo(e.target.value)}
              >
                  <MenuItem value="Empresa">Empresa</MenuItem>
                  <MenuItem value="Banco">Banco</MenuItem>
              </Select>
            </Grid>

          </Grid>
          <Button type="submit" fullWidth variant="contained" sx={{ mt: 3, mb: 2 }}  onClick={handleClick} >
              Cadastrar
          </Button>
        </Box>
      </Box>
    </Grid>

    <Grid item xs={false} sm={4} md={7} sx={{
      backgroundImage: `url(${fotoDeFundo})`,
      backgroundSize: 'cover',
      backgroundPosition: 'center',
      display: { xs: 'none', sm: 'flex' }, 
      flexDirection: 'column',
      alignItems: 'center', 
      justifyContent: 'center', 
      }}>

      <Typography variant="h5" fontWeight="fontWeightMedium" mb={3}  color="white">
          Possui conta?
      </Typography>
      
      <Button type="submit" size="medium"  variant="outlined" sx={{ width: '100px',  color: "white" }} >
          Login
      </Button>

    </Grid>
  </Grid>

  );
}