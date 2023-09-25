import { Typography } from "@mui/material"
import { Box } from "@mui/system"
import {Button} from '@mui/material';
import { Grid, TextField} from "@mui/material";
import fotoDeFundo from '../../assets/foto3.jpg'
import { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { useApi } from '../../hook/userApi';

export const CadastroVeiculo = () => {
    const navigate = useNavigate();

    const [matricula, setMatricula] = useState('');
    const [ano, setAno] = useState('');
    const [marca, setMarca] = useState('');
    const [modelo, setModelo] = useState('');
    const [placa, setPlaca] = useState('');
    const [valorAluguel, setValorAluguel] = useState('');

    const handleClick = async (e) => {
        e.preventDefault();

        const veiculo={
            matricula,
            ano,
            marca,
            modelo,
            placa,
            valorAluguel,
        }

        try{
            await useApi.post('veiculo/cadastrar', veiculo);
            alert('Veiculo cadastrado com sucesso');
            navigate('/analisar');
          }catch(error){
            console.error('Erro:', error);
          }

      
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
                            type="text"
                            value={matricula}
                            onChange={(e) => setMatricula(e.target.value)}
                        />
                    </Grid>
                    <Grid item xs={12} sm={6}>
                        <TextField
                            required
                            fullWidth
                            name="ano"
                            label="Ano"
                            type="text"
                            size="small"
                            value={ano}
                            onChange={(e) => setAno(e.target.value)}
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
                            value={marca}
                            onChange={(e) => setMarca(e.target.value)}
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
                            value={modelo}
                            onChange={(e) => setModelo(e.target.value)}
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
                            value={placa}
                            onChange={(e) => setPlaca(e.target.value)}
                        />
                    </Grid>
                        
                    <Grid item xs={12} >
                        <TextField
                            required
                            fullWidth
                            name="valor"
                            label="Preço"
                            type="number"
                            size="small"
                            value={valorAluguel}
                            onChange={(e) => setValorAluguel(e.target.value)}
                        />
                    </Grid>

                    <Grid item xs={12}>
                        <Button type="submit" fullWidth variant="contained" onClick={handleClick}>
                        Cadastrar veículo
                        </Button>
                    </Grid>
                </Grid>
                
            </Box>
        </Grid>
    </Grid>
  );
}
