import { Typography } from "@mui/material"
import { Box } from "@mui/system"
import {Button} from '@mui/material';
import { Grid, TextField} from "@mui/material";
import fotoDeFundo from '../../assets/foto3.jpg'
import { useState } from 'react'
import { useApi } from '../../hook/userApi';

export const CadastroVeiculo = () => {


    const [matricula, setMatricula] = useState('');
    const [ano, setAno] = useState('');
    const [marca, setMarca] = useState('');
    const [modelo, setModelo] = useState('');
    const [placa, setPlaca] = useState('');
    const [valor, setValor] = useState('');

    const handleClick = async () => {

        const veiculo={
            matricula,
            ano,
            marca,
            modelo,
            placa,
            valor,
        }

        await useApi //conferir essa rota
            .post('cadastrar', veiculo)
            .then(async _ => {
                navigate('/cadastrar')
            })
    }


  
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
        </Grid>

        <Grid item xs={12} sm={8} md={5}  elevation={6} square>
            <Box sx={{  my: 8, mx: 4, display: 'flex', flexDirection: 'column', alignItems: 'center' }} >
                <Typography variant="h4" fontWeight="fontWeightMedium" mb={3}>
                    Cadastre um automóvel 
                </Typography>
            
                <Grid container spacing={2} >
                    <Grid item xs={12} >
                        <TextField
                            name="matricula"
                            required
                            fullWidth
                            label="Matricula" 
                            size="small"
                        />
                    </Grid>
                    <Grid item xs={12} sm={6}>
                        <TextField
                            required
                            fullWidth
                            name="ano"
                            label="Ano"
                            type="string"
                            size="small"
                        />
                    </Grid>
                    <Grid item xs={12} sm={6}>
                        <TextField
                            required
                            fullWidth
                            name="text"
                            label="Marca"
                            type="text"
                            size="small"
                        />
                    </Grid>
                    
                    <Grid item xs={12} sm={6}>
                        <TextField
                            required
                            fullWidth
                            name="modelo"
                            label="Modelo"
                            type="text"
                            size="small"
                        />
                    </Grid>
                        
                    <Grid item xs={12} sm={6}>
                        <TextField
                            required
                            fullWidth
                            name="placa"
                            label="Placa"
                            type="text"
                            size="small"
                        />
                    </Grid>
                        
                    <Grid item xs={12} >
                        <TextField
                            required
                            fullWidth
                            name="valor"
                            label="Preço"
                            type="text"
                            size="small"
                        />
                    </Grid>

                    <Grid item xs={12}>
                        <Button type="submit" fullWidth variant="contained" >
                        Cadastrar veículo
                        </Button>
                    </Grid>
                </Grid>
                
            </Box>
        </Grid>
    </Grid>
  );
}
