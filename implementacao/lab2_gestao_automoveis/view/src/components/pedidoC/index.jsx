import React from 'react';
import { Grid, Typography, Button } from '@mui/material';
import {Barra} from '../navBar/index'
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { Box } from "@mui/system"
import { useState } from 'react'

const createData = (
  pedido,
  modelo,
  marca,
  placa,
  ano,
  matricula,
  dias,
  cancelar
) => {
  return { pedido, modelo, marca, placa, ano, matricula, dias, cancelar };
};

const rows = [
  createData(1, 'Corolla', 'Toyota', 'placa', 2023, 1,  5,  <Button type="submit" variant="outlined" size="small" >remover</Button>),
  createData(2, 'Fusca', 'Volkswagen', 'placa', 2023,2, 1, <Button type="submit" variant="outlined" size="small" >remover</Button>),
];

export const PedidosCliente = () => {
  return (
    <Paper elevation={3}  sx={{my: 8, mx: 4, display: 'flex', flexDirection: 'column', alignItems: 'center',}}>
      <Grid sx={{ position: 'fixed', top: 0, bottom: 0, left: 0, right: 0 }}>
        <Barra />
      </Grid>

      <Typography variant="h4" fontWeight="fontWeightMedium" mb={3}>
            Meus Pedidos
        </Typography>

        <TableContainer component={Paper} sx={{  display: 'flex', flexDirection: 'column', alignItems: 'center'}}>
          <Table sx={{ minWidth: 950 }} size="small">
            <TableHead>
              <TableRow>
                <TableCell align="right">Pedido</TableCell>
                <TableCell align="right">Modelo</TableCell>
                <TableCell align="right">Marca</TableCell>
                <TableCell align="right">Placa</TableCell>
                <TableCell align="right">Ano</TableCell>
                <TableCell align="right">Matrícula</TableCell>
                <TableCell align="right">Dias</TableCell>
                <TableCell align="right">Cancelar</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {rows.map((row) => (
                <TableRow key={row.matricula} sx={{ '&:last-child td, &:last-child th': { border: 0 } }} >
                  <TableCell component="th" scope="row" align="right">{row.pedido}</TableCell>
                  <TableCell align="right">{row.modelo}</TableCell>
                  <TableCell align="right">{row.marca}</TableCell>
                  <TableCell align="right">{row.placa}</TableCell>
                  <TableCell align="right">{row.ano}</TableCell>
                  <TableCell align="right">{row.matricula}</TableCell>
                  <TableCell align="right">{row.dias}</TableCell>
                  <TableCell align="right">{row.cancelar}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
        
    </Paper>
  );
}