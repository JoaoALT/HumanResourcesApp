import React from 'react';
import {BsFillTrashFill, BsFillPencilFill} from 'react-icons/bs'
import "../css/TableComponent.css"

export default function TableComponent({listaempleados}) {
  return (
    <div className="Table-wrapper">
      <table className="Table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Email</th>
            <th>Telefono</th>
            <th>Habilidades</th>
            <th>Formación academica</th>
            <th>Historial laboral</th>
            <th>Acciones</th>
          </tr>
        </thead>

        <tbody>

          {listaempleados.map((empleado, i) => (
            <tr key={i}>
              <td>{empleado.id}</td>
              <td>{empleado.nombre}</td>
              <td>{empleado.apellido}</td>
              <td>{empleado.email}</td>
              <td>{empleado.telefono}</td>
              <td className="Expand">{empleado.habilidades}</td>
              <td className="Expand">{empleado.formacionAcademica}</td>
              <td className="Expand">{empleado.historialLaboral}</td>
              <td>
                <span className="Actions">
                  <BsFillTrashFill className="Delete-btn"/>
                  <BsFillPencilFill className="Edit-btn"/>
                </span>
              </td>
          </tr>
          ))


          }

        </tbody>

      </table>
    </div>
  )
}