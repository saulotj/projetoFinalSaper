import React from "react";

export const TableSchedule = () => {
    const renderTableRows = () => {
      const rows = [];
      const min = 30;
  
      for (let hour = 8; hour <= 18; hour++) {
        for (let minute = 0; minute < 60; minute += min) {
          const time = `${hour.toString().padStart(2, '0')}:${minute.toString().padStart(2, '0')}`;
  
          rows.push(
            <tr key={time}>
              <td>{time}</td>
              {week.map((day) => (
                <td key={`${time}-${day}`}>{/* Adicione o conteúdo para cada célula */}</td>
              ))}
            </tr>
          );
        }
      }
  
      return rows;
    };
  
    const week = ['Segunda-Feira', 'Terça-Feira', 'Quarta-Feira', 'Quinta-Feira', 'Sexta-Feira'];
  
    return (
      <table className="table">
        <thead className="table-light">
          <tr>
            <th>Hora</th>
            {week.map((day: string) => (
              <th key={day}>{day}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          {renderTableRows()}
        </tbody>
      </table>
    );
  };
  
  export const Agenda = () => {
    return (
      <div>
        <h2>Agenda</h2>
        <TableSchedule />
      </div>
    );
  };