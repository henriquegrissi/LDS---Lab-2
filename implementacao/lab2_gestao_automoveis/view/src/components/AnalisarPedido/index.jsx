import React from 'react';
import { Grid, Typography, Button } from '@mui/material';
import {BarraAgente} from '../navBarAgente/index'
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import Switch from '@mui/material/Switch';
import { Box } from "@mui/system"
import {ModalDia} from '../modalDias/index'
import { useState } from 'react'

const label = { inputProps: { 'aria-label': 'Switch demo' } };

const createData = (
  cliente,
  modelo,
  placa,
  analise,

) => {
  return { cliente,modelo, placa, analise };
};

const rows = [
  createData('Bárbara', 'Corolla', 'placa',   <Switch {...label} defaultChecked />),
  createData('Laura', '320i', 'placa', <Switch {...label} defaultChecked />),
 
];



export const HomeAgente = () => {
  return (
    <Paper elevation={3}  sx={{my: 8, mx: 4, display: 'flex', flexDirection: 'column', alignItems: 'center',}}>
      <Grid sx={{ position: 'fixed', top: 0, bottom: 0, left: 0, right: 0 }}>
        <BarraAgente />
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
                <TableCell align="right">Aprovado</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {rows.map((row) => (
                <TableRow key={row.matricula} sx={{ '&:last-child td, &:last-child th': { border: 0 } }} >
                  <TableCell component="th" scope="row" align="right">{row.cliente}</TableCell>
                  <TableCell align="right">{row.modelo}</TableCell>
                  <TableCell align="right">{row.placa}</TableCell>
                  <TableCell align="right">{row.analise}</TableCell>
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