import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import { useNavigate } from 'react-router-dom';

export const BarraAgente = () => {
    const navigate = useNavigate();


    const handleClick = async (e) => {
        e.preventDefault();
        navigate('/analisar');
    }

    const handleClick2 = async (e) => {
        e.preventDefault();
        navigate('/veiculo/cadastro');
    }

  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
          >
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            Locadora
          </Typography>
          <Button color="inherit"  onClick={handleClick} >Analisar pedido   </Button>
          <Button color="inherit" onClick={handleClick2} >Cadastrar veículo</Button>
         
        </Toolbar>
      </AppBar>
    </Box>
  );
}