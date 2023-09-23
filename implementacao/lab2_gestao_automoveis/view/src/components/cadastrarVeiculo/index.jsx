import { Box } from "@mui/system"
import { Typography, Button, Grid, TextField, Select, MenuItem } from '@mui/material';
import { useState } from 'react'


export const CadastroVeiculo = () => {
  
  return (
    <form>
               
        <Grid container justifyContent="center"  sx={{ marginTop: 5, display:'flex', flexDirection:'column', alignItems:'center'}} >
            <Typography variant="h4" fontWeight="fontWeightMedium" mb={3}>
                🚘 Cadastrar um automóvel 🚘
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

                <Button type="submit" fullWidth variant="contained" sx={{ mt: 3, mb: 7 }}  >
                    Cadastrar
                </Button>
            </Grid>
        </Grid>
            
    </form>
   

  );
}