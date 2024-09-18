import TableComponent from './components/TableComponent';
import ModalAdd from './components/ModalAdd';
import './App.css';
import api from './api/axiosConfig';
import { useState, useEffect } from 'react';

function App() {

  const [empleados, setEmpleados] = useState([]);

  const getEmpleados = async () => {

    try{
      
    const response = await api.get("/empleados");

    setEmpleados(response.data);

    console.log(empleados);

    }catch(err){
      console.log(err);
    }
  }

  useEffect(() => {
    getEmpleados();
  },[]);

  return (
    <div className='App'>
      <TableComponent listaempleados={empleados}/>
      <ModalAdd/>
    </div>
  );
}

export default App;
