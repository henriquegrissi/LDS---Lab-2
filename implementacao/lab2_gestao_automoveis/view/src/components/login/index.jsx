import { Typography } from "@mui/material"
import { Box } from "@mui/system"
import {Button} from '@mui/material';
import { Grid, TextField} from "@mui/material";
import fotoDeFundo from '../../assets/fundoCarro.png'


export const Login = () => {
    return (
      <Grid container component="main" sx={{ height: '100vh'}}>
     
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
              Não possui conta?
          </Typography>
          
          <Button type="submit" size="medium"  variant="outlined" sx={{ width: '200px',  color: "white" }} >
              cadastrar
          </Button>
  
        </Grid>

        <Grid item xs={12} sm={8} md={5}  elevation={6} square>
          <Box sx={{
              my: 8,
              mx: 4,
              display: 'flex',
              flexDirection: 'column',
              alignItems: 'center',
            }}>
            
            <Box component="form"  sx={{mt: 1}} >
              <Typography variant="h4" fontWeight="fontWeightMedium" mb={3}>
                Faça seu login
              </Typography>
           
              <Grid container spacing={2}>
               
                
               
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
                  Login
              </Button>
            </Box>
          </Box>
        </Grid>       
      </Grid>

    );
  }