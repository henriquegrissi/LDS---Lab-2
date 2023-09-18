import { Typography } from "@mui/material"
import { Box } from "@mui/system"
import {Button} from '@mui/material';
import { Grid, TextField} from "@mui/material";
import fotoDeFundo from '../../assets/fundoCarro.png'


export const CadastroCliente = () => {
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
                />
              </Grid>
              <Grid item xs={12} >
                <TextField
                  required
                  fullWidth
                  name="profissao"
                  label="Profissão"
                  type="text"
                  id="profissao"
                  size="small"
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
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  required
                  fullWidth
                  name="empresa"
                  label="Rendimento aurífero"
                  type="Amount"
                  id="empresa"
                  size="small"
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