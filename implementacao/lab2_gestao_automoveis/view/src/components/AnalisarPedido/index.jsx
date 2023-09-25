import { Grid, Typography, Button } from '@mui/material';
import {Barra} from '../navBar/index'
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import Switch from '@mui/material/Switch';
import { Box } from "@mui/system"
import { useEffect, useState } from 'react';
import { useApi } from '../../hook/userApi';

const label = { inputProps: { 'aria-label': 'Switch demo' } };

export const HomeAgente = () => {
  const [rows, setRows] = useState([]);

  const listarPedidos = async () => {
    try {
      const response = await useApi.get('pedido/listar');
      setRows(response.data);
    } catch (error) {
      console.error('Erro ao buscar pedidos:', error);
    }
  }
  useEffect(() => {
    listarPedidos()
  }, []);

  return (
    <Paper elevation={3}  sx={{my: 8, mx: 4, display: 'flex', flexDirection: 'column', alignItems: 'center',}}>
      <Grid sx={{ position: 'fixed', top: 0, bottom: 0, left: 0, right: 0 }}>
        <Barra />
      </Grid>
    
        <Typography variant="h4" fontWeight="fontWeightMedium" mb={3}>
            Analisar Pedidos
        </Typography>
        
        <TableContainer component={Paper} sx={{  display: 'flex', flexDirection: 'column', alignItems: 'center'}}>
            
          <Table sx={{ minWidth: 800 }} size="small">
            <TableHead>
              <TableRow>
                <TableCell align="right">Cliente</TableCell>
                <TableCell align="right">Modelo</TableCell>
                <TableCell align="right">Placa</TableCell>
                <TableCell align="right">Status</TableCell>
                <TableCell align="right">Aprovado</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {rows.map((row) => (
                <TableRow key={row.id} sx={{ '&:last-child td, &:last-child th': { border: 0 } }} >
                  <TableCell component="th" scope="row" align="right">{row.cliente.nome}</TableCell>
                  <TableCell align="right">{row.veiculo.modelo}</TableCell>
                  <TableCell align="right">{row.veiculo.placa}</TableCell>
                  <TableCell align="right">{row.statusPedido}</TableCell>
                  <TableCell align="right">
                    <Switch {...label} defaultChecked />
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
          

          
        </TableContainer>
        <Box sx={{ textAlign: 'center', marginTop: 2 }}>
          <Button variant="contained" color="primary">
            Salvar
          </Button>
        </Box>    
      
    </Paper>
  );
}