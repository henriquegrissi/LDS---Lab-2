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
  modelo,
  marca,
  placa,
  ano,
  matricula,
  status,
  alugar
) => {
  return { modelo, marca, placa, ano, matricula, status, alugar };
};

const rows = [
  createData('Corolla', 'Toyota', 'placa',2023, 1,  'disponível',  <Button type="submit" variant="outlined" size="small" >alugar</Button>),
  createData('Fusca', 'Volkswagen', 'placa', 2023,2, 'alugado', ''),
  createData('HB20', 'Hyundai', 'placa', 2023, 3,  'disponível',  <Button type="submit" variant="outlined" size="small" >alugar</Button>),
  createData('BMW', '320i', 'placa', 2023, 3,  'ocupado', '' ),
  createData('Audi', 'A3', 'placa', 2023, 3,  'disponível',  <Button type="submit" variant="outlined" size="small" >alugar</Button>),
];

export const HomeCliente = () => {
  return (
    <Paper elevation={3}  sx={{my: 8, mx: 4, display: 'flex', flexDirection: 'column', alignItems: 'center',}}>
      <Grid sx={{ position: 'fixed', top: 0, bottom: 0, left: 0, right: 0 }}>
        <Barra />
      </Grid>

      <Typography variant="h4" fontWeight="fontWeightMedium" mb={3}>
            Alugar Veículos
        </Typography>

        <TableContainer component={Paper} sx={{  display: 'flex', flexDirection: 'column', alignItems: 'center'}}>
          <Table sx={{ minWidth: 950 }} size="small">
            <TableHead>
              <TableRow>
                <TableCell align="right">Modelo</TableCell>
                <TableCell align="right">Marca</TableCell>
                <TableCell align="right">Placa</TableCell>
                <TableCell align="right">Ano</TableCell>
                <TableCell align="right">Matrícula</TableCell>
                <TableCell align="right">Status</TableCell>
                <TableCell align="right">Alugar</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {rows.map((row) => (
                <TableRow key={row.matricula} sx={{ '&:last-child td, &:last-child th': { border: 0 } }} >
                  <TableCell component="th" scope="row" align="right">{row.modelo}</TableCell>
                  <TableCell align="right">{row.marca}</TableCell>
                  <TableCell align="right">{row.placa}</TableCell>
                  <TableCell align="right">{row.ano}</TableCell>
                  <TableCell align="right">{row.matricula}</TableCell>
                  <TableCell align="right">{row.status}</TableCell>
                  <TableCell align="right">{row.alugar}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
        
    </Paper>
  );
}