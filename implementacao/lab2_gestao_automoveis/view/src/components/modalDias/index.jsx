import * as React from 'react';
import { Button } from '@mui/material';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import { Box } from "@mui/system"
import { useState } from 'react'

const style = {
  position: 'absolute' ,
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 400,
  bgcolor: 'background.paper',
  border: '2px solid #000',
  boxShadow: 24,
  p: 4,
};

export const ModalDia = ({isOpen, setModalOpen,}) => {
  
  if(isOpen){
    return (
      <div>
        <Button >Open modal</Button>
        <Modal  aria-labelledby="modal-modal-title" aria-describedby="modal-modal-description" >
          <Box sx={style}>
            <Typography id="modal-modal-title" variant="h6" component="h2">
              Digite a Quantidade de dias que deseja alugar o veículo:
            </Typography>
            <Typography id="modal-modal-description" sx={{ mt: 2 }}>
              Duis mollis, est non commodo luctus, nisi erat porttitor ligula.
            </Typography>
          </Box>
        </Modal>
      </div>
    );
  }
}