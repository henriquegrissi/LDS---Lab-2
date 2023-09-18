import { Typography } from "@mui/material"
import { Box } from "@mui/system"
import {Button} from '@mui/material';
import { Grid, TextField} from "@mui/material";
import fotoDeFundo from '../../assets/fundoCarro.png'
import { useState } from 'react'


export const CadastroCliente = () => {

  const [nome, setNome] = useState('');
  const [rg, setRg] = useState('');
  const [cpf, setCpf] = useState('');
  const [profissao, setProfissao] = useState('');
  const [empresa, setEmpresa] = useState('');
  const [r1, setR1] = useState('');
  const [r2, setR2] = useState('');
  const [r3, setR3] = useState('');
  const [v1, setV1] = useState('');
  const [v2, setV2] = useState('');
  const [v3, setV3] = useState('');
  const [rua, setRua] = useState('');
  const [bairro, setBairro] = useState('');
  const [numero, setNumero] = useState('');
  const [cidade, setCidade] = useState('');
  const [estado, setEstado] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');







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
                id="Nome"
                label="Nome"
                size="small"
                autoFocus
                value={nome}
                onChange={(e) => setNome(e.target.value)}
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                required
                fullWidth
                name="RG"
                label="RG"
                type="number"
                id="RG"
                size="small"
                value={rg}
                onChange={(e) => setRg(e.target.value)}
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                required
                fullWidth
                name="CPF"
                label="CPF"
                type="number"
                id="CPF"
                size="small"
                value={cpf}
                onChange={(e) => setCpf(e.target.value)}
              />
            </Grid>
            <Grid item xs={6} >
              <TextField
                required
                fullWidth
                name="profissao"
                label="Profissão"
                type="text"
                id="profissao"
                size="small"
                value={profissao}
                onChange={(e) => setProfissao(e.target.value)}
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                required
                fullWidth
                name="empresa"
                label="Empresa"
                type="text"
                id="empresa"
                size="small"
                value={empresa}
                onChange={(e) => setEmpresa(e.target.value)}
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                required
                fullWidth
                name="ra1"
                label="RA nome: "
                type="text"
                id="ra1"
                size="small"
                value={r1}
                onChange={(e) => setR1(e.target.value)}
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                required
                fullWidth
                name="valor1"
                label="Valor: "
                type="number"
                id="valor1"
                size="small"
                value={v1}
                onChange={(e) => setV1(e.target.value)}
              />
            </Grid><Grid item xs={12} sm={6}>
              <TextField
                required
                fullWidth
                name="ra2"
                label="RA nome: "
                type="text"
                id="ra2"
                size="small"
                value={r2}
                onChange={(e) => setR2(e.target.value)}
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                required
                fullWidth
                name="valor2"
                label="Valor: "
                type="number"
                id="valor2"
                size="small"
                value={v2}
                onChange={(e) => setV2(e.target.value)}
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                required
                fullWidth
                name="ra3"
                label="RA nome: "
                type="text"
                id="ra3"
                size="small"
                value={r3}
                onChange={(e) => setR3(e.target.value)}
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                required
                fullWidth
                name="valor3"
                label="Valor: "
                type="number"
                id="valor3"
                size="small"
                value={v3}
                onChange={(e) => setV3(e.target.value)}
              />
            </Grid>
            <Grid item xs={12} sm={7}>
              <TextField
                fullWidth
                name="rua"
                label="Rua"
                type="text"
                id="rua"
                size="small"
                value={rua}
                onChange={(e) => setRua(e.target.value)}
              />
            </Grid>
            <Grid item xs={12} sm={5}>
              <TextField
                fullWidth
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
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </Grid>
          </Grid>
          <Button type="submit" fullWidth variant="contained" sx={{ mt: 3, mb: 2 }} >
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