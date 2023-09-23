import React from 'react';
import { Grid, Typography } from '@mui/material';
import {Barra} from '../navBar/index'


import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

const createData = (
  modelo,
  marca,
  placa,
  ano,
  matricula,
  editar,
  excluir
) => {
  return { modelo, marca, placa, ano, matricula, editar, excluir };
};

const rows = [
  createData('corolla', 'toyota', 'placa',2023, 1,  4, 4, 5),
  createData('fusca', 'teste', 'placa', 2023,2, 4, 4, 5),
  createData('HB20', 'teste', 'placa', 2023, 3,  4, 4, 5),
];

export const HomeCliente = () => {
  return (
    <Paper elevation={3}>
    <Grid sx={{ position: 'fixed', top: 0, bottom: 0, left: 0, right: 0 }}>
      <Barra />
    </Grid>
        <TableContainer component={Paper}>
        <Table sx={{ minWidth: 750 }} size="small" >
          <TableHead>
            <TableRow>
              <TableCell>Modelo</TableCell>
              <TableCell align="right">Marca</TableCell>
              <TableCell align="right">Placa</TableCell>
              <TableCell align="right">Ano</TableCell>
              <TableCell align="right">Matrícula</TableCell>
              <TableCell align="right">Editar</TableCell>
              <TableCell align="right">Excluir</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {rows.map((row) => (
              <TableRow
                key={row.name}
                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
              >
                <TableCell component="th" scope="row">
                  {row.name}
                </TableCell>
                
                <TableCell align="right">{row.marca}</TableCell>
                <TableCell align="right">{row.placa}</TableCell>
                <TableCell align="right">{row.ano}</TableCell>
                <TableCell align="right">{row.matricula}</TableCell>
                <TableCell align="right">{row.editar}</TableCell>
                <TableCell align="right">{row.excluir}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </Paper>
  );
}